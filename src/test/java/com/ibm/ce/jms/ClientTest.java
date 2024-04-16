package com.ibm.ce.jms;

import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.TextMessage;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

import org.junit.jupiter.api.Test;

public class ClientTest {

	@Test
	public static void main(String [] args) throws Exception {

		System.setProperty("com.ibm.mq.cfg.SSL.outboundSNI", "HOSTNAME");
		
		JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
		JmsConnectionFactory cf = ff.createConnectionFactory();

		cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, "native-ha-qm-ibm-mq-qm-mq.apps.6602d6121b0194001e821256.cloud.techzone.ibm.com");
		cf.setIntProperty(WMQConstants.WMQ_PORT, 443);

		cf.setStringProperty(WMQConstants.WMQ_CHANNEL, "HAQMCHL");
		cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
		cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, "NATIVEHAQM");
		cf.setStringProperty(WMQConstants.WMQ_APPLICATIONNAME, "TestClient");
		cf.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, false);
		cf.setStringProperty(WMQConstants.WMQ_SSL_CIPHER_SUITE, "*TLS12ORHIGHER");
			
		try (JMSContext context = cf.createContext()) {
			Destination destination = context.createQueue("queue:///QUEUE2");

			TextMessage message = context.createTextMessage(new Date().toString());

			JMSProducer producer = context.createProducer();
			producer.send(destination, message);

			JMSConsumer consumer = context.createConsumer(destination);
			String body = consumer.receiveBody(String.class, 5000);

			System.out.println("Message body: " +  body);
		}
	}

}

package com.ibm.ce.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

@Stateless
public class Producer {
    
    @Inject
    @JMSConnectionFactory("jms/mqConnectionFactory")
    JMSContext context;

    @Resource(lookup = "jms/queue1")
    Queue queue1;

    @Resource(lookup = "jms/queue2")
    Queue queue2;

    public void sendMessage(String message) {
        JMSProducer jmsProducer = context.createProducer();
        jmsProducer.send(queue1, message);
        jmsProducer.send(queue2, message);

        System.out.println("Sent JMS Messages.");
    }
}

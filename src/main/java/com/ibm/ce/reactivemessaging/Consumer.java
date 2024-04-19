package com.ibm.ce.reactivemessaging;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import com.ibm.ce.jms.Producer;

@ApplicationScoped
public class Consumer {

    @EJB
    private Producer jmsProducer;
    
    /**
     * Consume from DOOR.BADGEIN Kafka Topic
     * 
     *  https://smallrye.io/smallrye-reactive-messaging/4.9.0/kafka/receiving-kafka-records/#acknowledgement
     */
    @Incoming("door")
    @Acknowledgment(Acknowledgment.Strategy.NONE)
    public void consumeDoorEvents(String string) {    
        System.out.println("Received Kafka door event: " + string);  
    
        try {
            jmsProducer.sendMessage(string);
            System.out.println("Sent JMS Messages.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    @Incoming("order")
    @Outgoing("sink")
    @Acknowledgment(Acknowledgment.Strategy.NONE)
    public String consumeOrderEvents(String string)  {
        System.out.println("Received Kafka order event: " + string);
        return string.toUpperCase();
    }
}
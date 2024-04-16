package com.ibm.ce.reactivemessaging;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.ibm.ce.jms.Producer;

@ApplicationScoped
public class Consumer {

    @EJB
    Producer jmsProducer;
    
    // https://smallrye.io/smallrye-reactive-messaging/4.9.0/kafka/receiving-kafka-records/#acknowledgement
    @Incoming("door")
    @Acknowledgment(Acknowledgment.Strategy.NONE)
    public void consumeDoorEvents(String string) {    
        System.out.println("Received door event: " + string);  
    
        try {
            jmsProducer.sendMessage(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
      
    /**
     * Consume from DOOR.BADGEIN Kafka Topic
     */
    @Incoming("order")
    @Acknowledgment(Acknowledgment.Strategy.NONE)
    public void consumeOrderEvents(String string)  {
        System.out.println("Received order event: " + string);
    }
}
package com.ibm.ce.reactivemessaging;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.ibm.ce.jms.Producer;

@ApplicationScoped
public class Consumer {

    //@EJB
    //Producer jmsProducer;

    /**
     * Consume from DOOR.BADGEIN Kafka Topic
     */
    @Incoming("door")
    public void consumeDoorEvents(String string) throws Exception {
        System.out.println("Received door event:  " + string);
        //jmsProducer.sendMessage(string);
    }

    /**
     * Consume from DOOR.BADGEIN Kafka Topic
     */
    @Incoming("order")
    public void consumeOrderEvents(String string)  {
        System.out.println("Received order event: " + string);
    }
}
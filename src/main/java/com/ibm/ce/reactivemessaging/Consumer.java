package com.ibm.ce.reactivemessaging;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class Consumer {

    /**
     * Consume from DOOR.BADGEIN Kafka Topic
     */
    @Incoming("door")
    public void consumeDoorEvents(String string)  {
        System.out.println("Received door event: " + string);
    }

    /**
     * Consume from DOOR.BADGEIN Kafka Topic
     */
    @Incoming("order")
    public void consumeOrderEvents(String string)  {
        System.out.println("Received order event: " + string);
    }
}
package com.ibm.ce.reactivemessaging;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class Consumer {

    @Incoming("door")
    public void consume(String string)  {
        System.out.println("Received message: " + string);
    }
}
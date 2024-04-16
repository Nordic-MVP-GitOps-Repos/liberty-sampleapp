package com.ibm.ce.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class Producer {
    
    @Inject
    @JMSConnectionFactory("jms/mqConnectionFactory")
    JMSContext context;

    @Resource(lookup = "jms/queue1")
    Queue queue;

    public void sendMessage(String message) {
        context.createProducer().send(queue, message);
        try {
            System.out.println("Sent message.");            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.ibm.ce.jms;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "ListenerMDB")
public class Listener implements MessageListener {

  public void onMessage(Message message) {
    try {
      System.out.println("Received JMS Message: " + message.getBody(String.class));
    } catch (JMSException e) {
      throw new RuntimeException(e);
    }
  }
}
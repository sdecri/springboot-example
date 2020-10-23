/**
 * Consumer.java
 */
package com.sdc.springboot_example.jms.embedded;

import java.util.Objects;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.sdc.springboot_example.model.Person;

/**
 * @author Simone.DeCristofaro
 * Oct 15, 2020
 */
public class Consumer implements MessageListener{
    
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Consumer.class);
    
    @Override
    public void onMessage(Message message) {
        try {
            Object messageBody = message.getBody(Object.class);
            if(messageBody instanceof Person) {
                LOG.info("The arrived message is a Person ^_^");
            }
            String messageContent = Objects.toString(messageBody);
            LOG.info("> Received message: " + messageContent);
        }catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}

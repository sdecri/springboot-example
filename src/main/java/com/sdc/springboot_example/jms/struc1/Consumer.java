/**
 * Consumer.java
 */
package com.sdc.springboot_example.jms.struc1;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author Simone.DeCristofaro
 * Oct 15, 2020
 */
public class Consumer implements MessageListener{
    
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Consumer.class);
    
    @Override
    public void onMessage(Message message) {
        try {
            LOG.info("Received message: " + message.getBody(Object.class));
        }catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}

/**
 * Receiver.java
 */
package com.sdc.springboot_example.jms.consumer.struc2;

import org.apache.activemq.artemis.jms.client.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author Simone.DeCristofaro
 * Oct 16, 2020
 */
@Component
public class Receiver {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Receiver.class);
    
    @JmsListener(destination = "${queue2}", containerFactory = "myCurrentConnectionFactory")
    public void onMessage(ActiveMQTextMessage message) {
        LOG.info("Received message: " + message.getText());
    }
    
    
}

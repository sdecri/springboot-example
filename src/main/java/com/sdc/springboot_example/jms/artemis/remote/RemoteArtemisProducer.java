/**
 * RemoteArtemisNoMessageTypeProducer.java
 */
package com.sdc.springboot_example.jms.artemis.remote;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.tre.TreStatusMessage;

/**
 * @author Simone.DeCristofaro
 * Oct 16, 2020
 */
@Component
@Profile(Application.PROFILE_JMS_ARTEMIS_REMOTE)
public class RemoteArtemisProducer {
    
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(RemoteArtemisProducer.class);
    
    @Autowired
    private JmsTemplate artemisJmsTemplate;
    
    @Value("${artemis.remote.topic}")
    private String destination;

    

    public void send(TreStatusMessage message){
        LOG.info("> Sending general message...");
        artemisJmsTemplate.convertAndSend(destination, message);
    }
}
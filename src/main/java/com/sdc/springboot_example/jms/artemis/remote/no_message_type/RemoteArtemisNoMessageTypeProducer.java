/**
 * RemoteArtemisNoMessageTypeProducer.java
 */
package com.sdc.springboot_example.jms.artemis.remote.no_message_type;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.tre.TreStatusMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Simone.DeCristofaro
 * Oct 16, 2020
 */
@Component
@Profile(Application.PROFILE_JMS_ARTEMIS_REMOTE_NO_MESSAGE_TYPE)
@Slf4j
public class RemoteArtemisNoMessageTypeProducer {
    
    @Autowired
    private JmsTemplate artemisJmsTemplateNoMessageType;
    
    @Value("${artemis.remote.topic}")
    private String destination;

    

    public void send(TreStatusMessage message){
        log.info("> Sending general message...");
        artemisJmsTemplateNoMessageType.convertAndSend(destination, message);
    }
}
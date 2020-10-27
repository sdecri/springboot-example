/**
 * RemoteArtemisNoMessageTypeProducer.java
 */
package com.sdc.springboot_example.jms.artemis.embedded;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Simone.DeCristofaro
 * Oct 16, 2020
 */
@Component
@Profile(Application.PROFILE_JMS_ARTEMIS_EMBEDDED)
@Slf4j
public class EmbeddedArtemisProducer {
    
    @Autowired
    private JmsTemplate artemisJmsTemplate;
    
    @Value("${artemis.topic.person}")
    String queuePerson;
    
    @Value("${artemis.topic.street}")
    String queueStreet;
    
    public void send(Person person){
        log.info("> Sending message person...");
        artemisJmsTemplate.convertAndSend(queuePerson, person);
    }

    public void send(String message){
        log.info("> Sending general message...");
        artemisJmsTemplate.convertAndSend(queueStreet, message);
    }
}
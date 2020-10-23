/**
 * ArtemisProducer.java
 */
package com.sdc.springboot_example.jms.embedded;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.Person;

/**
 * @author Simone.DeCristofaro
 * Oct 16, 2020
 */
@Component
@EnableJms
@Profile(Application.PROFILE_PRODUCER_1)
public class ArtemisProducer {
    
    @Autowired
    JmsTemplate jmsTemplate;
    
    @Value("${queue1}")
    String destinationQueue;
    
    public void send(Person person){
        jmsTemplate.convertAndSend(destinationQueue, person);
    }


}
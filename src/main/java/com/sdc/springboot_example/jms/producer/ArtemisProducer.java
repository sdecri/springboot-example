/**
 * ArtemisProducer.java
 */
package com.sdc.springboot_example.jms.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.model.Person;

/**
 * @author Simone.DeCristofaro
 * Oct 16, 2020
 */
@Component
@EnableJms
public class ArtemisProducer {
    
    @Autowired
    JmsTemplate jmsTemplate;
    
    @Value("${queue1}")
    String destinationQueue;
    
    public void send(Person person){
        jmsTemplate.convertAndSend(destinationQueue, person);
    }


}
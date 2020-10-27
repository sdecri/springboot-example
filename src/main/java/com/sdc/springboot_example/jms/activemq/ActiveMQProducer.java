package com.sdc.springboot_example.jms.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.tre.TreStatusMessage;
import lombok.extern.slf4j.Slf4j;

@Component
@Profile(Application.PROFILE_JMS_ACTIVEMQ)
@Slf4j
public class ActiveMQProducer {

    @Autowired
    private JmsTemplate activeMQJmsTemplate;

    @Value("${active-mq.topic}")
    private String topic;

    public void sendMessage(TreStatusMessage message){
        try{
            log.info("Attempting Send message to Topic: "+ topic);
            activeMQJmsTemplate.convertAndSend(topic, message);
        } catch(Exception e){
            log.error("Recieved Exception during send Message: ", e);
        }
    }
    

}
package com.sdc.springboot_example.jms.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.tre.TreStatusMessage;

@Component
@Profile(Application.PROFILE_PRODUCER_2 + " | " + Application.PROFILE_PRODUCER_3)
public class JmsProducer {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(JmsProducer.class);
    
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${active-mq.topic}")
    private String topic;

    public void sendMessage(TreStatusMessage message){
        try{
            LOG.info("Attempting Send message to Topic: "+ topic);
            jmsTemplate.convertAndSend(topic, message);
        } catch(Exception e){
            LOG.error("Recieved Exception during send Message: ", e);
        }
    }
    

}
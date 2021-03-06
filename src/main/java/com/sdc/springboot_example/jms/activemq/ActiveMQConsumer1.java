package com.sdc.springboot_example.jms.activemq;

import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.tre.TreStatusMessage;
import lombok.extern.slf4j.Slf4j;

@Component
@Profile(Application.PROFILE_JMS_ACTIVEMQ)
@Slf4j
public class ActiveMQConsumer1 {

    @JmsListener(destination = "${active-mq.topic}", containerFactory = "jmsActiveMQListenerContainerFactory")
    public void onTreMessage(TreStatusMessage treMessage) {
        log.info(String.format("Received Message from consumer: %s: %s", getClass(), treMessage.toString()));
    }
}
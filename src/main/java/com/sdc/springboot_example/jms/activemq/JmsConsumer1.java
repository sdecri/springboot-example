package com.sdc.springboot_example.jms.activemq;

import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.tre.TreStatusMessage;

@Component
@Profile(Application.PROFILE_PRODUCER_2)
public class JmsConsumer1 {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(JmsConsumer1.class);
    
    @JmsListener(destination = "${active-mq.topic}", containerFactory = "jmsActiveMQListenerContainerFactory")
    public void onTreMessage(TreStatusMessage treMessage) {
        LOG.info(String.format("Received Message from consumer: %s: %s", getClass(), treMessage.toString()));
    }
}
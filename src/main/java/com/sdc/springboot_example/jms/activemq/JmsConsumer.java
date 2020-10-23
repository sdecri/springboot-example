package com.sdc.springboot_example.jms.activemq;

import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.tre.TreStatusMessage;

@Component
@Profile(Application.PROFILE_PRODUCER_2)
public class JmsConsumer {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(JmsConsumer.class);
    
    @JmsListener(destination = "${active-mq.topic}", containerFactory = "activeMQConnectionFactory")
    public void onMessage(TreStatusMessage treMessage) {

        try {
//            ObjectMessage objectMessage = (ObjectMessage) message;
//            TreStatusMessage treMessage = (TreStatusMessage) objectMessage.getObject();
            LOG.info("Received Message: " + treMessage.toString());
        }
        catch (Exception e) {
            LOG.error("Received Exception : " + e);
        }

    }
}
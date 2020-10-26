/**
 * RemoteArtemisNoMessageTypeConsumer.java
 */
package com.sdc.springboot_example.jms.artemis.remote.no_message_type;


import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.tre.TreStatusMessage;

/**
 * @author Simone.DeCristofaro
 * Oct 15, 2020
 */
@Component
@Profile(Application.PROFILE_JMS_ARTEMIS_REMOTE_NO_MESSAGE_TYPE)
public class RemoteArtemisNoMessageTypeConsumer {
    
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(RemoteArtemisNoMessageTypeConsumer.class);

    @JmsListener(destination = "${artemis.remote.topic}", containerFactory = "remoteArtemisJmsListenerContainerFactoryNoMessageType")
    public void onMessage(TreStatusMessage message) {
        LOG.info("> Received message: " + message.toString());
    }

}

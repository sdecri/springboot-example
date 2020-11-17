/**
 * RemoteArtemisNoMessageTypeConsumer.java
 */
package com.sdc.springboot_example.jms.artemis.remote;


import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.tre.TreStatusMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Simone.DeCristofaro
 * Oct 15, 2020
 */
@Component
@Profile(Application.PROFILE_JMS_ARTEMIS_REMOTE)
@Slf4j
public class RemoteArtemisConsumer {
    
    @JmsListener(destination = "${artemis.remote.topic}", containerFactory = "remoteArtemisJmsListenerContainerFactory")
    public void onMessage(TreStatusMessage message) {
        log.info("> Received message: " + message.toString());
    }

}

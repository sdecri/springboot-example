/**
 * RemoteArtemisNoMessageTypeConsumer.java
 */
package com.sdc.springboot_example.jms.artemis.embedded;


import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.model.Person;

/**
 * @author Simone.DeCristofaro
 * Oct 15, 2020
 */
@Component
@Profile(Application.PROFILE_JMS_ARTEMIS_EMBEDDED)
public class EmbeddedArtemisConsumer {
    
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(EmbeddedArtemisConsumer.class);

    @JmsListener(destination = "${artemis.topic.street}", containerFactory = "embeddedArtemisJmsListenerContainerFactory")
    public void onStreetMessage(Message<String> message) {
        LOG.info("> Received message: " + message.getPayload());
    }

    @JmsListener(destination = "${artemis.topic.person}", containerFactory = "embeddedArtemisJmsListenerContainerFactory")
    public void onPersonMessage(Message<Person> message) {
        LOG.info("> Received message: " + message.getPayload());
    }    

}

/**
 * TreSchedulerActiveMQ.java
 */
package com.sdc.springboot_example.scheduler;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.jms.artemis.remote.no_message_type.RemoteArtemisNoMessageTypeProducer;
import com.sdc.springboot_example.model.tre.TreStatusMessage;

/**
 * @author Simone.DeCristofaro
 * Oct 21, 2020
 */
@Component
@Profile(Application.PROFILE_JMS_ARTEMIS_REMOTE_NO_MESSAGE_TYPE)
public class TreSchedulerArtemisNoMessageType {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(TreSchedulerArtemisNoMessageType.class);
    
    @Autowired
    public RemoteArtemisNoMessageTypeProducer producer;
    
    @Scheduled(cron = "${schedule.tre.signal}")
    public void sendSignal() throws JMSException {
        LOG.info("> Schuled task trigger TRE signal");
//        String message = String.format("Message of time %s", LocalDateTime.now());
        
        TreStatusMessage treStatusMessage = TreMessageStatusBuilder.createTreStatusMessage();
        
        producer.send(treStatusMessage);
    }
    
}

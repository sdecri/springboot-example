/**
 * TreSchedulerActiveMQ.java
 */
package com.sdc.springboot_example.scheduler;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.jms.artemis.remote.no_message_type.RemoteArtemisNoMessageTypeProducer;
import com.sdc.springboot_example.model.tre.TreMessageStatusBuilder;
import com.sdc.springboot_example.model.tre.TreStatusMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Simone.DeCristofaro
 * Oct 21, 2020
 */
@Component
@Profile(Application.PROFILE_JMS_ARTEMIS_REMOTE_NO_MESSAGE_TYPE)
@Slf4j
public class TreSchedulerArtemisNoMessageType {

    @Autowired
    public RemoteArtemisNoMessageTypeProducer producer;
    
    @Value("${tre.statu.message.tenantId}")
    private String tenantId;
    
    @Scheduled(cron = "${schedule.tre.signal}")
    public void sendSignal() throws JMSException {
        log.info("> Schuled task trigger TRE signal");
//        String message = String.format("Message of time %s", LocalDateTime.now());
        
        TreStatusMessage treStatusMessage = TreMessageStatusBuilder.createTreStatusMessage(tenantId);
        
        producer.send(treStatusMessage);
    }
    
}

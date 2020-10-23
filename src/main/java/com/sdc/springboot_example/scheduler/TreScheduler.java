/**
 * TreScheduler.java
 */
package com.sdc.springboot_example.scheduler;

import java.util.Arrays;
import java.util.List;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.Application;
import com.sdc.springboot_example.jms.activemq.JmsProducer;
import com.sdc.springboot_example.model.tre.Simu;
import com.sdc.springboot_example.model.tre.SimulationGroup;
import com.sdc.springboot_example.model.tre.TreStatusMessage;

/**
 * @author Simone.DeCristofaro
 * Oct 21, 2020
 */
@Component
@Profile(Application.PROFILE_PRODUCER_2 + " | " + Application.PROFILE_PRODUCER_3)
public class TreScheduler {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(TreScheduler.class);
    
    @Autowired
    public JmsProducer jmsProducer;
    
    @Scheduled(cron = "${schedule.tre.signal}")
    public void sendSignal() throws JMSException {
        LOG.info("> Schuled task trigger TRE signal");
//        String message = String.format("Message of time %s", LocalDateTime.now());
        
        TreStatusMessage treStatusMessage = createTreStatusMessage();
        
        jmsProducer.sendMessage(treStatusMessage);
    }

    /**
     * @return
     */
    private TreStatusMessage createTreStatusMessage() {

        Integer dayTypeTRE = 1;
        String status = "waiting";
        String message = "I'm the TRE message status";
        Double progress = 1.;
        String instanceName = "TRE_TATTICO";
        SimulationGroup simulationGroup = createSimulationGroup();
        String timeToNextSim = "1";
        Integer init = 1;
        String simulationDay = "monday";
        Integer ends = 2;
        Integer lastDay = 2;
        String lastRunEndTime = "20/10/22 16:19:31";
        TreStatusMessage treStatusMessage = new TreStatusMessage(
                status
                , message
                , progress
                , instanceName
                , simulationGroup
                , dayTypeTRE
                , timeToNextSim
                , init
                , ends
                , simulationDay
                , lastDay
                , lastRunEndTime
                );
        return treStatusMessage;
    }

    /**
     * @return
     */
    private SimulationGroup createSimulationGroup() {

        Integer idno = 30;
        return new SimulationGroup(idno , createSimus());
        
    }

    /**
     * @return
     */
    private List<Simu> createSimus() {

        Boolean base = true;
        Integer idno = 1;
        List<Object> scen = Arrays.asList("scen1", "scen2");
        Integer stat = 1;
        Simu simu1 = new Simu(base, idno, scen, stat);
        base = false;
        idno = 2;
        scen = Arrays.asList("scen3", "scen4");
        stat = 2;
        Simu simu2 = new Simu(base, idno, scen, stat);
        return Arrays.asList(simu1, simu2);
        
    }
    
}

/**
 * TreMessageStatusBuilder.java
 */
package com.sdc.springboot_example.model.tre;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author Simone.DeCristofaro
 * Oct 23, 2020
 */
public class TreMessageStatusBuilder {

    /**
     * @return
     */
    public static TreStatusMessage createTreStatusMessage() {
    
        Integer dayTypeTRE = 1;
        String status = "waiting";
        String message = "Ready";
        Double progress = 1.;
        String instanceName = "TRE_TATTICO";
        SimulationGroup simulationGroup = TreMessageStatusBuilder.createSimulationGroup();
        String timeToNextSim = "1";
        Integer init = 1;
        String simulationDay = "monday";
        Integer ends = 2;
        Integer lastDay = 2;
        String lastRunEndTime = "20/10/22 16:19:31";
        String MessageId = "message_" + LocalDateTime.now();
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
                , MessageId
                );
        return treStatusMessage;
    }

    /**
     * @return
     */
    public static SimulationGroup createSimulationGroup() {
    
        Integer idno = 30;
        return new SimulationGroup(idno , TreMessageStatusBuilder.createSimus());
        
    }

    /**
     * @return
     */
    public static List<Simu> createSimus() {
    
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

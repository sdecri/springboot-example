
package com.sdc.springboot_example.model.tre;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class TreStatusMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    private String tenantId;
    private String status;
    private String message;
    private Double progress;
    private String instanceName;
    private SimulationGroup simulationGroup;
    private Integer dayType;
    private String timeToNextSim;
    private Integer init;
    private Integer ends;
    private String simulationDay;
    private Integer lastDay;
    private String lastRunEndTime;
}

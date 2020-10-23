
package com.sdc.springboot_example.model.tre;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class SimulationGroup {

    private static final long serialVersionUID = 1L;
    private Integer idno;
    private List<Simu> simu = null;

    
}

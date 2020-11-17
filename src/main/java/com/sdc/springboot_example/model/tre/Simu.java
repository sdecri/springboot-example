
package com.sdc.springboot_example.model.tre;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class Simu implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Boolean base;
    private Integer idno;
    private List<Object> scen = null;
    private Integer stat;
    
}

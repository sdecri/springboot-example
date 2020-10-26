/**
 * Person.java
 */
package com.sdc.springboot_example.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Simone.DeCristofaro
 * Oct 16, 2020
 */
@NoArgsConstructor @Getter @Setter @AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    
    /**
    * {@inheritDoc}
    */
    @Override
    public String toString() {
    
        return String.format("FIRST_NAME: %s, LAST_NAME = %s", firstName, lastName);
        
    }
        
}

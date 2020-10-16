/**
 * Person.java
 */
package com.sdc.springboot_example.model;

import java.io.Serializable;

/**
 * @author Simone.DeCristofaro
 * Oct 16, 2020
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private String fname;
    private String lname;
    
    /**
    * {@inheritDoc}
    */
    @Override
    public String toString() {
    
        return String.format("FIRST_NAME: %s, LAST_NAME = ", fname, lname);
        
    }
    
    
    /**
     * 
     */
    public Person() {

        super();
    }
    /**
     * @param fname
     * @param lname
     */
    public Person(String fname, String lname) {

        super();
        this.fname = fname;
        this.lname = lname;
    }
    
    /**
     * @return the {@link Person#fname}
     */
    public String getFname() {
    
        return fname;
    }
    
    /**
     * @param fname the {@link Person#fname} to set
     */
    public void setFname(String fname) {
    
        this.fname = fname;
    }
    
    /**
     * @return the {@link Person#lname}
     */
    public String getLname() {
    
        return lname;
    }
    
    /**
     * @param lname the {@link Person#lname} to set
     */
    public void setLname(String lname) {
    
        this.lname = lname;
    }
    

    
}

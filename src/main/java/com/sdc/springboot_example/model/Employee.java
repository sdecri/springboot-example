package com.sdc.springboot_example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * The type Employee.
 */
@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class Employee implements Serializable {
    private static final long serialVersionUID = 300002228479017363L;

    private int employeeId;
    private String employeeFullName;

}

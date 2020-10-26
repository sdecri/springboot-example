package com.sdc.springboot_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Application.java
 */

/**
 * @author Simone.DeCristofaro
 * Oct 14, 2020
 */
@SpringBootApplication
@EnableScheduling
@EnableJms
public class Application {

    public static final String PROFILE_JMS_ARTEMIS_EMBEDDED = "jms_artemis_embedded";
    public static final String PROFILE_JMS_ACTIVEMQ = "jms_activemq";
    public static final String PROFILE_CONTROLLER = "controller";
    public static final String PROFILE_JMS_ARTEMIS_REMOTE = "jms_artemis_remote"; 
    public static final String PROFILE_JMS_ARTEMIS_REMOTE_NO_MESSAGE_TYPE = "jms_artemis_remote_no_message_type"; 
    
    /**
     * @param args
     */
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
//        .close();

    }

}

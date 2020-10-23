package com.sdc.springboot_example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class Application {

    public static final String PROFILE_PRODUCER_1 = "producer1";
    public static final String PROFILE_PRODUCER_2 = "producer2";
    public static final String PROFILE_PRODUCER_3 = "producer3";
    public static final String PROFILE_RECEIVER_1 = "consumer1";
    public static final String PROFILE_RECEIVER_2 = "consumer2";
    public static final String PROFILE_CONTROLLER = "controller";
    
    /**
     * @param args
     */
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
//        .close();

    }

}

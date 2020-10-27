package com.sdc.springboot_example.command_line_runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.model.Strt;
import com.sdc.springboot_example.service.strt.StrtService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CommandLineAppStartupRunner implements CommandLineRunner {

    
    @Autowired
    private StrtService strtService;
    
//    @Autowired
//    private JmsTemplate template;
//    
//    @Value("${queuePerson}")
//    private String queue;

    
    @Override
    public void run(String... args) throws Exception {

        List<Strt> strts = strtService.findAll();
        log.info(String.format("Number of existing streets: %d", strts.size()));
        
        int idno = 550049426;
        int tail = 105226076;
        Optional<Strt> strtOp = strtService.findByIdnoTail(idno, tail);
        if(strtOp.isPresent())
            log.info(String.format("Requested street: %s", strtOp.get()));
        else {
            log.warn(String.format("No street found with: idno = %d and tail = %d", idno, tail));
        }
        
        strts = strtService.findByIdno(idno);
        log.info(String.format("Street with idno = %d: %s"
                , idno
                , String.join(System.lineSeparator(), strtService.findByIdno(idno)
                        .stream()
                        .map(Object::toString)
                        .toArray(size -> new String[size]))));

        
//        log.info("Sending> ...");
//        template.convertAndSend(queue, "Hello World from Spring Boot!");
//        log.info("Application end");
        
        
    }
    
    
}
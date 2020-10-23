package com.sdc.springboot_example.command_line_runner;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sdc.springboot_example.model.Strt;
import com.sdc.springboot_example.scheduler.TreScheduler;
import com.sdc.springboot_example.service.strt.StrtService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);
    
    @Autowired
    private StrtService strtService;
    
//    @Autowired
//    private JmsTemplate template;
//    
//    @Value("${queue1}")
//    private String queue;
    
    @Autowired
    private TreScheduler treScheduler;

    @Override
    public void run(String... args) throws Exception {

        List<Strt> strts = strtService.findAll();
        LOG.info(String.format("Number of existing streets: %d", strts.size()));
        
        int idno = 550049426;
        int tail = 105226076;
        Optional<Strt> strtOp = strtService.findByIdnoTail(idno, tail);
        if(strtOp.isPresent())
            LOG.info(String.format("Requested street: %s", strtOp.get()));
        else {
            LOG.warn(String.format("No street found with: idno = %d and tail = %d", idno, tail));
        }
        
        strts = strtService.findByIdno(idno);
        LOG.info(String.format("Street with idno = %d: %s"
                , idno
                , String.join(System.lineSeparator(), strtService.findByIdno(idno)
                        .stream()
                        .map(Object::toString)
                        .toArray(size -> new String[size]))));

        
//        LOG.info("Sending> ...");
//        template.convertAndSend(queue, "Hello World from Spring Boot!");
//        LOG.info("Application end");
        
        treScheduler.sendSignal();
        
    }
    
    
}
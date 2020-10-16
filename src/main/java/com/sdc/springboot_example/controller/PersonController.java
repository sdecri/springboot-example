package com.sdc.springboot_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sdc.springboot_example.jms.producer.ArtemisProducer;
import com.sdc.springboot_example.model.Person;

@Controller
public class PersonController {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(PersonController.class);
    
    @Autowired
    private ArtemisProducer producer;

   
    @RequestMapping("/form")
    public String getPerson(Model model) {
        
        model.addAttribute("person", new Person());
        
        return "form";
    }
    
    @PostMapping("/submit")
    public String submit(@ModelAttribute Person person, Model model){
        model.addAttribute("person", person);
        LOG.info("First name:" + person.getFname());
        LOG.info("Last name:" + person.getLname());
        producer.send(person);
        //return "redirect:/form";
        return "form";
    }    
    
}
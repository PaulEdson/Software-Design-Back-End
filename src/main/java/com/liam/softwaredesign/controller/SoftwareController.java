package com.liam.softwaredesign.controller;

import com.liam.softwaredesign.models.Clients;
import com.liam.softwaredesign.models.RegisteredClient;
import com.liam.softwaredesign.repository.ClientRepository;
import com.liam.softwaredesign.service.SoftwareDesign;
import jdk.jfr.Registered;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Slf4j
public class SoftwareController {

    @Autowired
    SoftwareDesign softwareDesign;


    @PostMapping("/insertClient")
    public Clients insertClient(@RequestBody Clients client){
        log.info("Inside Insert Client API");
        return softwareDesign.insertNewClient(client);
    }


    @PostMapping("/registerUser")
    public RegisteredClient registerUser(@RequestBody RegisteredClient registeredClient){
        log.info("Inside Register User");
        return softwareDesign.registerNewClient(registeredClient);
    }
}

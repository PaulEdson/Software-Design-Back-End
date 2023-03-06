package com.liam.softwaredesign.controller;

import com.liam.softwaredesign.models.Clients;
import com.liam.softwaredesign.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoftwareController {

    @Autowired
    ClientRepository clientRepository;


    @PostMapping("/addClient")
    public Clients saveClient(@RequestBody Clients client){
        clientRepository.save(client);
        return client;
    }
}

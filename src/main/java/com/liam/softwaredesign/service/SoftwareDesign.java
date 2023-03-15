package com.liam.softwaredesign.service;

import com.liam.softwaredesign.models.Clients;
import com.liam.softwaredesign.models.RegisteredClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface SoftwareDesign {


    Clients getAllClients();
    Clients findClient();
    Clients insertNewClient(Clients requestBody);
    Clients updateClient();


    RegisteredClient registerNewClient(RegisteredClient registeredClient);
}

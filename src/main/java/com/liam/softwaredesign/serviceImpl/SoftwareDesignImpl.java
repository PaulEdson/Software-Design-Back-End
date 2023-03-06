package com.liam.softwaredesign.serviceImpl;

import com.liam.softwaredesign.models.Clients;
import com.liam.softwaredesign.repository.ClientRepository;
import com.liam.softwaredesign.service.SoftwareDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoftwareDesignImpl implements SoftwareDesign {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Clients getAllClients() {
        return null;
    }

    @Override
    public Clients findClient() {
        return null;
    }

    @Override
    public Clients insertNewClient(Clients requestBody) {
        Clients newClient = new Clients();
        newClient.setName(requestBody.getName());
        newClient.setUser(requestBody.getUser());
        clientRepository.save(newClient);

        return newClient;
    }

    @Override
    public Clients updateClient() {
        return null;
    }
}

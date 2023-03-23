package com.liam.softwaredesign.serviceImpl;

import com.liam.softwaredesign.Utils.MailSenderUtils;
import com.liam.softwaredesign.models.*;
import com.liam.softwaredesign.repository.ClientRepository;
import com.liam.softwaredesign.repository.FuelQuoteHistory;
import com.liam.softwaredesign.repository.RegisteredClientRepository;
import com.liam.softwaredesign.service.SoftwareDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SoftwareDesignImpl implements SoftwareDesign {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    MailSenderUtils mailSender;

    @Autowired
    RegisteredClientRepository registeredClientRepository;

    @Autowired
    FuelQuoteHistory fuelQuoteHistory;

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
        Clients newClient = requestBody;
        clientRepository.save(newClient);
        return newClient;
    }

    @Override
    public RegisteredClient registerNewClient(RegisteredClient registeredClient){
        List<Clients> clientsList = clientRepository.findAll();
        List<RegisteredClient> registeredClientList = registeredClientRepository.findAll();
        RegisteredClient newClient = null;
        boolean alreadyExist = false;

        for(int i = 0; i < clientsList.size(); i++){
            if(clientsList.get(i).getUser().toLowerCase().compareTo(registeredClient.getUsername().toLowerCase()) == 0){
                alreadyExist = true;
            }
        }

        for(int i = 0; i < registeredClientList.size(); i++){
            if(registeredClientList.get(i).getUsername().toLowerCase().compareTo(registeredClient.getUsername().toLowerCase()) == 0){
                alreadyExist = true;
            }
        }

        if(!alreadyExist){
            registeredClientRepository.save(registeredClient);
            newClient = registeredClient;
            mailSender.sendEmail(newClient.getUsername(), "User Registered", "Thank you For Registering! Once your account is enabled please log back on and finish the registration");
        }

        return newClient;

    }

    @Override
    public FuelQuoteForm insertNewFuelQuote(FuelQuoteForm fuelQuoteForm){

        List<FuelQuoteForm> fuelQuoteFormList = fuelQuoteHistory.findAll();

        for(int i = 0; i < fuelQuoteFormList.size(); i++){
            if(fuelQuoteFormList.get(i).equals(fuelQuoteForm)){
                return null;
            }
        }

        fuelQuoteHistory.save(fuelQuoteForm);

        return fuelQuoteForm;
    }

    @Override
    public FuelQuotes getUserQuoteHistory(FuelQuoteRequest fuelQuoteRequest) {
        FuelQuotes fuelQuotes = new FuelQuotes();

        List<FuelQuoteForm> fuelQuoteFormList = fuelQuoteHistory.findByUser(fuelQuoteRequest.getUsername());

        fuelQuotes.setFuelQuotesFormList(fuelQuoteFormList);

        return fuelQuotes;
    }

    @Override
    public FuelQuotes getAllQuoteHistory() {
        FuelQuotes fuelQuotes = new FuelQuotes();

        List<FuelQuoteForm> fuelQuoteFormList = fuelQuoteHistory.findAll();

        fuelQuotes.setFuelQuotesFormList(fuelQuoteFormList);

        return fuelQuotes;
    }

    @Override
    public Clients updateClient() {
        return null;
    }
}

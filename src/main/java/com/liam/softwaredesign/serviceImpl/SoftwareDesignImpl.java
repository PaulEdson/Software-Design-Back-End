package com.liam.softwaredesign.serviceImpl;

import com.liam.softwaredesign.Utils.MailSenderUtils;
import com.liam.softwaredesign.models.*;
import com.liam.softwaredesign.repository.ClientRepository;
import com.liam.softwaredesign.repository.FuelQuoteRepository;
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
    FuelQuoteRepository fuelQuoteRepository;

    @Override
    public Clients insertNewClient(Clients requestBody) {
        Clients newClient = requestBody;
        List<Clients> clientsList = clientRepository.findAll();
        boolean alreadyExist = false;

        for(int i = 0; i < clientsList.size(); i++){
            if(clientsList.get(i).getUser().toLowerCase().compareTo(newClient.getUser().toLowerCase()) == 0){
                alreadyExist = true;
            }
        }

        if(!alreadyExist){
            clientRepository.save(newClient);
            mailSender.sendEmail(newClient.getUser(), "User Registered", "Thank you For Registering! Once your account is enabled please log back on and finish the registration");
        }
        else{
            return null;
        }

        return newClient;
    }

    @Override
    public FuelQuoteForm insertNewFuelQuote(FuelQuoteForm fuelQuoteForm){

        List<FuelQuoteForm> fuelQuoteFormList = fuelQuoteRepository.findAll();

        for(int i = 0; i < fuelQuoteFormList.size(); i++){
            if(fuelQuoteFormList.get(i).equals(fuelQuoteForm)){
                return null;
            }
        }

        fuelQuoteRepository.save(fuelQuoteForm);

        return fuelQuoteForm;
    }

    @Override
    public FuelQuotes getUserQuoteHistory(FuelQuoteRequest fuelQuoteRequest) {
        FuelQuotes fuelQuotes = new FuelQuotes();

        List<FuelQuoteForm> fuelQuoteFormList = fuelQuoteRepository.findByUser(fuelQuoteRequest.getUsername());

        fuelQuotes.setFuelQuotesFormList(fuelQuoteFormList);

        return fuelQuotes;
    }

    @Override
    public FuelQuotes getAllQuoteHistory() {
        FuelQuotes fuelQuotes = new FuelQuotes();

        List<FuelQuoteForm> fuelQuoteFormList = fuelQuoteRepository.findAll();

        fuelQuotes.setFuelQuotesFormList(fuelQuoteFormList);

        return fuelQuotes;
    }

}

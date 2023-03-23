package com.liam.softwaredesign.service;

import com.liam.softwaredesign.models.*;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface SoftwareDesign {

    Clients insertNewClient(Clients requestBody);


    FuelQuoteForm insertNewFuelQuote(FuelQuoteForm fuelQuoteForm);

    FuelQuotes getUserQuoteHistory(FuelQuoteRequest fuelQuoteRequest);

    FuelQuotes getAllQuoteHistory();
}

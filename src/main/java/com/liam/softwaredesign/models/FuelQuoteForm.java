package com.liam.softwaredesign.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection="FuelQuote")
public class FuelQuoteForm {
    private String gallonsRequested;
    private String deliveryAddress;

    private String deliveryDate;

    private String suggestedPrice;

    private String totalAmount;

    private String user;

}

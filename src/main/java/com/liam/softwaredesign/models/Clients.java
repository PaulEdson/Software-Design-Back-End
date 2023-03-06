package com.liam.softwaredesign.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection="Clients")
public class Clients {
    private String name;
    private String user;
}

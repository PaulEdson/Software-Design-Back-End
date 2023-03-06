package com.liam.softwaredesign.connector;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
public class mongo {


    @Bean
    public MongoClient mongoClient() throws Exception{
        MongoCredential cred = MongoCredential.createCredential("softwaredesign", "SoftwareDesign", "SOFT".toCharArray());
        MongoClientSettings mongoClientSettings = null;

        mongoClientSettings = MongoClientSettings.builder()
                .credential(cred)
                .applyConnectionString(new ConnectionString("mongodb+srv://softwaredesign:SOFT@cluster0.yguwuwr.mongodb.net/test"))
                .build();


        return MongoClients.create(mongoClientSettings);
    }


    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), "SoftwareDesign");
    }


}
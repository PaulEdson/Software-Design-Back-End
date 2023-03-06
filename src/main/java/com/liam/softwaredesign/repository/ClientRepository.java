package com.liam.softwaredesign.repository;

import com.liam.softwaredesign.models.Clients;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Clients, String> {




}

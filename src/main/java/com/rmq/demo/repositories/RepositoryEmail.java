package com.rmq.demo.repositories;

import com.rmq.demo.models.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryEmail extends MongoRepository<Email, String> {
    Email findEmailByName(String name);
    Email findEmailByEmail(String name);
    void deleteEmailByName(String name);
    void deleteEmailByEmail(String name);
}

package com.mongo.java.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.java.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

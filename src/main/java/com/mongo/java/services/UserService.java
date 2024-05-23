package com.mongo.java.services;

import java.util.List;

// import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongo.java.models.User;

@Service
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User createUser(User user) {
        return mongoTemplate.insert(user); // multiple user
    }

    public List<User> getAllUser() {
        return mongoTemplate.findAll(User.class);
    }

    public User getUserById(String id) {
        return mongoTemplate.findById(id, User.class);
    }

    public User updateUser(String id, User user) {
        user.setId(id);
        return mongoTemplate.save(user); // save for single user
    }

    public List<User> updateMultipleUsers(String email, String newName) {
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update().set("name", newName);
        mongoTemplate.updateMulti(query, update, newName);
        return mongoTemplate.find(query, User.class);
    }

    public Long countUser() {
        return mongoTemplate.count(new Query(), User.class);
    }

    public void deleteUser(String id) {
        mongoTemplate.remove(getUserById(id));
    }

}

package com.mongo.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongo.java.models.User;
import com.mongo.java.models.UserKafkaDTO;

@Service
public class ConsumerService {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${spring.kafka.topic.topic-java}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenMessage(String message) {
        try {

            System.out.println("Received message: " + message);

            UserKafkaDTO userKafkaDTO = objectMapper.readValue(message, UserKafkaDTO.class);

            System.out.println("Deserialized UserKafkaDTO: " + userKafkaDTO);

            // Map KafkaUserDTO to User
            User user = new User();
            user.setName(userKafkaDTO.getFirstName() + " " + userKafkaDTO.getLastName());
            user.setEmail(userKafkaDTO.getEmailAddress());

            // Save to MongoDB
            userService.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

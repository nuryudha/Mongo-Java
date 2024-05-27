package com.mongo.java.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.java.models.UserKafkaDTO;
import com.mongo.java.services.ProducerService;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private static Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private ProducerService producerService;

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestBody UserKafkaDTO userKafkaDTO) {
        logger.info("Received Request to Send Message : ", userKafkaDTO);
        producerService.sendMessage(userKafkaDTO);
        logger.info("Request Process Succesfully");
        return new ResponseEntity<>("Message Send to Kafka Topic", HttpStatus.OK);
    }
}

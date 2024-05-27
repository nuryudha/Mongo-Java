package com.mongo.java.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Value("${spring.kafka.topic.topic-java}")
    private String kafkaTopic;

    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(Object message) {

        logger.info("Sending Message to Topic Kafka : ", kafkaTopic, message);
        kafkaTemplate.send(kafkaTopic, message);
        logger.info("Message Sent");

    }

}

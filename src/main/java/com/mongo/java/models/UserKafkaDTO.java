package com.mongo.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

// import com.fasterxml.jackson.annotation.JsonProperty;

//Model ini digunakan untuk menangkap pesan dari Kafka:
@Data
public class UserKafkaDTO {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email_address")
    private String emailAddress;

}
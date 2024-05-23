package com.mongo.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.java.models.User;
import com.mongo.java.services.UserService;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class UserController {

    // ? Kalau menggunakan Repo tidak perlu pakai Mongo template begitupun
    // sebaliknya
    // @Autowired
    // private UserRepository userRepository;

    // @PostMapping
    // public User addUser(@RequestBody User user) {
    // return userRepository.save(user);
    // }

    // @GetMapping
    // public List<User> getUsers() {
    // return userRepository.findAll();
    // }

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PutMapping("/updateByEmail/{email}")
    public List<User> updateMutipleUsers(@PathVariable String email, @RequestParam String name) {
        return userService.updateMultipleUsers(email, name);
    }

    @GetMapping("/count")
    public long countUsers() {
        return userService.countUser();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

}

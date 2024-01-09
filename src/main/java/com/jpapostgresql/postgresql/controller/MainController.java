package com.jpapostgresql.postgresql.controller;


import org.springframework.graphql.client.WebGraphQlClient;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import com.jpapostgresql.postgresql.entity.User;
import com.jpapostgresql.postgresql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserService userService;



    @GetMapping("")
    public String getHome(){
        return "Hello, I am Herman web developer springboot and angular";
    }
    @GetMapping("/users")
    public List<User> allUsers(){
        return userService.findAllUser();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody() User user){
        return userService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody() User user){
        return userService.updateUser(id, user);
    }
}

package com.jpapostgresql.postgresql.controller;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import com.jpapostgresql.postgresql.entity.User;
import com.jpapostgresql.postgresql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserGraphqlController {

    @Autowired
    private UserService userService;


    @QueryMapping(name="findOneUser")
    public User findOneUser(@Argument int id){
        return userService.findOneUser(id);
    }


    @QueryMapping(name = "queryUsers")
    public List<User> greeting() {
        return userService.findAllUser();
    }

    @MutationMapping(name="createUser")
    public User createUser(
            @Argument String name,
            @Argument String lastname,
            @Argument String email,
            @Argument String password,
            @Argument String payementway,
            @Argument Boolean islogged
    ){
        User user = new User().builder()
                .name(name)
                .lastname(lastname)
                .email(email)
                .password(password)
                .payementway(payementway)
                .islogged(islogged)
                .build();
        return userService.save(user);
    }


    @MutationMapping(name="updateUser")
    public String updateUser(
            @Argument int id,
            @Argument String name,
            @Argument String lastname,
            @Argument String password,
            @Argument String payementway
    ){
        User user = new User().builder()
                .name(name)
                .email("")
                .lastname(lastname)
                .password(password)
                .payementway(payementway)
                .islogged(false)
                .build();
        return userService.updateUser(id, user);
    }

    @MutationMapping(name= "DeleteUser")
    public String mutationDeleteUser(int id){
        return userService.deleteUser(id);
    }


}


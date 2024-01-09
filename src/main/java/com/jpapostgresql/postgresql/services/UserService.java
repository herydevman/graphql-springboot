package com.jpapostgresql.postgresql.services;

import com.jpapostgresql.postgresql.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public User save(User user);
    public List<User> findAllUser();

    public String deleteUser(int id);

    public String updateUser(int id, User user);

    public User findOneUser(int id);
}

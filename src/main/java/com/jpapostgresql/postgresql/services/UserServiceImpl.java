package com.jpapostgresql.postgresql.services;

import com.jpapostgresql.postgresql.entity.User;
import com.jpapostgresql.postgresql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(int id) {
        User user = userRepository.findById(id).get();
        if (user == null){
            return "Nothing to delete";
        }
        userRepository.delete(user);
        return "successfully deleted";
    }

    @Override
    public String updateUser(int id, User user) {
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setName(user.getName());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setPayementway(user.getPayementway());
        userRepository.save(userToUpdate);
        return "successfully updated";
    }

    @Override
    public User findOneUser(int id) {
        User user = userRepository.findById(id).get();
        return user;
    }

}

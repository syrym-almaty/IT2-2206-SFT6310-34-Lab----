package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User saveUser(@Valid User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public User findUser(Long id) {
        return userRepository.findUserById(id);
    }

}

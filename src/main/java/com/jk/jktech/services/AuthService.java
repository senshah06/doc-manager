package com.jk.jktech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.jktech.entities.User;
import com.jk.jktech.repositories.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user!=null&&password.equals(user.getPassword())) {
        	return user;
        }else {
        	return null;
        }
    }
}

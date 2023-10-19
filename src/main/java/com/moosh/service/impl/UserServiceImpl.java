package com.moosh.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.moosh.domain.model.User;
import com.moosh.domain.repository.UserRepository;
import com.moosh.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findByID(Long id) {
        return userRepository.findById(id)
        .orElseThrow(NoSuchElementException:: new);
    }

    @Override
    public User create(User userToCreate) {
        
        if(userRepository.existsByEmail(userToCreate.getEmail())){
            throw new IllegalArgumentException("This email aready registred!");
        }
        
        return userRepository.save(userToCreate);
    }
    
}

package com.moosh.RaidOrganizer.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.moosh.RaidOrganizer.domain.model.User;
import com.moosh.RaidOrganizer.domain.repository.UserRepository;
import com.moosh.RaidOrganizer.service.UserService;

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

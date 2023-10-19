package com.moosh.service;

import com.moosh.domain.model.User;

public interface UserService {
    User findByID(Long id);

    User create(User userToCreate);

    
}

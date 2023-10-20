package com.moosh.RaidOrganizer.service;


import com.moosh.RaidOrganizer.domain.model.Raid;
import com.moosh.RaidOrganizer.domain.model.User;

public interface UserService {
    User findByID(Long id);

    User create(User userToCreate);

    User addRaidByEmail(String email, Raid raid);
}

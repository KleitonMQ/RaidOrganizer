package com.moosh.RaidOrganizer.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.moosh.RaidOrganizer.domain.model.Raid;
import com.moosh.RaidOrganizer.domain.model.User;
import com.moosh.RaidOrganizer.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findByID(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        var userToCreate = userService.create(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userToCreate.getUserID())
                .toUri();

        return ResponseEntity.created(location).body(userToCreate);
    }

    @PostMapping("/addRaid/{email}")
    public ResponseEntity<User> addRaidByEmail(@PathVariable String email, @RequestBody Raid raid) {
        User updatedUser = userService.addRaidByEmail(email, raid);
        return ResponseEntity.ok(updatedUser);
    }
}

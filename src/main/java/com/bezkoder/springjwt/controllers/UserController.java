package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.model.SearchCondition;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> userList(){

        return userRepository.findAll();
    }

    @GetMapping("/roles")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<User> userRole(long id, SearchCondition searchCondition){

        String test = "test";

        return userRepository.findById(id);
    }

}

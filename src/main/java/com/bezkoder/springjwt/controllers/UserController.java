package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dtos.UserRoleDto;
import com.bezkoder.springjwt.entity.UserRoleEntity;
import com.bezkoder.springjwt.entity.UserRoleIds;
import com.bezkoder.springjwt.model.SearchCondition;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

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

    @DeleteMapping("/roles")
    public boolean delete(Long user_id, SearchCondition searchCondition, UserRoleIds userRoleIds) {

        ArrayList<Integer> testArray =  searchCondition.getRoles();
        userRoleIds.setUser_id(user_id);

        int success_cnt = 0;

        for(Integer tt : testArray){
            userRoleIds.setRole_id(tt);

            if (userRoleRepository.findById(userRoleIds).isPresent()) {
                userRoleRepository.deleteById(userRoleIds);
                success_cnt++;
            }
        }

        if(success_cnt == testArray.size()){
            return true;
        }

        return false;
    }

    @PostMapping("/roles")
    public boolean create(@RequestBody UserRoleDto userRoleDto) {

        // ArrayList<Integer> testArray =  userRoleDto.getRole_id();

        String roles = userRoleDto.getRoles();
        String[] roleArr = roles.split(",");

        // int success_cnt = 0;

        for(String tt : roleArr){

            int val = Integer.parseInt(tt);

            UserRoleEntity entity = UserRoleEntity.builder()
                    .user_id(userRoleDto.getUser_id())
                    .role_id(val)
                    .build();

            userRoleRepository.save(entity);
        }
        return true;
    }

}

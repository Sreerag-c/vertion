package com.ayata.ayatamart.controller;

import com.ayata.ayatamart.dto.response.UserResponse;
import com.ayata.ayatamart.model.User;
import com.ayata.ayatamart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/ayatamart")

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users/login")
    public ResponseEntity<UserResponse> loginUser(@Valid @RequestBody User user) {
        UserResponse userResponse = userService.currentLoginStatus(user);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}

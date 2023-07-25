package com.example.springapp.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.springapp.model.LoginRequest;
import com.example.springapp.model.LoginResponse;
import com.example.springapp.model.User;
import com.example.springapp.service.AuthService;

@CrossOrigin(origins = "https://8081-dfbbcbdcedaecbfcaaafaebabceaeaadbdbabf.project.examly.io")
@RestController
@RequestMapping("/api")
public class AuthController
{

    @Autowired
    AuthService authService;


    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception
    {
        return authService.registerUserService(user);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) throws Exception
    {
        return authService.loginUserService(loginRequest);
    }
    
    
    
    

}
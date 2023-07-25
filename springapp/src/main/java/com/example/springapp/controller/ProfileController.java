package com.example.springapp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.User;
import com.example.springapp.service.AuthService;



@CrossOrigin(origins = "https://8081-bacfeeecffacbfcaaafaebabceaeaadbdbabf.project.examly.io/")
@RestController
@RequestMapping("/api")
public class ProfileController 
{
	
	
    @Autowired
    AuthService authService;
    
    @GetMapping("/home")
    public String homepage()
    {
    	return "Home Page";
    }
    
    @GetMapping("/currentuser")
    public String getUSer(Principal principal)
    {
    	return principal.getName();
    }
	
	@PutMapping("/profile/{id}")
    public ResponseEntity<User> profileedit(@RequestBody User user,@PathVariable("id") long id)
    {
       User u = authService.editUserProfile(user, id);
       return ResponseEntity.ok(u);
    }
    
    @GetMapping("/profile/{id}")
    public ResponseEntity<User> profilepage(@PathVariable("id") long id )
    {
        User user = authService.getUserprofile(id);
    	return ResponseEntity.ok(user);
    }
    

}
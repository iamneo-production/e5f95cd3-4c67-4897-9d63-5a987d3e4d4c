package com.example.springapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> 
{
    //sed to find a user entity by its username
    User findByUsername(String username);
}
package com.example.springapp.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Event;



public interface EventRepository extends JpaRepository<Event, Long>
{

}
=======
import com.example.springapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event,Long> 
{

}
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

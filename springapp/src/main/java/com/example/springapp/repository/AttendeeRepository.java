package com.example.springapp.repository;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Attendee;


=======
import com.example.springapp.model.Attendee;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65
public interface AttendeeRepository extends JpaRepository<Attendee,Long>
{
  List<Attendee> findAttendeeByEventId(Long id);
}
<<<<<<< HEAD

=======
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

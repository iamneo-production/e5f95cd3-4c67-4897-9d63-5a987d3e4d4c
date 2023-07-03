package com.example.springapp.repository;

import com.example.springapp.model.Attendee;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AttendeeRepository extends JpaRepository<Attendee,Long>
{
  List<Attendee> findAttendeeByEventId(Long id);
}
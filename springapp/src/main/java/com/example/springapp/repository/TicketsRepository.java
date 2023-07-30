package com.example.springapp.repository;

<<<<<<< HEAD
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springapp.model.Ticket;


=======
import com.example.springapp.model.Ticket;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

public interface TicketsRepository extends JpaRepository<Ticket,Long>
{
  List<Ticket>  findTicketByEventId(Long id);
  List<Ticket>  findTicketByAttendeeId(Long id);
}

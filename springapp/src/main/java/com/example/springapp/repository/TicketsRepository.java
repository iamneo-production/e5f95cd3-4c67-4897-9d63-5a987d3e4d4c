package com.example.springapp.repository;
import com.example.springapp.model.Ticket;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Ticket,Long>
{
  List<Ticket>  findTicketByEventId(Long id);
  List<Ticket>  findTicketByAttendeeId(Long id);
}

<<<<<<< HEAD
package  com.example.springapp.controller;


import java.util.List;

=======
package com.example.springapp.controller;

import com.example.springapp.model.Ticket;
import com.example.springapp.service.TicketService;


import java.util.List;
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.example.springapp.model.Ticket;
import com.example.springapp.service.TicketService;


@CrossOrigin(origins = "https://8081-ceabacddbcbfcaaafaebabcddfaadfadc.project.examly.io")

=======

@CrossOrigin(origins="http://localhost:8081")
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65
@RestController
@RequestMapping("/ticket")
public class TicketsController 
{
	@Autowired
	private TicketService ticketService;

	public TicketsController()
	{
	}

	public TicketsController(TicketService ticketService) 
	{
		
		this.ticketService = ticketService;
	}

	public TicketService getTicketService() 
	{
		return ticketService;
	}

	public void setTicketService(TicketService ticketService)
	{
		this.ticketService = ticketService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Ticket>> getAllTicket()
	{
		
	   List<Ticket> tic = ticketService.getAllTicket();
	  return ResponseEntity.ok(tic);
	}
	

	
	@GetMapping("/{eventId}")
	public ResponseEntity<List<Ticket>> getTicketByEventId(@PathVariable("eventId") Long eventId)
	{
		List<Ticket> t =   ticketService.getTicketByEventId(eventId);
	 return ResponseEntity.ok(t);
	}




<<<<<<< HEAD
	@GetMapping("/attendee/{attendeeId}")
=======
	@GetMapping("/{attendeeId}")
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65
    public ResponseEntity<List<Ticket>>  getTicketByAttendeeId(@PathVariable("attendeeId") Long attendeeId)
	{
		List<Ticket> t = ticketService.getTicketByAttendeeId(attendeeId);
	return ResponseEntity.ok(t);
	}




<<<<<<< HEAD
	@GetMapping("/ticket/{id}")
=======
	@GetMapping("/{id}")
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65
	public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long id)
	{
		Ticket t = ticketService.getTicketById(id);
	return ResponseEntity.ok(t);
	}
	
    

	@PostMapping
	public ResponseEntity<Ticket> createTicket(@RequestBody  Ticket tickets)
	{
		Ticket tic = ticketService.createTicket(tickets);
		return ResponseEntity.ok(tic);
	}
	
	
	@PutMapping
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket tickets)
	{
		Long ticketId= tickets.getId();	
		Ticket ti = ticketService.updateTicket(tickets,ticketId);
		return ResponseEntity.ok(ti);
	}
	
	@DeleteMapping("/{ticketId}")
	public ResponseEntity<Boolean> deleteTicket(@PathVariable("ticketId") Long ticketId)
	{
		boolean ans = ticketService.deleteTicket(ticketId);
	 return ResponseEntity.ok(ans);
	}
<<<<<<< HEAD
}





=======
	
	
	
	
	
	
}
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

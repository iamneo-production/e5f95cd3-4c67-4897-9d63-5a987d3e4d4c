package com.example.springapp.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springapp.model.Event;
import com.example.springapp.repository.EventRepository;
import com.example.springapp.service.EventService;

import java.util.List;


@CrossOrigin(origins = "https://8081-ceabacddbcbfcaaafaebabcddfaadfadc.project.examly.io")
=======
import com.example.springapp.model.Event;
import com.example.springapp.service.EventService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins="http://localhost:8081")
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65
@RestController
@RequestMapping("/event")
public class EventController
{
	@Autowired
	private EventService eventService;
<<<<<<< HEAD
	
	
	@Autowired
	private EventRepository eventRepository;
=======
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

	public EventController() {
		super();
	}

	public EventController(EventService eventService) {
		super();
		this.eventService = eventService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	
	@PostMapping
    public ResponseEntity<String> createEvent(@RequestBody Event event) 
	{
        Event createdEvent = eventService.createEvent(event);
		if(createdEvent!=null)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body("Event created");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Event creation failed");
        }
      
    }
	
	@GetMapping
    public ResponseEntity<List<Event>> getAllEvent() 
	{
        List<Event> events = eventService.getAllEvent();
     return ResponseEntity.ok(events);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable("id") Long id)
	{
		Event event = eventService.getEventById(id);
	    return ResponseEntity.ok(event);
	}
	
	@PutMapping
    public ResponseEntity<String> updateEvent(@RequestBody Event event)
    {
		Long id = event.getId();
        Event updatedEvent = eventService.updateEvent(event,id);
		if(updatedEvent !=null)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body("Updated");
		}
		else
		{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Event updation failed");
		}
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteEvent(@PathVariable Long id) 
	{
		boolean deleted = eventService.deleteEvent(id);
		if(deleted)
		{
		return ResponseEntity.ok(deleted);
		}
		else
		{
		return ResponseEntity.ok(deleted);
		}
	}
	
<<<<<<< HEAD
	
	@PutMapping("/tickets/{id}")
	public ResponseEntity<String> updateTicketCount(@RequestBody Long ticketCount,@PathVariable("id") Long id)
	{
		
		Event event  = eventService.getEventById(id);
		Long ticketcountnow =event.getTotalTicket();
		System.out.println("event ticket count"+ticketcountnow);
		System.out.println("event tickets to book"+ticketCount);
		System.out.println(event.toString());
		
		if(ticketcountnow < ticketCount)
		{
			return ResponseEntity.ok("Not updated tickets");
		}
		else 
		{
			event.setTotalTicket(ticketcountnow-ticketCount);
			eventRepository.save(event);
		return ResponseEntity.ok("Event tickets count updated");
		}
		
	}
	
	

	
=======
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65
}
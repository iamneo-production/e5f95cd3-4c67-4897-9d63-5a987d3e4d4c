package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Attendee;
import com.example.springapp.model.Event;
import com.example.springapp.repository.AttendeeRepository;
import com.example.springapp.repository.EventRepository;

<<<<<<< HEAD

=======
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65
@Service
public class AttendeeService {
	@Autowired
	private AttendeeRepository attendeeRepository;

	@Autowired
	private EventRepository eventRepository;

	public AttendeeService() {
		super();
	}

	public AttendeeService(AttendeeRepository attendeeRepository) {
		this.attendeeRepository = attendeeRepository;
	}

	public AttendeeRepository getAttendeeRepository() {
		return attendeeRepository;
	}

	public void setAttendeeRepository(AttendeeRepository attendeeRepository) {
		this.attendeeRepository = attendeeRepository;
	}

	public EventRepository getEventRepository() {
		return eventRepository;
	}

	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
<<<<<<< HEAD
	
	
=======
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

	public Attendee registerAttendee(Attendee attendee)
	 {
		long eid = attendee.getEvent().getId();
		Optional<Event> e = eventRepository.findById(eid);
		Event event = e.get();
		attendee.setEvent(event);
		return attendeeRepository.save(attendee);
	}
<<<<<<< HEAD
	
=======
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

	public List<Attendee> getAttendeeByEventId(Long id)
	{
	  return attendeeRepository. findAttendeeByEventId(id);
	}

	
	public Attendee getAttendeeById(Long attendeeId) 
	{
        Optional<Attendee> opt = attendeeRepository.findById(attendeeId);
        return opt.get();
     }
	
	
	public List<Attendee> getAllAttendee() {
		return attendeeRepository.findAll();
	}
<<<<<<< HEAD
	
	
	
	public Attendee getAttendee(long id)
	{
		Optional<Attendee> at = attendeeRepository.findById(id);
		return at.get();
	}
=======
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

	public Attendee updateAttendeee(Long attendeeId,Attendee attendee)
	{
		Optional<Attendee> opt = attendeeRepository.findById(attendeeId);
        if(opt.isPresent())
        {
       	 Attendee att = opt.get();
       	 att.setName(attendee.getName());
       	 att.setEmail(attendee.getEmail());
       	 att.setAddress(attendee.getAddress());
       	 att.setPhone(attendee.getPhone());
       	
        return attendeeRepository.save(att);
        }
        else
        {
        return null;
        }
	}

	public boolean removeAttendeeById(Long attendeeId) {
		Optional<Attendee> opt = attendeeRepository.findById(attendeeId);
		if (opt.isPresent())
		{
			attendeeRepository.deleteById(attendeeId);
			return true;
		}
		return false;
	}
<<<<<<< HEAD
}


=======

}
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

package com.example.springapp.model;
<<<<<<< HEAD



import javax.persistence.*;

import lombok.ToString;



@ToString
=======
import javax.persistence.*;
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65
@Entity
@Table(name="TicketSales")
public class TicketSales
{
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
<<<<<<< HEAD
	   
=======
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65
	   private String totalTicketsBooked;
	   private String AvailableTickets;
	   private String noOfAttendees;
	   private Long eventId;
	   private Double totalPrice;
		public TicketSales() 
		{
			super();
			
		}
		public TicketSales(Long id, String totalTicketsBooked, String availableTickets, String noOfAttendees,
				Long eventId, Double totalPrice) {
			this.id = id;
			this.totalTicketsBooked = totalTicketsBooked;
			AvailableTickets = availableTickets;
			this.noOfAttendees = noOfAttendees;
			this.eventId = eventId;
			this.totalPrice = totalPrice;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTotalTicketsBooked() {
			return totalTicketsBooked;
		}
		public void setTotalTicketsBooked(String totalTicketsBooked) {
			this.totalTicketsBooked = totalTicketsBooked;
		}
		public String getAvailableTickets() {
			return AvailableTickets;
		}
		public void setAvailableTickets(String availableTickets) {
			AvailableTickets = availableTickets;
		}
		public String getNoOfAttendees() {
			return noOfAttendees;
		}
		public void setNoOfAttendees(String noOfAttendees) {
			this.noOfAttendees = noOfAttendees;
		}
		public Long getEventId() {
			return eventId;
		}
		public void setEventId(Long eventId) {
			this.eventId = eventId;
		}
		public Double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(Double totalPrice) {
			this.totalPrice = totalPrice;
		}
		
		
	
<<<<<<< HEAD
}




=======
}
>>>>>>> cd20a07a8d17164e81677b15f295cacebc216f65

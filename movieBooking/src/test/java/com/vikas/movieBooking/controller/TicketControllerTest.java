//package com.vikas.movieBooking.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.vikas.movieBooking.exceptions.MovieIdAlreadyExistsExceptions;
//import com.vikas.movieBooking.model.Ticket;
//import com.vikas.movieBooking.service.TicketService;
//
//@SpringBootTest
//class TicketControllerTest {
//
//	@InjectMocks
//	TicketController ticketController;
//	
//	@Mock
//	TicketService ticketService;
//	
//	@Mock
//	Ticket ticket;
//	
//	@Test
//	void bookTicketTest() throws MovieIdAlreadyExistsExceptions {
//		when(ticketService.bookTicket(null, ticket)).thenReturn("Ticket Booked");
//		assertEquals(new ResponseEntity<>("Ticket Booked", HttpStatus.CREATED), ticketController.bookTicket(null, ticket));
//	}	
//
//}
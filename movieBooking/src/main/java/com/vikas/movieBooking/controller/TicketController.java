package com.vikas.movieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.movieBooking.exceptions.MovieIdAlreadyExistsExceptions;
import com.vikas.movieBooking.model.Ticket;
import com.vikas.movieBooking.service.TicketService;


@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping({"/api/v1/moviebooking"})

public class TicketController {
  @Autowired
  private TicketService ticketService;
  
  @PostMapping({"/book/{movieName}"})
  public ResponseEntity<?> bookTicket(@PathVariable("movieName") String movieName, @RequestBody Ticket ticket) throws MovieIdAlreadyExistsExceptions {
    if (this.ticketService.bookTicket(movieName, ticket) != null) {
      ticket.setMovieName(movieName);
      return new ResponseEntity(ticket,HttpStatus.CREATED);
    } 
    return new ResponseEntity("Movie object is null",HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  @GetMapping({"/ticket/all"})
  public ResponseEntity<?> getAllTicket() {
    List<Ticket> ticketList = this.ticketService.getAllTicket();
    if (ticketList != null)
      return new ResponseEntity(ticketList,HttpStatus.OK); 
    return new ResponseEntity("Ticket List is Empty!",HttpStatus.NO_CONTENT);
  }
  
  @DeleteMapping({"/user/delete/{ticketId}"})
  public ResponseEntity<?> deleteMovie(@PathVariable("ticketId") int ticketId) {
    if (this.ticketService.deleteTicket(ticketId))
      return new ResponseEntity("Ticket got deleted successfully",HttpStatus.OK); 
    return new ResponseEntity("Ticket did not get deleted ", HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
}
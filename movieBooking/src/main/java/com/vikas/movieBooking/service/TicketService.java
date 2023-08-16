package com.vikas.movieBooking.service;

import java.util.List;

import com.vikas.movieBooking.model.Ticket;

public interface TicketService 
{
	Object bookTicket(String bookTicket, Ticket ticket);
	  
	  List<Ticket> getAllTicket();
	  
	  boolean deleteTicket(int tId);
	  
	  Object updateMovie(int mId, String movieName, Ticket ticket);
	  
	  List<Ticket> getTicketByMovieName(String ticket);
	  
	  int getAvailableSeatByMovieName(String mName);
}

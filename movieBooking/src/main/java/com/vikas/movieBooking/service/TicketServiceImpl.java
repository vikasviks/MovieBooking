package com.vikas.movieBooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.movieBooking.model.Movie;
import com.vikas.movieBooking.model.Ticket;
import com.vikas.movieBooking.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
  @Autowired
  private TicketRepository ticketRepository;
  
  @Autowired
  private MovieService movieService;
  
  public Object bookTicket(String movieName, Ticket ticket) {
    Movie movie = this.movieService.getMovieByMovieName(movieName);
    int bookedSeat = getAvailableSeatByMovieName(movieName);
    System.out.println(bookedSeat);
    int totalBookedSeat = bookedSeat + ticket.getSeatBooked();
    if (movie != null && totalBookedSeat <= 100) {
      ticket.setMovieName(movieName);
      ticket.setMovie(movie);
      movie.setTotalSeatBooked(totalBookedSeat);
      movie.setAvailableSeatsForBooking(movie.getTotalSeat() - totalBookedSeat);
      return this.ticketRepository.saveAndFlush(ticket);
    } 
    return null;
  }
   
  public List<Ticket> getAllTicket() {
    return this.ticketRepository.findAll();
  }
  
  public boolean deleteTicket(int ticketId) {
    Optional<Ticket> findById = this.ticketRepository.findById(Integer.valueOf(ticketId));
    if (findById.isPresent()) {
      String movieName = ((Ticket)findById.get()).getMovieName();
      Movie movie = this.movieService.getMovieByMovieName(movieName);
      movie.setTotalSeatBooked(movie.getTotalSeatBooked() - ((Ticket)findById.get()).getSeatBooked());
      movie.setAvailableSeatsForBooking(movie.getAvailableSeatsForBooking() + ((Ticket)findById.get()).getSeatBooked());
      this.ticketRepository.deleteById(Integer.valueOf(ticketId));
      return true;
    } 
    return false;
  }
  
  public Object updateMovie(int ticketId, String moviename, Ticket ticket) {
    Ticket findedTicket = this.ticketRepository.findByTransactionIdAndMovieName(ticketId, moviename);
    if (findedTicket != null) {
      findedTicket.setAddress(ticket.getAddress());
      findedTicket.setMovieName(moviename);
      findedTicket.setTheaterName(ticket.getTheaterName());
      findedTicket.setTransactionId(ticketId);
      this.ticketRepository.saveAndFlush(findedTicket);
      ticket.setBookingTime(findedTicket.getBookingTime());
      return "Data Save";
    } 
    return null;
  }
  
  public List<Ticket> getTicketByMovieName(String moviename) {
    List<Ticket> findedTicket = this.ticketRepository.findByMovieName(moviename);
    if (findedTicket != null)
      return findedTicket; 
    return null;
  }
  
  public int getAvailableSeatByMovieName(String movie) {
    Integer bookedSeat = this.ticketRepository.totalBookingForMovie(movie);
    if (bookedSeat != null)
      return bookedSeat.intValue(); 
    bookedSeat = Integer.valueOf(0);
    return bookedSeat.intValue();
  }
}
package com.vikas.movieBooking.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class Movie {
  @Id
  private int movieId;
  
  private String movieName;
  
  private String theaterName;
  

@CreationTimestamp
  private Date releaseDate;
  
  @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "movie")
  private List<Ticket> ticket;
  
  private int totalSeat;
  
  private int totalSeatBooked;
  
  private int availableSeatsForBooking;

public int getMovieId() {
	return movieId;
}

public void setMovieId(int movieId) {
	this.movieId = movieId;
}

public String getMovieName() {
	return movieName;
}

public void setMovieName(String movieName) {
	this.movieName = movieName;
}

public String getTheaterName() {
	return theaterName;
}

public void setTheaterName(String theaterName) {
	this.theaterName = theaterName;
}

public Date getReleaseDate() {
	return releaseDate;
}

public void setReleaseDate(Date releaseDate) {
	this.releaseDate = releaseDate;
}

public List<Ticket> getTicket() {
	return ticket;
}

public void setTicket(List<Ticket> ticket) {
	this.ticket = ticket;
}

public int getTotalSeat() {
	return totalSeat;
}

public void setTotalSeat(int totalSeat) {
	this.totalSeat = totalSeat;
}

public int getTotalSeatBooked() {
	return totalSeatBooked;
}

public void setTotalSeatBooked(int totalSeatBooked) {
	this.totalSeatBooked = totalSeatBooked;
}

public int getAvailableSeatsForBooking() {
	return availableSeatsForBooking;
}

public void setAvailableSeatsForBooking(int availableSeatsForBooking) {
	this.availableSeatsForBooking = availableSeatsForBooking;
}
  
  
}
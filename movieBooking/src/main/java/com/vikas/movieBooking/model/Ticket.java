package com.vikas.movieBooking.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int transactionId;
  
  @NotNull
  private String movieName;
  
  @NotNull
  private String theaterName;
  
  @NotNull
  private int seatBooked;

  
  private String address;
  
  @UpdateTimestamp
  private Time bookingTime;
  
  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movie_id", nullable = false)
  private Movie movie;
  
  public int getTransactionId() {
    return this.transactionId;
  }
  
  public void setTransactionId(int transactionId) {
    this.transactionId = transactionId;
  }
  
  public String getMovieName() {
    return this.movieName;
  }
  
  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }
  
  public String getTheaterName() {
    return this.theaterName;
  }
  
  public void setTheaterName(String theaterName) {
    this.theaterName = theaterName;
  }
  
  
  public int getSeatBooked() {
    return this.seatBooked;
  }
  
  public void setSeatBooked(int seatBooked) {
    this.seatBooked = seatBooked;
  }
  
  
  public String getAddress() {
    return this.address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  
  public Time getBookingTime() {
    return this.bookingTime;
  }
  
  public void setBookingTime(Time bookingTime) {
    this.bookingTime = bookingTime;
  }
  
  public Movie getMovie() {
    return this.movie;
  }
  
  public void setMovie(Movie movie) {
    this.movie = movie;
  }
}
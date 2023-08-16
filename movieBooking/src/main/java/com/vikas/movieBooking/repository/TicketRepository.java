package com.vikas.movieBooking.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vikas.movieBooking.model.Ticket;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Integer>
{
	@Query("select sum( t.seatBooked)  from Ticket t where t.movieName = :movie_name")
	  Integer totalBookingForMovie(@Param("movie_name") String paramString);
	  
	  Ticket findByTransactionIdAndMovieName(int paramInt, String paramString);
	  
	  List<Ticket> findByMovieName(String paramString);
	
}

package com.vikas.movieBooking.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vikas.movieBooking.model.Movie;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie,Integer> {

	@Query("select m.movieName  from Movie m ")
	  List<String> moviesName();

	Movie findByMovieName(String movieName);
}

package com.vikas.movieBooking.service;

import java.util.List;

import com.vikas.movieBooking.exceptions.MovieIdAlreadyExistsExceptions;
import com.vikas.movieBooking.model.Movie;

public interface MovieService {
	
	List<Movie> getAllMovies();
	  
	  Movie addMovie(Movie movie) throws MovieIdAlreadyExistsExceptions;
	  
	  Movie getMovieById(int movieId);
	  
	  Movie getMovieByMovieName(String movieName);
	  
	  boolean deleteMovie(int movieId);
	  
	  Movie updateMovie(String movieName, Movie movie);
	  
	  List<String> getMoviesList();
}

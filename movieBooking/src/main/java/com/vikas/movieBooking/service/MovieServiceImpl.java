package com.vikas.movieBooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.movieBooking.exceptions.MovieIdAlreadyExistsExceptions;
import com.vikas.movieBooking.model.Movie;
import com.vikas.movieBooking.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
  @Autowired
  private MovieRepository movieRepository;
  
  
  public List<Movie> getAllMovies() {
    return this.movieRepository.findAll();
  }
  
  public Movie addMovie(Movie movie) throws MovieIdAlreadyExistsExceptions {
    Optional<Movie> findById = this.movieRepository.findById(Integer.valueOf(movie.getMovieId()));
    Movie findByMovieName = this.movieRepository.findByMovieName(movie.getMovieName());
    if (findById.isPresent() || findByMovieName != null)
      throw new MovieIdAlreadyExistsExceptions(); 
    movie.setAvailableSeatsForBooking(movie.getTotalSeat()-movie.getTotalSeatBooked());
    return (Movie)this.movieRepository.saveAndFlush(movie);
  }
  
  public boolean deleteMovie(int movieId) {
    Movie findById = this.movieRepository.findById(Integer.valueOf(movieId)).get();
    if (findById.getMovieId() != -1) {
      this.movieRepository.deleteById(Integer.valueOf(movieId));
      return true;
    } 
    return false;
  }
  
  public Movie getMovieById(int movieId) {
    Optional<Movie> findById = this.movieRepository.findById(Integer.valueOf(movieId));
    if (findById.isPresent())
      return this.movieRepository.findById(Integer.valueOf(movieId)).get(); 
    return null;
  }
  
  public Movie getMovieByMovieName(String movieName) {
    return this.movieRepository.findByMovieName(movieName);
  }
  
  public Movie updateMovie(String movieName, Movie movie) {
	    Movie findByMovieName = this.movieRepository.findByMovieName(movieName);
	    if (findByMovieName != null) {
	      Movie movie2 = new Movie();
	      movie2.setMovieName(movieName);
	      movie2.setMovieId(findByMovieName.getMovieId());
	      movie2.setReleaseDate(findByMovieName.getReleaseDate());
	      return (Movie)this.movieRepository.saveAndFlush(movie2);
	    } 
	    return null;
	  }
  
  public List<String> getMoviesList() {
    List<String> listMovies = this.movieRepository.moviesName();
    if (listMovies.isEmpty())
      return null; 
    return listMovies;
  }

}

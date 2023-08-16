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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.movieBooking.exceptions.MovieIdAlreadyExistsExceptions;
import com.vikas.movieBooking.model.Movie;
import com.vikas.movieBooking.service.MovieService;

@RestController
@RequestMapping({"/api/v1/moviebooking"})
@CrossOrigin(origins = {"*"})
public class MovieController {
  @Autowired
  private MovieService movieService;
  
  @GetMapping({"/getAllMovies"})
  public ResponseEntity<?> getAllMovies() {
    List<Movie> movieList = this.movieService.getAllMovies();
    if (movieList != null)
      return new ResponseEntity(movieList,HttpStatus.OK); 
    return new ResponseEntity("Movies List Empty!!",HttpStatus.NO_CONTENT);
  }
  
  @GetMapping({"/movie/{movieId}"})
  public ResponseEntity<?> getMovieById(@PathVariable("movieId") int movieId) {
    Movie movie = this.movieService.getMovieById(movieId);
    if (movie != null)
      return new ResponseEntity(movie,HttpStatus.OK); 
    return new ResponseEntity("Movies List Empty!!",HttpStatus.NO_CONTENT);
  }
  
  @PostMapping({"/admin/addmovie"})
  public ResponseEntity<?> addMovie(@RequestBody Movie movie) throws MovieIdAlreadyExistsExceptions {
    if (this.movieService.addMovie(movie) != null)
      return new ResponseEntity(movie,HttpStatus.CREATED); 
    return new ResponseEntity("Movie object is null",HttpStatus.NO_CONTENT);
  }
  
  @DeleteMapping({"/admin/delete/{movieId}"})
  public ResponseEntity<?> deleteMovie(@PathVariable("movieId") int movieId) {
    if (this.movieService.deleteMovie(movieId))
      return new ResponseEntity("Movie got deleted successfully",HttpStatus.OK); 
    return new ResponseEntity("Movie did not get deleted ",HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  @PutMapping({"/admin/update/{movieName}"})
  public ResponseEntity<?> updateMovie(@PathVariable("movieName") String movieName, @RequestBody Movie movie) throws MovieIdAlreadyExistsExceptions {
    if (this.movieService.updateMovie(movieName, movie) != null) {
      Movie movieByMovieName = this.movieService.getMovieByMovieName(movieName);
      movie.setMovieName(movieName);
      movie.setMovieId(movieByMovieName.getMovieId());
      movie.setReleaseDate(movieByMovieName.getReleaseDate());
      return new ResponseEntity("Movie Updated Successfully",HttpStatus.CREATED);
    } 
    return new ResponseEntity("Movie not Found with movie name",HttpStatus.NO_CONTENT);
  }
   
}

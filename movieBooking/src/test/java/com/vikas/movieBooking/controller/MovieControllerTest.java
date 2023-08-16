//package com.vikas.movieBooking.controller;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.vikas.movieBooking.exceptions.MovieIdAlreadyExistsExceptions;
//import com.vikas.movieBooking.model.Movie;
//import com.vikas.movieBooking.service.MovieService;
//
//@SpringBootTest
//class MovieControllerTest {
//
//	@InjectMocks
//	MovieController movieController;
//	
//	@Mock
//	MovieService movieService;
//	
//	@Mock
//	Movie movie;
//
//
//	@Test
//	void addMovieTest() throws MovieIdAlreadyExistsExceptions {
//		when(movieService.addMovie(movie)).thenReturn(movie);
//		assertEquals(new ResponseEntity<>(movie,HttpStatus.CREATED), movieController.addMovie(movie));
//	}
//
//}
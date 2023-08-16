import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Movie } from '../model/movie';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  url_getAllMovies = 'http://localhost:8080/api/v1/moviebooking/getAllMovies';
  url_getMovieById = 'http://localhost:8080/api/v1/moviebooking/movie/';
  url_addMovie = 'http://localhost:8080/api/v1/moviebooking/admin/addmovie';
  url_updateMovie = 'http://localhost:8080/api/v1/moviebooking/admin/update/';
  url_deleteMovie = 'http://localhost:8080/api/v1/moviebooking/admin/delete/';

  // aws urls 
  // url_getAllMovies = 'https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/movie';
  // url_getMovieById = 'https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/moviebyid/%7Bmovieid+%7D';
  // url_addMovie = 'https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/movie';
  // url_updateMovie = 'https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/moviebyid/%7Bmovieid+%7D';
  // url_deleteMovie = 'https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/moviebyid/%7Bmovieid+%7D';

  constructor(private http: HttpClient) { }

  createMovie(movie: Movie | any): Observable<Movie> {
    // let headers=new HttpHeaders({
    //   'Authorization':`Bearer ${localStorage.getItem('token')}`
    // });
    return this.http.post<Movie>(this.url_addMovie, movie);
  }

  getAllMovie(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.url_getAllMovies)
  }

  deleteMovie(id: any): Observable<any> {
    return this.http.delete<any>(`${this.url_deleteMovie}${id}`);
  }

  updateMovie(movie: any, id: number): Observable<Movie> {
    return this.http.put<Movie>(`${this.url_updateMovie}/${id}`, movie);
  }

}

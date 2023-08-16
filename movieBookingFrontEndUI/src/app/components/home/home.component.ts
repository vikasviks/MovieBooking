import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MovieService } from 'src/app/services/movie.service';
import { UserService } from 'src/app/services/user.service';
import { Movie } from 'src/app/model/movie';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';

let ELEMENT_DATA: Movie[] = [
];

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  movie:Movie=new Movie();
  role: string | any = localStorage.getItem('roles')
  movies: Movie[] | any[] = [];
  displayedColumns: string[] = ['movieId', 'movieName','theaterName', 'totalSeatBooked', 'availableSeatsForBooking', 'action'];
  dataSource: any = new MatTableDataSource(this.movies);
  createMovieForm=new FormGroup({
    movieId:new FormControl(''),
    movieName:new FormControl(''),
    totalSeat:new FormControl(''),
    theaterName:new FormControl('')
  })

  constructor(private movieService: MovieService, private userService: UserService,private router:Router) { }
  ngOnInit(): void {
    this.getAllMovie()
  }

  getAllMovie() {
    this.movieService.getAllMovie().subscribe(data => {
      this.movies = data
      this.dataSource = this.movies
      console.log(this.movies)
      
    }, error => {
      console.log(error)
    })
  }

  deleteMovie(event: any) {
    alert('Movie will be deleted with id:' + event)
    this.movieService.deleteMovie(event).subscribe(data => {
    },
    error => {
      console.log(error);
    })
    window.location.reload();
  }

  getMovieName(event: any) {
    localStorage.setItem('movieName', event)
    console.log(event)
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  update(event:any){
    alert('Movie will be updated with id:' + event)
    this.movieService.updateMovie(event,this.movie.movieId).subscribe(data => {
    },
    error => {
      console.log(error);
    })
    window.location.reload();
  }

}


import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-ticket-booking',
  templateUrl: './ticket-booking.component.html',
  styleUrls: ['./ticket-booking.component.css']
})
export class TicketBookingComponent implements OnInit {
  movieName:any=localStorage.getItem('movieName');
  constructor(private ticketService:TicketService,private router:Router) { }

  bookingForm=new FormGroup({
    theaterName:new FormControl(''),
    seatBooked:new FormControl(''),
    address:new FormControl('')
  })

  ngOnInit(): void {
  }

  bookTicket(){
    this.ticketService.bookTicket(this.bookingForm.value,this.movieName).subscribe(res=>{
      window.alert("Booking Confirm for Movie!!! \n"+this.movieName)
      this.router.navigate(['/home'])
    })
  }

  cancel(){
    this.router.navigate(['/home'])
  }

}

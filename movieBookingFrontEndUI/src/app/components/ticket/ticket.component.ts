import { Component, OnInit } from '@angular/core';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {
  data:any[]=[]
  displayedColumns: string[] = ['transactionId', 'movieName', 'theaterName', 'seatBooked','address','bookingTime'];
  dataSource:any[]=[];
  constructor(private ticketService:TicketService) { }

  ngOnInit(): void {
    this.ticketService.getAllTicket().subscribe(res=>{
      this.dataSource=res
    })
  }

}

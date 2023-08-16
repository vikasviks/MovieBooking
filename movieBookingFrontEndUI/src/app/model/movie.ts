import { Ticket } from "../model/ticket";

export class Movie {

  movieId  :number |any;
  movieName:string |any;
  theaterName:string |any;
  releaseDate:Date|any;
  totalSeat:number |any;
  totalSeatBooked:number |any;
  availableSeatsForBooking:number |any;
  ticketList: Array<Ticket>=[];

}

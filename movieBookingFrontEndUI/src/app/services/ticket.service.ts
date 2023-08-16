import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  url_getTicket='http://localhost:8080/api/v1/moviebooking/ticket/all'
  url_bookTicket='http://localhost:8080/api/v1/moviebooking/book/'
  url_deleteTicket='http://localhost:8080/api/v1/moviebooking/book/'

  // aws Urls
  // url_getTicket='https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/ticket'
  // url_bookTicket='https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/ticket/%7Bmoviename+%7D'
  // url_deleteTicket='https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/ticket/%7Bmoviename+%7D'


  constructor(private http:HttpClient) { }

  getAllTicket():Observable<any>{
  return this.http.get<any>(this.url_getTicket,{})
  }

  bookTicket(data:any,movieName:any):Observable<any>{
    return this.http.post<any>(`${this.url_bookTicket}${movieName}`,data)
    }

}

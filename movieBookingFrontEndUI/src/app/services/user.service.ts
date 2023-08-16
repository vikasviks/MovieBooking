import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  adminStatus:boolean=false
  status:boolean=false
  user!:User;
  loggedIn=false;

  url_register='http://localhost:8084/auth/v1/addUser'
  url_login='http://localhost:8080/call/consumer/login'
  url_forgetPassword='http://localhost:8084/auth/v1/forgetPassword/'
  url_getAllUsers='http://localhost:8084/api/v1/getAllUsers'

  // aws url 
  // url_register='https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/user'
  // url_login='https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/user/userlogin'
  // url_forgetPassword='https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/%7Bforgetpasswordid+%7D'
  // url_getAllUsers='https://2y2g6zgxmb.execute-api.us-west-2.amazonaws.com/movieApi/user'

  constructor(private http:HttpClient) { }

    authenticate(loginId:string, password:string):Observable<boolean>{
     return this.http.get<boolean>(this.url_login+loginId+'/'+password);
  }

  registerUser(user: User | any): Observable<User> {
    return this.http.post<User>(this.url_register, user);
  }

  loginUser(userDetails:any):Observable<any>{
    let headers=new HttpHeaders().set("Access-Control-Allow-Origin", "*")
    return this.http.post<loginResponse>(this.url_login,userDetails,{headers});
  }

  getAllUser():Observable<User[]>{
    return this.http.get<User[]>(this.url_getAllUsers);
  }

  forgetPassword(id:any):Observable<any>{
        let headers=new HttpHeaders().set("Access-Control-Allow-Origin", "*")
    return this.http.put<User>(`${this.url_forgetPassword}${id}`,{headers});
  }
  
}
interface loginResponse{
    Message:any
    Token:any
}

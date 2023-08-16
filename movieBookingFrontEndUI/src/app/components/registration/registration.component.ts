import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user:User=new User();
  users:User[]=[];
  data:any={}

  status!:boolean;
  UserForm = new FormGroup({
    loginId: new FormControl(''),
    userName: new FormControl(''),
    password:new FormControl(''),
    email: new FormControl(''),
    role: new FormControl(''),
    secretQuestion:new FormControl('First Pet'),
    answer:new FormControl(''),
    contactNumber: new FormControl(''),
    confirmPassword: new FormControl(''),    
  });
  
  constructor(private service:UserService, private route:Router) { }

  addUser(){
    this.user.id=this.UserForm.value.loginId
    this.user.username=this.UserForm.value.userName
    this.user.password=this.UserForm.value.password
    this.user.email=this.UserForm.value.email
    this.user.confirmPassword=this.UserForm.value.confirmPassword
    this.user.contactNumber=this.UserForm.value.confirmPassword
    this.user.roles=this.UserForm.value.role
    this.user.answer=this.UserForm.value.answer
    this.service.registerUser(this.user).subscribe(data=>{
      console.log(data)
      alert("User is Registered!")
      this.route.navigate(['/login'])
    },
    error=>{
      console.log(error);
    })    
  }


  cancel(){
    this.route.navigate(['']);
  }
  ngOnInit(): void {
    // this.user1=this.UserForm.value;
  }

}

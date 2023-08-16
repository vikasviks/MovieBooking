import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
  
  user:User=new User();
  users:User[]=[];
  data:any={}
  
  form=new FormGroup({
    username:new FormControl(''),
    password:new FormControl(''),
    confirmPassword:new FormControl(''),
    answer:new FormControl('')
  });
  
  constructor(private userService:UserService,private router:Router) { }

  getForgetPasswordFormData(){
    if(this.form.value.password!==this.form.value.confirmPassword){
      alert("Please Type password & confirm password same")
      this.router.navigate(['/forget'])
    }else{
      this.user.password=this.form.value.password
      // this.userService.forgetPassword(this.data).subscribe(data=>{
      //   console.log(data)
      //   alert("Movie is Created!")
      //   this.router.navigate(['/home'])
      // })
      alert("Password is changed")
      this.router.navigate(['/login'])
    }
   
  }

  cancel(){
    this.router.navigate(['/login'])
  }


  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-testdemo',
  templateUrl: './testdemo.component.html',
  styleUrls: ['./testdemo.component.css']
})
export class TestdemoComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  sumOfTwoNumber(num1:number,num2:number){
    return num1+num2;
  }

  evenOrOdd(val:number){
    if(val%2==0){
      return 'even'
    }
    else{
      return 'odd'
    }
  }

}

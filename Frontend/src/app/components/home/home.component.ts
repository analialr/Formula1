import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username: string | null;
  follows: [] | null;

  constructor() { 
    this.username = '';
    this.follows = [];
  }

  ngOnInit(): void {
    // localStorage.getItem("currentUser");
    this.username = JSON.parse(localStorage.getItem("currentUser") as string).username;
    this.follows = JSON.parse(localStorage.getItem("currentUser") as string).follows;
    console.log(this.follows);
  }

}

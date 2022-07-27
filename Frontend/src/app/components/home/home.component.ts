import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FollowService } from 'src/app/services/follow.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username: string | null;
  follows: [];

  constructor(private followService: FollowService) { 
    this.username = '';
    this.follows = [];
  }

  ngOnInit(): void {
    this.username = JSON.parse(localStorage.getItem("currentUser") as string).username;
    this.follows = JSON.parse(localStorage.getItem("currentUser") as string).follows;
  }

  unfollow(driverId:string, index:number):void {
    let userId:number = JSON.parse(localStorage.getItem("currentUser") as string).id;
    this.followService.unfollow(userId, driverId).subscribe(
      () => {
        let currentUser = JSON.parse(localStorage.getItem("currentUser") as string);
        currentUser.follows.splice(index, 1);
        this.follows = currentUser.follows;
        localStorage.removeItem('currentUser');
        localStorage.setItem('currentUser', JSON.stringify(currentUser));
      }
    );
  }

}

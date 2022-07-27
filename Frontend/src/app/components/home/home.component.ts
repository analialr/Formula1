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
  follows: any[];
  results: any[];
  currentYear: number;

  constructor(private followService: FollowService) { 
    this.username = '';
    this.follows = [];
    this.results = [];
    this.currentYear = new Date().getFullYear();
  }

  ngOnInit(): void {
    this.username = JSON.parse(localStorage.getItem("currentUser") as string).username;
    this.follows = JSON.parse(localStorage.getItem("currentUser") as string).follows;
    if (this.results.length === 0) {
      this.followService.getResultsData(this.currentYear).subscribe((result:any) => {
        console.log("res",result.response);
        
        this.follows.forEach((follow:any, index:number) => {
          let first:any = result.response.find((result:any) => {
            return result.driver.name.includes(follow.givenName) && result.driver.name.includes(follow.familyName);
          });
          if (first !== undefined) {
            this.results[follow.driverId] = first;
          }
        });

      });
    }
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

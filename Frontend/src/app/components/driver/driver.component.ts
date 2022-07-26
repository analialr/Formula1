import { Component, OnInit } from '@angular/core';
import { DriverService } from 'src/app/services/driver.service';
import { FollowService } from 'src/app/services/follow.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html',
  styleUrls: ['./driver.component.css']
})
export class DriverComponent implements OnInit {
  drivers: [] | null;

  constructor(
    private driverService: DriverService,
    private followService: FollowService
  ) { 
 
    this.drivers = []; 
 
  }

  ngOnInit(): void {
    this.driverService.getDrivers().subscribe(
      result => {
        console.log(result);
        this.drivers = result;
      }
    ) 
  }

  follow(driverId:string) {
    let userId:number = JSON.parse(localStorage.getItem("currentUser") as string).id;
    console.log(userId, driverId);
    this.followService.follow(userId, driverId).subscribe(
      (user: User) => {
        console.log(user);
        console.log(user.follows.length);
        localStorage.removeItem('currentUser');
        localStorage.setItem('currentUser', JSON.stringify(user));
      }
    );
  }

}

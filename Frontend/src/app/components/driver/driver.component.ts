import { Component, OnInit } from '@angular/core';
import { DriverService } from 'src/app/services/driver.service';

@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html',
  styleUrls: ['./driver.component.css']
})
export class DriverComponent implements OnInit {
  drivers: [] | null;

  constructor( private driverService: DriverService) { 
   
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

}

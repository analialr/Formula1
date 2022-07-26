import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Driver } from '../models/driver.model';



@Injectable({
  providedIn: 'root'
})
export class DriverService {
  
  readonly API_URL = 'http://localhost:8080';

  constructor(
    private http: HttpClient
  ) { }

 

  getDrivers(): Observable<any> {
    return this.http.get<any>(`${this.API_URL}/drivers`, {});  
  }
}

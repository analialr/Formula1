import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';


@Injectable({
  providedIn: 'root'
})
export class FollowService {
  
  readonly API_URL = 'http://localhost:8080';

  constructor(
    private http: HttpClient
  ) { }

  follow(userId: number, driverId: string): Observable<User> {
    return this.http.post<User>(`${this.API_URL}/users/${userId}/follows/${driverId}`, {});
  }

  unfollow(userId: number, driverId: string): Observable<any> {
    return this.http.delete(`${this.API_URL}/users/${userId}/follows/${driverId}`, {});
  }
}
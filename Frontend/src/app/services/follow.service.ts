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

  getResultsData() {
    let headers = new HttpHeaders()
    .set('X-RapidAPI-Key', '78c83e8d62msh3cfab604663e8d0p1e5261jsnd0f47d777da0')
    .set('X-RapidAPI-Host', 'api-formula-1.p.rapidapi.com');
    return this.http.get<any>("https://api-formula-1.p.rapidapi.com/rankings/drivers?season=2022", { headers: headers });

  }
}
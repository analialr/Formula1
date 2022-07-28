import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Race } from 'src/app/models/race.model';


@Injectable({
  providedIn: 'root'
})
export class RaceService {
  
  readonly API_URL = 'http://localhost:8080';

  constructor(
    private http: HttpClient
  ) { }

 

  getLastRace(): Observable<Race> {
    return this.http.get<Race>(`${this.API_URL}/races/last`, {});
  }


  
}

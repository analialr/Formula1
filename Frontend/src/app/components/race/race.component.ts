import { Component, OnInit } from '@angular/core';
import { RaceService } from 'src/app/services/race.service';
import { Race } from 'src/app/models/race.model';

@Component({
  selector: 'app-race',
  templateUrl: './race.component.html',
  styleUrls: ['./race.component.css']
})
export class RaceComponent implements OnInit {
  race: Race | null;

  constructor(private raceService: RaceService) {
    this.race = null;
  }

  ngOnInit(): void {
    this.raceService.getLastRace().subscribe( result => { this.race = result; }) 
  }

}

import { Component, OnInit } from '@angular/core';
import { Termek } from '../termek';
import { GymService } from '../gym.service';

@Component({
  selector: 'app-termek',
  templateUrl: './termek.component.html',
  styleUrls: ['./termek.component.css']
})
export class TermekComponent implements OnInit {
  public termekek!: Termek[];
  constructor(private GymService: GymService) { }

  ngOnInit(): void {
    this.getTermekek();
  }
  public getTermekek(): void{
    this.GymService.getTermekek().subscribe(
      (response: Termek[]) => {
        this.termekek = response;
      }
    );
  }
  
}

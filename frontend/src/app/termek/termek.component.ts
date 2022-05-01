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

  public searchTermek(key: string): void{
    const results: Termek[] = [];
    for(const termek of this.termekek){
      if(termek.termek_nev.toLowerCase().indexOf(key.toLowerCase()) !== -1){
        results.push(termek);
      }
    }
    this.termekek = results;
    if(results.length === 0 || !key){
      this.getTermekek();
    }
  }
  
}

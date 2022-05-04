import { Component, OnInit } from '@angular/core';
import { Termek } from '../termek';
import { GymService } from '../gym.service';
import { NgForm } from '@angular/forms';
import { Rendeles } from '../rendeles';
import { HttpErrorResponse } from '@angular/common/http';
import { Berlet } from '../berlet';

@Component({
  selector: 'app-termek',
  templateUrl: './termek.component.html',
  styleUrls: ['./termek.component.css']
})
export class TermekComponent implements OnInit {
  public termekek!: Termek[];
  berletek!:Berlet[];
  constructor(private GymService: GymService) { }

  ngOnInit(): void {
    this.getBerletek();
    this.getTermekek();
  }
  public getTermekek(): void{
    this.GymService.getTermekek().subscribe(
      (response: Termek[]) => {
        this.termekek = response;
      }
    );
  }

  public addRendelesTermek(addTermekForm: NgForm): void{
    document.getElementById('add-termek-form')?.click();
    this.GymService.addRendelesTermek(addTermekForm.value).subscribe(
      (response:Rendeles)=>{
        addTermekForm.reset();
      }
      ,(error: HttpErrorResponse) =>{
        alert("Sikeres Rendelés!");
        addTermekForm.reset();
        alert(error.message);
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
  public onOpenModalTermek(rendeles: Rendeles, mode: string): void {
    const container = document.getElementById('container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addRendelesTermekModal');
    }
    container?.appendChild(button);
    button.click();
  }
  public getBerletek(): void{
    this.GymService.getBerletek().subscribe(
      (response: Berlet[]) => {
        this.berletek = response;
      }
    );
  }
  public addRendelesBerlet(addBerletForm: NgForm): void{
    document.getElementById('add-berlet-form')?.click();
    this.GymService.addRendelesBerlet(addBerletForm.value).subscribe(
      (response:Rendeles)=>{
        alert(response);
        addBerletForm.reset();
      }
    );
  } 

  public onOpenModalBerlet(rendeles: Rendeles, mode: string): void {
    const container = document.getElementById('container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addRendelesBerletModal');
    }
    container?.appendChild(button);
    button.click();
  }
}

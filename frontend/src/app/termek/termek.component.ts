import { Component, OnInit } from '@angular/core';
import { Termek } from '../termek';
import { GymService } from '../gym.service';
import { NgForm } from '@angular/forms';
import { Rendeles } from '../rendeles';
import { HttpErrorResponse } from '@angular/common/http';

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

  public addRendelesTermek(addForm: NgForm): void{
    document.getElementById('add-employee-form')?.click();
    this.GymService.addRendelesTermek(addForm.value).subscribe(
      (response:Rendeles)=>{
        addForm.reset();
      }
      ,(error: HttpErrorResponse) =>{
        alert(error.message);
        addForm.reset();
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
  public onOpenModal(rendeles: Rendeles, mode: string): void {
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
}

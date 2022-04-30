import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Edzo } from './edzo';
import { Felhasznalo } from './felhasznalo';
import { GymService } from './gym.service';
import { Termek } from './termek';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  public felhasznalok!: Felhasznalo[];
  public editFelhasznalo!: Felhasznalo;
  public deleteFelhasznalo!: Felhasznalo;
  public edzok!: Edzo[];
  public termek!: Termek[];

  constructor(private GymService: GymService) { }

  ngOnInit() {
      this.getFelhasznalok();
  }
  
  public getFelhasznalok(): void {
    this.GymService.getFelhasznalok().subscribe(
      (response: Felhasznalo[]) => {
        this.felhasznalok = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddFelhasznalo(addForm: NgForm):void {
    document.getElementById('add-felhasznalo-form')?.click();
    this.GymService.addFelhasznalok(addForm.value).subscribe(
      (response: Felhasznalo) =>{
        console.log(response);
        this.getFelhasznalok();
        addForm.reset();
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateFelhasznalo(felhasznalo: Felhasznalo):void {
    this.GymService.updateFelhasznalo(felhasznalo).subscribe(
      (response: Felhasznalo) =>{
        console.log(response);
        this.getFelhasznalok();
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }

  public onDeleteFelhasznalo(felhasznaloID: number):void {
    this.GymService.deleteFelhasznalo(felhasznaloID).subscribe(
      (response: void) =>{
        console.log(response);
        this.getFelhasznalok();
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }

public searchFelhasznalok(key: string): void{
  const results: Felhasznalo[] = [];
  for(const felhasznalo of this.felhasznalok){
    if(felhasznalo.felhasznalonev.toLowerCase().indexOf(key.toLowerCase()) !== -1 
    || felhasznalo.felh_vezeteknev.toLowerCase().indexOf(key.toLowerCase()) !== -1
    || felhasznalo.felh_keresztnev.toLowerCase().indexOf(key.toLowerCase()) !== -1
    || felhasznalo.felh_email.toLowerCase().indexOf(key.toLowerCase()) !== -1
    || felhasznalo.felh_telefon.toLowerCase().indexOf(key.toLowerCase()) !== -1){
      results.push(felhasznalo);
    }
  }
  this.felhasznalok = results;
  if(results.length === 0 || !key){
    this.getFelhasznalok();
  }
}

  public onOpenModal(felhasznalo: Felhasznalo, mode:string):void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');
    if(mode === 'add'){
      button.setAttribute('data-target','#addFelhasznaloModal');
    }
    if(mode === 'edit'){
      this.editFelhasznalo = felhasznalo;
      button.setAttribute('data-target','#updateFelhasznaloModal');
    }
    if(mode === 'delete'){
      this.deleteFelhasznalo =  felhasznalo;
      button.setAttribute('data-target','#deleteFelhasznaloModal');
    }
    container?.appendChild(button);
    button.click();
  }
}

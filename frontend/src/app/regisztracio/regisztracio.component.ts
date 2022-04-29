import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Edzo } from './../edzo';
import { Felhasznalo } from './../felhasznalo'
import { GymService } from './../felhasznalo.service';
import { EdzokService } from './../edzok.service';


@Component({
  selector: 'app-regisztracio',
  templateUrl: './regisztracio.component.html',
  styleUrls: ['./regisztracio.component.css']
})
export class RegisztracioComponent implements OnInit {
  

  constructor(private GymService: GymService) { }

  ngOnInit(): void {
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
  getFelhasznalok() {
    throw new Error('Method not implemented.');
  }
}

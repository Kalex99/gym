import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Edzo } from './../edzo';
import { Felhasznalo } from './../felhasznalo'
import { GymService } from '../gym.service';
import { FormBuilder, FormControl } from '@angular/forms';


@Component({
  selector: 'app-regisztracio',
  templateUrl: './regisztracio.component.html',
  styleUrls: ['./regisztracio.component.css']
})
export class RegisztracioComponent implements OnInit {
  

  constructor(private GymService: GymService) { }

  ngOnInit(): void {
    this.onAddFelhasznalo;
  }
  public onAddFelhasznalo(addForm: NgForm):void {
    this.GymService.addFelhasznalok(addForm.value).subscribe(
      (response: Felhasznalo) =>{
        console.log(response);
        
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
        addForm.reset();
      }
    );
  }
  public TermekBelepesHiba(){
    alert("Először lépjen be, hogy tudjon vásárolni!")
    console.log(Error("Először lépjen be, hogy tudjon vásárolni!"))
  }
  
}

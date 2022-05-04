import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Felhasznalo } from '../felhasznalo';
import { GymService } from '../gym.service';

@Component({
  selector: 'app-bejelentkezes',
  templateUrl: './bejelentkezes.component.html',
  styleUrls: ['./bejelentkezes.component.css']
})
export class BejelentkezesComponent implements OnInit {
  loginForm!: FormGroup;
  isLoggedIn!: Boolean;
  felhasznalok!:Felhasznalo[];
  constructor(private GymService:GymService, public fb:FormBuilder, private routerLink:Router) { }

  ngOnInit(): void {
    this.initializeform();
    this.getFelhasznalok();
  }
  initializeform(){
    this.loginForm = this.fb.group({
      felhasznalonev: new FormControl(''),
      jelszo: new FormControl(''),
      felhasznaloID: new FormControl('')
    })
  }
  public getFelhasznalok(): void {
    this.GymService.getFelhasznalok().subscribe(
      (response: Felhasznalo[]) => {
        this.felhasznalok = response;
        console.log(response)
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  
  bejelentkezes(){
    
    let isLoggedIn = false;
    for(var i = 0; i < this.felhasznalok.length; i++){
      
      if(this.loginForm.value.felhasznalonev === this.felhasznalok[i].felhasznalonev && this.loginForm.value.jelszo === this.felhasznalok[i].jelszo){
        isLoggedIn = true;
        alert('Sikeres belépés')
        alert('Kérem ezt az FelhasznaloID-t használja vásárláskor, az Ön ID-ja: '+this.felhasznalok[i].felhasznaloID)
      }
    }
    if(isLoggedIn === true){
      this.isLoggedIn = isLoggedIn;
      this.routerLink.navigate(['/termek-component']);

    }else{
      this.isLoggedIn = false;
      console.log('Sikertelen belépés')
    }
    
  }
}

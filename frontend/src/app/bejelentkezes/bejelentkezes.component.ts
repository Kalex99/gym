import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Felhasznalo } from '../felhasznalo';
import { GymService } from '../gym.service';

@Component({
  selector: 'app-bejelentkezes',
  templateUrl: './bejelentkezes.component.html',
  styleUrls: ['./bejelentkezes.component.css']
})
export class BejelentkezesComponent implements OnInit {
  felhasznalok!:Felhasznalo[]
  constructor(private GymService:GymService) { }

  ngOnInit(): void {
  }
  // public onSubmit(): void{
  //   this.GymService.bejelentkezesAccount(felhasznalonev,jelszo).subscribe(
  //     (response: Felhasznalo[]) =>{
  //       console.log(response);
  //       this.getFelhasznalok();
  //     },
  //     (error: HttpErrorResponse) =>{
  //       alert(error.message);
  //     }
  //   );
  // }
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
  public onBejelentkezesAccount(felhasznalonev: string, jelszo: string):void {
    this.GymService.bejelentkezesAccount(felhasznalonev,jelszo).subscribe(
      (response: Felhasznalo[]) =>{
        console.log(response);
        this.getFelhasznalok();
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    );
    // this.GymService.isLoggedIn(isLoggedIn).subscribe(
    //   (response: Felhasznalo)=> {

    //   }
    // )
  }
}

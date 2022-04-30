import { Component, OnInit } from '@angular/core';
import { GymService } from '../gym.service';
import { Edzo } from '../edzo';
import { Felhasznalo } from '../felhasznalo';
import { environment } from 'src/environments/environment';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-edzo',
  templateUrl: './edzo.component.html',
  styleUrls: ['./edzo.component.css']
})
export class EdzoComponent implements OnInit {
  public felhasznalok!: Felhasznalo[];
  public edzok!: Edzo[];
  constructor(private GymService: GymService) { }

  ngOnInit(): void {
    this.getEdzok();
  }
  public getEdzok(): void{
    this.GymService.getEdzok().subscribe(
      (response: Edzo[]) => {
        this.edzok = response;
      }
    );
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
}

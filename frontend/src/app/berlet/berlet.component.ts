import { Component, OnInit } from '@angular/core';
import { Rendeles } from '../rendeles';
import { GymService } from '../gym.service';
import { Berlet } from '../berlet';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-berlet',
  templateUrl: './berlet.component.html',
  styleUrls: ['./berlet.component.css']
})
export class BerletComponent implements OnInit {
  public berletek!: Berlet[];
  constructor(private GymService: GymService) { }

  ngOnInit(): void {
    this.getBerletek();
  }
  public getBerletek(): void{
    this.GymService.getBerletek().subscribe(
      (response: Berlet[]) => {
        this.berletek = response;
      }
    );
  }
  public addRendelesBerlet(addForm: NgForm): void{
    this.GymService.addRendelesTermek(addForm.value).subscribe(
      (response:Rendeles)=>{
        console.log(response);
      }
    );
  }
}

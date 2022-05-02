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
    document.getElementById('add-employee-form')?.click();
    this.GymService.addRendelesBerlet(addForm.value).subscribe(
      (response:Rendeles)=>{
        alert(response);
      }
    );
  }

  public onOpenModal(rendeles: Rendeles, mode: string): void {
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

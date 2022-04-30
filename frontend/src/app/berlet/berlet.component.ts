import { Component, OnInit } from '@angular/core';
import { GymService } from '../gym.service';
import { Berlet } from '../berlet';

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
}

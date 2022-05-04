import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-felszereles',
  templateUrl: './felszereles.component.html',
  styleUrls: ['./felszereles.component.css']
})
export class FelszerelesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  public TermekBelepesHiba(){
    alert("Először lépjen be, hogy tudjon vásárolni!")
    console.log(Error("Először lépjen be, hogy tudjon vásárolni!"))
  }
}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-karrier',
  templateUrl: './karrier.component.html',
  styleUrls: ['./karrier.component.css']
})
export class KarrierComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  public TermekBelepesHiba(){
    alert("Először lépjen be, hogy tudjon vásárolni!")
    console.log(Error("Először lépjen be, hogy tudjon vásárolni!"))
  }
}

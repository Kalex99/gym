import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-kapcsolat',
  templateUrl: './kapcsolat.component.html',
  styleUrls: ['./kapcsolat.component.css']
})
export class KapcsolatComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  public TermekBelepesHiba(){
    alert("Először lépjen be, hogy tudjon vásárolni!")
    console.log(Error("Először lépjen be, hogy tudjon vásárolni!"))
  }
}

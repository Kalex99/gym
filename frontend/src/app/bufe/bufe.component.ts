import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bufe',
  templateUrl: './bufe.component.html',
  styleUrls: ['./bufe.component.css']
})
export class BufeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  public TermekBelepesHiba(){
    alert("Először lépjen be, hogy tudjon vásárolni!")
    console.log(Error("Először lépjen be, hogy tudjon vásárolni!"))
  }

}

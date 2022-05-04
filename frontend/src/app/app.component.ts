import { Component, OnInit } from '@angular/core';
import { GymService } from './gym.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {

  constructor(private GymService: GymService) { }

  ngOnInit() {
  }

}
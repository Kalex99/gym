import { Component, OnInit } from '@angular/core';
import { EdzokService } from '../edzok.service';
import { Edzo } from '../edzo';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-edzo',
  templateUrl: './edzo.component.html',
  styleUrls: ['./edzo.component.css']
})
export class EdzoComponent implements OnInit {
  private apiServerUrl = environment.apiBaseUrl;
  public edzok!: Edzo[];
  constructor(private EdzokService: EdzokService) { }

  ngOnInit(): void {
  }
  public getEdzok(): void{
    this.EdzokService.getEdzok().subscribe(
      (response: Edzo[]) => {
        this.edzok = response;
      }
    );
  }
}

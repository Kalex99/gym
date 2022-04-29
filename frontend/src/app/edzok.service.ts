import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Edzo } from './edzo';

@Injectable({
  providedIn: 'root'
})
export class EdzokService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }
  
  public getEdzok(): Observable<Edzo[]>{
    return this.http.get<Edzo[]>(`${this.apiServerUrl}/szemelyi_edzo/Szemelyi_edzoOlvas`);
  }
}

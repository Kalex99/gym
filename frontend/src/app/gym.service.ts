import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http"
import { Felhasznalo } from "./felhasznalo";
import { environment } from "src/environments/environment";
import { Edzo } from './edzo';
import { Termek } from "./termek";
import { Berlet } from "./berlet";

@Injectable({
    providedIn: 'root'
})
export class GymService{
    private apiServerUrl = environment.apiBaseUrl;
    constructor(private http: HttpClient){}
    

    public getBerletek(): Observable<Berlet[]>{
      return this.http.get<Berlet[]>(`${this.apiServerUrl}/berletVasarlas/berletOlvas`);
    }
    public getFelhasznalok(): Observable<Felhasznalo[]>{
        return this.http.get<Felhasznalo[]>(`${this.apiServerUrl}/felhasznalo/felhOlvas`);
    }
    public getEdzok(): Observable<Edzo[]>{
      return this.http.get<Edzo[]>(`${this.apiServerUrl}/szemelyiEdzo/szemEdzoOlvas`);
    }
    public getTermekek(): Observable<Termek[]>{
      return this.http.get<Termek[]>(`${this.apiServerUrl}/termek/termekOlvas`)
    }
    public addFelhasznalok(felhasznalo: Felhasznalo): Observable<Felhasznalo>{
      return this.http.post<Felhasznalo>(`${this.apiServerUrl}/felhasznalo/felhLetrehoz`,felhasznalo);
    }
    public updateFelhasznalo(felhasznalo: Felhasznalo): Observable<Felhasznalo>{
      return this.http.put<Felhasznalo>(`${this.apiServerUrl}/felhasznalo/felhModosit`,felhasznalo);
    }
    public deleteFelhasznalo(felhasznaloID: number): Observable<void>{
      return this.http.delete<void>(`${this.apiServerUrl}/felhasznalo/felhTorles/${felhasznaloID}`);
    }
}
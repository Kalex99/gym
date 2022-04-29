import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http"
import { Felhasznalo } from "./felhasznalo";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class GymService{
    private apiServerUrl = environment.apiBaseUrl;
    constructor(private http: HttpClient){}

    public getFelhasznalok(): Observable<Felhasznalo[]>{
        return this.http.get<Felhasznalo[]>(`${this.apiServerUrl}/felhasznalo/felhOlvas`);
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
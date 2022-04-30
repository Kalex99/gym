import { StringMap } from "@angular/compiler/src/compiler_facade_interface";

export interface Felhasznalo{
    felhasznaloID:number,
    felhasznalonev:string,
    jelszo:string,
    felh_vezeteknev:string,
    felh_keresztnev:string,
    szuletesi_datum:Date,
    felh_email:string,
    felh_telefon:string
}
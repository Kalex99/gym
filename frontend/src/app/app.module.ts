import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GymService } from './felhasznalo.service';
import { FooldalComponent } from './fooldal/fooldal.component';
import { BerletComponent } from './berlet/berlet.component';
import { TermekComponent } from './termek/termek.component';
import { FelszerelesComponent } from './felszereles/felszereles.component';
import { BufeComponent } from './bufe/bufe.component';
import { KarrierComponent } from './karrier/karrier.component';
import { EdzoComponent } from './edzo/edzo.component';
import { BejelentkezesComponent } from './bejelentkezes/bejelentkezes.component';
import { RegisztracioComponent } from './regisztracio/regisztracio.component';

@NgModule({
  declarations: [
    AppComponent,
    FooldalComponent,
    BerletComponent,
    TermekComponent,
    FelszerelesComponent,
    BufeComponent,
    KarrierComponent,
    EdzoComponent,
    BejelentkezesComponent,
    RegisztracioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [GymService],
  bootstrap: [AppComponent]
})
export class AppModule { }

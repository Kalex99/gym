import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GymService } from './gym.service';
import { FooldalComponent } from './fooldal/fooldal.component';
import { BerletComponent } from './berlet/berlet.component';
import { TermekComponent } from './termek/termek.component';
import { FelszerelesComponent } from './felszereles/felszereles.component';
import { BufeComponent } from './bufe/bufe.component';
import { KarrierComponent } from './karrier/karrier.component';
import { EdzoComponent } from './edzo/edzo.component';
import { BejelentkezesComponent } from './bejelentkezes/bejelentkezes.component';
import { RegisztracioComponent } from './regisztracio/regisztracio.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { KapcsolatComponent } from './kapcsolat/kapcsolat.component';



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
    RegisztracioComponent,
    KapcsolatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [GymService],
  bootstrap: [AppComponent]
})
export class AppModule { }

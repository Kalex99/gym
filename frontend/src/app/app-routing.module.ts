import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FooldalComponent } from './fooldal/fooldal.component';
import { BerletComponent } from './berlet/berlet.component';
import { TermekComponent } from './termek/termek.component';
import { FelszerelesComponent } from './felszereles/felszereles.component';
import { EdzoComponent } from './edzo/edzo.component';
import { BufeComponent } from './bufe/bufe.component';
import { KarrierComponent } from './karrier/karrier.component';
import { RegisztracioComponent } from './regisztracio/regisztracio.component';
import { BejelentkezesComponent } from './bejelentkezes/bejelentkezes.component';
import { KapcsolatComponent } from './kapcsolat/kapcsolat.component';

const routes: Routes = [
  { path: 'fooldal-component', component: FooldalComponent },
  { path: 'berlet-component', component: BerletComponent},
  { path: 'termek-component', component: TermekComponent},
  { path: 'edzo-component', component: EdzoComponent},
  { path: 'felszereles-component', component: FelszerelesComponent},
  { path: 'bufe-component', component: BufeComponent},
  { path: 'karrier-component', component: KarrierComponent},
  { path: 'regisztracio-component', component: RegisztracioComponent},
  { path: 'bejelentkezes-component', component: BejelentkezesComponent},
  { path: 'kapcsolat-component', component: KapcsolatComponent},
  { path: '**', redirectTo: 'fooldal-component' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

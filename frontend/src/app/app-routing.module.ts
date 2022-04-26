import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FooldalComponent } from './fooldal/fooldal.component';
import { BerletComponent } from './berlet/berlet.component';
import { TermekComponent } from './termek/termek.component';
import { FelszerelesComponent } from './felszereles/felszereles.component';
import { EdzoComponent } from './edzo/edzo.component';
import { BufeComponent } from './bufe/bufe.component';
import { KarrierComponent } from './karrier/karrier.component';

const routes: Routes = [
  { path: 'fooldal-component', component: FooldalComponent },
  { path: 'berlet-component', component: BerletComponent},
  { path: 'termek-component', component: TermekComponent},
  { path: 'edzo-component', component: EdzoComponent},
  { path: 'felszereles-component', component: FelszerelesComponent},
  { path: 'bufe-component', component: BufeComponent},
  { path: 'karrier-component', component: KarrierComponent},
  { path: '**', redirectTo: 'fooldal-component' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

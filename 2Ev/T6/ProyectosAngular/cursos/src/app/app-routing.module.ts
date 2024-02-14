import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuscadorComponent } from './componentes/buscador/buscador.component';
import { CursosComponent } from './componentes/cursos/cursos.component';
import { InformacionComponent } from './componentes/informacion/informacion.component';

const routes: Routes = [

  {
    path: 'cursos',
    component:CursosComponent
  },
  {
    path: 'buscador',
    component:BuscadorComponent
  },
  {
    path: 'buscador/:curso/:nivel',
    component:BuscadorComponent
  },
  {
    path: 'info',
    component:InformacionComponent
  },
  {
    path: '**',
    redirectTo: 'info'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

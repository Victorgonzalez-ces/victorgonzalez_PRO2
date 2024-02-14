import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CursosComponent } from './componentes/cursos/cursos.component';
import { BusquedaComponent } from './componentes/busqueda/busqueda.component';
import { InfoComponent } from './componentes/info/info.component';

const routes: Routes = [
  {
    path: 'cursos',
    component: CursosComponent
  },
  {
    path: 'busqueda',
    component: BusquedaComponent
  },
  {
    path: 'busqueda/:curso',
    component: BusquedaComponent
  },
  {
    path: 'info',
    component: InfoComponent
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

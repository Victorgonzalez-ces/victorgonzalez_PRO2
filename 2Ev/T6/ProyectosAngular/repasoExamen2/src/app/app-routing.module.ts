import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CursosComponent } from './componentes/cursos/cursos.component';
import { InformacionComponent } from './componentes/informacion/informacion.component';
import { BusquedaComponent } from './componentes/busqueda/busqueda.component';

const routes: Routes = [
  {
    path: 'cursos',
    component: CursosComponent,
  },
  {
    path: 'info',
    component: InformacionComponent,
  },
  {
    path: 'busqueda',
    component: BusquedaComponent,
  },
  {
    path: 'busqueda/:curso',
    component: BusquedaComponent,
  },
  {
    path: '**',
    redirectTo: "info",
  },  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

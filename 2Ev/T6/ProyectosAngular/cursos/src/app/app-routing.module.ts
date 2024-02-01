import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CursosComponent } from './componentes/cursos/cursos.component';
import { InformacionComponent } from './componentes/informacion/informacion.component';

const routes: Routes = [
  {
    path: 'informacion',
    component:InformacionComponent
  },
  {
    path: 'cursos',
    component:CursosComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

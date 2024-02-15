import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetalleComponent } from './componentes/detalle/detalle.component';
import { NoticiasComponent } from './componentes/noticias/noticias.component';

const routes: Routes = [
  {
    path: 'noticias',
    component: NoticiasComponent
  },
  {
    path: 'detalle',
    component: DetalleComponent
  },
  {
    path: '**',
    redirectTo: 'noticias'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

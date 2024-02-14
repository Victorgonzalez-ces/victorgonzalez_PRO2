import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { InformacionComponent } from './componentes/informacion/informacion.component';
import { ImagenesPipe } from './pipes/imagenes.pipe';
import { CartaAsignaturaComponent } from './componentes/carta-asignatura/carta-asignatura.component';
import { CursosComponent } from './componentes/cursos/cursos.component';
import { BusquedaComponent } from './componentes/busqueda/busqueda.component';

@NgModule({
  declarations: [
    AppComponent,
    InformacionComponent,
    ImagenesPipe,
    CartaAsignaturaComponent,
    CursosComponent,
    BusquedaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

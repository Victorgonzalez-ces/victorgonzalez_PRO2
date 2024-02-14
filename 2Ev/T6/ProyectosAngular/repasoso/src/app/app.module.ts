import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartaAsignaturaComponent } from './componentes/carta-asignatura/carta-asignatura.component';
import { ImagenesPipe } from './pipes/imagenes.pipe';
import { FormsModule } from '@angular/forms';
import { CursosComponent } from './componentes/cursos/cursos.component';
import { BusquedaComponent } from './componentes/busqueda/busqueda.component';
import { InfoComponent } from './componentes/info/info.component';

@NgModule({
  declarations: [
    AppComponent,
    CartaAsignaturaComponent,
    ImagenesPipe,
    CursosComponent,
    BusquedaComponent,
    InfoComponent
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

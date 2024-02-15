import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartaNoticiaComponent } from './componentes/carta-noticia/carta-noticia.component';
import { ImagenesPipe } from './pipes/imagenes.pipe';
import { NoticiasComponent } from './componentes/noticias/noticias.component';
import { FormsModule } from '@angular/forms';
import { DetalleComponent } from './componentes/detalle/detalle.component';
import { NoticiasService } from './servicios/noticias.service';

@NgModule({
  declarations: [
    AppComponent,
    CartaNoticiaComponent,
    ImagenesPipe,
    NoticiasComponent,
    DetalleComponent
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

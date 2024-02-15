import { Component } from '@angular/core';
import { noticia } from '../../model/noticia';
import { NoticiasService } from '../../servicios/noticias.service';
import { CartaNoticiaComponent } from '../carta-noticia/carta-noticia.component';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrl: './detalle.component.css'
})
export class DetalleComponent {
  contenido = ""
  imagen = ""

  noticias: noticia[] = []

  constructor(private servicio: NoticiasService){
    this.noticias = this.servicio.getAllNoticias()
    this.imagen = this.noticias[0].urlToImage
    this.contenido = this.noticias[0].content
    //this.carta.encontrarNoticiaCarta()
  }


}

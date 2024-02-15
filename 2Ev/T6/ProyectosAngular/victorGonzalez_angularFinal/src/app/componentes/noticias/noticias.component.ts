import { ThisReceiver } from '@angular/compiler';
import { Component } from '@angular/core';
import { noticia } from '../../model/noticia';
import { NoticiasService } from '../../servicios/noticias.service';

@Component({
  selector: 'app-noticias',
  templateUrl: './noticias.component.html',
  styleUrl: './noticias.component.css'
})
export class NoticiasComponent {
  noticias: noticia[] = []

  constructor(private servicio: NoticiasService){
    this.noticias = this.servicio.getAllNoticias()
  }

  pulsacionBotones(categoria: string){
    if(categoria == 'deporte'){
      this.noticias = this.servicio.getNoticiasDeportes()
    }else if(categoria == 'politica'){
      this.noticias = this.servicio.getNoticiasPolitica()
    }else if(categoria == 'sociedad'){
      this.noticias = this.servicio.getNoticiasSociedad()
    }else{
      this.noticias = this.servicio.getAllNoticias()
    }
  }
}

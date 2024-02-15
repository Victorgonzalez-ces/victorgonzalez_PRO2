import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';


import { noticia } from '../../model/noticia';
import { NoticiasService } from '../../servicios/noticias.service';

@Component({
  selector: 'app-carta-noticia',
  templateUrl: './carta-noticia.component.html',
  styleUrl: './carta-noticia.component.css'
})
export class CartaNoticiaComponent {
  @Input() noticia: noticia = {source: '', category:'', author:'', title:'', description: '', url:'', urlToImage:'',publishedAt:'',content:''}

  constructor(private ruta: Router){}

  pulsacionDetalle(){
    this.ruta.navigate(['detalle'])
  }
  //encontrarNoticiaCarta(): noticia{
    //  return this.service.encontrarNoticia(this.noticia.author)
  //}
}

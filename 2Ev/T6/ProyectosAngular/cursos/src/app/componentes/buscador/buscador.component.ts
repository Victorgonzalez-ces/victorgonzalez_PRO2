import { Component } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Asignatura } from '../../model/Asignatura';
import { AsignaturasService } from '../../services/asignaturas.service';

@Component({
  selector: 'app-buscador',
  templateUrl: './buscador.component.html',
  styleUrl: './buscador.component.css'
})
export class BuscadorComponent {

  nombreBuscar:string = ""
  asignaturaBuscar:string = ""
  conocimientoBuscar:string = ""
  asignaturaFiltro: Asignatura[] = []
  constructor(private servicio:AsignaturasService, private rutaActiva: ActivatedRoute){
    //console.log(this.rutaActiva.snapshot.params["curso"])
    this.rutaActiva.paramMap.subscribe((item : ParamMap)=>{
      //console.log(item.get('curso'))
      let seleccion:any = item.get("curso")
      let nivel: any = item.get("nivel")
      this.asignaturaBuscar = seleccion
      console.log(seleccion);
      console.log(nivel);
      
      
      this.asignaturaFiltro = this.servicio.getCursoAsignatura(seleccion).filter((item)=>{
        return item.nivel == nivel
      })
    })
  }
  realizarBusqueda(){
    this.asignaturaFiltro =  this.servicio.getCursoAsignatura(this.asignaturaBuscar)
  }
}

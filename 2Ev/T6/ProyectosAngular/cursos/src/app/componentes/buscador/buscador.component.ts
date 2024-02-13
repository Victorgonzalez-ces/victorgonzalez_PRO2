import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
    console.log(this.rutaActiva.snapshot.params["curso"])
  }
  realizarBusqueda(){
    this.asignaturaFiltro =  this.servicio.getCursoAsignatura(this.asignaturaBuscar)
  }
}

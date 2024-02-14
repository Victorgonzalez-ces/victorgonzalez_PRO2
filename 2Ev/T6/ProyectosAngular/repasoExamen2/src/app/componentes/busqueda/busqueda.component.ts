import { Component } from '@angular/core';
import { asignatura } from '../../model/asignatura';
import { AsignaturasService } from '../../servicios/asignaturas.service';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrl: './busqueda.component.css'
})
export class BusquedaComponent {
  nombreBuscar: string = ""
  asignaturaBuscar: string = ""
  asignaturasFiltro: asignatura[] = []

  constructor(private servicio: AsignaturasService, private rutaActiva: ActivatedRoute){
    
    this.rutaActiva.paramMap.subscribe((item: ParamMap)=>{
      let seleccion: any = item.get('curso')
      this.asignaturaBuscar = seleccion
    })
  }
  realizarBusqueda(){
    this.asignaturasFiltro = this.servicio.getCursoAsignaturas(this.asignaturaBuscar)
  }
  realizarBusquedaProfesor(){
    this.asignaturasFiltro = this.servicio.getProfesorAsignaturas(this.nombreBuscar)
  }
}

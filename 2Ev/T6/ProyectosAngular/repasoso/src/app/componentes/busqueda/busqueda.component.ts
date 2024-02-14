import { Component } from '@angular/core';
import { AsignaturasService } from '../../servicios/asignaturas.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { asignatura } from '../../model/asignatura';
import { log } from 'console';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrl: './busqueda.component.css'
})
export class BusquedaComponent {

  profeBuscar = ""
  cursoBuscar = ""
  asignaturasFiltradas: asignatura[] = []
  constructor(private servicio: AsignaturasService, private rutaActual: ActivatedRoute){
      rutaActual.paramMap.subscribe((item: ParamMap)=>{
        if(item.get('curso') == 'dam'){
          this.asignaturasFiltradas = this.servicio.getAsignaturasCurso('DAM')
        }
      })
  }

  realizarBusqueda(){
    this.asignaturasFiltradas = this.servicio.getAsignaturasCurso(this.cursoBuscar)
  }
}

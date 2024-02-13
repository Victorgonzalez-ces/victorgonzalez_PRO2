import { Component } from '@angular/core';
import { Asignatura } from '../../model/Asignatura';
import { AsignaturasService } from '../../services/asignaturas.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrl: './cursos.component.css'
})
export class CursosComponent {
  
  asignaturas: Asignatura[] = [];
    constructor(private servicio: AsignaturasService){
      this.asignaturas = this.servicio.getAllAsignaturas();
    }

  
}

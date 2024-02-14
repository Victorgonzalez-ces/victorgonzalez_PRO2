import { Component } from '@angular/core';
import { asignatura } from '../../model/asignatura';
import { AsignaturasService } from '../../servicios/asignaturas.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrl: './cursos.component.css'
})
export class CursosComponent {

  asignaturasP: asignatura[] = []

   constructor(private servicio: AsignaturasService){
    this.asignaturasP = this.servicio.getAllAsignaturas()
   }
}

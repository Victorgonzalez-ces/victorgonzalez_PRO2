import { Component, input, Input} from '@angular/core';
import { Asignatura } from '../../model/Asignatura';
@Component({
  selector: 'app-carta-asignatura',
  templateUrl: './carta-asignatura.component.html',
  styleUrl: './carta-asignatura.component.css'
})
export class CartaAsignaturaComponent {
 @Input() asignatura: Asignatura = {nombre:"",conocimientos:[],curso:"",horas:2,imagen:"",profesor:"",nivel:1,siglas:""}
}

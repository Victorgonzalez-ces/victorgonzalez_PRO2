import { Component } from '@angular/core';
import { CocheClase } from '../../model/coche';

@Component({
  selector: 'app-concesionario',
  templateUrl: './concesionario.html',
})

export class concesionarioComponent{
    listado: CocheClase[]
}
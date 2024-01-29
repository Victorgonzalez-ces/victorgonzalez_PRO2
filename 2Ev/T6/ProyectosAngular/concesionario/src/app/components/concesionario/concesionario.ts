import { Component } from '@angular/core';
import { CocheClase } from '../../model/coche';

@Component({
  selector: 'app-concesionario',
  templateUrl: './concesionario.html',
})

export class concesionarioComponent{
    listado: CocheClase[] = [];
    listaCocheBuscado:any[] = [];
    listadoCochesMotor: CocheClase [] = [];
    agregarCoche(
      marca: string,
      modelo: string,
      matricula: string,
      cv: string,
      cc: string,
      motor: string
    ) {
      this.listado.push(
        new CocheClase(marca, modelo, Number(cv), Number(cc), matricula, motor)
      );
    }
    buscarCoche(){}

    buscarTipoMotor(motor: string){
      this.listaCocheBuscado = this.listado.filter((item: CocheClase) => {
        return item.getMotor == motor;
      });
    }
    
}
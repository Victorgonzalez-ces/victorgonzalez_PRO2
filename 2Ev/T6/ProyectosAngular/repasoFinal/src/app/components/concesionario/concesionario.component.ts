import { Component } from '@angular/core';
import { CocheClase } from '../../model/Coche';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-concesionario',
  templateUrl: './concesionario.component.html',
  styleUrl: './concesionario.component.css'
})
export class ConcesionarioComponent {
    concesionario = "Concesionario SL";
    imagenConcesionario = '';
    marca: string = '';
    modelo: string = '';
    matricula: string = '';
    cv: string = '';
    cc: string = '';
    motor: string = '';
    precio: string = '';
    listado: CocheClase[] = []
    listadoCocheBuscado: any[] = []
    listadoMotorCoche: CocheClase[] = []
    agregarCoche(){
      if(
        this.marca.length > 0 &&
        this.modelo.length > 0 &&
        this.matricula.length > 0 &&
        Number(this.cc) > 0 &&
        Number(this.cv) > 0 &&
        Number(this.precio) > 0
      ){
        this.listado.push(new CocheClase(
          this.marca,
          this.modelo,
          Number(this.cc),
          Number(this.cv),
          this.matricula,
          Number(this.precio),
          this.motor
        ))

        this.marca = '';
        this.modelo = '';
        this.cc = '';
        this.cv = '';
        this.matricula = '';
        this.precio = '';
        this.motor = '';

        Swal.fire({
          title: 'correcto',
          text: 'Coche agregado correctamente',
          icon: 'success',
          confirmButtonText: 'Cool'
        })
      }else{
        Swal.fire({
          title: 'Error!',
          text: 'Faltan datos',
          icon: 'error',
          confirmButtonText: 'Cool'
        })
      }
    }

    buscarCoche(matricula: string){
      this.listadoCocheBuscado = []
      let cocheBuscado = this.listado.find((item)=>{
        return item.getMatricula == matricula
      })
      this.listadoCocheBuscado.push(cocheBuscado)
    }
  
    buscarTipoMotor(motor: string){
      this.listadoMotorCoche = this.listado.filter((item)=>{
        return item.getMotor.toLocaleLowerCase() == motor.toLocaleLowerCase()
      })
    }


}

import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes'
})
export class ImagenesPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {
    if(value.length>0){
      return value;
    }else{
      return 'https://marketplace.canva.com/EAFrDm3ydqw/1/0/1600w/canva-presentación-noticias-telediario-corporativo-azul-rojo-Vh4S5Wt7FD4.jpg'
    }
  }

}

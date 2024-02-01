import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes'
})
export class ImagenesPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {

    if(value.length>0){
      return value;
    }else{
      return "https://valenciaplaza.com/public/Image/2017/1/lengua.png_NoticiaAmpliada.jpg";
    }
  }

}

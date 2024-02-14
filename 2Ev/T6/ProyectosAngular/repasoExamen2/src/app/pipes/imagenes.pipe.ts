import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes'
})
export class ImagenesPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {
    if(value.length > 0){
      return value
    }else{
      return "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-oJH2cIqxLJ48NzRWy5hxIpT3K-UWwajUWQJp29l6bA&s"
    }

    
  }

}

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  nombre: String = 'Víctor';
  apellido: String = 'González';
  edad: number = 20;
}

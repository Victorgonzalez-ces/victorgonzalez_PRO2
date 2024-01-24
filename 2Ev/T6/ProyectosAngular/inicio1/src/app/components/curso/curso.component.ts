import { Component } from '@angular/core';

@Component({
  selector: 'app-curso',
  templateUrl: './curso.component.html',
  styleUrl: './curso.component.css',
})
export class CursoComponent {
  nombre: String = '';
  pass: String = '';
  curso: String = '';
  mostrar: boolean = false;
  usuarios: String[] = ["usuario 1","usuario 2", "usuario 3", "usuario 4"];
  metodoPulsacion(nombre: String, pass: String, curso: String) {
    this.nombre = nombre;
    this.pass = pass;
    this.curso = curso;
    this.mostrar = true;
    this.usuarios.push(nombre)
  }
  seleccionCurso(curso: String) {}
} 
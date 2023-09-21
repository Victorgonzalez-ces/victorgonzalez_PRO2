import Controller.ProyectosDAM_Controller;
import DataBase.ConexionDB;
import Model.Alumno;
import Model.Profesor;
import Model.Proyecto;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner leer = null;
        int o = 0;
        ProyectosDAM_Controller proyectosDAM_controller = new ProyectosDAM_Controller();
        do {
            leer = new Scanner(System.in);
            System.out.println("1. Agregar alumno\n2. Agregar profesor\n3. Agregar proyecto\n4. Listar proyectos\n5. Salir menú");
            o = leer.nextInt();
            switch (o){
                case 1:
                    System.out.println("introduzca nombre");
                    String name = leer.next();
                    System.out.println("introduzca apellido");
                    String ape = leer.next();
                    System.out.println("introduzca dni");
                    String dni = leer.next();
                    proyectosDAM_controller.agregarAlumno(new Alumno(name,ape,dni));
                    break;
                case 2:
                    System.out.println("introduzca nombre");
                    name = leer.next();
                    System.out.println("introduzca apellido");
                    ape = leer.next();
                    System.out.println("introduzca dni");
                    dni = leer.next();
                    System.out.println("introduzca asignatura");
                    String asig = leer.next();
                    proyectosDAM_controller.agregarProfesor(new Profesor(dni,name,ape,asig));
                    break;
                case 3:
                    System.out.println("Introduzca un titulo");
                    name = leer.next();
                    System.out.println("Introduzca una descripcion");
                    String desc = leer.next();
                    System.out.println("Introduzca un contenido");
                    String cont = leer.next();
                    proyectosDAM_controller.agregarProyecto(new Proyecto(name,desc,cont));
                case 4:
                    System.out.println("Listando proyectos...");
                    proyectosDAM_controller.listarProyectos();
            }
        }while (o!=5);

    }
}

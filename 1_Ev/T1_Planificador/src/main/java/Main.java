import dataBase.GestionDB;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = null;
        /*Tarea.metodoEstatico();
        Tarea tareaInicial = new Tarea(3,"pepe", Prioridades.Media,"caballo");
        Tarea tareaInicial2 = new Tarea(4,"pepa", Prioridades.Media,"caballo");
        Tarea tareaInicial3 = new Tarea(5,"pepu", Prioridades.Media,"caballo");
        //propiedades
        // id;
        // String titulo;
        // String prioridad;
        // String fecha;
        // String descripcion;
        System.out.println(tareaInicial);
        Tarea tareaSecundaria = new Tarea(1,"Tarea secundaria");
        //propiedades
        // id;
        // String titulo;
        // String prioridad;
        // String fecha;
        // String descripcion;
        System.out.println(tareaSecundaria);

        Planificador planificador = new Planificador();
        planificador.agregarTarea(tareaInicial);
        planificador.agregarTarea(tareaInicial2);
        planificador.agregarTarea(tareaInicial3);
        planificador.agregarTarea(tareaSecundaria);
        System.out.println("el numero de tareas es de: "+planificador.getListTareas().size());

        planificador.filtrarTarea(Prioridades.Media);
        */
        //crear un menu para poder agregar tareas al planificador
            //1 agregar tarea : no se pueden agregar tareas con el mismo id
                //ocio o trabajo -> pedir datos
            //2 listar tareas
            //3 modificar tareas: id -> nueva descripcion y nueva prioridad

        GestionDB connection = new GestionDB();
        Planificador planificador = new Planificador();
        int num = 0, id = 0, presupuesto = 0,n1 = 0;
        Prioridades prioridad = null;
        String titulo = null, descripcion = null, ubicacion = null, proyecto = null;
        do {
            System.out.println("introduzca 1 agregar tarea :\n" +
                    "                //ocio o trabajo -> pedir datos\n" +
                    "            //2 listar tareas\n" +
                    "            //3 modificar tareas: id -> nueva descripcion y nueva prioridad");
            leer = new Scanner(System.in);
            num = leer.nextInt();
            switch (num){
                case 0:
                    System.out.println("cerrando programa...");
                    break;
                case 1:
                    System.out.println("ha seleccionado la opción agregar tarea, introduzca 0 para tarea ocio y 1 para tarea trabajo");
                    int n = leer.nextInt();
                    if (n==0){
                        System.out.println("creando tarea de ocio");
                        //int id, String titulo, Prioridades prioridad, String descripcion, String ubicacion, int presupuesto
                        System.out.println("introduzca un id");
                            id = leer.nextInt();
                        System.out.println("introduzca un titulo");
                            titulo = leer.next();
                        System.out.println("introduzca una prioridad- 1.baja 2.media 3.alta");
                            n1 = leer.nextInt();
                        if (n1 == 1){
                            prioridad = Prioridades.Baja;
                        } else if (n1 == 2) {
                            prioridad = Prioridades.Media;
                        } else if (n1 == 3) {
                            prioridad = Prioridades.Alta;
                        }
                        System.out.println("introduzca descripcion");
                            descripcion = leer.next();
                        System.out.println("introduzca ubicacion");
                            ubicacion = leer.next();
                        System.out.println("introduzca presupuesto");
                            presupuesto = leer.nextInt();
                        planificador.agregarTarea(new TareaOcio(id,titulo,prioridad,descripcion,ubicacion,presupuesto));
                    } else if (n==1) {
                        System.out.println("creando tarea de trabajo");
                        //int id, String titulo, Prioridades prioridad, String descripcion, String proyecto
                        System.out.println("introduzca un id");
                            id = leer.nextInt();
                        System.out.println("introduzca un titulo");
                            titulo = leer.next();
                        System.out.println("introduzca una prioridad- 1.baja 2.media 3.alta");
                            n1 = leer.nextInt();
                        if (n1 == 1){
                            prioridad = Prioridades.Baja;
                        } else if (n1 == 2) {
                            prioridad = Prioridades.Media;
                        } else if (n1 == 3) {
                            prioridad = Prioridades.Alta;
                        }
                        System.out.println("introduzca descripcion");
                            descripcion = leer.next();
                        System.out.println("introduzca proyecto");
                            proyecto = leer.next();
                        planificador.agregarTarea(new TareaTrabajo(id,titulo,prioridad,descripcion,proyecto));
                    }else{
                        System.out.println("Error, introduzca solo 0 o 1");
                    }
                    break;
                case 2:
                    planificador.listarTareas();
                    break;
                case 3:
                    System.out.println("introduzca el id de la tarea que desea modificar");
                    id = leer.nextInt();
                    planificador.modificarTarea(id);
                    break;
                default:
                    System.out.println("introduzca un numero del 1 al 3");
            }
        }while (num!=0);
    }
}

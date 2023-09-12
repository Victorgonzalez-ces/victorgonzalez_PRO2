import model.Planificador;
import model.Prioridades;
import model.Tarea;

public class Main {
    public static void main(String[] args) {
        Tarea.metodoEstatico();
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
    }
}

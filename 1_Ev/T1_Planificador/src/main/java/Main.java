import model.Tarea;

public class Main {
    public static void main(String[] args) {
        Tarea.metodoEstatico();
        Tarea tareaInicial = new Tarea();
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
    }
}

package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Tarea {
    //variables
    private int id;
    private String titulo;
    private Prioridades prioridad;
    private String fecha;
    private String descripcion;
    //constructores


    public Tarea() {
        this.fecha = "01/01/20";
        this.prioridad = Prioridades.Baja;
    }

    public Tarea(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = "01/01/20";
        this.prioridad = Prioridades.Baja;
    }

    public Tarea(int id, String titulo, Prioridades prioridad, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.fecha = "01/01/20";
    }

    public static void metodoEstatico(){
        System.out.println("ejemplo de metodo estático para una tarea");
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", fecha='" + fecha + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

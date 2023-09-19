package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaTrabajo extends Tarea implements Gestionario{

    private String proyecto;

    public TareaTrabajo(){
        super();
    }

    public TareaTrabajo(String titulo, String fecha, String descripcion, boolean completada) {
        super(titulo, fecha, descripcion, completada);
    }

    public TareaTrabajo(int id, String titulo, Prioridades prioridad, String descripcion, String proyecto) {
        super(id, titulo, prioridad, descripcion);
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "TareaTrabajo{"+super.toString() +
                "proyecto='" + proyecto + '\'' +
                '}';
    }

    @Override
    public void verDetalle() {

    }
}

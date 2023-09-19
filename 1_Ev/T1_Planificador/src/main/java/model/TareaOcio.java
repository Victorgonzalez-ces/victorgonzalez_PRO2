package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaOcio extends Tarea implements Gestionario{
    private String ubicacion;
    private int presupuesto;

    public TareaOcio() {
        super();
    }

    public TareaOcio(String titulo, String fecha, String descripcion, boolean completada) {
        super(titulo, fecha, descripcion, completada);
    }

    public TareaOcio(int id, String titulo, Prioridades prioridad, String descripcion, String ubicacion, int presupuesto) {
        super(id, titulo, prioridad, descripcion);
        this.ubicacion = ubicacion;
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "TareaOcio{"+super.toString() +
                "ubicacion='" + ubicacion + '\'' +
                ", presupuesto=" + presupuesto +
                '}';
    }

    @Override
    public void verDetalle() {

    }
}

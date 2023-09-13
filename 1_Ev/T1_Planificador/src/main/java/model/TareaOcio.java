package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaOcio extends Tarea{
    private String ubicacion;
    private int presupuesto;

    public TareaOcio() {
        super();
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
}

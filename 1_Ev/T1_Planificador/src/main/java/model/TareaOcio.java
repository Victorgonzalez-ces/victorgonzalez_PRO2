package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
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
}

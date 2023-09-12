package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TareaTrabajo extends Tarea{

    private String proyecto;

    public TareaTrabajo(){
        super();
    }
    public TareaTrabajo(int id, String titulo, Prioridades prioridad, String descripcion, String proyecto) {
        super(id, titulo, prioridad, descripcion);
        this.proyecto = proyecto;
    }
}

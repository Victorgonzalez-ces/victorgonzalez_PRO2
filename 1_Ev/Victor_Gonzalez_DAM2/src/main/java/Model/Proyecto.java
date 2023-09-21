package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Proyecto {
    private String titulo;
    private String descripcion;
    private String contenido;

    public Proyecto(String titulo, String descripcion, String contenido) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}

package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Profesor {

    private String dni_p;
    private String nombre_p;
    private String apellido_p;
    private String asignatura;

    public Profesor(String dni_p, String nombre_p, String apellido_p, String asignatura) {
        this.dni_p = dni_p;
        this.nombre_p = nombre_p;
        this.apellido_p = apellido_p;
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "dni_p='" + dni_p + '\'' +
                ", nombre_p='" + nombre_p + '\'' +
                ", apellido_p='" + apellido_p + '\'' +
                ", asignatura='" + asignatura + '\'' +
                '}';
    }
}


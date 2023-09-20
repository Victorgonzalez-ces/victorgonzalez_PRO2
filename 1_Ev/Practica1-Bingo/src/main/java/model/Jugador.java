package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Jugador {

    private String nombre;
    private String dni;
    private int cartera;

    private ArrayList<Carton> cartones;

    public Jugador(String nombre, String dni, int cartera) {
        this.nombre = nombre;
        this.dni = dni;
        this.cartera = cartera;
        cartones = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", cartera=" + cartera +
                ", cartones=" + cartones +
                '}';
    }
}

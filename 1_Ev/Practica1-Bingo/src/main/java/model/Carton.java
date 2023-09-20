package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Array;
import java.util.Arrays;


@Getter
@Setter
public class Carton {

    //Atributos
    private int id;
    private final int PRECIO = 1;
    private int[] numeros;

    //constructores
    public Carton(int id) {
        this.id = id;
        numeros = new int[10];
        generaAleatorios(numeros);
    }

    //metodo generar aleatorios
    private void generaAleatorios(int[] a){
        for (int i = 0; i < a.length; i++) {
            int num = (int)(Math.random()*100)+1;
            a[i] = num;
            while (a[i]!=num){
                num = (int)(Math.random()*100)+1;
                a[i] = num;
            }
        }
    }


    //metodo toString
    @Override
    public String toString() {
        return "Carton{" +
                "id=" + id +
                ", PRECIO=" + PRECIO +
                ", numeros=" + Arrays.toString(numeros) +
                '}';
    }

    //metodo para saber si existe carton
    //public boolean existeCarton(Carton carton){

    //}
}

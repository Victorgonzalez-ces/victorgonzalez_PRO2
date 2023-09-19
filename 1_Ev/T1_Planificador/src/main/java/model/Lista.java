package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Lista {

    private int id;
    private ArrayList<Tarea> listaCosas;

    public Lista(int id) {
        this.id = id;
        listaCosas = new ArrayList<>();
    }


}

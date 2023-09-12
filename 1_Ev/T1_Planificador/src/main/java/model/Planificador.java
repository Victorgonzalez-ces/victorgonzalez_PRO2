package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Planificador {

    @Getter
    @Setter
    private ArrayList<Tarea> listTareas;

    public Planificador(){
        listTareas = new ArrayList<>();
    }

    //metodo que permite agregar una tarea al planificador
    public boolean agregarTarea(Tarea tarea){
        return listTareas.add(tarea);
    }

    //hacer un metodo que permita filtrar tareas por un tipo de prioridad
    public void filtrarTarea(Prioridades prioridad){
        for (Tarea tarea:listTareas) {
            if (tarea.getPrioridad() == prioridad){
                System.out.println(tarea.toString());
            }
        }
    }
}

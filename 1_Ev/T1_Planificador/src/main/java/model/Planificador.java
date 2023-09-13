package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

public class Planificador {
    Scanner leer = new Scanner(System.in);
    @Getter
    @Setter
    private ArrayList<Tarea> listTareas;

    public Planificador(){
        listTareas = new ArrayList<>();
    }

    //metodo que permite agregar una tarea al planificador
    public void agregarTarea(Tarea tarea){
        boolean aux = false;
        for (int i = 0; i < listTareas.size(); i++) {
            if (listTareas.get(i).getId()!=tarea.getId()){
                aux = true;
            }else{
                aux = false;
            }
        }
        if (listTareas.size()==0){
            System.out.println("agregando tarea");
            listTareas.add(tarea);
        }
        if (aux){
            System.out.println("agregando tarea..");
            listTareas.add(tarea);
            System.out.println("tarea agregada");
        }else{
            System.out.println("no se ha podido crear tarea ya que el id introducido ya existe");
        }
    }

    //hacer un metodo que permita filtrar tareas por un tipo de prioridad
    public void filtrarTarea(Prioridades prioridad){
        System.out.println("listando prioridades: "+prioridad.name());
        for (Tarea tarea:listTareas) {
            if (tarea.getPrioridad() == prioridad){
                System.out.println(tarea.toString());
            }
        }
    }

    public void listarTareas(){
        for (Tarea item:listTareas) {
            System.out.println(item);
        }
    }
    public void modificarTarea(int id){
        for (Tarea item:listTareas) {
            if (id == item.getId()){
                System.out.println("escriba una nueva descripcion");
                item.setDescripcion(leer.next());
                System.out.println("introduzca una prioridad- 1.baja 2.media 3.alta");
                int n1 = leer.nextInt();
                Prioridades prioridad = null;
                if (n1 == 1){
                    prioridad = Prioridades.Baja;
                } else if (n1 == 2) {
                    prioridad = Prioridades.Media;
                } else if (n1 == 3) {
                    prioridad = Prioridades.Alta;
                }
                item.setPrioridad(prioridad);
                System.out.println("la nueva tarea es: ");
                System.out.println(item);
            }else{
                System.out.println("no se ha encontrado ningun id asociado al introducido");
            }
        }
    }
    public void dependenciaTareas(int id){
        if (existeTarea(id)){
            System.out.println("de que tarea quieres que dependa");
            System.out.println("introduce id");
            int n = leer.nextInt();
            for (int i = 0; i < listTareas.size(); i++) {
                if (listTareas.get(i).getId()==n){

                }
            }
        }
    }
    public boolean existeTarea(int id){
        if (listTareas.size()==0){
            return false;
        }else{
            for (Tarea item:listTareas) {
                if (item.getId()==id){
                    return true;
                }
            }
            return false;
        }
    }


    public Tarea devuelveTarea(int id){
        if (listTareas.size()==0){
            return null;
        }else{
            for (Tarea item:listTareas) {
                if (item.getId()==id){
                    return item;
                }
            }
            return null;
        }
    }
}

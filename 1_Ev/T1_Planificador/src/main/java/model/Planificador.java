package model;

import dataBase.GestionDB;
import dataBase.SchemaDB;
import lombok.Getter;
import lombok.Setter;
import model.Gestionario;

import java.sql.*;
import java.util.ArrayList;

@Getter
@Setter
public class Planificador {

    private ArrayList<Gestionario> listaTareas;
    private Connection connection;
    private Statement statement;

    private ResultSet resultSet;
    public Planificador() {
        listaTareas = new ArrayList<>();
        connection = new GestionDB().getConnection();
    }

    public boolean existeId(int id) {

        if (listaTareas.size() == 0) {
            return false;
        } else {

            for (Gestionario item : listaTareas) {

                if (item.getId() == id) {
                    return true;
                }
            }
            return false;
        }




    }
    public void addGestionableSQLPS(Gestionario gestionario){
        try {
            if (gestionario instanceof Tarea){
                PreparedStatement preparedStatement = connection.prepareStatement(String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?,?,?,?)"
                        ,SchemaDB.tabla,SchemaDB.COL_TITULO,SchemaDB.COL_DES,SchemaDB.COL_FECHA,SchemaDB.COL_COMPL));

                preparedStatement.setString(1, ((Tarea) gestionario).getTitulo());
                preparedStatement.setString(2, ((Tarea) gestionario).getDescripcion());
                preparedStatement.setString(3, ((Tarea) gestionario).getFecha());
                preparedStatement.setBoolean(4, ((Tarea) gestionario).isCompletada());
                System.out.println(preparedStatement.executeUpdate());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addGestionableSQL(Gestionario gestionario){
        try{
            statement = connection.createStatement();

        if (gestionario instanceof Tarea){
            //agregar a base de datos
            String query = "INSERT INTO %s (%s, %s, %s, %s) VALUES" +
                    "('%s','%s','%s',%b)";
            statement.execute(String.format(query, SchemaDB.tabla
            , SchemaDB.COL_TITULO, SchemaDB.COL_DES, SchemaDB.COL_FECHA, SchemaDB.COL_COMPL
            , ((Tarea) gestionario).getTitulo(), ((Tarea) gestionario).getDescripcion(), ((Tarea) gestionario).getDescripcion(), ((Tarea) gestionario).isCompletada()));
        }else if (gestionario instanceof Lista){

        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addGestionable(Gestionario tarea) {
        return listaTareas.add(tarea);
    }

    public void getAllTareas(){
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM "+SchemaDB.tabla);
            while(resultSet.next()){
                String titulo = resultSet.getString(SchemaDB.COL_TITULO);
                String descripcion = resultSet.getString(SchemaDB.COL_DES);
                String fecha = resultSet.getString(SchemaDB.COL_FECHA);
                Boolean completa = resultSet.getBoolean(SchemaDB.COL_COMPL);
                TareaOcio tareaOcio = new TareaOcio(titulo,descripcion,fecha,completa);
                System.out.println(tareaOcio.getTitulo()+" "+tareaOcio.getDescripcion()+" "+tareaOcio.getFecha()+" "+tareaOcio.isCompletada());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addLista(Lista lista) {
        return listaTareas.add(lista);
    }

    public void listarTareas() {
        /*for (Tarea item : listaTareas) {
            item.mostrarDatos();
        }*/
    }

    // hacer un método que permita filtrar tareas por un tipo de prioridad
    public void filtrarTareas(Prioridades prioridad) {
        /*for (Tarea tarea : listaTareas) {
            if (tarea.getPrioridad() == prioridad) {
                System.out.println(tarea);
            }
        }*/
    }
}
package controller;

import database.ConectionDB;
import database.SchemeDB;
import model.Tarea;

import java.sql.*;

public class TareaController {
    Connection connection;

    public TareaController(){
        connection = new ConectionDB().getConnection();
    }

    public void insertarTarea(Tarea tarea){
       String query = "INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(String.format(query, SchemeDB.TB_NAME,
                    SchemeDB.COL_TITULO, SchemeDB.COL_DESCRIPCION, SchemeDB.COL_PRIORIDAD, SchemeDB.COL_COMPLETADA));
            ps.setString(1,tarea.getTitulo());
            ps.setString(2,tarea.getDescripcion());
            ps.setString(3,tarea.getPrioridad());
            ps.setBoolean(4,tarea.isCompletada());
            ps.execute();
            System.out.println("tarea añadida correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarTarea(int id){
        String query = "DELETE FROM %s WHERE %s = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(String.format(query,SchemeDB.TB_NAME, SchemeDB.COL_ID));
            ps.setInt(1,id);
            ps.execute();
            System.out.println("Tarea borrada correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTarea(String titulo){
        String query = "UPDATE %s SET %s = ? WHERE %s = 'papa' ";

        try {
            PreparedStatement ps = connection.prepareStatement(String.format(query,SchemeDB.TB_NAME,SchemeDB.COL_TITULO,SchemeDB.COL_TITULO));
            ps.setString(1,titulo);
            ps.execute();
            System.out.println("nombre de tarea modificada correcramente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectTarea(){
        String query = "SELECT * FROM %s";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(String.format(query,SchemeDB.TB_NAME));

            while(rs.next()){
                String titulo = rs.getString(SchemeDB.COL_TITULO);
                String descripcion = rs.getString(SchemeDB.COL_DESCRIPCION);
                String prioridad = rs.getString(SchemeDB.COL_PRIORIDAD);
                boolean completada = rs.getBoolean(SchemeDB.COL_COMPLETADA);

                Tarea tarea = new Tarea(titulo,descripcion,prioridad,completada);
                System.out.println("TITULO: "+tarea.getTitulo());
                System.out.println("DESCRIPCION: "+tarea.getDescripcion());
                System.out.println("PRIORIDAD: "+tarea.getPrioridad());
                System.out.println("COMPLETADA: "+tarea.isCompletada());
                System.out.println("///////////////////////////////////////////////////");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package Controller;

import DataBase.ConexionDB;
import DataBase.SchemaDB;
import Model.Alumno;
import Model.Profesor;
import Model.Proyecto;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;

@Getter
@Setter
public class ProyectosDAM_Controller {

    private Connection connection;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Profesor> profesores;
    public ProyectosDAM_Controller() {
        connection = new ConexionDB().getConnection();
        alumnos = new ArrayList<>();
        profesores = new ArrayList<>();
    }

    public void agregarAlumno(Alumno al){
        String query = "INSERT INTO %s(%s,%s,%s) VALUES (?,?,?)";
        boolean aux = false;
        if (alumnos.size()==0){
            alumnos.add(al);
            try {
                PreparedStatement ps = connection.prepareStatement(String.format(query, SchemaDB.TABLE_NAME_AL, SchemaDB.COL_NOMBRE, SchemaDB.COL_APE, SchemaDB.COL_DNI));
                ps.setString(1,al.getNombre());
                ps.setString(2,al.getApellido());
                ps.setString(3,al.getDni());
                ps.execute();
                System.out.println("Alumno agregado correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            for (int i = 0; i < alumnos.size(); i++) {
                if (alumnos.get(i).getDni().equalsIgnoreCase(al.getDni())){
                    aux = true;
                    break;
                }
            }
            if (aux){
                System.out.println("Lo sentimos el alumno introducido ya se encuentra en la base de datos");
            }else{
                alumnos.add(al);
                try {
                    PreparedStatement ps = connection.prepareStatement(String.format(query, SchemaDB.TABLE_NAME_AL, SchemaDB.COL_NOMBRE, SchemaDB.COL_APE, SchemaDB.COL_DNI));
                    ps.setString(1,al.getNombre());
                    ps.setString(2,al.getApellido());
                    ps.setString(3,al.getDni());
                    ps.execute();
                    System.out.println("Alumno agregado correctamente");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void agregarProfesor(Profesor prof){
        String query = "INSERT INTO %s(%s,%s,%s,%s) VALUES (?,?,?,?)";
        boolean aux = false;
        if (profesores.size()==0){
            profesores.add(prof);
            try {
                PreparedStatement ps = connection.prepareStatement(String.format(query, SchemaDB.TABLE_NAME_P,SchemaDB.COL_DNIP ,SchemaDB.COL_NOMBREP, SchemaDB.COL_APEP, SchemaDB.COL_ASIG));
                ps.setString(1, prof.getDni_p());
                ps.setString(2,prof.getNombre_p());
                ps.setString(3,prof.getApellido_p());
                ps.setString(4,prof.getAsignatura());
                ps.execute();
                System.out.println("Profesor agregado correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            for (int i = 0; i < profesores.size(); i++) {
                if (profesores.get(i).getDni_p().equalsIgnoreCase(prof.getDni_p())){
                    aux = true;
                    break;
                }
            }
        }
        if (aux){
            System.out.println("el profesor ya existe en la base de datos");
        }else{
            profesores.add(prof);
            try {
                PreparedStatement ps = connection.prepareStatement(String.format(query, SchemaDB.TABLE_NAME_P,SchemaDB.COL_DNIP ,SchemaDB.COL_NOMBREP, SchemaDB.COL_APEP, SchemaDB.COL_ASIG));
                ps.setString(1, prof.getDni_p());
                ps.setString(2,prof.getNombre_p());
                ps.setString(3,prof.getApellido_p());
                ps.setString(4,prof.getAsignatura());
                ps.execute();
                System.out.println("Profesor agregado correctamente");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void agregarProyecto(Proyecto proyecto){
        String query = "INSERT INTO %s(%s,%s,%s) VALUES (?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(String.format(query,SchemaDB.TABLE_NAMEPRO,SchemaDB.COL_TITULO,SchemaDB.COL_DESC,SchemaDB.COL_CONTENIDO));
            ps.setString(1,proyecto.getTitulo());
            ps.setString(2,proyecto.getDescripcion());
            ps.setString(3,proyecto.getContenido());
            ps.execute();
            System.out.println("proyecto añadido correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listarProyectos(){
        String querySelect = "SELECT * FROM %s";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(String.format(querySelect,SchemaDB.TABLE_NAMEPRO));
            while (rs.next()){
                String titulo = rs.getString(SchemaDB.COL_TITULO);
                String descrip = rs.getString(SchemaDB.COL_DESC);
                String conten = rs.getString(SchemaDB.COL_CONTENIDO);
                System.out.println("Titulo: "+titulo);
                System.out.println("Descripción: "+descrip);
                System.out.println("Contenido: "+conten);
                System.out.println("///////////////////////////////////////////");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package DataBase;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class ConexionDB {
    private Connection connection;

    public ConexionDB() {
        realizarConexion();
    }

    private void realizarConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="";
            String host="127.0.0.1:3306";
            String dbName= "proyectos_dam";
            String url= "jdbc:mysql://"+host+"/"+dbName;
            connection = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void llamarConexion(){
        System.out.println(connection.toString());
    };
}

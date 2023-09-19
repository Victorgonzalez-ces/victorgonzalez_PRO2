package dataBase;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Setter
public class GestionDB {

    private Connection connection;

    public GestionDB(){
        realizarConexion();
    }
    private void realizarConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="";
            String host="127.0.0.1:3306";
            String dbName= "TareasApp";
            String url= "jdbc:mysql://"+host+"/"+dbName;
            connection = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

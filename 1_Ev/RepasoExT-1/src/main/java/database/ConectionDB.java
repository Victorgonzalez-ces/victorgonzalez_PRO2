package database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConectionDB {
    private Connection connection;

    private void createConnection() {

        String url = String.format("jdbc:mysql://localhost/%s", SchemeDB.DB_NAME);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,"root","root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Conexion incorrecta");
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    public void closeConnecion() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

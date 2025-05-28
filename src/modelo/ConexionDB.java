package modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionDB {

    private static Connection conexion = null;

    public static Connection getConnection() {

        if (conexion == null) {

            try {
                Properties props = new Properties();

                props.load(new FileInputStream("db.properties"));

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.pass");
                
                conexion = DriverManager.getConnection(url, user, password);
                System.out.println("¡Conexión exitosa a NeonDB!");
            } catch (SQLException | IOException error) {
                System.out.println("Error conectando a la base de datos: " + error);
            }
        }
        return conexion;
    }
    public static void closeConnection() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (Exception exception) {
                System.out.println("Exception cerrando la base de datos: " + exception);
                exception.printStackTrace();
            }
        }
    }
}

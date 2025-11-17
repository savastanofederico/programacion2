package config;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
private static final String PROPERTIES_PATH = "/config/db.properties";

   
static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   // <- driver de MySQL 8/9
            System.out.println("Driver MySQL cargado correctamente.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver JDBC de MySQL en el classpath.", e);
        }
    }
// La conexión se crea y se devuelve en cada llamada.
    
    public static Connection getConnection() throws SQLException {

        Properties props = new Properties();
        Connection newConnection = null;

        try (InputStream input = DatabaseConnection.class.getResourceAsStream(PROPERTIES_PATH)) {

            if (input == null) {
                throw new RuntimeException("No se encontró " + PROPERTIES_PATH + " en el classpath.");
            }

            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            newConnection = DriverManager.getConnection(url, user, password);
            return newConnection;

        } catch (Exception ex) {
            throw new SQLException("Error al establecer la conexión con la base de datos: " + ex.getMessage(), ex);
        }
    }
}

// Abrir el archivo db.properties
//        try (InputStream input = DatabaseConnection.class
//                    .getClassLoader()
//                    .getResourceAsStream("db.properties")) {
//
//            if (input == null) {
//                // Lanzamos RuntimeException si no encontramos el archivo
//                throw new RuntimeException("No se encontró db.properties en el classpath.");
//            }
//
//            props.load(input);
//
//            String url = props.getProperty("db.url");
//            String user = props.getProperty("db.user");
//            String password = props.getProperty("db.password");
//            
//            // Abrir la nueva conexión
//            newConnection = DriverManager.getConnection(url, user, password);
//            
//
//            return newConnection;
//
//        } catch (Exception ex) {
//            // Si la conexión falla, lanzamos SQLException para que los DAOs lo manejen
//            throw new SQLException("Error al establecer la conexión con la base de datos: " + ex.getMessage(), ex);
//        }
//    }
//    


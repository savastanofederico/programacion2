package config;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Properties;

public class DatabaseConnection {
   

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try (InputStream input = DatabaseConnection.class
                    .getClassLoader()
                    .getResourceAsStream("db.properties")) {

                if (input == null) {
                    throw new RuntimeException("No se encontró db.properties");
                }

                Properties props = new Properties();
                props.load(input);

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");

                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexión establecida correctamente.");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }
}



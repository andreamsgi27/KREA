package com.krea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import org.h2.tools.Server; // si no la comento, se borra sola esta linea!!

public class DatabaseConnection {
    
    private static final String URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String USER = "krea";
    private static final String PASSWORD = "krea";
 
    
    public static void startServer() {
        try {
            org.h2.tools.Server.createTcpServer("-tcpPort", "8080", "-tcpAllowOthers").start();
            System.out.println("Servidor H2 iniciado en el puerto 8080.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public static void main(String[] args) {
        // Iniciar el servidor con puerto específico y permitir conexiones remotas
        startServer();
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}

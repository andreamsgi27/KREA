package com.krea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginCRUD {
        
    
    // Validar usuario

    public static void validarUsuario(String usuario, String password) {

    }

    
        // Obtener todas los nombres de usuario y su contraseña de la base de datos
        public static List<Login> getAllusers() {
            List<Login> users = new ArrayList<>();
            String sql = "SELECT * FROM login";
            try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
        //         while (rs.next()) {
        //             int id = rs.getInt("id");
        //             String password = rs.getString("password");
        //             int age = rs.getInt("age");
        //             persons.add(new Person(id, name, age));
        //         }
        //         System.out.println("Todas las personas recuperadas: " + persons);
        //     } catch (SQLException e) {
        //         e.printStackTrace();
            }
        //     return users;
        }
    
        
    
        
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vkaiido.DB;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Vkaiido
 */
public class ConexionAMySQL {
    private static Connection ConnectionDB = null;
    public Connection getConection() {

        try {
            String url = "jdbc:mysql://localhost:3306/lab";
            String user = "Vkaiido";
            String password = "root";

            ConnectionDB = DriverManager.getConnection(url, user, password);
            
            System.out.println("Conexion establecida Correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e.toString());
        }
        
        
        
        return ConnectionDB;

    }

}

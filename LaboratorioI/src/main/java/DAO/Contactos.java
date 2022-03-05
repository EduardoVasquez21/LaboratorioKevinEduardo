/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Contacto;
import com.vkaiido.DB.ConexionAMySQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vkaiido
 */
public class Contactos {

    
        ConexionAMySQL con = new ConexionAMySQL();
        Connection conexion = con.getConection();
    
    public ArrayList<Contacto> ListaContactos() {
        ArrayList<Contacto> listado = null;
        
        ConexionAMySQL con = new ConexionAMySQL();
        Connection conexion = con.getConection();
        
        try {
            listado = new ArrayList<Contacto>();
            CallableStatement cb = conexion.prepareCall("select * from contactos");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                Contacto cc = new Contacto();

                cc.setNombre(resultado.getString("Nombre"));
                cc.setEdad(resultado.getString("Edad"));
                cc.setEmail(resultado.getString("Email"));
                cc.setNumeroDeTelefono(resultado.getString("NumeroDeTelefono"));

                listado.add(cc);
            }

        } catch (Exception e) {
        }
        return listado;
    }
    
     public void AddContacto(Contacto es){
    ConexionAMySQL con = new ConexionAMySQL();
    Connection conexion = con.getConection();
        try {
             CallableStatement cb =conexion.prepareCall("insert into "
                    + "contactos(Nombre,Edad,Email,NumeroDeTelefono) values('"+es.getNombre()+"', '"+es.getEdad()+"','"+es.getEmail()+"', '"+es.getNumeroDeTelefono()+"')");
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Persona Agregada");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error"+ex);
        }
     }  
}

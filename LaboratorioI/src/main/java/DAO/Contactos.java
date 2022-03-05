/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Contacto;
import Services.IContactos;
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
public class Contactos implements IContactos {

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
                cc.setId(resultado.getInt("Id"));
                cc.setNombre(resultado.getString("Nombre"));
                cc.setEdad(resultado.getInt("Edad"));
                cc.setEmail(resultado.getString("Email"));
                cc.setNumeroDeTelefono(resultado.getString("NumeroDeTelefono"));

                listado.add(cc);
            }

        } catch (Exception e) {
        }
        return listado;
    }

    public void AddContacto(Contacto es) {
        ConexionAMySQL con = new ConexionAMySQL();
        Connection conexion = con.getConection();
        try {

            CallableStatement cb = conexion.prepareCall("insert into "
                    + "contactos(Nombre,Edad,Email,NumeroDeTelefono) values('" + es.getNombre() + "', '" + es.getEdad() + "','" + es.getEmail() + "', '" + es.getNumeroDeTelefono() + "')");
            cb.execute();

            JOptionPane.showMessageDialog(null, "Persona Agregada");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }
    }

    public void UpdateContacto(Contacto es) {
        ConexionAMySQL con = new ConexionAMySQL();
        Connection conexion = con.getConection();
        try {
            CallableStatement cb = conexion.prepareCall("update Contactos set Nombre=?, Edad=?, Email=?, NumeroDeTelefono=? where Id=?");
            cb.setString(1, es.getNombre());
            cb.setInt(2, es.getEdad());
            cb.setString(3, es.getEmail());
            cb.setString(4, es.getNumeroDeTelefono());
            cb.setInt(5, es.getId());
            cb.execute();

            JOptionPane.showMessageDialog(null, "Actualizado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }
    }

    public void DeleteContacto(Contacto es) {
        ConexionAMySQL con = new ConexionAMySQL();
        Connection conexion = con.getConection();
        try {
            CallableStatement cb = conexion.prepareCall("delete from contactos where id=?");
            cb.setInt(1, es.getId());
            cb.execute();

            JOptionPane.showMessageDialog(null, "Contacto eliminado correctamente");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }
    }

}

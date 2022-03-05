/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Vkaiido
 */
public class Contacto {


    int Id;
    String Nombre;
    int Edad;
    String Email;
    String NumeroDeTelefono;
    
      public Contacto() {
    }

    public Contacto(int Id) {
        this.Id = Id;
    }

    public Contacto(String Nombre, int Edad, String Email, String NumeroDeTelefono) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Email = Email;
        this.NumeroDeTelefono = NumeroDeTelefono;
    }

    public Contacto(int Id, String Nombre, int Edad, String Email, String NumeroDeTelefono) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Email = Email;
        this.NumeroDeTelefono = NumeroDeTelefono;
    }






    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
 
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }



  

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNumeroDeTelefono() {
        return NumeroDeTelefono;
    }

    public void setNumeroDeTelefono(String NumeroDeTelefono) {
        this.NumeroDeTelefono = NumeroDeTelefono;
    }
    
}

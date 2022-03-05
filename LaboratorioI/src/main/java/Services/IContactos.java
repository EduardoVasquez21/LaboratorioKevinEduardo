/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Entidades.Contacto;
import java.util.ArrayList;

/**
 *
 * @author Vkaiido
 */
public interface IContactos {

    
    ArrayList<Contacto> ListaContactos();
    void AddContacto(Contacto contacto);

    void UpdateContacto(Contacto contacto);

    void DeleteContacto(Contacto contacto);
}

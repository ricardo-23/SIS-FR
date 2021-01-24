/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ricar
 */
public class Usuario {
    private String Nombre;
    private String Clave;

    public Usuario() {
     
    }
    
    public Usuario(String Nombre, String Clave) {
        this.Nombre = Nombre;
        this.Clave = Clave;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }  
}

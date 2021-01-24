/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author ricar
 */
public class Seguridad {
    /**
    * Este metodo se usa para Encriptar la clave del usuario.
    * @param clave Con este parametro recibimos la clave que deseamos encriptar.
    * @return String Retorna una cadena donde se encuentre la clave encriptada.
    */
    public String Encriptar (String clave){
        char array[]=clave.toCharArray();
        for(int i=0;i<array.length;i++){
            array[i]=(char)(array[i]+(char)((7*i)+(3*(i+1))));
        }
        String encriptado=String.valueOf(array);
        return encriptado;
    }
    
    /**
    * Este metodo se usa para Desencriptar la clave del usuario.
    * @param clave Con este parametro recibimos la clave que deseamos desencriptar.
    * @return String Retorna una cadena donde se encuentre la clave desencriptada.
    */
    public String Desencriptar (String clave){
        char array[]=clave.toCharArray();
        for(int i=0;i<array.length;i++){
            array[i]=(char)(array[i]-(char)((7*i)+(3*(i+1))));
        }
        String desencriptado=String.valueOf(array);
        return desencriptado;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;
import javax.swing.JComboBox;



/**
 *
 * @author ricar
 */
public class ControladorUsuario {
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();
    private Usuario usuarios = new Usuario();
    private Seguridad seguridad = new Seguridad();

    /**
    * Este metodo se usa para obtener una lista.
    * @return ListaSimpleAvanzada Esto devuelve una lista.
    */
    public ListaSimpleAvanzada getLista() {
        return lista;
    }

    /**
    * Este metodo se usa para ingresar datos en una lista.
    * @param lista Con este parametro recibimos una lista.
    * @return void No retorna ningún valor.
    */
    public void setLista(ListaSimpleAvanzada lista) {
        this.lista = lista;
    }
    /**
    * Este metodo se usa para obtener usuarios, y si no existe, se crea uno.
    * @return Usuario Esto devuelve un objeto de tipo Usuario.
    */
    public Usuario getUsuarios() {
        if (usuarios == null) {
            this.usuarios = new Usuario();
        }
        return usuarios;
    }
    /**
    * Este metodo se usa para ingresar datos en un Usuario.
    * @param usuarios Con este parametro recibimos un usuario.
    * @return void No retorna ningún valor.
    */
    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    /**
    * Este metodo se usa para guardar un usuario es decir insertarlo en una lista.
    * @return boolean Esto devuelve un booleano para verificar si se inserto o no el objeto usuario en la lista.
    */
    public boolean guardarUsuario() {
        try {
            lista.insertar(clonar());
            return true;
        } catch (Exception e) {
            System.out.println("Dato null: "+e);
            return false;
        }
    }
    
    /**
    * Este metodo se usa para clonar un usuario.
    * @return Usuario Esto devuelve un usuario clonado del usuario que se va a ingresar.
    */
    public Usuario clonar(){
            Usuario u = new Usuario();
            u.setNombre(usuarios.getNombre());
            u.setClave(seguridad.Encriptar(usuarios.getClave()));
            return u;
    }
    /**
    * Este metodo se usa para Insertar una lista de usuarios en un archivo de texto.
    * @return void No retorna ningún valor, solo escribe en un archivo de texto.
    */
    public void InsertarArchivo() {
        File file = new File("USUARIOS.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
            }
        }
        try {
            String aux;
            Nodo tmp = lista.cabecera;
            PrintWriter escribir = new PrintWriter(file, "utf-8");
            for (int i = 0; i < lista.tamano(); i++) {
                aux = ((Usuario) tmp.getDato()).getNombre()+","+((Usuario) tmp.getDato()).getClave();
                escribir.print(aux);
                escribir.println();
                tmp = tmp.getSiguiente();
            }
            escribir.println();
            escribir.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
        }
    }
    
    /**
    * Este metodo se usa para Cargar datos de usuarios en una lista, y estos se encuentran en un archivo de texto.
    * @return void No retorna ningún valor.
    */
   public void CargarDatos() {
        File archivo1 = new File("USUARIOS.txt");
        int tamanioCola = lista.tamano();
        lista.cabecera = null;
        //LEER DESDE EL ARCHIVO Y ESCRIBIR
        try {
            FileReader leerArchivo1 = new FileReader(archivo1);
            BufferedReader bufferr1 = new BufferedReader(leerArchivo1);
            String linea = null;
            Nodo tmp = null;
            while ((linea = bufferr1.readLine()) != null) {
                StringTokenizer ST = new StringTokenizer(linea, ",");
                //for (int i = 0; i <= lista.tamano(); i++) {
                    //System.out.println(ST.nextToken());
                   String aux1 = (ST.nextToken());
                   String aux2 = (ST.nextToken());
                   lista.insertar(new Usuario(aux1, aux2));
                //}
            }
            bufferr1.close();
        } catch (Exception e) {
        }
    }
}

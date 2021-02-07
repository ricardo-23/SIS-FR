/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.System.out;
import java.util.StringTokenizer;
import javax.swing.JComboBox;



/**
 *
 * @author ricar
 */
public class ControladorUsuario {
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();
    private ListaSimpleAvanzada listabusqueda = new ListaSimpleAvanzada();
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
    * Este metodo se usa para obtener una lista.
    * @return ListaSimpleAvanzada Esto devuelve una lista.
    */
    public ListaSimpleAvanzada getListabusqueda() {
        return listabusqueda;
    }

    /**
    * Este metodo se usa para ingresar datos en una lista.
    * @param ListaSimpleAvanzada Con este parametro recibimos una lista.
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
    * @param Usuario Con este parametro recibimos un usuario.
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
            out.println("Dato null: "+e);
            return false;
        }
    }
    
    
    
    /**
    * Este metodo se usa para clonar un usuario.
    * @return Usuario Esto devuelve un usuario clonado del usuario que se va a ingresar.
    */
    public Usuario clonar(){
            var u = new Usuario();
            u.setNombre(usuarios.getNombre());
            u.setClave(seguridad.Encriptar(usuarios.getClave()));
            return u;
    }
    /**
    * Este metodo se usa para Insertar una lista de usuarios en un archivo de texto.
    * @return void No retorna ningún valor, solo escribe en un archivo de texto.
    */
    public void eliminarContenidoArchivo(){
    var file = new File("USUARIO.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
            }
        }else{
            file.delete();
        }
    }
    /**
    * Este metodo se usa para Insertar datos de una lista en un archivo.
    * @return void No retorna ningún valor, solo escribe en un archivo de texto.
    */
    public void InsertarArchivo() {
        var file = new File("USUARIOS.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
            }
        }
        try {
            String aux;
            var tmp = lista.cabecera;
            try (var escribir = new PrintWriter(file, "utf-8")) {
                for (var i = 0; i < lista.tamano(); i++) {
                    aux = ((Usuario) tmp.getDato()).getNombre()+","+((Usuario) tmp.getDato()).getClave();
                    escribir.print(aux);
                    escribir.println();
                    tmp = tmp.getSiguiente();
                }
                escribir.println();
                escribir.close();
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
        }
    }
    
    /**
    * Este metodo se usa para Modificar un registro de un archivo.
    * @param File,String Con este parametro recibimos el fichero destino y el registro que cambiaremos por el anterior.
    * @return void No retorna ningún valor.
    */
    public void EscribirFichero(File Ffichero, String SCadena){

  try {
          //Si no Existe el fichero lo crea
           if(!Ffichero.exists()){
               Ffichero.createNewFile();
           }
          /*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8. 
           *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)",
           *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia*/
          BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero,true), "utf-8"));
          /*Escribe en el fichero la cadena que recibe la función. 
           *el string "\r\n" significa salto de linea*/
          Fescribe.write(SCadena + "\r\n");
          //Cierra el flujo de escritura
          Fescribe.close();
       } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
          System.out.println(ex.getMessage());
       } 

}
    
    /**
    * Este metodo se usa para Insertar datos de una lista en un archivo.
    * @return void No retorna ningún valor, solo escribe en un archivo de texto.
    */
    public void InsertarArchivoOtro() {
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
        var archivo1 = new File("USUARIOS.txt");
        var tamanioCola = lista.tamano();
        lista.cabecera = null;
        //LEER DESDE EL ARCHIVO Y ESCRIBIR
        try {
            var leerArchivo1 = new FileReader(archivo1);
            try (var bufferr1 = new BufferedReader(leerArchivo1)) {
                String linea = null;
                Nodo tmp = null;
                while ((linea = bufferr1.readLine()) != null) {
                    var ST = new StringTokenizer(linea, ",");
                    //for (int i = 0; i <= lista.tamano(); i++) {
                    //System.out.println(ST.nextToken());
                    var aux1 = ST.nextToken();
                    var aux2 = ST.nextToken();
                    lista.insertarFinal(new Usuario(aux1, aux2));
                    //}
                }
            }
        } catch (Exception e) {
        }
        
    }
   
   /**
    * Este metodo se usa para Cargar datos de usuarios en una lista, y estos se encuentran en un archivo de texto.
    * @return void No retorna ningún valor.
    */
   public void CargarDatosOtro() {
        File archivo1 = new File("USUARIO.txt");
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
                   lista.insertarFinal(new Usuario(aux1, aux2));
                //}
            }
            bufferr1.close();
            
        } catch (Exception e) {
        }
    }
   
   /**
    * Este metodo se usa para buscar un registro en un archivo.
    * @param String Con este parametro recibimos dato que vamos a buscar.
    * @return void No retorna ningún valor.
    */
   public void CargarDatosPorBusqueda(String dato) {
        File archivo1 = new File("USUARIOS.txt");
        FileReader lector;
        BufferedReader almacenar;
        listabusqueda.cabecera = null;
        //LEER DESDE EL ARCHIVO Y ESCRIBIR
        try {
            lector = new FileReader(archivo1);
            almacenar = new BufferedReader(lector);
            //var bufferr1 = new BufferedReader(almacenar)
            try (var bufferr1 = new BufferedReader(almacenar)) {
                String linea = null;
                Nodo tmp = null;
                while ((linea = bufferr1.readLine()) != null) {
                    var ST = new StringTokenizer(linea, ",");
                    //for (int i = 0; i <= lista.tamano(); i++) {
                    //System.out.println(ST.nextToken());
                    var aux1 = ST.nextToken();
                    if (dato.equalsIgnoreCase(aux1)) {
                    var aux2 = ST.nextToken();
                    
                   listabusqueda.insertar(new Usuario(aux1, aux2));
                    }
                }
            }

        } catch (Exception e) {
        }
    }
   
   
   /**
    * Este metodo se usa para buscar un registro y verificar si se encuentra en el archivo.
    * @param String, String Con este parametro recibimos los datos que vamos a buscar.
    * @return boolean retorna un valor booleano para verificatr la busqueda.
    */
   public boolean Busqueda(String nombre, String clave) {
        File archivo1 = new File("USUARIOS.txt");
        FileReader lector;
        BufferedReader almacenar;
        listabusqueda.cabecera = null;
        boolean verificador = false;
        int cont = lista.tamano()-1;
        try {
            lector = new FileReader(archivo1);
            almacenar = new BufferedReader(lector);
            //var bufferr1 = new BufferedReader(almacenar)
            try (var bufferr1 = new BufferedReader(almacenar)) {
                String linea = null;
                Nodo tmp = null;
                while ((linea = bufferr1.readLine()) != null) {
                    var ST = new StringTokenizer(linea, ",");
                    //for (int i = 0; i <= lista.tamano(); i++) {
                    //System.out.println(ST.nextToken());
                    var aux1 = ST.nextToken();
                    var aux2 = ST.nextToken();
                    if (nombre.equals(aux1) && clave.equals(aux2)) {
//                        getLista().eliminarPorPosicionOtro(cont);
//                        eliminarContenidoArchivo();
//                        this.InsertarArchivoOtro();
                        //this.CargarDatosOtro();
                        //break;
                        verificador = true;
                    }
                    cont--;
                }
            }
            return verificador;
        } catch (Exception e) {
            return verificador;
        }
    }
 
   /**
    * Este metodo se usa para Modificar un fichero.
    * @param File, String, String Con este parametro recibimos el archivo de donde queremos modificar, el registro que vamos a modificar, el registro que remplzaremos por el anterior.
    * @return boolean retorna un valor booleano para verificatr la busqueda.
    */
     public  void ModificarFichero(File FficheroAntiguo,String Satigualinea,String Snuevalinea){        
        /*Obtengo un numero aleatorio*/
        //Random numaleatorio= new Random(3816L); 
        /*Creo un nombre para el nuevo fichero apartir del
         *numero aleatorio*/
        String SnombFichNuev="USUARIO.txt";
        /*Crea un objeto File para el fichero nuevo*/
        File FficheroNuevo=new File(SnombFichNuev);
        
        try {
            /*Si existe el fichero inical*/
            if(FficheroAntiguo.exists()){
                /*Abro un flujo de lectura*/
                BufferedReader Flee= new BufferedReader(new FileReader(FficheroAntiguo));
                String Slinea;
                /*Recorro el fichero de texto linea a linea*/
                while((Slinea=Flee.readLine())!=null) { 
                    /*Si la lia obtenida es igual al la bucada
                     *para modificar*/
                    if (Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {
                       /*Escribo la nueva linea en vez de la que tenia*/
                        EscribirFichero(FficheroNuevo,Snuevalinea);
                    }else{
                        /*Escribo la linea antigua*/
                         EscribirFichero(FficheroNuevo,Slinea);
                    }             
                }
                /*Obtengo el nombre del fichero inicial*/
                String SnomAntiguo=FficheroAntiguo.getName();
                /*Borro el fichero inicial*/
                BorrarFichero(FficheroAntiguo);
                /*renombro el nuevo fichero con el nombre del 
                *fichero inicial*/
                FficheroNuevo.renameTo(FficheroAntiguo);
                /*Cierro el flujo de lectura*/
                //eliminarContenidoArchivo2();
                CargarDatosOtro();
                InsertarArchivoOtro();
                
                Flee.close();
//                CargarDatosOtro();
//                InsertarArchivoOtro();
//                eliminarContenidoArchivo();

            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
    }
    
    
    /**
    * Este metodo se usa para Borrar un fichero.
    * @param File Con este parametro recibimos el archivo que vamos a borrar.
    * @return void No retorna ningún valor.
    */
    public static  void BorrarFichero(File Ffichero){
     try {
         /*Si existe el fichero*/
         if(Ffichero.exists()){
           /*Borra el fichero*/  
           Ffichero.delete(); 
           System.out.println("Fichero Borrado con Exito");
         }
     } catch (Exception ex) {
         /*Captura un posible error y le imprime en pantalla*/ 
          System.out.println(ex.getMessage());
     }
} 
}

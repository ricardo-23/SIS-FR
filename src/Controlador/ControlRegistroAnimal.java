/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroAnimal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.System.out;
import java.util.StringTokenizer;

public class ControlRegistroAnimal {

    private ListaSimpleAvanzada listabusqueda = new ListaSimpleAvanzada();
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();
    private RegistroAnimal registroAnimal = new RegistroAnimal();
    private String usuario;

    public ListaSimpleAvanzada getListabusqueda() {
        return listabusqueda;
    }

    public void setListabusqueda(ListaSimpleAvanzada listabusqueda) {
        this.listabusqueda = listabusqueda;
    }

    public ListaSimpleAvanzada getLista() {
        return lista;
    }

    public void setLista(ListaSimpleAvanzada lista) {
        this.lista = lista;
    }

    public RegistroAnimal getRegistroAnimal() {
        if (registroAnimal == null) {
            this.registroAnimal = new RegistroAnimal();
        }
        return registroAnimal;
    }

    public void setRegistroAnimal(RegistroAnimal registroAnimal) {
        this.registroAnimal = registroAnimal;
    }

    /**
     * Este metodo se usa para guardar un objeto de tipo RegistroAnimal en una
     * lista
     *
     * @return Retorna true si se a guadado la lista. Retorna un false si no se
     * a podido guadar
     */
    public boolean guardarRegistroAnimal() {
        try {
            lista.insertar(clonar());
            return true;
        } catch (Exception e) {
            out.println("Dato null: " + e);
            return false;
        }
    }

    /**
     * Este metodo se usa para clonar un elemento de tipo RegistroAnimal
     *
     * @return Retorna un objeto de tipo RegistroAnimal.
     */
    public RegistroAnimal clonar() {
        var u = new RegistroAnimal();
        u.setCalcio(registroAnimal.getCalcio());
        u.setEnergiaMetabolizable(registroAnimal.getEnergiaMetabolizable());
        u.setEtapa(registroAnimal.getEtapa());
        u.setFosforo(registroAnimal.getFosforo());
        u.setLisina(registroAnimal.getLisina());
        u.setNombre(registroAnimal.getNombre());
        u.setOrigen(registroAnimal.getOrigen());
        u.setProductoFinal(registroAnimal.getProductoFinal());
        u.setProteinaC(registroAnimal.getProteinaC());
        u.setRaza(registroAnimal.getRaza());
        u.setTipo(registroAnimal.getTipo());

        return u;
    }

    /**
     * Este metodo se usa para presentrar los datos del registroAnimal
     *
     */
    public void Presentar() {
        for (var i = 0; i < lista.tamano(); i++) {
            out.println(i + "--" + "Nombre: " + ((RegistroAnimal) lista.verDatoPosicion(i)).getNombre());
            out.println(i + "--" + "Raza: " + ((RegistroAnimal) lista.verDatoPosicion(i)).getRaza());
            out.println(i + "--" + "Etapa: " + ((RegistroAnimal) lista.verDatoPosicion(i)).getEtapa());
            out.println(i + "--" + "Origen: " + ((RegistroAnimal) lista.verDatoPosicion(i)).getOrigen());
            out.println(i + "--" + "Tipo: " + ((RegistroAnimal) lista.verDatoPosicion(i)).getTipo());
            out.println(i + "--" + "Calcio:" + ((RegistroAnimal) lista.verDatoPosicion(i)).getCalcio());
            out.println(i + "--" + "Energia Metabolizable: " + ((RegistroAnimal) lista.verDatoPosicion(i)).getEnergiaMetabolizable());
            out.println(i + "--" + "Fosforo: " + ((RegistroAnimal) lista.verDatoPosicion(i)).getFosforo());
            out.println(i + "--" + "Lisina: " + ((RegistroAnimal) lista.verDatoPosicion(i)).getLisina());
            out.println(i + "--" + "Producto final: " + ((RegistroAnimal) lista.verDatoPosicion(i)).getProductoFinal());
            out.println(i + "--" + "ProteinaC: " + ((RegistroAnimal) lista.verDatoPosicion(i)).getProteinaC());
            out.println("\n");
        }
    }
    /**
    * Este metodo se usa para Eliminar todos los datos el archivo
    */
    public void eliminarContenidoArchivo() {
        var file = new File("ANIMAL.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
            }
        } else {
            file.delete();
        }
    }
   /**
    * Este metodo se usa para guardar los datos de la lista en un archivo
    * Se guardara cada atributo separado con una coma y cada dato de la lista por un salto de linea
    */
    public void InsertarArchivo() {
        var file = new File("ANIMAL.txt");
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
                    aux = ((RegistroAnimal) lista.verDatoPosicion(i)).getNombre() + "," + ((RegistroAnimal) lista.verDatoPosicion(i)).getRaza() + ","
                            + ((RegistroAnimal) lista.verDatoPosicion(i)).getEtapa() + "," + ((RegistroAnimal) lista.verDatoPosicion(i)).getOrigen() + ","
                            + ((RegistroAnimal) lista.verDatoPosicion(i)).getTipo() + "," + ((RegistroAnimal) lista.verDatoPosicion(i)).getCalcio() + ","
                            + ((RegistroAnimal) lista.verDatoPosicion(i)).getEnergiaMetabolizable() + "," + ((RegistroAnimal) lista.verDatoPosicion(i)).getFosforo() + ","
                            + ((RegistroAnimal) lista.verDatoPosicion(i)).getLisina() + "," + ((RegistroAnimal) lista.verDatoPosicion(i)).getProductoFinal() + ","
                            + ((RegistroAnimal) lista.verDatoPosicion(i)).getProteinaC();
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
    * Este metodo se usa para llenar la lista con los datos que se encuentran en el archivo ANIMAL.txt
    */
    public void CargarDatos() {
        var archivo1 = new File("ANIMAL.txt");
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
                    var aux3 = ST.nextToken();
                    var aux4 = ST.nextToken();
                    var aux5 = ST.nextToken();
                    var aux6 = ST.nextToken();
                    var aux7 = ST.nextToken();
                    var aux8 = ST.nextToken();
                    var aux9 = ST.nextToken();
                    var aux10 = ST.nextToken();
                    var aux11 = ST.nextToken();
                    lista.insertar(new RegistroAnimal(aux1, aux2, aux3, aux4, aux5, Double.parseDouble(aux6),
                            Double.parseDouble(aux7), Double.parseDouble(aux8), Double.parseDouble(aux9),
                            aux10, Double.parseDouble(aux11)));
                    //}
                }
            }

        } catch (Exception e) {
        }
    }
      /**
    * Este metodo se usa para llenar una listaBusqueda con los datos que unicamente tengan relacion con el nombre del Animal
    * @param dato es de tipo String y es el dato que se usara para comparar con los nombre que tiene la lista
    */
    public void CargarDatosPorBusqueda(String dato) {
        File archivo1 = new File("ANIMAL.txt");
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
                        var aux3 = ST.nextToken();
                        var aux4 = ST.nextToken();
                        var aux5 = ST.nextToken();
                        var aux6 = ST.nextToken();
                        var aux7 = ST.nextToken();
                        var aux8 = ST.nextToken();
                        var aux9 = ST.nextToken();
                        var aux10 = ST.nextToken();
                        var aux11 = ST.nextToken();                       
                        listabusqueda.insertar(new RegistroAnimal(aux1, aux2, aux3, aux4, aux5, Double.parseDouble(aux6),
                                Double.parseDouble(aux7), Double.parseDouble(aux8), Double.parseDouble(aux9), aux10,
                                Double.parseDouble(aux11)));
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
        File archivo1 = new File("ANIMAL.txt");
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
}

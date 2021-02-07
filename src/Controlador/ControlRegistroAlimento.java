/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroAlimento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.System.out;
import java.util.StringTokenizer;

/**
 *
 * @author josue
 */
public class ControlRegistroAlimento {
    private ListaSimpleAvanzada listabusqueda = new ListaSimpleAvanzada();
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();
    private RegistroAlimento registroAlimento = new RegistroAlimento();

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

    public RegistroAlimento getRegistroAlimento() {
        if (registroAlimento == null) {
            this.registroAlimento = new RegistroAlimento();
        }
        return registroAlimento;
    }

    public void setRegistroAlimento(RegistroAlimento registroAlimento) {
        this.registroAlimento = registroAlimento;
    }
    /**
    * Este metodo se usa para guardar un objeto de tipo RegistroAlimento en una lista
    * @return 
    * Retorna true si se a guadado la lista.
    * Retorna un false si no se a podido guadar
    */
    public boolean guardarRegistroAlimento() {
        try {
            lista.insertar(clonar());
            return true;
        } catch (Exception e) {
            out.println("Dato null: "+e);
            return false;
        }
    }
    /**
    * Este metodo se usa para clonar un elemento de tipo RegistroAlimento
    * @return Retorna un objeto de tipo RegistroAlimento.
    */    
    public RegistroAlimento clonar(){
            var u = new RegistroAlimento();
            u.setCalcio(registroAlimento.getCalcio());
            u.setCalidad(registroAlimento.getCalidad());
            u.setCostoKg(registroAlimento.getCostoKg());
            u.setEnergiaMetabolizable(registroAlimento.getEnergiaMetabolizable());
            u.setFosforo(registroAlimento.getFosforo());
            u.setLisina(registroAlimento.getLisina());
            u.setNombre(registroAlimento.getNombre());
            u.setOrigen(registroAlimento.getOrigen());
            u.setParte(registroAlimento.getParte());
            u.setProceso(registroAlimento.getProceso());
            u.setProteinaC(registroAlimento.getProteinaC());
            u.setTipo(registroAlimento.getTipo());
            u.setTipoAlimento(registroAlimento.getTipoAlimento());

            return u;
    }
   /**
    * Este metodo se usa para presentrar los datos del RegistroAlimento
    */
    public void presentar(){
        for(var i=0;i<lista.tamano();i++){
            out.println(i+"---->"+"Nombre: "+((RegistroAlimento)lista.verDatoPosicion(i)).getNombre());
            out.println(i+"---->"+"Variedad o tipo: "+((RegistroAlimento)lista.verDatoPosicion(i)).getTipo());
            out.println(i+"---->"+"Parte: "+((RegistroAlimento)lista.verDatoPosicion(i)).getParte());
            out.println(i+"---->"+"Proceso: "+((RegistroAlimento)lista.verDatoPosicion(i)).getProceso());
            out.println(i+"---->"+"Calidad: "+((RegistroAlimento)lista.verDatoPosicion(i)).getCalidad());
            out.println(i+"---->"+"Origen: "+((RegistroAlimento)lista.verDatoPosicion(i)).getOrigen());
            out.println(i+"---->"+"Tipo de alimento: "+((RegistroAlimento)lista.verDatoPosicion(i)).getTipoAlimento());
            out.println(i+"---->"+"Costo por Kg: "+((RegistroAlimento)lista.verDatoPosicion(i)).getCostoKg());
            out.println(i+"---->"+"Energia Metabolizable: "+((RegistroAlimento)lista.verDatoPosicion(i)).getEnergiaMetabolizable());
            out.println(i+"---->"+"ProteinaC : "+((RegistroAlimento)lista.verDatoPosicion(i)).getProteinaC());
            out.println(i+"---->"+"Lisina: "+((RegistroAlimento)lista.verDatoPosicion(i)).getLisina());
            out.println(i+"---->"+"Fosforo: "+((RegistroAlimento)lista.verDatoPosicion(i)).getFosforo());
            out.println(i+"---->"+"Calcio: "+((RegistroAlimento)lista.verDatoPosicion(i)).getCalcio());
            out.println("\n");
        }
    }
   /**
    * Este metodo se usa para guardar los datos de la lista en un archivo
    * Se guardara cada atributo separado con una coma y cada dato de la lista por un salto de linea
    */
    public void InsertarArchivo() {
        var file = new File("ALIMENTO.txt");
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
                    aux = ((RegistroAlimento)lista.verDatoPosicion(i)).getNombre() + "," +((RegistroAlimento)lista.verDatoPosicion(i)).getTipo()+ "," +
                           ((RegistroAlimento)lista.verDatoPosicion(i)).getParte()+ "," +((RegistroAlimento)lista.verDatoPosicion(i)).getProceso()+ "," +
                           ((RegistroAlimento)lista.verDatoPosicion(i)).getCalidad()+ "," +((RegistroAlimento)lista.verDatoPosicion(i)).getOrigen()+ "," +
                           ((RegistroAlimento)lista.verDatoPosicion(i)).getTipoAlimento()+ "," +((RegistroAlimento)lista.verDatoPosicion(i)).getCostoKg()+ "," +
                           ((RegistroAlimento)lista.verDatoPosicion(i)).getEnergiaMetabolizable()+ "," +((RegistroAlimento)lista.verDatoPosicion(i)).getProteinaC()+ "," +
                           ((RegistroAlimento)lista.verDatoPosicion(i)).getLisina()+ "," +((RegistroAlimento)lista.verDatoPosicion(i)).getFosforo()+ "," +
                           ((RegistroAlimento)lista.verDatoPosicion(i)).getCalcio();
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
    * Este metodo se usa para llenar la lista con los datos que se encuentran en el archivo ALIMENTO.txt
    */
    public void CargarDatos() {
        var archivo1 = new File("ALIMENTO.txt");
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
                    var aux12 = ST.nextToken();
                    var aux13 = ST.nextToken();
                   lista.insertar(new RegistroAlimento(aux1, aux2, aux3, aux4, aux5, aux6, aux7, Double.parseDouble(aux8),
                           Double.parseDouble(aux9), Double.parseDouble(aux10), Double.parseDouble(aux11), Double.parseDouble(aux12),
                           Double.parseDouble(aux13)));
                    //}
                }
            }

        } catch (Exception e) {
        }
    }
       /**
    * Este metodo se usa para llenar una listaBusqueda con los datos que unicamente tengan relacion con el nombre del Alimento
    * @param dato es de tipo String y es el dato que se usara para comparar con los nombre que tiene la lista
    */
    public void CargarDatosPorBusqueda(String dato) {
        File archivo1 = new File("ALIMENTO.txt");
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
                    var aux12 = ST.nextToken();
                    var aux13 = ST.nextToken();
                   listabusqueda.insertar(new RegistroAlimento(aux1, aux2, aux3, aux4, aux5, aux6, aux7, Double.parseDouble(aux8),
                           Double.parseDouble(aux9), Double.parseDouble(aux10), Double.parseDouble(aux11), Double.parseDouble(aux12),
                           Double.parseDouble(aux13)));
                    }
                }
            }

        } catch (Exception e) {
        }
    }
     /**
    * Este metodo se usa para Eliminar todos los datos el archivo
    */
        public void eliminarContenidoArchivo() {
        var file = new File("ALIMENTO.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
            }
        } else {
            file.delete();
        }
    }
}

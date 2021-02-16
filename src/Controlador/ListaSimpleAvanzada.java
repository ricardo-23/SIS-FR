/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroAlimento;
import Modelo.Usuario;
import static java.lang.System.out;
import java.util.Arrays;

/**
 *
 * @author Ricardo
 */
public class ListaSimpleAvanzada extends ListaSimple {

    public ListaSimpleAvanzada() {
        super();
    }

    /**
     * Sirve para retornar el tamaño que tiene la lista
     *
     * @return int Retorna el tamaño de la lista
     */
    public int tamano() {
        var tamano = 0;
        if (!estaVacia()) {
            var temporal = cabecera;
            while (temporal != null) {
                tamano++;
                temporal = temporal.getSiguiente();
            }
        }
        return tamano;
    }

    /**
     * Sirve para colocar un dato en una posicion dada por el usuario
     *
     * @param dato de tipo Object.
     * @param pos de tipo int.
     */
    public void insertar(Object dato, int pos) {
        if (estaVacia() || pos <= 0) {
            insertar(dato);
        } else {
            var iterador = this.cabecera;
            for (var i = 0; i < pos; i++) {
                if (iterador.getSiguiente() == null) {
                    break;
                }
                iterador = iterador.getSiguiente();
            }
            var temporal = new Nodo(dato, iterador.getSiguiente());
            iterador.setSiguiente(temporal);
        }
    }

    public void insertarPos(Object dato, int pos) {
        if (estaVacia() || pos <= 0) {
            insertar(dato);
        } else {
            Nodo iterador = this.cabecera;
            for (int i = 0; i < pos; i++) {
                if (iterador.getSiguiente() == null) {
                    break;
                }
                iterador = iterador.getSiguiente();
            }
            Nodo temporal = new Nodo(dato, iterador.getSiguiente());
            iterador.setSiguiente(temporal);
        }
    }

    public void insertarFinal(Object dato) {
        insertarPos(dato, tamano());
    }

    /**
     * Sirve para eliminar un dato en una posicion especifica.
     *
     * @param pos de tipo int.
     */
    public void eliminarPorPosicion(int pos) {
        if (!estaVacia()) {
            if (pos < 0) {
                out.println("Debe ser una posicion mayor a cero");
            } else {
                if (pos == 0) {
                    cabecera = cabecera.getSiguiente();
                } else if (pos <= (tamano() - 1)) {
                    var aux = cabecera;
                    for (var i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }
                    var siguiente = aux.getSiguiente();
                    aux.setSiguiente(siguiente.getSiguiente());
                } else {
                    out.println("No se elimino");
                }
            }
        } else {
            out.println("Lista vacia");
        }
    }

    public void eliminarPorPosicionOtro(int pos) {
        if (!estaVacia()) {
            if (pos < 0) {
                System.out.println("Debe ser una posicion mayor a cero");
            } else {
                if (pos == 0) {
                    cabecera = cabecera.getSiguiente();
                } else if (pos <= (tamano() - 1)) {
                    Nodo aux = cabecera;
                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(siguiente.getSiguiente());
                } else {
                    System.out.println("No se elimino");
                }
            }
        } else {
            System.out.println("Lista vacia");
        }
    }

    /**
     * Sirve para reemplazar un objeto con otro
     *
     * @param posicion de tipo int.
     * @param dato de tipo Object.
     */
    public void editarPorPosicion(int posicion, Object dato) {
        if (posicion >= 0 && posicion < tamano()) {
            if (posicion == 0) {
                cabecera.setDato(dato);
            } else {
                var aux = cabecera;
                for (var i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }
        } else {
            out.println("Fuera de Rango");
        }
    }

    public Object obtenerPorPosicion(int pos) {
        Object aux = null;
        if (estaVacia() || pos < 0) {
            out.println("Vacio");
            //aux = verDatoPosicion(pos);
        } else if (pos > (tamano() - 1)) {
            out.println("El numero esta fuera de rango");
        } else if (pos == 0) {
            aux = verDatoPosicion(pos);
        } else {
            var iterador = cabecera;
            for (var i = 1; i < pos; i++) {
                if (iterador.getSiguiente().getSiguiente() == null) {
                    break;
                } else {
                    iterador = iterador.getSiguiente();
                }
            }
            aux = iterador.getSiguiente().getDato();
        }
        return aux;
    }
    /**
     * Sirve para buscar la posicion en la que se encuentra el objeto enviado dentro de una lista
     * @param dato de tipo Object.
     * @return la posicion en donde se encuentra el objeto dentro de la lista
     */  
    public int buscarDatoAlimento(Object dato) {
        String aux = null;
        String pos = "";
        if (estaVacia()) {
            System.out.println("Lista Vacia");
        } else {
            Nodo iterador = cabecera;
            int cont = 0;
            while (iterador != null) {
                if (((RegistroAlimento) iterador.getDato()).getNombre().equalsIgnoreCase(((RegistroAlimento) dato).getNombre())
                        && ((RegistroAlimento) iterador.getDato()).getTipo().equalsIgnoreCase(((RegistroAlimento) dato).getTipo())
                        && ((RegistroAlimento) iterador.getDato()).getParte().equalsIgnoreCase(((RegistroAlimento) dato).getParte())
                        && ((RegistroAlimento) iterador.getDato()).getProceso().equalsIgnoreCase(((RegistroAlimento) dato).getProceso())
                        && ((RegistroAlimento) iterador.getDato()).getCalidad().equalsIgnoreCase(((RegistroAlimento) dato).getCalidad())
                        && ((RegistroAlimento) iterador.getDato()).getOrigen().equalsIgnoreCase(((RegistroAlimento) dato).getOrigen())
                        && ((RegistroAlimento) iterador.getDato()).getTipoAlimento().equalsIgnoreCase(((RegistroAlimento) dato).getTipoAlimento())
                        && ((RegistroAlimento) iterador.getDato()).getCostoKg() == ((RegistroAlimento) dato).getCostoKg()
                        && ((RegistroAlimento) iterador.getDato()).getEnergiaMetabolizable() == ((RegistroAlimento) dato).getEnergiaMetabolizable()
                        && ((RegistroAlimento) iterador.getDato()).getFosforo() == ((RegistroAlimento) dato).getFosforo()
                        && ((RegistroAlimento) iterador.getDato()).getProteinaC() == ((RegistroAlimento) dato).getProteinaC()
                        && ((RegistroAlimento) iterador.getDato()).getCalcio() == ((RegistroAlimento) dato).getCalcio()
                        && ((RegistroAlimento) iterador.getDato()).getLisina() == ((RegistroAlimento) dato).getLisina()) {

                    return cont;
                }
                cont++;
                iterador = iterador.getSiguiente();
            }
        }
        return -1;
    }
    
    public int buscarDatoUsuario(Object dato) {
        String aux = null;
        String pos = "";
        if (estaVacia()) {
            System.out.println("Lista Vacia");
        } else {
            Nodo iterador = cabecera;
            int cont = 0;
            while (iterador != null) {
                if (((Usuario) iterador.getDato()).getNombre().equalsIgnoreCase(((Usuario) dato).getNombre())
                        && ((Usuario) iterador.getDato()).getClave().equalsIgnoreCase(((Usuario) dato).getClave())
                        ) {
                    return cont;
                }
                cont++;
                iterador = iterador.getSiguiente();
            }
        }
        return -1;
    }
}

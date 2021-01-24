/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


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
     * @return int Retorna el tamaño de la lista
     */
    public int tamano() {
        int tamano = 0;
        if (!estaVacia()) {
            Nodo temporal = cabecera;
            while (temporal != null) {
                tamano++;
                temporal = temporal.getSiguiente();
            }
        }
        return tamano;
    }

    /**
     * Sirve para colocar un dato en una posicion dada por el usuario
     * @param dato de tipo Object.
     * @param pos de tipo int.
     */   
    public void insertar(Object dato, int pos) {
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

    /**
     * Sirve para eliminar un dato en una posicion especifica.
     * @param pos de tipo int.
     */ 
    public void eliminarPorPosicion(int pos) {
        if (!estaVacia()) {
            if (pos < 0) {
                System.out.println("Debe ser una posicion mayor a cero");
            } else {
                if (pos == 0) {
                    cabecera = cabecera.getSiguiente();
                } else if (pos <= (tamano() - 1)) {
                    Nodo aux = cabecera;
                    for (int i = 0; i < pos-1; i++) {
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
     * @param posicion de tipo int.
     * @param dato de tipo Object.
     */    
    public void editarPorPosicion(int posicion, Object dato){
        if(posicion >= 0 && posicion < tamano()){
            if(posicion == 0){
                cabecera.setDato(dato);
            }else{
                Nodo aux = cabecera;
                for(int i = 0 ; i < posicion ; i++){
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }
        }else{
            System.out.println("Fuera de Rango");
        }
    }
}

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
public class ListaSimple {
    protected Nodo cabecera;
    
    public ListaSimple(){
        this.cabecera = null;
    }
    
    /**
     * Sirve para verificar si la lista esta vacia o no
     * @return Nos retornara un true en caso que la lista no tenga datos.
     * Caso contrario sera un false
     */    
    public boolean estaVacia(){
        //OPERADOR TERNARIO
        return (this.cabecera == null);
    }
    
    /**
     * Sirve para insertar un nodo al inicio de la lista
     * @param dato de tipo Object
     */  
    public void insertar(Object dato){
        Nodo temporal = new Nodo(dato, null);
        temporal.setSiguiente(cabecera);
        cabecera = temporal; 
    }
    
    /**
     * Sirve para imprimir todos los nodos que contenga la lista
     * @return void No retorna ningún valor.
     */     
    public void imprimir(){
        if(!estaVacia()){
            Nodo temporal = cabecera;
            while(temporal != null){
                System.out.println("-- "+temporal.getDato()+" --");
                temporal = temporal.getSiguiente();
            }
            
        }else{
            System.out.println("La lista se encuentra vacia");
        }
    }
    
    /**
     * Sirve para obtener un objeto en una posicion dada
     * @param pos de tipo entero
     * @return Object
     */     
    public Object verDatoPosicion(int pos){
        Object dato = null;
        if(!estaVacia() && pos >= 0){
            Nodo temporal = cabecera;
            for (int i = 0; i < pos; i++) {
                temporal = temporal.getSiguiente();
                if(temporal == null){
                    break;
                }
            }
            dato = (temporal != null) ? temporal.getDato() : null;
        }
        return dato;

    }
}

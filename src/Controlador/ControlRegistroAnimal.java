/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroAnimal;

public class ControlRegistroAnimal {
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();
    private RegistroAnimal registroAnimal = new RegistroAnimal();

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
    * Este metodo se usa para guardar un objeto de tipo RegistroAnimal en una lista
    * @return 
    * Retorna true si se a guadado la lista.
    * Retorna un false si no se a podido guadar
    */
    public boolean guardarRegistroAnimal() {
        try {
            lista.insertar(clonar());
            return true;
        } catch (Exception e) {
            System.out.println("Dato null: "+e);
            return false;
        }
    }
    
    /**
    * Este metodo se usa para clonar un elemento de tipo RegistroAnimal
    * @return Retorna un objeto de tipo RegistroAnimal.
    */
    public RegistroAnimal clonar(){
            RegistroAnimal u = new RegistroAnimal();
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
    * @return No retorna ningun valor.
    */
    public void Presentar(){
        for(int i=0; i<lista.tamano();i++){
            System.out.println(i+"--"+"Nombre: "+((RegistroAnimal)lista.verDatoPosicion(i)).getNombre());  
            System.out.println(i+"--"+"Raza: "+((RegistroAnimal)lista.verDatoPosicion(i)).getRaza());
            System.out.println(i+"--"+"Etapa: "+((RegistroAnimal)lista.verDatoPosicion(i)).getEtapa());
            System.out.println(i+"--"+"Origen: "+((RegistroAnimal)lista.verDatoPosicion(i)).getOrigen());
            System.out.println(i+"--"+"Tipo: "+((RegistroAnimal)lista.verDatoPosicion(i)).getTipo());
            System.out.println(i+"--"+"Calcio:"+((RegistroAnimal)lista.verDatoPosicion(i)).getCalcio());           
            System.out.println(i+"--"+"Energia Metabolizable: "+((RegistroAnimal)lista.verDatoPosicion(i)).getEnergiaMetabolizable());   
            System.out.println(i+"--"+"Fosforo: "+((RegistroAnimal)lista.verDatoPosicion(i)).getFosforo());
            System.out.println(i+"--"+"Lisina: "+((RegistroAnimal)lista.verDatoPosicion(i)).getLisina());   
            System.out.println(i+"--"+"Producto final: "+((RegistroAnimal)lista.verDatoPosicion(i)).getProductoFinal());
            System.out.println(i+"--"+"ProteinaC: "+((RegistroAnimal)lista.verDatoPosicion(i)).getProteinaC());             
            System.out.println("\n");
        }
    }
    
}

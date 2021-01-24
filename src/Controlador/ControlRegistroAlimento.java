/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroAlimento;

/**
 *
 * @author josue
 */
public class ControlRegistroAlimento {
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();
    private RegistroAlimento registroAlimento = new RegistroAlimento();

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
            System.out.println("Dato null: "+e);
            return false;
        }
    }
    /**
    * Este metodo se usa para clonar un elemento de tipo RegistroAlimento
    * @return Retorna un objeto de tipo RegistroAlimento.
    */    
    public RegistroAlimento clonar(){
            RegistroAlimento u = new RegistroAlimento();
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
            //u.setTipo(usuarios.getTipo());
            return u;
    }
   /**
    * Este metodo se usa para presentrar los datos del RegistroAlimento
    * @return No retorna ningun valor.
    */
    public void presentar(){
        for(int i=0;i<lista.tamano();i++){
            System.out.println(i+"---->"+"Nombre: "+((RegistroAlimento)lista.verDatoPosicion(i)).getNombre());
            System.out.println(i+"---->"+"Variedad o tipo: "+((RegistroAlimento)lista.verDatoPosicion(i)).getTipo());
            System.out.println(i+"---->"+"Parte: "+((RegistroAlimento)lista.verDatoPosicion(i)).getParte());
            System.out.println(i+"---->"+"Proceso: "+((RegistroAlimento)lista.verDatoPosicion(i)).getProceso());
            System.out.println(i+"---->"+"Calidad: "+((RegistroAlimento)lista.verDatoPosicion(i)).getCalidad());
            System.out.println(i+"---->"+"Origen: "+((RegistroAlimento)lista.verDatoPosicion(i)).getOrigen());
            System.out.println(i+"---->"+"Tipo de alimento: "+((RegistroAlimento)lista.verDatoPosicion(i)).getTipoAlimento());
            System.out.println(i+"---->"+"Costo por Kg: "+((RegistroAlimento)lista.verDatoPosicion(i)).getCostoKg());
            System.out.println(i+"---->"+"Energia Metabolizable: "+((RegistroAlimento)lista.verDatoPosicion(i)).getEnergiaMetabolizable());
            System.out.println(i+"---->"+"ProteinaC : "+((RegistroAlimento)lista.verDatoPosicion(i)).getProteinaC());
            System.out.println(i+"---->"+"Lisina: "+((RegistroAlimento)lista.verDatoPosicion(i)).getLisina());
            System.out.println(i+"---->"+"Fosforo: "+((RegistroAlimento)lista.verDatoPosicion(i)).getFosforo());
            System.out.println(i+"---->"+"Calcio: "+((RegistroAlimento)lista.verDatoPosicion(i)).getCalcio());
            System.out.println("\n");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tablas;

import Controlador.ListaSimpleAvanzada;
import Modelo.RegistroAnimal;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author josue
 */
public class TablaAnimal extends AbstractTableModel {
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();

    public ListaSimpleAvanzada getLista() {
        return lista;
    }

    public void setLista(ListaSimpleAvanzada lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public int getRowCount() {
        return lista.tamano();
    }

    @Override
    public Object getValueAt(int i, int j) {
        var u = (RegistroAnimal) lista.obtenerPorPosicion(i);
        switch(j){
            case 0: return u.getNombre()+"/"+u.getRaza()+"/"+u.getEtapa()+"/"+u.getProductoFinal()+"/"+
                           u.getOrigen();
            case 1: return u.getTipo();
            case 2: return u.getEnergiaMetabolizable();
            case 3: return u.getProteinaC();
            case 4: return u.getCalcio();
            case 5: return u.getLisina();
            case 6: return u.getFosforo();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Descripcion";
            case 1: return "Tipo de animal";
            case 2: return "Energia Metabolizable";
            case 3: return "Proteina";
            case 4: return "Calcio";
            case 5: return "Lisina";
            case 6: return "Fosforo";
            default: return null;
        }
    }   
}

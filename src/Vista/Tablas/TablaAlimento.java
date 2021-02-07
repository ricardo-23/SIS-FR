/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tablas;

import Controlador.ListaSimpleAvanzada;
import Modelo.RegistroAlimento;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author josue
 */
public class TablaAlimento extends AbstractTableModel  {
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();

    public ListaSimpleAvanzada getLista() {
        return lista;
    }

    public void setLista(ListaSimpleAvanzada lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public int getRowCount() {
        return lista.tamano();
    }

    @Override
    public Object getValueAt(int i, int j) {
        var u = (RegistroAlimento) lista.obtenerPorPosicion(i);
        switch(j){
            case 0: return u.getNombre()+"/"+u.getTipo()+"/"+u.getParte()+"/"+u.getProceso()+"/"+
                           u.getCalidad()+"/"+u.getOrigen();
            case 1: return u.getTipoAlimento();
            case 2: return u.getCostoKg();
            case 3: return u.getEnergiaMetabolizable();
            case 4: return u.getProteinaC();
            case 5: return u.getCalcio();
            case 6: return u.getLisina();
            case 7: return u.getFosforo();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Descripcion";
            case 1: return "Tipo de Alimento";
            case 2: return "Costo por Kg.";
            case 3: return "Energia Metabolizable";
            case 4: return "ProteinaC";
            case 5: return "Calcio";
            case 6: return "Lisina";
            case 7: return "Fosforo";
            default: return null;
        }
    }       
}

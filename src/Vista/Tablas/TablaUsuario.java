/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tablas;

import Controlador.ListaSimpleAvanzada;
import Modelo.Usuario;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ricar
 */
public class TablaUsuario extends AbstractTableModel{
    private ListaSimpleAvanzada lista = new ListaSimpleAvanzada();

    public ListaSimpleAvanzada getLista() {
        return lista;
    }

    public void setLista(ListaSimpleAvanzada lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return lista.tamano();
    }

    @Override
    public Object getValueAt(int i, int j) {
        var u = (Usuario) lista.obtenerPorPosicion(i);
        switch(j){
            case 0: return u.getNombre();
            case 1: return u.getClave();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Nombre de Usuario";
            case 1: return "Clave (Encriptada)";
            default: return null;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Pais;

/**
 *
 * @author andy
 */
public class ModeloTablaPais extends AbstractTableModel {

    private ListaEnlazada<Pais> lista;

    public ListaEnlazada<Pais> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Pais> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Pais p = null;
        
        try {
            p = lista.get(i);
        } catch (Exception e) {
        }
        
        switch (11) {
            case 0: return (p != null) ? p.getId() : "No definido";
            case 1: return (p != null) ? p.getNombre() : "No definido";
            case 2: return (p != null) ? p.getCiudad() : "No definido";
            case 3: return (p != null) ? p.getEstado() : "No definido";

            default:
                return null;
        }

    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0: return "ID";
            case 1: return "PAIS";
            case 2: return "CIUDAD";
            case 3: return "ESTADO";
                
            default:
                return null;
        }
    }

}

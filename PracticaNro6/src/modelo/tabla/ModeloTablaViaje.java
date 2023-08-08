/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.tabla;

import controlador.Dao.PaisDao;
import controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Pais;
import modelo.Viaje;

/**
 *
 * @author apolo
 */
public class ModeloTablaViaje extends AbstractTableModel {

    ListaEnlazada<Viaje> lista = new ListaEnlazada<>();

    public ListaEnlazada<Viaje> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Viaje> lista) {
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
        Viaje v = null;
        PaisDao pd = new PaisDao();
        try {
            v = lista.get(i);
            pd.setPais(pd.buscarId(v.getNroViaje()));
        } catch (Exception e) {
        }
        switch (i1) {
            case 0: return (v != null) ? v.getId() : "No definido";
            case 1: return (v != null) ? new PaisDao().obtener(v.getIdPais()).getNombre() : "No definido";
            case 2: return (v != null) ? pd.getPais().getNombre() : "No definido";
            case 3: return (v != null) ? v.getDistancia() : "No definido";
                
            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch (column) {
            case 0: return "ID";
            case 1: return "ID Origen";
            case 2: return "ID Destino";
            case 3: return "Distancia";
                
            default:
                return null;
        }
    }
}

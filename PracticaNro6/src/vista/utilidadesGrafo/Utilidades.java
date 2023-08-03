/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.utilidadesGrafo;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import javax.swing.JComboBox;
import modelo.Pais;

/**
 *
 * @author apolo
 */
public class Utilidades {

    public static void cargarCombo(ListaEnlazada<Pais> lista, JComboBox cbx) throws VacioException, PosicionException {
        cbx.removeAllItems();

        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.get(i));
        }
    }

    public static Pais obtenerCombo(ListaEnlazada<Pais> lista, JComboBox cbx)
            throws VacioException, PosicionException {
        return lista.get(cbx.getSelectedIndex());
    }
}

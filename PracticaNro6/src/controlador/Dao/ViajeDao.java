/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Dao;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.io.IOException;
import modelo.Viaje;

/**
 *
 * @author andy
 */
public class ViajeDao extends AdaptadorDao<Viaje> {

    private Viaje viaje;

    public ViajeDao() {
        super(Viaje.class);
    }

    public Viaje getViaje() {
        if (viaje == null) {
            viaje = new Viaje();
        }
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public void guardar() throws IOException, VacioException, PosicionException {
        viaje.setId_pais(generateId());
        this.guardar(viaje);
    }

    public void modificar(Integer pos) throws IOException, VacioException, PosicionException {

        this.modificar(viaje, pos);
    }

    private Integer generateId() {
        return listar().size() + 1;
    }

    public ListaEnlazada<Viaje> listaPorPais(Integer id_Pais) throws VacioException, PosicionException {
        ListaEnlazada<Viaje> lista = new ListaEnlazada<>();
        ListaEnlazada<Viaje> listado = listar();
        for (int i = 0; i < listado.size(); i++) {
            Viaje aux = listado.get(i);
            if (aux.getId_pais().equals(id_Pais)) {
                lista.insertar(aux);
            }
        }
        return lista;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Dao;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.io.IOException;
import modelo.Pais;

/**
 *
 * @author andy
 */
public class PaisDao extends AdaptadorDao<Pais> {
    
    private Pais pais;
    
    public PaisDao() {
        super(Pais.class);
    }
    
    public Pais getPais() {
        if (pais == null) {
            pais = new Pais();
        }
        return pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    public void guardar() throws IOException {
        pais.setId(generateID());
        pais.setNro_viaje(generate());
        this.guardar(pais);
    }
    
    public void modificar(Integer pos) throws VacioException, PosicionException, IOException {
        this.modificar(pais, pos);
    }
    
    private Integer generateID() {
        return listar().size() + 1;
    }
    
    private String generate() {
        return String.valueOf(listar().size() + 1);
    }

    public Pais buscarId(String nroViaje) throws VacioException, PosicionException {
        Pais pais = null;
        ListaEnlazada<Pais> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Pais aux = lista.get(i);
            if (aux.getNro_viaje().equalsIgnoreCase(nroViaje)) {
                pais = aux;
                break;
            }
        }
        return pais;
    }
}

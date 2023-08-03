/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Dao.Grafo;

import controlador.Dao.PaisDao;
import controlador.Dao.ViajeDao;
import controlador.ed.grafo.GrafoEtiquetadoD;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.util.HashMap;
import java.util.Map;
import modelo.Pais;
import modelo.Viaje;

/**
 *
 * @author andy
 */
public class PaisGrafo {

    private GrafoEtiquetadoD<Pais> grafo;
    private ListaEnlazada<Pais> lista = new ListaEnlazada<>();

    public PaisGrafo() {
        PaisDao paisDao = new PaisDao();
        lista = paisDao.listar();
        grafo = new GrafoEtiquetadoD<>(lista.size());
        try {
            for (int i = 0; i < lista.size(); i++) {
                grafo.etiquetarVertice(i + 1, lista.get(i));
                System.out.println(lista.get(i));
            }
            System.out.println("----------------");
            llenarGrafo();
        } catch (Exception e) {
        }
    }

    public GrafoEtiquetadoD<Pais> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoEtiquetadoD<Pais> grafo) {
        this.grafo = grafo;
    }

    public ListaEnlazada<Pais> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Pais> lista) {
        this.lista = lista;
    }

    
    private void llenarGrafo() {
        try {
            for (int i = 0; i < lista.size(); i++) {
                Pais pais = lista.get(i);
                HashMap<String, Double> mapa = new HashMap<>();
                System.out.println("PAIS " + pais.getNombre());
                ListaEnlazada<Viaje> listaV = new ViajeDao().listaPorPais(pais.getId());
                for (int j = 0; j < listaV.size(); j++) {
                    Viaje viaje = listaV.get(j);
                    if (mapa.get(viaje.getNroViaje()) != null) {
                        Double suma = mapa.get(viaje.getNroViaje());
                        suma += viaje.getDistancia();
                        mapa.put(viaje.getNroViaje(), suma);
                    } else {
                        mapa.put(viaje.getNroViaje(), viaje.getDistancia());
                    }
                }
                for (Map.Entry<String, Double> entry : mapa.entrySet()) {
                    Pais aux = getPais(entry.getKey());
                    if (aux != null) {
                        System.out.println(aux);
                        grafo.insertarAristaE(pais, aux, entry.getValue());
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error de llenado: " + e);
            e.printStackTrace();
        }
    }

    private Pais getPais(String nroViaje) throws VacioException, PosicionException {
        Pais aux = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNro_viaje().equals(nroViaje)) {
                aux = lista.get(i);
                break;
            }
        }
        return aux;
    }
    
    
}

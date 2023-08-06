/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Dao.Grafo;

import controlador.Dao.PaisDao;
import controlador.Dao.ViajeDao;
import controlador.ed.grafo.Adycencia;
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

//    public ListaEnlazada<Pais> bellmanFord(Pais inicio, Pais destino) throws VacioException, PosicionException {
//        Integer vertices = grafo.numVertices();
//        ListaEnlazada<Pais> caminoCorto = new ListaEnlazada<>();
//        ListaEnlazada<Integer> ListaP = grafo.camin0(grafo.getVerticeNum(inicio), grafo.getVerticeNum(destino));
//        System.out.println(ListaP.size());
//        
//        // Inicializar las distancias a infinito y los padres a -1
//        for (int i = 1; i <= ListaP.size(); i++) {
//            caminoCorto.insertar(grafo.getEtiqueta(ListaP.get(i)));
//        }
//
//        // Obtener el índice de los vértices de inicio y destino
//        Integer inicioIndex = grafo.getVerticeNum(inicio);
//        Integer destinoIndex = grafo.getVerticeNum(destino);
//        ListaP.update(inicioIndex - 1, 0); // La distancia al inicio es 0
//
//        // Relajar las aristas repetidamente V-1 veces
//        for (int i = 1; i < vertices; i++) {
//            for (int j = 1; j <= vertices; j++) {
//                ListaEnlazada<Adycencia> adycentes = grafo.adyacentesGE(grafo.getEtiqueta(j));
//                for (int k = 0; k < adycentes.size(); k++) {
//                    Adycencia ady = adycentes.get(k);
//                    int v = ady.getDestino();
//                    int pesoUV = (int) ady.getPeso();
//
//                    if (ListaP.get(j - 1) + pesoUV < ListaP.get(v - 1)) {
//                        ListaP.update(v - 1, ListaP.get(j - 1) + pesoUV);
//                        ListaP.update(v - 1, j);
//                    }
//                }
//            }
//        }
//
//        // Reconstruir el camino más corto
//        int current = destinoIndex;
//        while (current != -1) {
//            caminoCorto.insertarInicio(grafo.getEtiqueta(current));
//            current = ListaP.get(current - 1);
//        }
//        return caminoCorto;
//    }
    public ListaEnlazada<Pais> bellmanFord(Pais origen, Pais destino) throws VacioException, PosicionException {
        System.out.println(grafo.getVerticeNum(origen) + "   " + grafo.getVerticeNum(destino));
        Integer vertices = grafo.numVertices();
        ListaEnlazada<Pais> caminoCorto = new ListaEnlazada<>();
        ListaEnlazada<Integer> distancias = new ListaEnlazada<>();
        ListaEnlazada<Integer> padres = new ListaEnlazada<>();

        //-------Inicializar las distancias a infinito y los padres a -1
        for (int i = 1; i <= vertices; i++) {
            distancias.insertar(Integer.MAX_VALUE);
            padres.insertar(-1);
        }

        //-------Obtener el índice de los vértices de origen y destino
        Integer inicioIndex = grafo.getVerticeNum(origen);
        Integer destinoIndex = grafo.getVerticeNum(destino);
        distancias.update(inicioIndex - 1, 0); // La distancia al inicio es 0

        //-------Relajar las aristas repetidamente V-1 veces
        for (int i = 1; i < vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                ListaEnlazada<Adycencia> adycentes = grafo.adyacentesGE(grafo.getEtiqueta(j));
                for (int k = 0; k < adycentes.size(); k++) {
                    Adycencia ady = adycentes.get(k);
                    int v = ady.getDestino();
                    int pesoUV = (int) ady.getPeso();

                    if (distancias.get(j - 1) + pesoUV < distancias.get(v - 1)) {
                        distancias.update(v - 1, distancias.get(j - 1) + pesoUV);
                        padres.update(v - 1, j);
                    }
                }
            }
        }

         //-------Reconstruir el camino más corto
        
        while (destinoIndex != -1) {
            caminoCorto.insertarInicio(grafo.getEtiqueta(destinoIndex));
            destinoIndex = padres.get(destinoIndex - 1);
        }
        return caminoCorto;
    }
}

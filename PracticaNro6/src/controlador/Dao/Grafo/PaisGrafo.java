/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Dao.Grafo;

import controlador.Dao.PaisDao;
import controlador.Dao.ViajeDao;
import controlador.ed.grafo.Adycencia;
import controlador.ed.grafo.GrafoEtiquetadoD;
import controlador.ed.grafo.GrafoEtiquetadoND;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import modelo.Pais;
import modelo.Viaje;
import vista.utilidadesGrafo.Utilidades;

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
                    String nroViajeDestino = entry.getKey();
                    Double distancia = entry.getValue();
                    Pais paisDestino = getPais(nroViajeDestino);
                    if (paisDestino != null) {
                        System.out.println(paisDestino);
                        grafo.insertarAristaE(pais, paisDestino, distancia);
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

    //------------Calcular camino mas corto "Metodo Floyd"---------
    public ListaEnlazada<Pais> calcularCaminoMinimoFloyd(Pais origen, Pais destino) throws VacioException, PosicionException {
        int n = lista.size();
        HashMap<Pais, Integer> indiceMap = new HashMap<>();
        int indice = 1;

        for (int i = 0; i < lista.size(); i++) {
            Pais pais = lista.get(i);
            indiceMap.put(pais, indice);
            indice++;
        }

        double[][] distancias = new double[n + 1][n + 1];
        int[][] intermedios = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                distancias[i][j] = Double.POSITIVE_INFINITY;
                intermedios[i][j] = -1;
            }
        }

        for (int i = 1; i <= n; i++) {
            distancias[i][i] = 0;
            Pais pais = lista.get(i - 1);
            ListaEnlazada<Viaje> listaV = new ViajeDao().listaPorPais(pais.getId());
            for (int j = 0; j < listaV.size(); j++) {
                Viaje viaje = listaV.get(j);
                Pais destinoPais = getPaisPorNroViaje(viaje.getNroViaje());
                if (destinoPais != null) {
                    distancias[i][indiceMap.get(destinoPais)] = viaje.getDistancia();
                    intermedios[i][indiceMap.get(destinoPais)] = i;
                }
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    double distanciaIK = distancias[i][k];
                    double distanciaKJ = distancias[k][j];

                    if (distanciaIK != Double.POSITIVE_INFINITY && distanciaKJ != Double.POSITIVE_INFINITY) {
                        double distanciaIJ = distancias[i][j];
                        double nuevaDistancia = distanciaIK + distanciaKJ;

                        if (nuevaDistancia < distanciaIJ) {
                            distancias[i][j] = nuevaDistancia;
                            intermedios[i][j] = intermedios[k][j];
                        }
                    }
                }
            }
        }
        ListaEnlazada<Pais> caminoMinimo = reconstruirCamino(indiceMap.get(origen), indiceMap.get(destino), intermedios);

        if (caminoMinimo.isEmpty()) {
            System.out.println("\nNO EXISTE UN CAMINO MINIMO ENTRE " + origen.getNombre() + " Y " + destino.getNombre());
        } else {
            System.out.println("\nCAMINO MINIMO POR FLOYD ENTRE " + origen.getNombre() + " Y " + destino.getNombre() + ":");
            for (int i = 0; i < caminoMinimo.size(); i++) {
                System.out.println(caminoMinimo.get(i));
            }
        }

        return caminoMinimo;
    }

    private ListaEnlazada<Pais> reconstruirCamino(int origen, int destino, int[][] intermedios) throws VacioException, PosicionException {
        ListaEnlazada<Pais> camino = new ListaEnlazada<>();
        if (intermedios[origen][destino] == -1) {
            return camino;
        }
        camino.insertarAlInicio(lista.get(destino - 1));
        while (origen != destino) {
            destino = intermedios[origen][destino];
            camino.insertarAlInicio(lista.get(destino - 1));
        }
        return camino;
    }

    private Pais getPaisPorNroViaje(String nroViaje) throws VacioException, PosicionException {
        for (int i = 0; i < lista.size(); i++) {
            Pais pais = lista.get(i);
            if (pais.getNro_viaje().equals(nroViaje)) {
                return pais;
            }
        }
        return null;
    }

    //------------Calcular camino mas corto "Metodo BellmanFord"---------
    public ListaEnlazada<Pais> bellmanFord(Pais origen, Pais destino) throws VacioException, PosicionException {
        HashMap<Pais, Double> distancias = new HashMap<>();
        HashMap<Pais, Pais> siguiente = new HashMap<>();
        ListaEnlazada<Pais> camino = new ListaEnlazada<>();

        // Inicializar las distancias con infinito excepto para el vértice origen
        for (int i = 1; i <= grafo.numVertices(); i++) {
            Pais pais = grafo.getEtiqueta(i);
            if (pais.equals(origen)) {
                distancias.put(pais, 0.0);
            } else {
                distancias.put(pais, Double.MAX_VALUE);
            }
        }

        // Relajar las aristas V - 1 veces (donde V es el número de vértices)
        for (int i = 1; i <= grafo.numVertices() - 1; i++) {
            for (int j = 1; j <= grafo.numVertices(); j++) {
                Pais paisI = grafo.getEtiqueta(j);
                ListaEnlazada<Adycencia> adycentes = grafo.adyacentesGE(grafo.getEtiqueta(j));
                for (int k = 0; k < adycentes.size(); k++) {
                    Adycencia ady = adycentes.get(k);
                    Pais paisJ = grafo.getEtiqueta(ady.getDestino());

                    if (distancias.get(paisI) + ady.getPeso() < distancias.get(paisJ)) {
                        distancias.put(paisJ, distancias.get(paisI) + ady.getPeso());
                        siguiente.put(paisJ, paisI);
                    }
                }
            }
        }

        // Construir el camino más corto desde el origen al destino
        ListaEnlazada<Pais> caminoMinimo = reconstruirCamino(destino, origen, siguiente, camino);

        if (caminoMinimo.isEmpty()) {
            System.out.println("\nNO EXISTE CAMINO ENTRE " + origen.getNombre() + " - " + destino.getNombre());
        } else {
            System.out.println("\nCAMINO POR BELLMANFORD ENTRE " + origen.getNombre() + " - " + destino.getNombre() + ":");
            for (int i = 0; i < caminoMinimo.size(); i++) {
                System.out.println(caminoMinimo.get(i));
            }
        }

        return camino;
    }

    public ListaEnlazada<Pais> reconstruirCamino(Pais destino, Pais origen, HashMap<Pais, Pais> siguiente, ListaEnlazada<Pais> camino) {

        while (destino != null && !destino.equals(origen)) {
            camino.insertarInicio(destino);
            destino = siguiente.get(destino);
        }
        if (destino != null) {
            camino.insertarInicio(origen);
        } else {
            // Si el destino no es alcanzable desde el origen, se limpia la lista
            camino.deleteAll();
        }
        return camino;
    }

    //------Algoritmo de busqueda en profundidad-------
     public boolean esConectado() throws VacioException, PosicionException{
        if (grafo.numVertices() == 0) {
            return false; // El grafo vacío no está conectado
        }

        HashSet<Pais> visitados = new HashSet<>();
        ListaEnlazada<Adycencia> adycentes = grafo.adyacentesGE(grafo.getEtiqueta(1)); // Comenzar la búsqueda desde el primer vértice

        dfs(grafo.getEtiqueta(1), visitados); // Realizar búsqueda DFS desde el primer vértice

        return visitados.size() == grafo.numVertices(); // Si se visitaron todos los vértices, el grafo está conectado
    }

    private void dfs(Pais vertice, HashSet<Pais> visitados) throws VacioException, PosicionException {
        visitados.add(vertice);
        ListaEnlazada<Adycencia> adycentes = grafo.adyacentesGE(vertice);

        for (int i = 0; i < adycentes.size(); i++) {
            Adycencia ady = adycentes.get(i);
            Pais verticeDestino = grafo.getEtiqueta(ady.getDestino());
            if (!visitados.contains(verticeDestino)) {
                dfs(verticeDestino, visitados);
            }
        }
    }

    public static void main(String[] args) {
    PaisGrafo pg = new PaisGrafo();

    try {
        boolean esConectado = pg.esConectado();
        if (esConectado) {
            System.out.println("El grafo está conectado.");
        } else {
            System.out.println("El grafo no está conectado.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


}

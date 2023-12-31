/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.grafo;

import controlador.ed.grafo.exception.GrafoSizeExeption;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.util.HashMap;


public class GrafoEtiquetadoD<E> extends GrafoD {

    protected E etiquetas[];
    protected HashMap<E, Integer> dicVertices;

    public GrafoEtiquetadoD(Integer verc) {
        super(verc);
        etiquetas = (E[]) new Object[verc + 1];
        dicVertices = new HashMap<>(verc);

    }

    public Boolean existeAristaE(E i, E j) throws GrafoSizeExeption {
        return this.existeArista(getVerticeNum(i), getVerticeNum(j));
    }

    public Integer getVerticeNum(E etiqueta) {

        return dicVertices.get(etiqueta);
    }

    public E getEtiqueta(Integer vertNum) {
        return etiquetas[vertNum];
    }

    public void insertarAristaE(E i, E j, Double peso) throws GrafoSizeExeption {
        this.insertar(getVerticeNum(i), getVerticeNum(j), peso);
    }

    public void insertarAristaE(E i, E j) throws GrafoSizeExeption {
        this.insertar(getVerticeNum(i), getVerticeNum(j));
    }

    public ListaEnlazada<Adycencia> adyacentesGE(E i) {
        return this.adycentes(getVerticeNum(i));
    }

    public void etiquetarVertice(Integer vertice, E etiqueta) {
        etiquetas[vertice] = etiqueta;
        dicVertices.put(etiqueta, vertice);

    }

    @Override
    public String toString() {
        StringBuilder grafo = new StringBuilder("GRAFO" + "\n");
        for (int i = 1; i <= numVertices(); i++) {
            grafo.append(" V " + i + " *(" + getEtiqueta(i) + ")" + "\n");
            ListaEnlazada<Adycencia> lista = adycentes(i);
            grafo.append((!lista.isEmpty()) ? "Adycencias" : "No Adycencias");
            grafo.append("\n");
            for (int j = 0; j < lista.size(); j++) {
                try {
                    Adycencia aux = lista.get(j);
                    grafo.append(" -- V " + aux.getDestino() + " (" + getEtiqueta(aux.getDestino()) + ")" + " PESO --> " + aux.getPeso() + "\n");
                } catch (Exception e) {
                }
            }
        }
        return grafo.toString();
    }
}

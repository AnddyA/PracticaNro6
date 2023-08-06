/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.Dao.Grafo.PaisGrafo;
import controlador.Dao.PaisDao;
import controlador.Dao.ViajeDao;
import controlador.ed.grafo.Adycencia;
import controlador.ed.grafo.Grafo;
import controlador.ed.grafo.GrafoEtiquetadoD;
import controlador.ed.grafo.GrafoEtiquetadoND;
import controlador.ed.grafo.exception.GrafoSizeExeption;
import controlador.ed.lista.ListaEnlazada;
import java.util.Date;
import modelo.Pais;
import modelo.TipoViaje;
import vista.FrmGrafo;

/**
 *
 * @author andy
 */
public class Control {

    public static void main(String[] args) {

//        PaisGrafo paisGrafo = new PaisGrafo(); // Asegúrate de que se haya cargado el grafo desde el JSON
//        System.out.println("fuera");
//        try {
//        System.out.println("denntro");
//
//            ListaEnlazada camino = paisGrafo.bellmanFord(paisGrafo.getLista().get(0), paisGrafo.getLista().get(4));
//            System.out.println("Camino más corto: " + camino);
//            camino.imprimir();
//            System.out.println("xd");
//        } catch (Exception e) {
//        }
        // Por ejemplo, para encontrar el camino más corto entre Estados Unidos (id 1) y España (id 5)

//        g.bfs(i);
//        try {
//            GrafoEtiquetadoD<Pais> ged = new GrafoEtiquetadoD<>(6);
//            
//            ged.etiquetarVertice(1, new Pais(1, "Ecuador", "Quito",true));
//            ged.etiquetarVertice(2, new Pais(1, "Colombia", "Quito", true));
//            ged.etiquetarVertice(3, new Pais(1, "Mexico", "Quito", true));
//            ged.etiquetarVertice(4, new Pais(1, "España", "Quito", true));
//            ged.etiquetarVertice(5, new Pais(1, "Japon", "Quito", true));
//            ged.etiquetarVertice(6, new Pais(1, "Rusia", "Quito", true));
//            
//            ged.insertarAristaE(ged.getEtiqueta(1), ged.getEtiqueta(6), 400.0);
//            ged.insertarAristaE(ged.getEtiqueta(2), ged.getEtiqueta(6), 400.0);
//            ged.insertarAristaE(ged.getEtiqueta(3), ged.getEtiqueta(6), 400.0);
//            ged.insertarAristaE(ged.getEtiqueta(4), ged.getEtiqueta(6), 400.0);
//            ged.insertarAristaE(ged.getEtiqueta(5), ged.getEtiqueta(6),400.0);
//
//            
//            System.out.println(ged.toString());
//            new FrmGrafo(null, true, ged).setVisible(true);
//             
//            System.out.println(ged.getEtiqueta(1));
//        } catch (Exception e) {
//            System.out.println("error en GE " + e);
//        }
//        
//          -------------cargar datos a json----------------
//
//        try {
//            PaisDao pd = new PaisDao();
//
//            pd.getPais().setNombre("EstadosUnidos");
//            pd.getPais().setCiudad("New York");
//            pd.getPais().setNro_viaje("454545");
//            pd.getPais().setEstado(true);
//            pd.guardar();
//            pd.setPais(null);
//
//            pd.getPais().setNombre("ReinoUnido");
//            pd.getPais().setCiudad("Londre");
//            pd.getPais().setNro_viaje("454545");
//            pd.getPais().setEstado(true);
//            pd.guardar();
//            pd.setPais(null);
//
//            pd.getPais().setNombre("Francia");
//            pd.getPais().setCiudad("Paris");
//            pd.getPais().setNro_viaje("454545");
//            pd.getPais().setEstado(true);
//            pd.guardar();
//            pd.setPais(null);
//
//            pd.getPais().setNombre("Italia");
//            pd.getPais().setCiudad("Milan");
//            pd.getPais().setNro_viaje("454545");
//            pd.getPais().setEstado(true);
//            pd.guardar();
//            pd.setPais(null);
//
//            pd.getPais().setNombre("España");
//            pd.getPais().setCiudad("Madrid");
//            pd.getPais().setNro_viaje("454545");
//            pd.getPais().setEstado(true);
//            pd.guardar();
//            pd.setPais(null);
//
//            pd.getPais().setNombre("Brasil");
//            pd.getPais().setCiudad("Janeiro");
//            pd.getPais().setNro_viaje("454545");
//            pd.getPais().setEstado(true);
//            pd.guardar();
//            pd.setPais(null);
//
//            pd.getPais().setNombre("Ecuador");
//            pd.getPais().setCiudad("Quito");
//            pd.getPais().setNro_viaje("454545");
//            pd.getPais().setEstado(true);
//            pd.guardar();
//            pd.setPais(null);
//
//        } catch (Exception e) {
//        }
//      ----------------cargar datos viaje a json-----------------
        try {
            ViajeDao vd = new ViajeDao();
            
            vd.getViaje().setIdPais(7);
            vd.getViaje().setNroViaje("434343");
            vd.getViaje().setDistancia(912.05);
            vd.getViaje().setTipo(TipoViaje.Valido);
            vd.guardar();
            vd.setViaje(null);
            vd.getViaje().setIdPais(2);
            vd.getViaje().setNroViaje("101010");
            vd.getViaje().setDistancia(325.80);
            vd.getViaje().setTipo(TipoViaje.Valido);
            vd.guardar();
            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(1);
//            vd.getViaje().setNroViaje("414141");
//            vd.getViaje().setDistancia(855.25);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(5);
//            vd.getViaje().setNroViaje("444333");
//            vd.getViaje().setDistancia(754.25);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(2);
//            vd.getViaje().setNroViaje("454545");
//            vd.getViaje().setDistancia(875.50);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(2);
//            vd.getViaje().setNroViaje("414141");
//            vd.getViaje().setDistancia(855.25);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(3);
//            vd.getViaje().setNroViaje("404040");
//            vd.getViaje().setDistancia(754.25);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(3);
//            vd.getViaje().setNroViaje("4443344");
//            vd.getViaje().setDistancia(545.0);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(4);
//            vd.getViaje().setNroViaje("101010");
//            vd.getViaje().setDistancia(484.25);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(4);
//            vd.getViaje().setNroViaje("404040");
//            vd.getViaje().setDistancia(548.44);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(5);
//            vd.getViaje().setNroViaje("454545");
//            vd.getViaje().setDistancia(885.0);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(5);
//            vd.getViaje().setNroViaje("112211");
//            vd.getViaje().setDistancia(582.10);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(6);
//            vd.getViaje().setNroViaje("101010");
//            vd.getViaje().setDistancia(748.0);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            vd.getViaje().setIdPais(6);
//            vd.getViaje().setNroViaje("858585");
//            vd.getViaje().setDistancia(487.0);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
            
        } catch (Exception e) {
        }
    }
}

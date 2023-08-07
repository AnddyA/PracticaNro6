/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.Dao.PaisDao;
import controlador.Dao.ViajeDao;
import controlador.ed.grafo.GrafoEtiquetadoD;
import controlador.ed.grafo.GrafoEtiquetadoND;
import java.io.IOException;
import java.util.Date;
import modelo.Pais;
import modelo.TipoViaje;
import vista.FrmGrafo;

public class Control {

    public static void main(String[] args) throws IOException {

        PaisDao pd = new PaisDao();
        try {
//            pd.getPais().setNombre("ESPANIA");
//            pd.getPais().setCiudad("MADRID");
//            pd.getPais().setId(1);
//            pd.getPais().setEstado(true);
//            pd.getPais().setNro_viaje("1");
//            pd.guardar();
//            pd.setPais(null);
//
//            pd.getPais().setNombre("ECUADOR");
//            pd.getPais().setCiudad("QUITO");
//            pd.getPais().setId(1);
//            pd.getPais().setEstado(true);
//            pd.getPais().setNro_viaje("2");
//            pd.guardar();
//            pd.setPais(null);
//
//            pd.getPais().setNombre("BRASIL");
//            pd.getPais().setCiudad("BRASILIA");
//            pd.getPais().setId(1);
//            pd.getPais().setEstado(true);
//            pd.getPais().setNro_viaje("3");
//            pd.guardar();
////            pd.setPais(null);
//
//            pd.getPais().setNombre("ARGENTINA");
//            pd.getPais().setCiudad("BUENOS AIRES");
//            pd.getPais().setId(1);
//            pd.getPais().setEstado(true);
//            pd.getPais().setNro_viaje("4");
//            pd.guardar();
//            pd.setPais(null);
//

  pd.getPais().setNombre("ALBANIA");
            pd.getPais().setCiudad("TIRANA");
            pd.getPais().setEstado(true);
            pd.getPais().setNro_viaje("5");
            pd.guardar();
            pd.setPais(null);
            
              pd.getPais().setNombre("ALEMANIA");
            pd.getPais().setCiudad("BERLIN");
            pd.getPais().setEstado(true);
            pd.getPais().setNro_viaje("6");
            pd.guardar();
            pd.setPais(null);
            
              pd.getPais().setNombre("ANDORRA");
            pd.getPais().setCiudad("ANDORRA LV");
            pd.getPais().setEstado(true);
            pd.getPais().setNro_viaje("7");
            pd.guardar();
            pd.setPais(null);
            
              pd.getPais().setNombre("AUSTRIA");
            pd.getPais().setCiudad("VIENA");
            pd.getPais().setEstado(true);
            pd.getPais().setNro_viaje("8");
            pd.guardar();
            pd.setPais(null);
            
              pd.getPais().setNombre("BELGICA");
            pd.getPais().setCiudad("BRUSELAS");
            pd.getPais().setEstado(true);
            pd.getPais().setNro_viaje("9");
            pd.guardar();
            pd.setPais(null);
            
              pd.getPais().setNombre("BOLIVIA");
            pd.getPais().setCiudad("SUCRE");
            pd.getPais().setEstado(true);
            pd.getPais().setNro_viaje("10");
            pd.guardar();
            pd.setPais(null);
//////            vd.getViaje().setId(5);
//////            vd.getViaje().setIdPais(2);
//////            vd.getViaje().setNroViaje("3");
//////            vd.getViaje().setDistancia(10000.0);
//////            vd.getViaje().setTipo(TipoViaje.Valido);
//////            vd.guardar();
//////            vd.setViaje(null);
//////            vd.getViaje().setId(6);
//////            vd.getViaje().setIdPais(3);
//////            vd.getViaje().setNroViaje("1");
//////            vd.getViaje().setDistancia(100000.0);
//////            vd.getViaje().setTipo(TipoViaje.Valido);
//////            vd.guardar();
//////            vd.setViaje(null);
////////              vd.getViaje().setId(8);
////////            vd.getViaje().setIdPais(2);
////////            vd.getViaje().setNroViaje("1");
////////            vd.getViaje().setDistancia(100000.0);
////////            vd.getViaje().setTipo(TipoViaje.Valido);
////////            vd.guardar();
////////            vd.setViaje(null);
//////             vd.getViaje().setId(7);
//////            vd.getViaje().setIdPais(4);
//////            vd.getViaje().setNroViaje("2");
//////            vd.getViaje().setDistancia(100000.0);
//////            vd.getViaje().setTipo(TipoViaje.Valido);
//////            vd.guardar();
//////            vd.setViaje(null);
//////            
//////                   vd.getViaje().setId(7);
//////            vd.getViaje().setIdPais(4);
//////            vd.getViaje().setNroViaje("2");
//////            vd.getViaje().setDistancia(100000.0);
//////            vd.getViaje().setTipo(TipoViaje.Valido);
//////            vd.guardar();
//////            vd.setViaje(null);

//            vd.getViaje().setId(1);
//            vd.getViaje().setIdPais(1);
//            vd.getViaje().set.NroViaje("4");
//            vd.getViaje().setDistancia(2000.0);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//              vd.getViaje().setId(2);
//            vd.getViaje().setIdPais(1);
//            vd.getViaje().setNroViaje("3");
//            vd.getViaje().setDistancia(5600.0);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//              vd.getViaje().setId(3);
//            vd.getViaje().setIdPais(1);
//            vd.getViaje().setNroViaje("2");
//            vd.getViaje().setDistancia(7000.0);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);  
//            
//            vd.getViaje().setId(4);
//            vd.getViaje().setIdPais(4);
//            vd.getViaje().setNroViaje("1");
//            vd.getViaje().setDistancia(2000.0);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            GrafoEtiquetadoD<Pais> ged = new GrafoEtiquetadoD<>(4);
//            ged.insertarAristaE(pd.obtener(1), pd.obtener(2));
//            ged.etiquetarVertice(1, pd.obtener(1));
//            System.out.println(ged.toString());
        } catch (Exception e) {
        }
        try {
//            GrafoEtiquetadoD<Pais> ged = new GrafoEtiquetadoD<>(6);
//
//            ged.etiquetarVertice(1, new Pais(1, "Ecuador", "Quito",true));
//            ged.etiquetarVertice(2, new Pais(1, "Colombia", "Quito", true));
//            ged.etiquetarVertice(3, new Pais(1, "Mexico", "Quito", true));
//            ged.etiquetarVertice(4, new Pais(1, "España", "Quito", true));
//            ged.etiquetarVertice(5, new Pais(1, "Japon", "Quito", true));
//            ged.etiquetarVertice(6, new Pais(1, "Rusia", "Quito", true));
//            ged.insertarAristaE(ged.getEtiqueta(1), ged.getEtiqueta(6), 400.0);
//            ged.insertarAristaE(ged.getEtiqueta(2), ged.getEtiqueta(6), 400.0);
//            ged.insertarAristaE(ged.getEtiqueta(3), ged.getEtiqueta(6), 400.0);
//            ged.insertarAristaE(ged.getEtiqueta(4), ged.getEtiqueta(6), 400.0);
//            ged.insertarAristaE(ged.getEtiqueta(5), ged.getEtiqueta(6), 400.0);
//
//            System.out.println(ged.toString());
//             new FrmGrafo(null, true, ged).setVisible(true);.
//
//            System.out.println(ged.getEtiqueta(1));
        } catch (Exception e) {
            System.out.println("error en GE " + e);
        }

//          -------------cargar datos a jso      vd.getViaje().setIdPais(6);
//            vd.getViaje().setNroViaje("1");
//            vd.getViaje().setDistancia(81000.50);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//
//        try {
//        PaisDao pd = new PaisDao();

////            pd.getPais().setNombre("EstadosUnidos");
////            pd.getPais().setCiudad("New York");
////            pd.getPais().setNro_viaje("454545");
////            pd.getPais().setEstado(true);
////            pd.guardar();
////            pd.setPais(null);
////
////            pd.getPais().setNombre("ReinoUnido");
////            pd.getPais().setCiudad("Londres");
////            pd.getPais().setNro_viaje("454545");
////            pd.getPais().setEstado(true);
////            pd.guardar();
////            pd.setPais(null);
////
////         pd.getPais().setNombre("Francia");
////            pd.getPais().setCiudad("Paris");
////            pd.getPais().setNro_viaje("454545");
////            pd.getPais().setEstado(true);
////            pd.guardar();
////            pd.setPais(null);
////
////            pd.getPais().setNombre("Italia");
////            pd.getPais().setCiudad("Milan");
////            pd.getPais().setNro_viaje("454545");
////            pd.getPais().setEstado(true);
////            pd.guardar();
////            pd.setPais(null);
//////            pd.getPais().setNombre("España");
//////            pd.getPais().setCiudad("Madrid");
//////            pd.getPais().setNro_viaje("454545");
//////            pd.getPais().setEstado(true);
//////            pd.guardar();
//////            pd.setPais(null);
//
////////            pd.getPais().setNombre("Brasil");
////////            pd.getPais().setCiudad("Janeiro");
////////            pd.getPais().setNro_viaje("454545");
////////            pd.getPais().setEstado(true);
////////            pd.guardar();
////////            pd.setPais(null);
////////
////////            pd.getPais().setNombre("Ecuador");
////////            pd.getPais().setCiudad("Quito");
////////            pd.getPais().setNro_viaje("454545");
////////            pd.getPais().setEstado(true);
////////            pd.guardar();
////////            pd.setPais(null);
//
//        } catch (Exception e) {
//        }
//      ----------------cargar datos viaje a json-----------------
        try {
//                        ViajeDao vd = new ViajeDao();
//
//            vd.getViaje().setIdPais(5);
//            vd.getViaje().setNroViaje("4");
//            vd.getViaje().setDistancia(875.50);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//            
//             vd.getViaje().setIdPais(6);
//            vd.getViaje().setNroViaje("1");
//            vd.getViaje().setDistancia(81000.50);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//                  vd.getViaje().setIdPais(7);
//            vd.getViaje().setNroViaje("6");
//            vd.getViaje().setDistancia(4000.50);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//                  vd.getViaje().setIdPais(8);
//            vd.getViaje().setNroViaje("3");
//            vd.getViaje().setDistancia(81000.50);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//                   vd.getViaje().setIdPais(6);
//            vd.getViaje().setNroViaje("8");
//            vd.getViaje().setDistancia(123455.50);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
//            
//                   vd.getViaje().setIdPais(1);
//            vd.getViaje().setNroViaje("7");
//            vd.getViaje().setDistancia(84800.50);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);

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
//            vd.getViaje().setIdPais(6);
//            vd.getViaje().setNroViaje("858587");
//            vd.getViaje().setDistancia(340.0);
//            vd.getViaje().setTipo(TipoViaje.Valido);
//            vd.guardar();
//            vd.setViaje(null);
        } catch (Exception e) {
        }
    }

}

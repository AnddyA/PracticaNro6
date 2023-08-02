/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author andy
 */
public class Viaje {

    private Integer id_pais;
    private String nro_viaje;
    private Date fecha;

    public Integer getId_pais() {
        return id_pais;
    }

    public void setId_pais(Integer id_pais) {
        this.id_pais = id_pais;
    }

    public String getNro_viaje() {
        return nro_viaje;
    }

    public void setNro_viaje(String nro_viaje) {
        this.nro_viaje = nro_viaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}

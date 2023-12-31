/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Pais {

    private Integer id;
    private String nombre;
    private String ciudad;
    private String nroPais;
    private Boolean estado;

    public Pais() {
    }

    public Pais(Integer id, String nombre, String ciudad, String nroPais, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.nroPais = nroPais;
        this.estado = estado;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNro_viaje() {
        return nroPais;
    }

    public void setNro_viaje(String nro_viaje) {
        this.nroPais = nro_viaje;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre + "(" + ciudad + ")";
    }
}

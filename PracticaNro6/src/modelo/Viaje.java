/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;



public class Viaje {

    private Integer id;
    private Integer idPais; //origen del viaje
    private String nroPais; // destino del viaje
    private Double distancia;
    private TipoViaje tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais_origen) {
        this.idPais = idPais_origen;
    }

    public String getNroViaje() {
        return nroPais;
    }

    public void setNroViaje(String nroViaje) {
        this.nroPais = nroViaje;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public TipoViaje getTipo() {
        return tipo;
    }

    public void setTipo(TipoViaje tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Viaje{" + "idPais=" + idPais + ", nroViaje=" + nroPais + ", distancia=" + distancia + '}';
    }
    

}

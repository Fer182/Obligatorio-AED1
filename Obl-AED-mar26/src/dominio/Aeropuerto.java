/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

//import tads.Cola;

import tads.Cola;


/**
 *
 * @author FERAR
 */
public class Aeropuerto implements Comparable<Aeropuerto> {
    private String codigo;
    private String nombre; 
    private Cola<Vuelo> viajesEnEspera;

public Aeropuerto(String codigo, String nombre) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.viajesEnEspera = new Cola<>();
}

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Cola<Vuelo> getViajesEnEspera() {
        return viajesEnEspera;
    }

    @Override
    public String toString() {
    return codigo + ";" + nombre + ";" + viajesEnEspera.size();
    }
    
    @Override
    public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Aeropuerto other = (Aeropuerto) obj;
    return this.codigo.equals(other.codigo);
   
    }
    
    @Override
    public int compareTo(Aeropuerto o) {
        return this.codigo.compareTo(o.codigo);
    }

}

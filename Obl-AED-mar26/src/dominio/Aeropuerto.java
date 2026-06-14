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

    @Override
    public int compareTo(Aeropuerto o) {
        return this.codigo.compareTo(o.codigo);
    }

}

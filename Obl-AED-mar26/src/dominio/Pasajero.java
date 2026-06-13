/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import sistemaViajes.Categoria;

/**
 *
 * @author FERAR
 */
public class Pasajero {
    private String cedula;
    private String nombre;
    private int edad; 
    private Categoria categoria; 

    public Pasajero(String cedula, String nombre, int edad, Categoria categoria) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.categoria = categoria;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    
    
}

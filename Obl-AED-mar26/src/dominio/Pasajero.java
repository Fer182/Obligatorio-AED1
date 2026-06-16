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
public class Pasajero implements Comparable<Pasajero> {
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

    public Pasajero(String cedula) {
        this.cedula = cedula;
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
    
    @Override
    public String toString() {
    return cedula + ";" + nombre + ";" + edad + ";" + categoria.getTexto();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pasajero other = (Pasajero) obj;
        return this.cedula.equals(other.cedula);
  
    }

    @Override
    public int compareTo(Pasajero p) {
        
        String c1 = this.cedula.replace(".","").replace("-","");
        String c2 = p.cedula.replace(".","").replace("-","");
        Integer c1Numerico = Integer.parseInt(c1);
        Integer c2Numerico = Integer.parseInt(c2);
        
        return c1Numerico - c2Numerico;
    }
    
}


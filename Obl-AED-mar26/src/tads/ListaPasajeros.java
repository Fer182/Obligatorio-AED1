/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads;

import dominio.Pasajero;

/**
 *
 * @author burio
 */
public class ListaPasajeros {
    private ILista<Pasajero> listaDePasajeros;

    
    public ListaPasajeros() {
        this.listaDePasajeros = new Lista<>(); 
    }

    public void registrarPasajero(Pasajero pasajero) {

    }
    
    public String buscarPasajero (String cedula) {
        int total = this.listaDePasajeros.cantidadElementos();

        for (int i = 0; i < total; i++) {
            Pasajero pasajeroActual = this.listaDePasajeros.obtenerElemento(i);
            if (pasajeroActual.getCedula().equals(cedula)) {
                return pasajeroActual.toString();
            }
        }
        return "No se encontro pasajero";
    }
}

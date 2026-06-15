/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import sistemaViajes.EstadoReserva;

/**
 *
 * @author burio
 */
public class Reserva {
    private String codigoDeVuelo;
    private String cedula;
    private EstadoReserva estado;

    public Reserva(String codigoDeVuelo, String cedula) {
        this.codigoDeVuelo = codigoDeVuelo;
        this.cedula = cedula;
        this.estado = estado.RESERVA;
    }

    public EstadoReserva getEstado() {
        return estado;
    }
    
    public String getcodigoDeVuelo () {
        return this.codigoDeVuelo;
    }
        
    public String getcedula () {
        return this.cedula;
    }
}

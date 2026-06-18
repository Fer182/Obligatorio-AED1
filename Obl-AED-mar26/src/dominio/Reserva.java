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
public class Reserva implements Comparable<Reserva>{
    private String codigoDeVuelo;
    private String cedula;
    private EstadoReserva estado;

    public Reserva(String codigoDeVuelo, String cedula) {
        this.codigoDeVuelo = codigoDeVuelo;
        this.cedula = cedula;
        this.estado = estado.RESERVA;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public Reserva(String cedula) {
        this.cedula = cedula;
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

    @Override
    public int compareTo(Reserva r) {
        int cmpVuelo = this.codigoDeVuelo.compareTo(r.codigoDeVuelo);
        if (cmpVuelo != 0) {
            return cmpVuelo;
        }

        String c1 = this.cedula.replace(".", "").replace("-", "");
        String c2 = r.cedula.replace(".", "").replace("-", "");

        return Integer.parseInt(c1) - Integer.parseInt(c2);
    }
}

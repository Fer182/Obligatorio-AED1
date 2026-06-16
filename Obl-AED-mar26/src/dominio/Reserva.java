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
        String c1 = this.cedula.replace(".","").replace("-","");
        String c2 = r.cedula.replace(".","").replace("-","");
        Integer c1Numerico = Integer.parseInt(c1);
        Integer c2Numerico = Integer.parseInt(c2);
        
        return c1Numerico - c2Numerico;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author burio
 */
public class Reserva {
    private String codigoDeVuelo;
    private String cedula;

    public Reserva(String codigoDeVuelo, String cedula) {
        this.codigoDeVuelo = codigoDeVuelo;
        this.cedula = cedula;
    }
    
    public String getcodigoDeVuelo () {
        return this.codigoDeVuelo;
    }
        
    public String getcedula () {
        return this.cedula;
    }
}

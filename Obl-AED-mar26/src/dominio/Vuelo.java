package dominio;

import sistemaViajes.Estado;

/**
 *
 * @author burio
 */
public class Vuelo {
   private String codigoAeropuestoOrigen;
   private String codigoAeropuertoDestino;
   private String codigoDeVuelo;
   private int capacidad;
   private int costoEnDolares;
   private Estado estado;
   private int cantidadDeReservas;
   private int cantidadDePasajerosConfirmados;

    public Vuelo(String codigoAeropuestoOrigen, String codigoAeropuertoDestino, String codigoDeVuelo, int capacidad, int costoEnDolares) {
        this.codigoAeropuestoOrigen = codigoAeropuestoOrigen;
        this.codigoAeropuertoDestino = codigoAeropuertoDestino;
        this.codigoDeVuelo = codigoDeVuelo;
        this.capacidad = capacidad;
        this.costoEnDolares = costoEnDolares;
        this.estado = estado.PROGRAMADO;
    }
    
    public String getcodigoDeVuelo () {
        return this.codigoDeVuelo; 
    }
   
    public int getCapacidad() {
        return this.capacidad;
    }
    
    public int getCostoEnDolares() {
        return this.costoEnDolares;
    }
    
    public String getEstado() {
        if(null != this.estado) switch (this.estado) {
           case PROGRAMADO:
               return "PROGRAMADO";
           case ABIERTO:
               return "ABIERTO";
           case CERRADO:
               return "CERRADO";
           default:
               break;
       }
        return "FINALIZADO";
    }
    
    public int getcantidadDeReservas () {
        return this.cantidadDeReservas;
    }
    
    public int getcantidadDePasajerosConfirmados() {
        return this.cantidadDePasajerosConfirmados;
    }
   
}

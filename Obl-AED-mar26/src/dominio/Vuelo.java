package dominio;

import sistemaViajes.Estado;

/**
 *
 * @author burio
 */
public class Vuelo implements Comparable<Vuelo>{
   private String codigoAeropuertoOrigen;
   private String codigoAeropuertoDestino;
   private String codigoDeVuelo;
   private int capacidad;
   private int costoEnDolares;
   private Estado estado;
   private int cantidadDeReservas;
   private int cantidadDePasajerosConfirmados;

    public Vuelo(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, String codigoDeVuelo, int capacidad, int costoEnDolares) {
        this.codigoAeropuertoOrigen = codigoAeropuertoOrigen;
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

    public void setEstado(Estado estado) {
        this.estado = estado;
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
    
    
    @Override
    public String toString() {
    return codigoAeropuertoOrigen + ";" + codigoAeropuertoDestino + ";" + codigoDeVuelo
            + ";" + capacidad + ";" + costoEnDolares + ";" + estado + ";" + cantidadDeReservas
            + ";" + cantidadDePasajerosConfirmados;
    }
    
    @Override
    public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Vuelo other = (Vuelo) obj;
    return this.codigoDeVuelo.equals(other.codigoDeVuelo);
   
    }
    
    @Override
    public int compareTo(Vuelo o) {
        return this.codigoDeVuelo.compareTo(o.codigoDeVuelo);
    }
   
}

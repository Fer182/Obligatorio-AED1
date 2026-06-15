package dominio;

import sistemaViajes.Estado;
import sistemaViajes.EstadoReserva;
import sistemaViajes.Retorno;
import tads.ILista;

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
   private ILista<Reserva> reservas;
   private ILista<Pasajero> pasajeros;

    public Vuelo(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, String codigoDeVuelo, int capacidad, int costoEnDolares) {
        this.codigoAeropuertoOrigen = codigoAeropuertoOrigen;
        this.codigoAeropuertoDestino = codigoAeropuertoDestino;
        this.codigoDeVuelo = codigoDeVuelo;
        this.capacidad = capacidad;
        this.costoEnDolares = costoEnDolares;
        this.estado = estado.PROGRAMADO;
    }

    public Vuelo(String codigoDeVuelo) {
        this.codigoDeVuelo = codigoDeVuelo;
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
    
    
    public int getcantidadDeReservasTotales () {
        return this.reservas.cantidadElementos();
    }
    
    public Pasajero getPasajeroPorCedula (String cedula) {
        int total = this.pasajeros.cantidadElementos();
        
        for (int i = 0; i < total; i++) {
        Pasajero pasajero = this.pasajeros.obtenerElemento(i);
            if (pasajero.getCedula().equals(cedula)) {
                return pasajero;
            }
        }
        return null;
    }
    
    public String getPasajerosConfirmados() {
        int total = this.reservas.cantidadElementos();
        String pasajeros = "";

        for (int i = 0; i < total; i++) {
            Reserva reserva = this.reservas.obtenerElemento(i);
            if (reserva.getEstado().equals(EstadoReserva.CHECKIN)) {
                Pasajero pasajero = this.getPasajeroPorCedula(reserva.getcedula());
                pasajeros += pasajero.toString();
            }
        }
        return pasajeros;
    }
    
    public int getcantidadDeReservasSinConfirmar() {
        int total = this.reservas.cantidadElementos();
        int sinConfirmar = 0;
        for (int i = 0; i < total; i++) {
            Reserva reserva = this.reservas.obtenerElemento(i);
            if (reserva.getEstado().equals(EstadoReserva.RESERVA)) {
                sinConfirmar ++;
            }
        }
        return sinConfirmar;
    }
    
    public int getcantidadDePasajerosConfirmados() {
        int total = this.reservas.cantidadElementos();
        int confirmados = 0;
        for (int i = 0; i < total; i++) {
            Reserva reserva = this.reservas.obtenerElemento(i);
            if (reserva.getEstado().equals(EstadoReserva.CHECKIN)) {
                confirmados ++;
            }
        }
        return confirmados;
    }
    
    
    @Override
    public String toString() {
    return codigoAeropuertoOrigen + ":" + codigoAeropuertoDestino + ";" + codigoDeVuelo
            + ";" + capacidad + ";" + costoEnDolares + ";" + estado.getTexto() + ";" + cantidadDeReservas
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

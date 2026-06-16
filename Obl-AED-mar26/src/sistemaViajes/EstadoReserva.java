/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaViajes;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author burio
 */
public enum EstadoReserva {
    CHECKIN(0, "Checkin"),
    RESERVA(1, "Reserva");
    
    private final int indice;
    private final String texto;

    EstadoReserva(int indice, String texto) {
        this.indice = indice;
        this.texto = texto;
    }

    public int getIndice() {
        return indice;
    }

    public String getTexto() {
        return texto;
    }

    public static EstadoReserva fromTexto(String texto) {
        return Arrays.stream(EstadoReserva.values())
                .filter(a -> Objects.equals(a.texto, texto))
                .findFirst()
                .orElse(null);
    }
}

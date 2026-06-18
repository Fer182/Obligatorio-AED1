package sistemaViajes.testNuestros;

import sistemaViajes.*;
import org.junit.Before;
import org.junit.Test;
import sistemaViajes.Categoria;
import sistemaViajes.ImplementacionSistema;
import sistemaViajes.Retorno;
import sistemaViajes.Sistema;
import static org.junit.Assert.*;

public class Test13_RealizarReserva {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @Before
    public void setUp() {
        s.inicializarSistema();
        s.registrarAeropuerto("MVD", "Aeropuerto de Carrasco");
        s.registrarAeropuerto("EZE", "Ezeiza");
        s.registrarVuelo("MVD", "EZE", "AR123", 2, 230);
        s.registrarPasajero("1.111.111-1", "Ana", 25, Categoria.FRECUENTE);
        s.registrarPasajero("2.222.222-2", "Bruno", 40, Categoria.PLATINO);
        s.registrarPasajero("3.333.333-3", "Carlos", 30, Categoria.ESTANDAR);
        s.registrarPasajero("935.457-7", "Diana", 50, Categoria.ESPORADICO);
    }

    @Test
    public void realizarReservaDuplicadaEnProgramado() {
        retorno = s.realizarReserva("AR123", "1.111.111-1");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.realizarReserva("AR123", "1.111.111-1");
        assertEquals(Retorno.Resultado.ERROR_6, retorno.getResultado());
    }
    
    @Test
    public void realizarReservaDuplicadaEnAbierto() {
        s.abrirVuelo("AR123");

        retorno = s.realizarReserva("AR123", "1.111.111-1");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.realizarReserva("AR123", "1.111.111-1");
        assertEquals(Retorno.Resultado.ERROR_6, retorno.getResultado());
    }
    
    @Test
    public void realizarReservaNoPermiteVueloCerrado() {
        s.abrirVuelo("AR123");
        s.cerrarVuelo("AR123");

        retorno = s.realizarReserva("AR123", "1.111.111-1");

        assertEquals(Retorno.Resultado.ERROR_5, retorno.getResultado());
    }
    
        @Test
    public void realizarReservaRespetaOverbookingCapacidadDos() {
        retorno = s.realizarReserva("AR123", "1.111.111-1");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.realizarReserva("AR123", "2.222.222-2");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.realizarReserva("AR123", "3.333.333-3");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.realizarReserva("AR123", "935.457-7");
        assertEquals(Retorno.Resultado.ERROR_7, retorno.getResultado());
    }
}

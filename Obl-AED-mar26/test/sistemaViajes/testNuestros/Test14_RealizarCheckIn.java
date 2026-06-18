package sistemaViajes.testNuestros;

import sistemaViajes.*;
import org.junit.Before;
import org.junit.Test;
import sistemaViajes.Categoria;
import sistemaViajes.ImplementacionSistema;
import sistemaViajes.Retorno;
import sistemaViajes.Sistema;
import static org.junit.Assert.*;

public class Test14_RealizarCheckIn {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @Before
    public void setUp() {
        s.inicializarSistema();
        s.registrarAeropuerto("MVD", "Aeropuerto de Carrasco");
        s.registrarAeropuerto("EZE", "Ezeiza");
        s.registrarVuelo("MVD", "EZE", "AR123", 1, 230);
        s.registrarPasajero("1.111.111-1", "Ana", 25, Categoria.FRECUENTE);
        s.registrarPasajero("2.222.222-2", "Bruno", 40, Categoria.PLATINO);
        s.registrarPasajero("3.333.333-3", "Carlos", 30, Categoria.ESTANDAR);
    }

    @Test
    public void realizarCheckInConCodigoVueloEspacios() {
        retorno = s.realizarCheckIn("   ", "1.111.111-1");

        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
    }

    @Test
    public void realizarCheckInNoPermiteVueloCerrado() {
        s.realizarReserva("AR123", "1.111.111-1");
        s.abrirVuelo("AR123");
        s.cerrarVuelo("AR123");

        retorno = s.realizarCheckIn("AR123", "1.111.111-1");

        assertEquals(Retorno.Resultado.ERROR_5, retorno.getResultado());
    }
    
    @Test
    public void realizarCheckInSegundoPasajeroReservadoPeroSinLugar() {
        s.realizarReserva("AR123", "1.111.111-1");
        s.realizarReserva("AR123", "2.222.222-2");

        s.abrirVuelo("AR123");

        retorno = s.realizarCheckIn("AR123", "1.111.111-1");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        assertEquals(
                "MVD:EZE;AR123;1;230;Abierto;2;1",
                s.obtenerInformacionDeVuelo("AR123").getValorString()
        );

        retorno = s.realizarCheckIn("AR123", "2.222.222-2");
        assertEquals(Retorno.Resultado.ERROR_8, retorno.getResultado());
    }

}

package sistemaViajes.testNuestros;

import sistemaViajes.*;
import org.junit.Before;
import org.junit.Test;
import sistemaViajes.Categoria;
import sistemaViajes.ImplementacionSistema;
import sistemaViajes.Retorno;
import sistemaViajes.Sistema;
import static org.junit.Assert.*;

public class Test12_CerrarVuelo {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @Before
    public void setUp() {
        s.inicializarSistema();
        s.registrarAeropuerto("ART", "Aeropuerto de Artigas");
        s.registrarAeropuerto("SLT", "Salto");
        s.registrarVuelo("ART", "SLT", "AR123", 5, 280);
        s.registrarPasajero("6.696.696-9", "Fulano", 18, Categoria.ESTANDAR);
        s.registrarPasajero("1.111.111-1", "Mengano", 96, Categoria.FRECUENTE);
        s.registrarPasajero("2.222.222-2", "Ciclano", 40, Categoria.PLATINO);
    }

    @Test
    public void cerrarVueloOkRetornaConfirmadosOrdenadosYNoConfirmados() {
        s.realizarReserva("AR123", "6.696.696-9");
        s.realizarReserva("AR123", "1.111.111-1");
        s.realizarReserva("AR123", "2.222.222-2");
        s.abrirVuelo("AR123");
        s.realizarCheckIn("AR123", "6.696.696-9");
        s.realizarCheckIn("AR123", "1.111.111-1");

        retorno = s.cerrarVuelo("AR123");

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("1.111.111-1;Mengano;96;Frecuente|6.696.696-9;Fulano;18;Estándar", retorno.getValorString());
        assertEquals(1, retorno.getValorEntero());
    }

    @Test
    public void cerrarVueloErrores() {
        assertEquals(Retorno.Resultado.ERROR_1, s.cerrarVuelo(null).getResultado());
        assertEquals(Retorno.Resultado.ERROR_1, s.cerrarVuelo("").getResultado());
        assertEquals(Retorno.Resultado.ERROR_2, s.cerrarVuelo("NO_EXISTE").getResultado());
        assertEquals(Retorno.Resultado.ERROR_3, s.cerrarVuelo("AR123").getResultado());
    }
}

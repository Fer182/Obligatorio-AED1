package sistemaViajes.testNuestros;

import sistemaViajes.*;
import org.junit.Before;
import org.junit.Test;
import sistemaViajes.ImplementacionSistema;
import sistemaViajes.Retorno;
import sistemaViajes.Sistema;
import static org.junit.Assert.*;

public class Test10_ObtenerInformacionDeVuelo {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @Before
    public void setUp() {
        s.inicializarSistema();
        s.registrarAeropuerto("ART", "Aeropuerto de Artigas");
        s.registrarAeropuerto("SLT", "Salto");
    }

    @Test
    public void obtenerInformacionVueloProgramadoSinReservas() {
        s.registrarVuelo("ART", "SLT", "AR123", 110, 280);

        retorno = s.obtenerInformacionDeVuelo("AR123");

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("ART:SLT;AR123;110;280;Programado;0;0", retorno.getValorString());
    }

    @Test
    public void obtenerInformacionVueloErrores() {
        assertEquals(Retorno.Resultado.ERROR_1, s.obtenerInformacionDeVuelo(null).getResultado());
        assertEquals(Retorno.Resultado.ERROR_1, s.obtenerInformacionDeVuelo("").getResultado());
        assertEquals(Retorno.Resultado.ERROR_2, s.obtenerInformacionDeVuelo("NO_EXISTE").getResultado());
    }
}

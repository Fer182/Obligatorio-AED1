package sistemaViajes.testNuestros;

import sistemaViajes.*;
import org.junit.Before;
import org.junit.Test;
import sistemaViajes.ImplementacionSistema;
import sistemaViajes.Retorno;
import sistemaViajes.Sistema;
import static org.junit.Assert.*;

public class Test08_ObtenerAeropuerto {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @Before
    public void setUp() {
        s.inicializarSistema();
    }

    @Test
    public void obtenerAeropuertoOkSinVuelosEnCola() {
        s.registrarAeropuerto("ART", "Aeropuerto de Artigas");

        retorno = s.obtenerAeropuerto("ART");

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("ART;Aeropuerto de Artigas", retorno.getValorString());
        assertEquals(0, retorno.getValorEntero());
    }

    @Test
    public void obtenerAeropuertoError01CodigoVacioONull() {
        assertEquals(Retorno.Resultado.ERROR_1, s.obtenerAeropuerto(null).getResultado());
        assertEquals(Retorno.Resultado.ERROR_1, s.obtenerAeropuerto("").getResultado());
    }

    @Test
    public void obtenerAeropuertoError02NoExiste() {
        retorno = s.obtenerAeropuerto("123");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
    }
}

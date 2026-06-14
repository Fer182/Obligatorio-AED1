package sistemaViajes;

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
        s.registrarAeropuerto("MVD", "Aeropuerto de Carrasco");

        retorno = s.obtenerAeropuerto("MVD");

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("MVD;Aeropuerto de Carrasco", retorno.getValorString());
        assertEquals(0, retorno.getValorEntero());
    }

    @Test
    public void obtenerAeropuertoError01CodigoVacioONull() {
        assertEquals(Retorno.Resultado.ERROR_1, s.obtenerAeropuerto(null).getResultado());
        assertEquals(Retorno.Resultado.ERROR_1, s.obtenerAeropuerto("").getResultado());
    }

    @Test
    public void obtenerAeropuertoError02NoExiste() {
        retorno = s.obtenerAeropuerto("EZE");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
    }
}

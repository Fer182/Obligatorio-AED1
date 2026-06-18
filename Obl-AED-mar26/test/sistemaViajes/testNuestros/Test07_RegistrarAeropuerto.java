package sistemaViajes.testNuestros;

import sistemaViajes.*;
import org.junit.Before;
import org.junit.Test;
import sistemaViajes.ImplementacionSistema;
import sistemaViajes.Retorno;
import sistemaViajes.Sistema;
import static org.junit.Assert.*;

public class Test07_RegistrarAeropuerto {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @Before
    public void setUp() {
        s.inicializarSistema();
    }

    @Test
    public void registrarAeropuertoCodigoConNumeros() {

        retorno = s.registrarAeropuerto("123", "Aeropuerto Numerico");

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    @Test
    public void registrarAeropuertoCodigoUnaLetra() {

        retorno = s.registrarAeropuerto("A", "Aeropuerto Chico");

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }
    @Test
    public void registrarAeropuertoNombreMuyLargo() {

        retorno = s.registrarAeropuerto(
                "MVD",
                "Aeropuerto Internacional General Cesareo Berisso de Carrasco Terminal Principal"
        );

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    @Test
    public void registrarMuchosAeropuertos() {

        assertEquals(
                Retorno.Resultado.OK,
                s.registrarAeropuerto("MVD", "Carrasco").getResultado()
        );

        assertEquals(
                Retorno.Resultado.OK,
                s.registrarAeropuerto("EZE", "Ezeiza").getResultado()
        );

        assertEquals(
                Retorno.Resultado.OK,
                s.registrarAeropuerto("GRU", "Guarulhos").getResultado()
        );

        assertEquals(
                Retorno.Resultado.OK,
                s.registrarAeropuerto("SCL", "Santiago").getResultado()
        );
    }

    @Test
    public void registrarAeropuertoCodigoMinimoYMaximo() {

        retorno = s.registrarAeropuerto("A", "Codigo Corto");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.registrarAeropuerto(
                "AEROPUERTOINTERNACIONAL",
                "Codigo Largo"
        );
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }
}

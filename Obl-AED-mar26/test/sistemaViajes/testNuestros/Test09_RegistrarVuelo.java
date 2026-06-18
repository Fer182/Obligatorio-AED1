package sistemaViajes.testNuestros;

import sistemaViajes.*;
import org.junit.Before;
import org.junit.Test;
import sistemaViajes.ImplementacionSistema;
import sistemaViajes.Retorno;
import sistemaViajes.Sistema;
import static org.junit.Assert.*;

public class Test09_RegistrarVuelo {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @Before
    public void setUp() {
        s.inicializarSistema();
        s.registrarAeropuerto("MVD", "Aeropuerto de Carrasco");
        s.registrarAeropuerto("EZE", "Ezeiza");
    }

    @Test
    public void registrarVueloCapacidadMinimaValida() {
        retorno = s.registrarVuelo("MVD", "EZE", "AR010", 1, 230);

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }
    
    @Test
    public void registrarVueloCostoMinimoValido() {
        retorno = s.registrarVuelo("MVD", "EZE", "AR011", 50, 1);

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }
    
    @Test
    public void registrarVueloMismoOrigenYDestino() {
        retorno = s.registrarVuelo("MVD", "MVD", "AR012", 50, 230);

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }
    
    @Test
    public void registrarVueloCodigoLargo() {
        retorno = s.registrarVuelo("MVD", "EZE", "VUELOINTERNACIONAL001", 100, 500);

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    @Test
    public void registrarVueloVariosVuelosMismoOrigenYDestino() {
        assertEquals(Retorno.Resultado.OK, s.registrarVuelo("MVD", "EZE", "AR020", 100, 230).getResultado());
        assertEquals(Retorno.Resultado.OK, s.registrarVuelo("MVD", "EZE", "AR021", 100, 230).getResultado());
        assertEquals(Retorno.Resultado.OK, s.registrarVuelo("MVD", "EZE", "AR022", 100, 230).getResultado());
    }
}

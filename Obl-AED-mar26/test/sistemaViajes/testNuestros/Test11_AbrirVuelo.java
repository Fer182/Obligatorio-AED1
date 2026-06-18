package sistemaViajes.testNuestros;

import sistemaViajes.*;
import org.junit.Before;
import org.junit.Test;
import sistemaViajes.ImplementacionSistema;
import sistemaViajes.Retorno;
import sistemaViajes.Sistema;
import static org.junit.Assert.*;

public class Test11_AbrirVuelo {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @Before
    public void setUp() {
        s.inicializarSistema();
        s.registrarAeropuerto("MVD", "Aeropuerto de Carrasco");
        s.registrarAeropuerto("EZE", "Ezeiza");
        s.registrarVuelo("MVD", "EZE", "AR123", 120, 230);
    }

    @Test
public void abrirVueloConCodigoConEspacios() {
    retorno = s.abrirVuelo("   ");

    assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
}

@Test
public void abrirVueloConVariosVuelosSoloAbreElIndicado() {
    s.registrarVuelo("MVD", "EZE", "AR200", 80, 150);

    retorno = s.abrirVuelo("AR200");
    assertEquals(Retorno.Resultado.OK, retorno.getResultado());

    retorno = s.obtenerInformacionDeVuelo("AR200");
    assertEquals("MVD:EZE;AR200;80;150;Abierto;0;0", retorno.getValorString());

    retorno = s.obtenerInformacionDeVuelo("AR123");
    assertEquals("MVD:EZE;AR123;120;230;Programado;0;0", retorno.getValorString());
}

@Test
public void abrirVueloConCapacidadMinima() {
    s.registrarVuelo("MVD", "EZE", "AR001", 1, 50);

    retorno = s.abrirVuelo("AR001");
    assertEquals(Retorno.Resultado.OK, retorno.getResultado());

    retorno = s.obtenerInformacionDeVuelo("AR001");
    assertEquals("MVD:EZE;AR001;1;50;Abierto;0;0", retorno.getValorString());
}

@Test
public void abrirDosVuelosDistintos() {
    s.registrarVuelo("MVD", "EZE", "AR200", 80, 150);

    retorno = s.abrirVuelo("AR123");
    assertEquals(Retorno.Resultado.OK, retorno.getResultado());

    retorno = s.abrirVuelo("AR200");
    assertEquals(Retorno.Resultado.OK, retorno.getResultado());

    retorno = s.obtenerInformacionDeVuelo("AR123");
    assertEquals("MVD:EZE;AR123;120;230;Abierto;0;0", retorno.getValorString());

    retorno = s.obtenerInformacionDeVuelo("AR200");
    assertEquals("MVD:EZE;AR200;80;150;Abierto;0;0", retorno.getValorString());
}
}

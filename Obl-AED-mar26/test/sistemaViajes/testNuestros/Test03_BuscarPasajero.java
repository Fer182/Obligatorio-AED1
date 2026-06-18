package sistemaViajes.testNuestros;

import sistemaViajes.*;
import sistemaViajes.Retorno;
import sistemaViajes.ImplementacionSistema;
import org.junit.Before;
import org.junit.Test;
import sistemaViajes.Categoria;
import sistemaViajes.ImplementacionSistema;
import sistemaViajes.Retorno;
import static org.junit.Assert.*;
import sistemaViajes.Sistema;
import sistemaViajes.Sistema;

public class Test03_BuscarPasajero {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @Before
    public void setUp() {
        s.inicializarSistema();
    }

    @Test
    public void buscarPasajeroOk() {
        retorno = s.registrarPasajero("7.335.584-2", "Carlos", 18, Categoria.FRECUENTE);
        retorno = s.buscarPasajero("7.335.584-2");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("7.335.584-2;Carlos;18;Frecuente", retorno.getValorString());
        
        retorno = s.registrarPasajero("3.123.456-7", "Mariana", 30, Categoria.ESTANDAR);
        retorno = s.buscarPasajero("3.123.456-7");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("3.123.456-7;Mariana;30;Estándar", retorno.getValorString());

        retorno = s.registrarPasajero("1.123.963-7", "Carla", 60, Categoria.PLATINO);
        retorno = s.buscarPasajero("1.123.963-7");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("1.123.963-7;Carla;60;Platino", retorno.getValorString());
    }

    @Test
    public void buscarPasajeroError01() {
        retorno = s.buscarPasajero("asdasd");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
        
        retorno = s.buscarPasajero("124323");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
        
        retorno = s.buscarPasajero("333-333-.11");
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
    }

    @Test
    public void buscarPasajeroError02() {
        retorno = s.buscarPasajero("7.785.006-1");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
        
        retorno = s.buscarPasajero("6.666.696-9");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
        
        retorno = s.buscarPasajero("6.767.676-7");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
    }

}

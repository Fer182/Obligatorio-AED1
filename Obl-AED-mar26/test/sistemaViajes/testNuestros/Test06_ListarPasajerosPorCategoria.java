package sistemaViajes.testNuestros;

import sistemaViajes.*;
import org.junit.Before;
import org.junit.Test;
import sistemaViajes.Categoria;
import sistemaViajes.ImplementacionSistema;
import sistemaViajes.Retorno;
import sistemaViajes.Sistema;
import static org.junit.Assert.*;

public class Test06_ListarPasajerosPorCategoria {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @Before
    public void setUp() {
        s.inicializarSistema();
    }

    @Test
    public void listarCategoriaSinPasajerosRetornaVacio() {
        retorno = s.listarPasajerosPorCategoría(Categoria.FRECUENTE);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("", retorno.getValorString());
        
        retorno = s.listarPasajerosPorCategoría(Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("", retorno.getValorString());
        
        retorno = s.listarPasajerosPorCategoría(Categoria.PLATINO);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("", retorno.getValorString());
    }

    @Test
    public void listarCategoriaFiltraYOrdenaPorCedulaAscendente() {
        s.registrarPasajero("4.985.345-4", "Carlos", 69, Categoria.PLATINO);
        s.registrarPasajero("935.457-7", "Mauro", 36, Categoria.PLATINO);
        s.registrarPasajero("1.345.345-4", "Alberto", 62, Categoria.FRECUENTE);

        retorno = s.listarPasajerosPorCategoría(Categoria.PLATINO);

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("935.457-7;Mauro;36;Platino|4.985.345-4;Carlos;69;Platino", retorno.getValorString());
    }
}

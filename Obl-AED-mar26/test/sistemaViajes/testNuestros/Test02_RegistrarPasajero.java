package sistemaViajes.testNuestros;

import org.junit.Before;
import org.junit.Test;
import sistemaViajes.Categoria;
import sistemaViajes.ImplementacionSistema;
import sistemaViajes.Retorno;
import sistemaViajes.Sistema;

import static org.junit.Assert.*;

public class Test02_RegistrarPasajero {

    private Sistema s;
    private Retorno retorno;

    @Before
    public void setUp() {
        s = new ImplementacionSistema();
        s.inicializarSistema();
    }

    @Test
    public void registrarPasajeroCorrectoConEdadCero() {
        retorno = s.registrarPasajero(
                "6.430.147-9",
                "Nicolas",
                0,
                Categoria.ESTANDAR
        );

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    @Test
    public void registrarPasajeroCorrectoConDistintasCategorias() {
        retorno = s.registrarPasajero("3.335.321-2", "Juan", 45, Categoria.ESPORADICO);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.registrarPasajero("6.430.147-9", "Nicolas", 20, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.registrarPasajero("1.111.111-1", "Ana", 30, Categoria.FRECUENTE);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.registrarPasajero("2.222.222-2", "Bruno", 40, Categoria.PLATINO);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    @Test
    public void registrarPasajeroDatosVaciosONulos() {
        retorno = s.registrarPasajero("", "Juan", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.registrarPasajero("3.335.321-2", "", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.registrarPasajero(null, "Juan", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.registrarPasajero("3.335.321-2", null, 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.registrarPasajero("3.335.321-2", "Juan", 45, null);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.registrarPasajero("   ", "Juan", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.registrarPasajero("3.335.321-2", "   ", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
    }

    @Test
    public void registrarPasajeroCedulaConFormatoIncorrecto() {
        retorno = s.registrarPasajero("000000", "Juan", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.registrarPasajero("3.321-2", "Juan", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.registrarPasajero("0.335.321-2", "Juan", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.registrarPasajero("3.3X5.321-2", "Juan", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.registrarPasajero("3.335.321-X", "Juan", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.registrarPasajero("3.335.321", "Juan", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.registrarPasajero("3.3 5.321-2", "Juan", 45, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
    }

    @Test
    public void registrarPasajeroEdadNegativa() {
        retorno = s.registrarPasajero("3.335.321-2", "Juan", -1, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());

        retorno = s.registrarPasajero("6.430.147-9", "Nicolas", -10, Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
    }

    @Test
    public void registrarPasajeroCedulaRepetida() {
        retorno = s.registrarPasajero("3.335.321-2", "Juan", 45, Categoria.ESPORADICO);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.registrarPasajero("3.335.321-2", "Aurora", 23, Categoria.PLATINO);
        assertEquals(Retorno.Resultado.ERROR_4, retorno.getResultado());
    }
}
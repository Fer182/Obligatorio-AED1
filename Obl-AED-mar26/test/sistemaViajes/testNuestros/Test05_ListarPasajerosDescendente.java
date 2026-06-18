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

public class Test05_ListarPasajerosDescendente {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @Before
    public void setUp() {
        s.inicializarSistema();
    }

    @Test
    public void listarPasajerosDescendenteConEdadesExtremas() {

        s.registrarPasajero("1.111.111-1", "Bebe", 0, Categoria.ESPORADICO);
        s.registrarPasajero("9.999.999-9", "Abuelo", 120, Categoria.PLATINO);

        retorno = s.listarPasajerosDescendente();

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        assertEquals(
                "9.999.999-9;Abuelo;120;Platino|1.111.111-1;Bebe;0;Esporádico",
                retorno.getValorString()
        );
    }
    
    @Test
    public void listarPasajerosDescendenteConCincoPasajeros() {

        s.registrarPasajero("5.555.555-5", "A", 10, Categoria.ESTANDAR);
        s.registrarPasajero("1.111.111-1", "B", 20, Categoria.FRECUENTE);
        s.registrarPasajero("3.333.333-3", "C", 30, Categoria.PLATINO);
        s.registrarPasajero("2.222.222-2", "D", 40, Categoria.ESPORADICO);
        s.registrarPasajero("4.444.444-4", "E", 50, Categoria.ESTANDAR);

        retorno = s.listarPasajerosDescendente();

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        assertEquals(
                "5.555.555-5;A;10;Estándar|4.444.444-4;E;50;Estándar|3.333.333-3;C;30;Platino|2.222.222-2;D;40;Esporádico|1.111.111-1;B;20;Frecuente",
                retorno.getValorString()
        );
    }
    
    @Test
    public void listarPasajerosDescendenteConTodasLasCategorias() {

        s.registrarPasajero("1.111.111-1", "Ana", 20, Categoria.ESPORADICO);
        s.registrarPasajero("2.222.222-2", "Bruno", 30, Categoria.ESTANDAR);
        s.registrarPasajero("3.333.333-3", "Carla", 40, Categoria.FRECUENTE);
        s.registrarPasajero("4.444.444-4", "Diego", 50, Categoria.PLATINO);

        retorno = s.listarPasajerosDescendente();

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        assertEquals(
                "4.444.444-4;Diego;50;Platino|3.333.333-3;Carla;40;Frecuente|2.222.222-2;Bruno;30;Estándar|1.111.111-1;Ana;20;Esporádico",
                retorno.getValorString()
        );
    }
    
    @Test
    public void listarPasajerosDescendenteConCedulasMuyDistantes() {

        s.registrarPasajero("9.111.111-1", "Ultimo", 25, Categoria.ESTANDAR);
        s.registrarPasajero("1.111.111-1", "Primero", 25, Categoria.ESTANDAR);

        retorno = s.listarPasajerosDescendente();

        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        assertEquals(
                "9.111.111-1;Ultimo;25;Estándar|1.111.111-1;Primero;25;Estándar",
                retorno.getValorString()
        );
    }

}

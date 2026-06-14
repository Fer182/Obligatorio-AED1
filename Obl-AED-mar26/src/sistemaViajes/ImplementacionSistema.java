package sistemaViajes;

//BRENDON BURIOL 331209, FERNANDO ARRIONDO 317501

import dominio.Pasajero;
import dominio.PasajeroWrapper;
import tads.ILista;

public class ImplementacionSistema implements Sistema {
    
    private ILista<Pasajero> listaDePasajeros;

    private ILista<PasajeroWrapper> listaDePasajerosWrapper;
    

    @Override
    public Retorno inicializarSistema() {
        return Retorno.noImplementada();
    }

    @Override 
    public Retorno registrarPasajero(String cedula, String nombre, int edad, Categoria categoria) {
        if(cedula==null || cedula.isEmpty() || nombre == null || nombre.isEmpty() || categoria == null)
        {
        return Retorno.error1();
        }
        if (!cedula.matches("(\\d\\.\\d{3}\\.\\d{3}-\\d)|(\\d{3}\\.\\d{3}-\\d)")) {
        return Retorno.error2();
        }
        if(edad < 0)
        {
            return Retorno.error3();
        }
        if(cedula.equals(cedula))
        {
        return Retorno.error4();
        }
        Pasajero p = new Pasajero(cedula, nombre, edad, categoria);
        PasajeroWrapper pw = new PasajeroWrapper(p);

        listaDePasajeros.insertarOrdenado(p);
        listaDePasajerosWrapper.insertarOrdenado(pw);
        return Retorno.ok();
                
    }

    @Override
    public Retorno buscarPasajero(String cedula) {
        
        if (!cedula.matches("(\\d\\.\\d{3}\\.\\d{3}-\\d)|(\\d{3}\\.\\d{3}-\\d)")) {
        return Retorno.error1();
        }
        
        int total = this.listaDePasajeros.cantidadElementos();

        for (int i = 0; i < total; i++) {
            Pasajero pasajeroActual = this.listaDePasajeros.obtenerElemento(i);
            if (pasajeroActual.getCedula().equals(cedula)) {
                return Retorno.ok(pasajeroActual.toString());
            }
        }
        return Retorno.error2();
    }

    @Override
    public Retorno listarPasajerosAscendente() {
        String valorString = "";
        for( int i = 0; i < listaDePasajeros.cantidadElementos(); i++){
            Pasajero p = listaDePasajeros.obtenerElemento(i);
         valorString += p.toString();

        }
        return Retorno.ok(valorString);
    }

    @Override
    public Retorno listarPasajerosDescendente() {
                String valorString = "";
        for( int i = 0; i < listaDePasajerosWrapper.cantidadElementos(); i++){
            PasajeroWrapper pw = listaDePasajerosWrapper.obtenerElemento(i);
         valorString += pw.toString();

        }
        return Retorno.ok(valorString);
    }

    @Override
    public Retorno listarPasajerosPorCategoría(Categoria unaCategoria) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarAeropuerto(String codigo, String nombre) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno obtenerAeropuerto(String codigo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarVuelo(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, String codigoDeVuelo, int capacidad, int costoEnDolares) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno obtenerInformacionDeVuelo(String codigoDeVuelo) {
        return Retorno.noImplementada();
    }
    
    @Override
    public Retorno abrirVuelo(String codigoDeVuelo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno cerrarVuelo(String codigoDeVuelo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno realizarReserva(String codigoDeVuelo, String cedula) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno realizarCheckIn(String codigoDeVuelo, String cedula) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno embarqueYDespegueDeVuelo(String codigoAeropuerto) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno consultaDisponibilidad(int[][] matriz, int cantidad, Clase unaClase) {
        return Retorno.noImplementada();
    } 

}

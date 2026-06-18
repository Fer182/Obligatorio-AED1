package sistemaViajes;

//BRENDON BURIOL 331209, FERNANDO ARRIONDO 317501

import dominio.Aeropuerto;
import dominio.Pasajero;
import dominio.PasajeroWrapper;
import dominio.Reserva;
import dominio.Vuelo;
import tads.ILista;
import tads.Lista;

public class ImplementacionSistema implements Sistema {
    
    //private ILista<Reserva> reservas;
    
    private ILista<Aeropuerto> listaDeAeropuertos;    
    
    private ILista<Vuelo> listaDeVuelos;    
    
    private ILista<Pasajero> listaDePasajeros;
    private ILista<PasajeroWrapper> listaDePasajerosWrapper;
    
    private ILista<Pasajero> listaDePasajeroCategoriaESPORADICO;
    private ILista<Pasajero> listaDePasajeroCategoriaESTANDAR;
    private ILista<Pasajero> listaDePasajeroCategoriaFRECUENTE;
    private ILista<Pasajero> listaDePasajeroCategoriaPLATINO;

    @Override
    public Retorno inicializarSistema() {
    listaDeAeropuertos = new Lista<>();
    listaDeVuelos = new Lista<>();
    
    //reservas = new Lista<>();
    
    listaDePasajeros = new Lista<>();
    listaDePasajerosWrapper = new Lista<>();

    listaDePasajeroCategoriaESPORADICO = new Lista<>();
    listaDePasajeroCategoriaESTANDAR = new Lista<>();
    listaDePasajeroCategoriaFRECUENTE = new Lista<>();
    listaDePasajeroCategoriaPLATINO = new Lista<>();

    return Retorno.ok();
    }

    @Override 
    public Retorno registrarPasajero(String cedula, String nombre, int edad, Categoria categoria) {
        if(cedula==null || cedula.trim().isEmpty() || nombre == null || nombre.trim().isEmpty() || categoria == null)
        {
        return Retorno.error1();
        }
        if (!cedula.matches("([1-9]\\.\\d{3}\\.\\d{3}-\\d)|([1-9]\\d{2}\\.\\d{3}-\\d)")) {
        return Retorno.error2();
        }
        if(edad < 0)
        {
            return Retorno.error3();
        }
        
        Pasajero p = new Pasajero(cedula, nombre, edad, categoria);
        PasajeroWrapper pw = new PasajeroWrapper(p);
                
        if(listaDePasajeros.existeElemento(p))
        {
        return Retorno.error4();
        }
        
        if(p.getCategoria() == Categoria.ESPORADICO){
        listaDePasajeroCategoriaESPORADICO.insertarOrdenado(p);
        }
        if(p.getCategoria() == Categoria.ESTANDAR){
        listaDePasajeroCategoriaESTANDAR.insertarOrdenado(p);
        }
        if(p.getCategoria() == Categoria.FRECUENTE){
        listaDePasajeroCategoriaFRECUENTE.insertarOrdenado(p);
        }
        if(p.getCategoria() == Categoria.PLATINO){
        listaDePasajeroCategoriaPLATINO.insertarOrdenado(p);
        }
        
        listaDePasajeros.insertarOrdenado(p);
        listaDePasajerosWrapper.insertarOrdenado(pw);
        return Retorno.ok();
                
    }

    @Override
    public Retorno buscarPasajero(String cedula) {
        
        if (!cedula.matches("([1-9]\\.\\d{3}\\.\\d{3}-\\d)|([1-9]\\d{2}\\.\\d{3}-\\d)")) {
        return Retorno.error1();
        }
        
        int total = listaDePasajeros.cantidadElementos();

        for (int i = 0; i < total; i++) {
            Pasajero pasajeroActual = listaDePasajeros.obtenerElemento(i);
            if (pasajeroActual.getCedula().equals(cedula)) {
                return Retorno.ok(pasajeroActual.toString());
            }
        }
        return Retorno.error2();
    }

    @Override
    public Retorno listarPasajerosAscendente() {
        String valorString = "";
        if(!listaDePasajeros.esVacia()){
        for( int i = 0; i < listaDePasajeros.cantidadElementos() - 1; i++){
            Pasajero p = listaDePasajeros.obtenerElemento(i);
         valorString += p.toString() + "|";

        }
        int cant = listaDePasajeros.cantidadElementos()-1;
        Pasajero ultimo = listaDePasajeros.obtenerElemento(cant);
        valorString += ultimo.toString();
        }
        
        return Retorno.ok(valorString);
    }

    @Override
    public Retorno listarPasajerosDescendente() {
                String valorString = "";
        if(!listaDePasajerosWrapper.esVacia()){
        for( int i = 0; i < listaDePasajerosWrapper.cantidadElementos() - 1; i++){
            PasajeroWrapper pw = listaDePasajerosWrapper.obtenerElemento(i);
         valorString += pw.toString() + "|";

        }
        
        PasajeroWrapper ultimoWrapper = listaDePasajerosWrapper.obtenerElemento(listaDePasajerosWrapper.cantidadElementos()-1);
        valorString += ultimoWrapper.toString();
        }
        
        return Retorno.ok(valorString);
    }

    @Override
    public Retorno listarPasajerosPorCategoría(Categoria unaCategoria) {
        ILista<Pasajero> aux = listaDePasajeroCategoriaESPORADICO;
        String valorString = "";
        
        if(unaCategoria.equals(Categoria.ESTANDAR)){
            aux = listaDePasajeroCategoriaESTANDAR;
        }else if(unaCategoria.equals(Categoria.FRECUENTE)){
            aux = listaDePasajeroCategoriaFRECUENTE;
        }else if(unaCategoria.equals(Categoria.PLATINO)){
            aux = listaDePasajeroCategoriaPLATINO;
        }
        if(aux.esVacia()){
            return Retorno.ok(valorString);
        }
        for( int i = 0; i < aux.cantidadElementos()-1; i++){
            Pasajero pCat = aux.obtenerElemento(i);
         valorString += pCat.toString() + "|";

        }
        Pasajero auxFinal = aux.obtenerElemento(aux.cantidadElementos()-1);
        valorString += auxFinal.toString();

        
        
        return Retorno.ok(valorString);
    }

    @Override
    public Retorno registrarAeropuerto(String codigo, String nombre) {
        if(codigo==null || codigo.trim().isEmpty() || nombre == null || nombre.trim().isEmpty())
        {
        return Retorno.error1();
        }
        
        Aeropuerto aero = new Aeropuerto(codigo, nombre);
        if(listaDeAeropuertos.existeElemento(aero))
        {
        return Retorno.error2();
        }
        
        listaDeAeropuertos.insertarOrdenado(aero);
        return Retorno.ok();
    }

    @Override
    public Retorno obtenerAeropuerto(String codigo) {
        if(codigo==null || codigo.isEmpty())
        {
        return Retorno.error1();
        }
        int total = this.listaDeAeropuertos.cantidadElementos();

        for (int i = 0; i < total; i++) {
            Aeropuerto aeropuertoActual = this.listaDeAeropuertos.obtenerElemento(i);
            if (aeropuertoActual.getCodigo().equals(codigo)) {
                if(aeropuertoActual.getViajesEnEspera().size() == 0){
                return Retorno.ok(aeropuertoActual.toString());

                }
                return Retorno.ok(aeropuertoActual.toString(), aeropuertoActual.getViajesEnEspera().size());
            }
        }
        return Retorno.error2();
    }

    @Override
    public Retorno registrarVuelo(String codigoAeropuertoOrigen, String codigoAeropuertoDestino, String codigoDeVuelo, int capacidad, int costoEnDolares) {
        if(capacidad <= 0 || costoEnDolares <=0)
        {
            return Retorno.error1();
        }
        if(codigoAeropuertoOrigen == null || codigoAeropuertoOrigen.isEmpty() || codigoAeropuertoDestino == null || codigoAeropuertoDestino.isEmpty() || codigoDeVuelo == null || codigoDeVuelo.isEmpty())
        {
            return Retorno.error2();
        }
        Aeropuerto aero = new Aeropuerto(codigoAeropuertoOrigen);
        Aeropuerto aero1 = new Aeropuerto(codigoAeropuertoDestino);

        if (!listaDeAeropuertos.existeElemento(aero)) {
            return Retorno.error3();
        }
        
        if (!listaDeAeropuertos.existeElemento(aero1)) {
            return Retorno.error4();
        }
        
        Vuelo vuelo = new Vuelo(codigoAeropuertoOrigen, codigoAeropuertoDestino, codigoDeVuelo, capacidad,costoEnDolares);
        
        if(listaDeVuelos.existeElemento(vuelo)){
        return Retorno.error5();
        }
        
        listaDeVuelos.insertarOrdenado(vuelo);
        return Retorno.ok();
    }

    @Override
    public Retorno obtenerInformacionDeVuelo(String codigoDeVuelo) {
        if(codigoDeVuelo == null || codigoDeVuelo.isEmpty())
        {
            return Retorno.error1();
        }
        
        int total = this.listaDeVuelos.cantidadElementos();

        for (int i = 0; i < total; i++) {
            Vuelo vueloActual = this.listaDeVuelos.obtenerElemento(i);
            if (vueloActual.getcodigoDeVuelo().equals(codigoDeVuelo)) {
                return Retorno.ok(vueloActual.toString());
            }
        }
        return Retorno.error2();
    }
    
    @Override
    public Retorno abrirVuelo(String codigoDeVuelo) {

        if (codigoDeVuelo == null || codigoDeVuelo.trim().isEmpty()) {
            return Retorno.error1();
        }

        int total = listaDeVuelos.cantidadElementos();
        for (int i = 0; i < total; i++) {
            Vuelo vueloActual = listaDeVuelos.obtenerElemento(i);
            String vueloEst = vueloActual.getEstado();
            if (vueloActual.getcodigoDeVuelo().equals(codigoDeVuelo)) {

                if (!vueloEst.equals("PROGRAMADO")) {
                    return Retorno.error3();
                }

                vueloActual.setEstado(Estado.ABIERTO);
                return Retorno.ok();
            }
        }
        return Retorno.error2();
    }

    @Override
    public Retorno cerrarVuelo(String codigoDeVuelo) {

        if (codigoDeVuelo == null || codigoDeVuelo.trim().isEmpty()) {
            return Retorno.error1();
        }

        Vuelo vuelo = new Vuelo(codigoDeVuelo);

        if (!listaDeVuelos.existeElemento(vuelo)) {
            return Retorno.error2();
        }

        int total = listaDeVuelos.cantidadElementos();

        for (int i = 0; i < total; i++) {

            Vuelo vueloActual = listaDeVuelos.obtenerElemento(i);

            if (vueloActual.getcodigoDeVuelo().equals(codigoDeVuelo)) {

                if (!vueloActual.getEstado().equals("ABIERTO")) {
                    return Retorno.error3();
                }

                Aeropuerto aeroActual = null;

                for (int j = 0; j < listaDeAeropuertos.cantidadElementos(); j++) {
                    Aeropuerto a = listaDeAeropuertos.obtenerElemento(j);

                    if (a.getCodigo().equals(vueloActual.getCodigoAeropuertoOrigen())) {
                        aeroActual = a;
                    }
                }

                aeroActual.getViajesEnEspera().enqueue(vueloActual);
                vueloActual.setEstado(Estado.CERRADO);

                return Retorno.ok(
                    vueloActual.getPasajerosConfirmados(),
                    vueloActual.getcantidadDeReservasSinConfirmar()
                );
            }
        }

        return Retorno.error2();
    }

    @Override
    public Retorno realizarReserva(String codigoDeVuelo, String cedula) {

        if (codigoDeVuelo == null || codigoDeVuelo.trim().isEmpty()
                || cedula == null || cedula.trim().isEmpty()) {
            return Retorno.error1();
        }

        if (!cedula.matches("([1-9]\\.\\d{3}\\.\\d{3}-\\d)|([1-9]\\d{2}\\.\\d{3}-\\d)")) {
            return Retorno.error2();
        }

        Vuelo vueloBuscado = new Vuelo(codigoDeVuelo);
        if (!listaDeVuelos.existeElemento(vueloBuscado)) {
            return Retorno.error3();
        }

        Pasajero pasajeroBuscado = new Pasajero(cedula);
        if (!listaDePasajeros.existeElemento(pasajeroBuscado)) {
            return Retorno.error4();
        }

        Pasajero pasajeroReal = obtenerPasajeroPorCedula(cedula);

        for (int i = 0; i < listaDeVuelos.cantidadElementos(); i++) {
            Vuelo vueloActual = listaDeVuelos.obtenerElemento(i);

            if (vueloActual.getcodigoDeVuelo().equals(codigoDeVuelo)) {

                String vueloEst = vueloActual.getEstado();

                if (!vueloEst.equals("PROGRAMADO") && !vueloEst.equals("ABIERTO")) {
                    return Retorno.error5();
                }

                if (vueloActual.tieneReserva(cedula) || vueloActual.tieneCheckIn(cedula)) {
                    return Retorno.error6();
                }

                if (vueloActual.getcantidadDeReservasTotales() >= Math.ceil(vueloActual.getCapacidad() * 1.10)) {
                    return Retorno.error7();
                }

                Reserva reserva = new Reserva(codigoDeVuelo, cedula);

                vueloActual.agregarReserva(reserva);
                vueloActual.agregarPasajero(pasajeroReal);

                return Retorno.ok();
            }
        }

        return Retorno.error3();
    }

    private Pasajero obtenerPasajeroPorCedula(String cedula) {
        for (int i = 0; i < listaDePasajeros.cantidadElementos(); i++) {
            Pasajero p = listaDePasajeros.obtenerElemento(i);

            if (p.getCedula().equals(cedula)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public Retorno realizarCheckIn(String codigoDeVuelo, String cedula) {

        if (codigoDeVuelo == null || codigoDeVuelo.trim().isEmpty()
                || cedula == null || cedula.trim().isEmpty()) {
            return Retorno.error1();
        }

        if (!cedula.matches("([1-9]\\.\\d{3}\\.\\d{3}-\\d)|([1-9]\\d{2}\\.\\d{3}-\\d)")) {
            return Retorno.error2();
        }

        Vuelo vuelo = new Vuelo(codigoDeVuelo);
        if (!listaDeVuelos.existeElemento(vuelo)) {
            return Retorno.error3();
        }

        Pasajero pasajero = new Pasajero(cedula);
        if (!listaDePasajeros.existeElemento(pasajero)) {
            return Retorno.error4();
        }

        for (int i = 0; i < listaDeVuelos.cantidadElementos(); i++) {
            Vuelo vueloActual = listaDeVuelos.obtenerElemento(i);

            if (vueloActual.getcodigoDeVuelo().equals(codigoDeVuelo)) {

                if (!vueloActual.getEstado().equals("ABIERTO")) {
                    return Retorno.error5();
                }

                if (!vueloActual.tieneReserva(cedula)) {
                    return Retorno.error6();
                }

                if (vueloActual.tieneCheckIn(cedula)) {
                    return Retorno.error7();
                }

                if (vueloActual.getcantidadDePasajerosConfirmados() >= vueloActual.getCapacidad()) {
                    return Retorno.error8();
                }

                vueloActual.realizarCheckIn(cedula);

                return Retorno.ok();
            }
        }

        return Retorno.error3();
    }

    @Override
    public Retorno embarqueYDespegueDeVuelo(String codigoAeropuerto) {
        
        if(codigoAeropuerto == null || codigoAeropuerto.trim().isEmpty() ){
            return Retorno.error1();
        }
        for (int i = 0; i < listaDeAeropuertos.cantidadElementos(); i++){
        
        Aeropuerto aeroActual = listaDeAeropuertos.obtenerElemento(i);
        
        if(aeroActual.getCodigo().equals(codigoAeropuerto)){
        
        if(aeroActual.getViajesEnEspera().size() == 0){
        return Retorno.error3();
        }
        
        Vuelo vuelo = aeroActual.getViajesEnEspera().peek();
        aeroActual.getViajesEnEspera().dequeue();
        
        vuelo.setEstado(Estado.FINALIZADO);
        
        return Retorno.ok(
                vuelo.getcodigoDeVuelo(),
                aeroActual.getViajesEnEspera().size()
            );  
        }
       }
        return Retorno.error2();
    }

    @Override
    public Retorno consultaDisponibilidad(int[][] matriz, int cantidad, Clase unaClase) {
        return Retorno.noImplementada();
    } 

}


package tads;

/**
 *
 * @author burio
 * @param <T>
 */
public interface ILista<T> {
    void agregarInicio(T x);
    String mostrar();
    int cantidadElementos();
    boolean esVacia();
    void vaciar();
    boolean existeElemento(T x);
    T obtenerElemento(int indice);
    void agregarFinal(T x);
    T eliminarInicio();
    T eliminarFinal();
    void insertarOrdenado(T elem);
    
}

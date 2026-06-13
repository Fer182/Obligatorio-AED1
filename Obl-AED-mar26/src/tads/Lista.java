/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads;

/**
 *
 * @author burio
 * @param <T>
 */
public class Lista<T extends Comparable<T>> implements ILista<T> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cant;

    @Override
    public void agregarInicio(T x) {
        Nodo<T> nuevo = new Nodo(x, inicio);
        if (inicio == null) {
            fin = nuevo;
        }
        inicio = nuevo;
        cant++;
    }

    @Override
    public String mostrar() {
        Nodo<T> aux = inicio;
        StringBuilder res = new StringBuilder();
        while (aux != null) {
            res.append(aux.dato);
            res.append(" ");
            aux = aux.sig;
        }
        return res.toString();
    }

    @Override
    public int cantidadElementos() {
        return cant;
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
        //return cant == 0;
    }

    @Override
    public void vaciar() {
        inicio = null;
        cant = 0;
    }

    @Override
    public boolean existeElemento(T x) {
        Nodo<T> aux = inicio;
        while (aux != null) {
            if (aux.dato.equals(x)) {
                return true;
            }
            aux = aux.sig;
        }
        return false;
    }

    @Override
    public T obtenerElemento(int indice) {
        Nodo<T> aux = inicio;
        int auxIndice = 0;
        while (aux != null) {
            if (auxIndice == indice) {
                return aux.dato;
            }
            auxIndice++;
            aux = aux.sig;
        }
        //return -1;
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void agregarFinal(T x) {
        Nodo<T> aux = inicio;

        while (aux != null) {
            if (aux.sig == null) {
                aux.sig = new Nodo(x);
                cant++;
                return;
            }
            aux = aux.sig;
        }
    }

    public void agregarFinal2(T x) {
        Nodo<T> nuevo = new Nodo(x);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.sig = nuevo;
            fin = nuevo;
        }

    }

    @Override
    public T eliminarInicio() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T eliminarFinal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insertarOrdenado(T elem) {
        if (inicio == null) {
            inicio = new Nodo(elem);
        } else if (inicio.dato.compareTo(elem) > 0) {
            inicio = new Nodo(elem);
        } else {
            Nodo<T> aux = inicio;
            while (aux.sig != null && aux.sig.dato.compareTo(elem) < 0) {
                aux = aux.sig;
            }
            Nodo<T> nuevo = new Nodo(elem, aux.sig);
            aux.sig = nuevo;
        }
        cant++;
    }

    private class Nodo<T extends Comparable<T>> {

        private T dato;
        private Nodo<T> sig;

        public Nodo(T dato, Nodo<T> sig) {
            this.dato = dato;
            this.sig = sig;
        }

        public Nodo(T dato) {
            this.dato = dato;
        }

    }

}
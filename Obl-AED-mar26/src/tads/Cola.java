/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads;
/**
 *
 * @author FERAR
 */
public class Cola<T> implements ICola<T> {

     private Nodo<T> inicio;
    private Nodo <T> fin;
    private int cant = 0;
    
    @Override
    public void enqueue(T dato) {
        if(isEmpty()){
            inicio = new Nodo <>(dato);
            fin = inicio;
        }else{
            fin.sig= new Nodo<>(dato);
            fin = fin.sig;
        }
        cant++;
    }

    @Override
    public void dequeue() {
        inicio = inicio.sig;
        if (inicio == null){
        fin = null;
        
        }
        cant--;
    }

    @Override
    public boolean isEmpty() {
        return inicio == null && fin == null;
    }

    @Override
    public T peek() {
        return inicio.dato; 
    }

    @Override
    public void clear() {
        inicio = null;
        fin = null;
    }

    @Override
    public int size() {
        return cant;
    }
    
    private class Nodo <Q> {
    
        private Q dato;
        private Nodo <Q> sig;
        
        public Nodo (Q dato) {
            this.dato = dato;
        }
        
        public Nodo(Q dato, Nodo<Q> sig){
        this.dato = dato;
        this.sig = sig;
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tads;

/**
 *
 * @author FERAR
 */
public interface ICola <T>{
    void enqueue (T dato);
    void dequeue();
    boolean isEmpty();
    T peek();
    void clear();
    void size();
    
    
    
}

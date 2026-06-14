/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author FERAR
 */
public class PasajeroWrapper implements Comparable<PasajeroWrapper>{
    private final Pasajero pasajero;
    
    public PasajeroWrapper(Pasajero p){
    this.pasajero = p;
    }
    

    @Override
    public String toString() {
    return pasajero.getCedula() + ";" + pasajero.getNombre() + ";" + pasajero.getEdad() + ";" + pasajero.getCategoria().getTexto();
    
    }
    
    @Override
    public int compareTo(PasajeroWrapper pw) {
        
        String c1 = this.pasajero.getCedula().replace(".","").replace("-","");
        String c2 = pw.pasajero.getCedula().replace(".","").replace("-","");
        Integer c1Numerico = Integer.parseInt(c1);
        Integer c2Numerico = Integer.parseInt(c2);

        return c2Numerico - c1Numerico;
    }
}

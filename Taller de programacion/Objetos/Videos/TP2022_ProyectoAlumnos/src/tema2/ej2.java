/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Mateo Spinetti
 */
public class ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        GeneradorAleatorio.iniciar();
        int dimL = 0;
        int dimF = 14;
        Persona [] vectorP = new Persona [15];
        Persona p1 = new Persona (GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(50000000), GeneradorAleatorio.generarInt(100));
        while ((dimL <= dimF)&& (p1.getEdad()!= 0)) {
            vectorP [dimL] = p1;
            dimL++;
            p1 =  new Persona (GeneradorAleatorio.generarString(5), GeneradorAleatorio.generarInt(50000000), GeneradorAleatorio.generarInt(100));         
        }
        
        int cant = 0;
        Persona minP = new Persona ();
        minP.setDNI(343534324);
        
        for (int i = 0; i < dimL; i++) {
            if (vectorP[i].getEdad() > 65) 
                cant ++;
            if (vectorP[i].getDNI() < minP.getDNI()) 
                minP = vectorP[i];
                       
        }
       
        System.out.printf("La cantidad de personas mayores a 65 años es %d", cant);
        System.out.println("");
        System.out.println(minP);
        
        
    }
}

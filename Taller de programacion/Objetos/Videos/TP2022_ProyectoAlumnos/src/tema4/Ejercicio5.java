/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Mateo Spinetti
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Cuadrado c1 = new Cuadrado (10, "amarillo", "verde");
        Cuadrado c2 = new Cuadrado (5, "naranja", "rojo");
        VisorFiguras v= new VisorFiguras();
        System.out.println(v.getGuardadas());
        v.guardar(c1);
        System.out.println(v.getGuardadas());
        v.guardar (c2);
        System.out.println(v.getGuardadas());
        v.mostrar();
        
        
        
    }
}

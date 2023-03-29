/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.Lector;
/**
 *
 * @author Mateo Spinetti
 */
public class ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println ("INGRESE EL LADO 1");
        double l1 = Lector.leerDouble();
        System.out.println ("INGRESE EL LADO 2");
        double l2 = Lector.leerDouble();
        System.out.println ("INGRESE EL LADO 3");
        double l3 = Lector.leerDouble();
        System.out.println ("INGRESE EL COLOR DE RELLENO");
        String colorR = Lector.leerString();
        System.out.println ("INGRESE EL COLOR DE LINEA");
        String colorL = Lector.leerString();
        Triangulo t1 = new Triangulo (l1, l2, l3, colorR, colorL);
        System.out.println ("El perimetro del triangulo ingresado es " + t1.calcularPerimetro());
        System.out.println ("El area del triangulo ingresado es " + t1.calcularArea());
    }
}

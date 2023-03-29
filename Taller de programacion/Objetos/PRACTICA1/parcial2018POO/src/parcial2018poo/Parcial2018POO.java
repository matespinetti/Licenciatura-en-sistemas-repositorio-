/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2018poo;
import PaqueteLectura.Lector;

/**
 *
 * @author Mateo Spinetti
 */
public class Parcial2018POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FuncionTeatro f1 = new FuncionTeatro("Cazafantasmas", "22-10-2018", "20:00");
        System.out.println ("Ingrese un dni");
        int dni = Lector.leerInt();
        System.out.println ("Ingrese su nombre");
        String nombre = Lector.leerString();
        System.out.println ("Ingrese su edad");
        int edad = Lector.leerInt();
        System.out.println("Ingrese que numero de fila prefiere");
        int fila = Lector.leerInt();
        while ((dni != 0) && (f1.calcularButacasLibres() > 0)) {
            if (f1.validarFila(fila)) {
                if (f1.hayButacaLibreEnFila(fila)) {
                    if (!f1.estaRegistradoEspectador(dni)) {
                        System.out.println ("El numero de butaca asignado es " + f1.agregarEspectadorAFila(fila, new Espectador(nombre, dni, edad)));
                    } else {
                       System.out.println("Ya hay un espectador registrado en la sala");
                    }
                } else {
                    System.out.println ("No hay mas butacas libres en la fila");
                }
 
        
            } else {
                System.out.println ("El numero de fila es invalido");
            }
            
            System.out.println ("Ingrese un dni");
         dni = Lector.leerInt();
         System.out.println ("Ingrese su nombre");
         nombre = Lector.leerString();
         System.out.println ("Ingrese su edad");
         edad = Lector.leerInt();
         System.out.println("Ingrese que numero de fila prefiere");
         fila = Lector.leerInt();
            
        }
        
        System.out.println ("La cantidad de butacas libres es de " + f1.calcularButacasLibres());
        System.out.println ("La edad promedio de los espectadores registrados es de " + f1.calcularEdadPromedio());
        
    }
    
    
}

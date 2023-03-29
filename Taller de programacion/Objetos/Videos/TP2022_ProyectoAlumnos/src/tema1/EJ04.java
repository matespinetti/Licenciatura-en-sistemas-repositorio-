/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.Lector;

/**
 *
 * @author Mateo Spinetti
 */
public class EJ04 {
    public static void main(String args[]) {
        int filas = 8;
        int columnas = 4;
        int [][] edificio = new int [filas] [columnas];
        for (int i = 0; i < filas; i++) {
            for (int j= 0; j < columnas; j++) {
                edificio [i] [j] = 0;
            }
        }
        System.out.println ("Ingrese el numero de piso");
        int piso = Lector.leerInt();
        System.out.println("Ingrese el numero de oficina");
        int oficina = Lector.leerInt();
        while (piso != 9) {
            edificio [piso - 1] [oficina - 1] += 1;
            System.out.println ("Ingrese el numero de piso");
            piso = Lector.leerInt();
            System.out.println("Ingrese el numero de oficina");
            oficina = Lector.leerInt();
        }
        
        
        for (int i = 0; i < filas; i++ ) {
            for (int j= 0; j < columnas; j++) {
                System.out.println ("La cantidad de personas que concurrieron a la oficina " + (j+1) + " del piso " + (i + 1) + "es de " + edificio[i][j]);
            }
        }
        
      
       
    }
}

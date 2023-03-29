/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 * @author Mateo Spinetti
 */
public class ej03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        GeneradorAleatorio.iniciar();
        int filas = 5;
        int columnas = 8;
        Persona [] [] matrizP = new Persona[5][8]; 
        int i = 0;
   
        Persona p1 = new Persona (Lector.leerString(), GeneradorAleatorio.generarInt(50000000), GeneradorAleatorio.generarInt(100));
        while (!(p1.getNombre().equals("ZZZ"))&&(i < filas)) {
            int j = 0;
            while (!(p1.getNombre().equals("ZZZ")) && (j < columnas)) {
                matrizP [i][j] = p1;
                j ++;
                p1 = new Persona (Lector.leerString(), GeneradorAleatorio.generarInt(50000000), GeneradorAleatorio.generarInt(100));
                       
            }
            i ++;
            
           
        } 
        
        for (i=  0; i < filas; i++) {
            for (int j= 0; j < columnas; j++) 
                if (matrizP[i][j] != null) {
                    System.out.println("");
                    System.out.printf("El nombre de la persona que se atendio el dia %d, turno %d es %s", i+1, j+1, matrizP[i][j].getNombre());
        
                }
                else {
                    System.out.println("");
                    System.out.printf("No hay persona anotada en el dia %d turno %d ", i+1, j+1);
                }
            }
        }


        
            
        
        
        
         
    }

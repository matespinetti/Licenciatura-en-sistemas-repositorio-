/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

//Paso 1. importar la funcionalidad para generar datos aleatorios

public class Ej03Matrices {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int [][] matriz = new int [5][5];
        for (int i= 0; i < 5; i ++) {
            for (int j= 0; j < 5; j++) {
                matriz [i][j] = GeneradorAleatorio.generarInt(31);
            }
        }
        
        
        
        //IMPRIMIR MATRIZ
        
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j= 0; j<5; j++) {
                System.out.print (matriz [i] [j] + "  " );
            }
        }
        
         int sumaFila1 = 0;
         for (int i= 0; i<5; i++) {
             sumaFila1 += matriz [0][i];
         }
         
         System.out.println ("La suma de los elementos de la fila 1 es " + sumaFila1);
         
         int [] vectorSuma = new int [5];
         for (int i= 0; i<5; i++) {
             vectorSuma [i] = 0;
             for (int j=0; j<5; j++) {
                 vectorSuma [i] += matriz [j] [i];
             }
         }
       
         
         for (int i=0; i <5; i++) 
             System.out.println ("La suma de los valores de la columna " + i + " es de " + vectorSuma[i]);
         
         
         System.out.println ("Ingrese un valor a buscar en la matriz");
         int valor = Lector.leerInt();
         boolean encontre = false;
         int fila = -1;
         int columna = -1;
         
         int i = 0;
         int j;
         while ((i < 5) && !(encontre)) {
             j = 0;
             while ((j < 5) && !(encontre)) {
                 if (matriz [i] [j] == valor) {
                     fila = i;
                     columna = j;
                     encontre = true;
                 }
                 
                 j +=1;
                     
       
             }
             
             i +=1;
         }
         
         
         
         if (encontre) 
             System.out.println ("El elemento esta en la fila " + fila + "columna " + columna);
         else
             System.out.println ("El elemento no esta en la matriz");
                
    }
    
    
    
   
}




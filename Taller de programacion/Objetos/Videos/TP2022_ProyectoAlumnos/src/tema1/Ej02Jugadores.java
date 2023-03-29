
package tema1;

import PaqueteLectura.GeneradorAleatorio;


public class Ej02Jugadores {

  
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int [] alturas = new int [15];
       
        double suma = 0;
        
        for (int i = 0; i < 15; i++) {
            alturas [i] = GeneradorAleatorio.generarInt(200);
            suma += alturas [i];
            System.out.println(alturas[i]);
        }
    
        double promedio = suma / 15;
        System.out.println("La altura promedio de todos los jugadores es de " + promedio );
        
        int superan = 0;
        for (int i = 0; i < 15; i++ ) {
            if (alturas[i] >= promedio)
                superan += 1;
               
        }
        
        System.out.println ("La cantidad de jugadores que superan el promedio es de " + superan);
    }
    
}

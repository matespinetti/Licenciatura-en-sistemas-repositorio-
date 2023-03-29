/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;

public class Ej01Tabla2 {

    /**
     * Carga un vector que representa la tabla del 2
     */
    public static void main(String[] args) {
        int DF = 11;
        int[] tabla2 = new int[DF]; // indices de 0 a 10

        for (int i = 0; i < DF; i++) {
            tabla2[i] = 2 * i;
            System.out.println(tabla2[i]);

        }

        int aux = GeneradorAleatorio.generarInt(12);
       
        while (aux != DF) {
            System.out.println ("El numero generado es " + aux);
            System.out.println(tabla2[aux]);
            aux = GeneradorAleatorio.generarInt(12);
        }

    }

}

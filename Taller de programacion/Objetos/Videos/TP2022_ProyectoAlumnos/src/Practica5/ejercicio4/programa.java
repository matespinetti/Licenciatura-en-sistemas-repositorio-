/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5.ejercicio4;

/**
 *
 * @author Mateo Spinetti
 */
public class programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        CoroSemicircular coroS = new CoroSemicircular (3, "iglesia", new Director (12, "monica", 20435234, 51));
        CoroHileras coroH = new CoroHileras (2, 2, "chiflados", new Director(5, "mauricio", 21767070, 52));
        coroH.agregarCorista(new Corista(9, "mateo", 45, 18));
        coroH.agregarCorista(new Corista (9, "manuel", 34523, 11));
        System.out.println(coroH);
        System.out.println(coroH.estaLleno());
        System.out.println(coroH.estaOrdenado());
    }
}

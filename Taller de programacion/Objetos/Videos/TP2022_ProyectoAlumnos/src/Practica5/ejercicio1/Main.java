/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5.ejercicio1;

/**
 *
 * @author Mateo Spinetti
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       Proyecto p1 = new Proyecto ("biologia", 34234, "mateo");
       Investigador investigador1 = new Investigador ("Manuel Spinetti", 3, "fauna");
       Investigador investigador2 = new Investigador ("Matias Ramos", 2, "fifa");
       investigador1.agregarSubsidio(new Subsidio (240, "fundacion"));
       investigador1.agregarSubsidio(new Subsidio (900, "felicidad"));
       investigador2.agregarSubsidio(new Subsidio (1500, "amor"));
       p1.agregarInvestigador(investigador1);
       p1.agregarInvestigador(investigador2);
       p1.otorgarTodos("Manuel Spinetti");
       p1.otorgarTodos("Matias Ramos");
       System.out.println (p1);
       
       
       
       
       
       
    }
}

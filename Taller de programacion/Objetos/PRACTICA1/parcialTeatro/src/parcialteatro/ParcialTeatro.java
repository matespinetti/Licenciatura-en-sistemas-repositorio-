/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialteatro;

/**
 *
 * @author Mateo Spinetti
 */
public class ParcialTeatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Teatro teatro = new Teatro("colon", "9 de julio", "macri");
        Obra obra1 = new Obra ("jeff", "netflix");
        obra1.agregarActor(new Actor ("mateo", "spinetti", "masculino", 18));
        obra1.agregarActor(new Actor("mauricio", "Spinetti", "masculino", 51));
        obra1.agregarActor(new Actor("elva", "demaria", "femenino", 15));
        teatro.agregarObra(obra1);
        System.out.println (teatro.nombreDirectorObra("jeff"));
        System.out.println (teatro.menorCantidadActores().getNombre());
        System.out.println (teatro.getObraAutor("mate", "spinetti"));
        System.out.println (teatro.actorConMasEdad());
        
    }
    
}

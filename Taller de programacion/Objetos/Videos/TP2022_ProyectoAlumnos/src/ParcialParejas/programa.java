/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialParejas;

/**
 *
 * @author Mateo Spinetti
 */
public class programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Concurso concurso = new Concurso (4);
        Pareja pareja1 = new Pareja();
        Pareja pareja2 = new Pareja();
        Participante [] participantes1 = new Participante [2];
        Participante [] participantes2 = new Participante [2];
        participantes1[0] = new Participante (45285325, 13, "mateo");
        participantes1[1] = new Participante (21767070, 18, "mauricio");
        participantes2[0] = new Participante (23446321, 94, "florencia");
        participantes2[1] = new Participante (44332532, 14, "santiago");
        
        pareja1.setParticipantes(participantes1);
        pareja2.setParticipantes(participantes2);
        
        concurso.agregarPareja(pareja1);
        concurso.agregarPareja(pareja2);
        
        System.out.println(concurso.maxDiferenciaEdad().getParticipantes()[0].getNombre());
        System.out.println(concurso.maxDiferenciaEdad().getParticipantes()[1].getNombre());
        
        
        
    }
}

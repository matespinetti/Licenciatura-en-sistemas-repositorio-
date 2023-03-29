/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialobjetos1;
import PaqueteLectura.Lector;



/**
 *
 * @author Mateo Spinetti
 */
public class Parcialobjetos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hospital hospital = new Hospital ("hospital de los ninos", "44 12 y 13");
                for (int i = 0; i < 3; i ++) {
            System.out.println ("Ingrese el numero de cama a ingresar el paciente");
            int nCama = Lector.leerInt();
            System.out.println("Ingrese el DNI del paciente");
            int dni = Lector.leerInt();
            System.out.println ("Ingrese el nombre del paciente");
            String nombre = Lector.leerString();
            System.out.println ("Ingrese la obra social del paciente");
            String obraSocial = Lector.leerString();
            hospital.ingresarPaciente(new Paciente(dni, nombre, obraSocial), nCama );
        }
        
        hospital.aumentarDiasOcupacion();
        System.out.println ("La cantidad de pacientes internados es de " + hospital.cantPacienteInternados());
        hospital.darAltaPaciente(45284325);
        System.out.println ("La cantidad de pacientes internados es de " + hospital.cantPacienteInternados());
        
        
        
    }
    
}

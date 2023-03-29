/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.Lector;

/**
 *
 * @author Mateo Spinetti
 */
public class ej04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Ingrese cuantas habitaciones tendra el hotel");
        int cantHabitaciones = Lector.leerInt();
        Hotel hotel = new Hotel(cantHabitaciones);
        for (int i = 0; i < cantHabitaciones; i++) {
            hotel.getHabitaciones()[i] = new Habitacion ();
        }
        for (int i = 0; i <4; i++) {
            System.out.println ("Ingrese la habitacion a modificar");
            int nHabitacion = Lector.leerInt();
            System.out.println ("Ingrese el nombre del cliente");
            String nombreCliente = Lector.leerString();
            System.out.println ("Ingrese el dni del cliente");
            int dniCliente = Lector.leerInt();
            System.out.println ("Ingrese la edad del cliente");
            int edadCliente = Lector.leerInt();
            Cliente cliente = new Cliente(nombreCliente, dniCliente, edadCliente);
            hotel.getHabitaciones()[nHabitacion].setCliente(cliente);
        }
        
        System.out.println (hotel);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Mateo Spinetti
 */
public class Hotel {

    private Habitacion[] habitaciones;

    public Hotel(int n) {
        habitaciones = new Habitacion[n];
    }

    public void setHabitaciones(Habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }

    public void ocuparHabitacion(Cliente c, int nHabitacion) {
        habitaciones[nHabitacion - 1].setCliente(c);
    }

    public String toString() {
        StringBuffer total = new StringBuffer("");
        for (int i = 0; i < habitaciones.length; i++) {
            String sHab = "Habitacion: " + (i + 1) + habitaciones[i].toString() + habitaciones[i].getCliente().toString();
            total.append(sHab);
            total.append("\n");
        }

        return total.toString();

    }
    

}

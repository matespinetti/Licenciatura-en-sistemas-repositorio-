package ar.edu.unlp.info.oo1;
import java.time.LocalDate;

public class Ticket {
    private LocalDate fecha;
    private int cantProductos;

    private double pesoTotal;

    private double precioTotal;


    public double impuesto(){

        return this.precioTotal * 1.21;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getCantProductos() {
        return cantProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
}

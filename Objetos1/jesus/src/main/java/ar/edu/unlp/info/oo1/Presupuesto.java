package ar.edu.unlp.info.oo1;
import java.time.LocalDate;
import java.util.ArrayList;

public class Presupuesto {
    private LocalDate fecha;
    private String cliente;

    private ArrayList<Item> items;

    public void agregarItem (Item item) {
        this.items.add(item);
        
    }

    public Presupuesto(String cliente) {
        this.cliente = cliente;
        this.fecha = LocalDate.now();
        items = new ArrayList<Item>();
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item:this.items) {
            total += item.costo();
        }

        return total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}

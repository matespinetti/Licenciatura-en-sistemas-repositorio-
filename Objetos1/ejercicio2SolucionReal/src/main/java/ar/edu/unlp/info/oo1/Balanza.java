package ar.edu.unlp.info.oo1;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
    private int cantidadDeProductos;
    private double precioTotal;

    private double pesoTotal;

    private List<Producto> productos = new ArrayList<Producto>();

    public void ponerEnCero(){
        this.cantidadDeProductos = 0;
        this.precioTotal = 0;
        this.pesoTotal = 0;
        this.productos.clear();

    }

    public void agregarProducto(Producto p){
        this.cantidadDeProductos++;
        this.precioTotal += p.getPrecio();
        this.pesoTotal += p.getPeso();
        this.productos.add(p);

    }

    public Ticket emitirTicket(){
        return new Ticket(this.cantidadDeProductos, this.pesoTotal, this.precioTotal, this.productos);
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public void setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}

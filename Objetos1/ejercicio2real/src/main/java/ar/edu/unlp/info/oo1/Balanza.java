package ar.edu.unlp.info.oo1;

public class Balanza {
    private int cantProductos;
    private double precioTotal;

    private double pesoTotal;




    public void ponerEnCero() {
        this.setPrecioTotal(0);
        this.setPesoTotal(0);
    }

    public void agregarProducto(Producto p){
        this.cantProductos++;
        this.precioTotal += p.getPrecioPorKilo() * p.getPeso();
        this.pesoTotal += p.getPeso();

    }


    public int getCantProductos() {
        return cantProductos;
    }

    public void setCantProductos(int cantProductos) {
        this.cantProductos = cantProductos;
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
}

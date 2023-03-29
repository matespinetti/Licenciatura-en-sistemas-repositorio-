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
public class Autor {
    
    private String nombre, biografia, origen;

    public Autor(String nombre, String biografia, String origen) {
        this.nombre = nombre;
        this.biografia = biografia;
        this.origen = origen;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        String aux = "NOMBRE: " + nombre + ", BIOGRAFIA: " + biografia + "ORIGEN: " + origen;
        return aux;
    }
    
    
    
}

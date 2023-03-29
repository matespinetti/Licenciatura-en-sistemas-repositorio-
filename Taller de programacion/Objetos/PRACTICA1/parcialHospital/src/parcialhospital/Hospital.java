/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialhospital;

/**
 *
 * @author Mateo Spinetti
 */
public class Hospital {
    private String nombre, direccion;
    private Cama [] vectorCamas;

    public Hospital(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.vectorCamas = new Cama [100];
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cama[] getVectorCamas() {
        return vectorCamas;
    }

    public void setVectorCamas(Cama[] vectorCamas) {
        this.vectorCamas = vectorCamas;
    }
    
    public void insertarPaciente (Paciente paciente, int nCama) {
        this.vectorCamas[nCama -1].setPaciente(paciente);
        this.vectorCamas[nCama-1].setOcupada(true);
        this.vectorCamas[nCama-1].setCantDiasOcupada(0);
    }
    
    
}

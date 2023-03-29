/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialobjetos1;

/**
 *
 * @author Mateo Spinetti
 */
public class Hospital {
    private String nombre, direccion;
    private Cama [] camas;

    public Hospital(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.camas = new Cama[100];
        for (int i = 0; i < this.camas.length; i ++) {
            camas[i] = new Cama (i + 1, false);
        }
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

    public Cama[] getCamas() {
        return camas;
    }

    public void setCamas(Cama[] camas) {
        this.camas = camas;
    }
    
    
   
    public void ingresarPaciente (Paciente paciente, int nCama) {
        this.camas[nCama].setPaciente(paciente);
        this.camas[nCama].setOcupada(true);
        this.camas[nCama].setCantDiasOcupada(0);
        
    }
    
    public void darAltaPaciente(int dni) {
        
        int i = 0;
        boolean encontre = false;
        while ((i < this.camas.length) && !(encontre)) {
            if (camas[i] != null) {
                if ((camas[i].getPaciente() != null) &&(camas[i].getPaciente().getDni() == dni)) {
                    encontre = true;
                    camas[i].setOcupada(false);
                    camas[i].setPaciente(null);
                }
            }
        i++;
        } 
    
    }
    
    public  void aumentarDiasOcupacion () {
        for (int i = 0; i < this.camas.length; i++) {
            if ((camas [i] != null) && (camas[i].isOcupada())) {
                camas [i].setCantDiasOcupada(camas[i].getCantDiasOcupada() + 1);
            }
        }
    }
    
    
    public int cantPacienteInternados() {
        int cant = 0;
        for (int i = 0; i < this.camas.length; i++) {
            if ((camas[i] != null) && camas[i].isOcupada()) {
                cant ++;
            }
        }
        
        return cant;
    }
    
        
}

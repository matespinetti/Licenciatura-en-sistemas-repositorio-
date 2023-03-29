/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5.ejercicio2;

/**
 *
 * @author Mateo Spinetti
 */
public class Estacionamiento {
    private String nombre, direccion, horaApertura, horaCierre;
    private Auto [] [] estacionamiento;

    public Estacionamiento(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = "8:00";
        this.horaCierre = "21:00";
        this.estacionamiento = new Auto [5][10];
        
        
                
    }

    public Estacionamiento(String nombre, String direccion, String horaApertura, String horaCierre, int nPisos, int nPlazas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.estacionamiento = new Auto [nPisos] [nPlazas];
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

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public Auto[][] getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(Auto[][] estacionamiento) {
        this.estacionamiento = estacionamiento;
    }
    
    public void registrarAuto (Auto auto, int nPiso, int nPlaza) {
        this.estacionamiento[nPiso][nPlaza] = auto;
    }
    
    public String dondeEstaEstacionado(String patente) {
        int i = 0;
        boolean encontre = false;
        int piso = -1;
        int plaza = -1;
        
        while ((i < this.estacionamiento.length) && !(encontre)) {
            int j = 0;
            while ((j < this.estacionamiento[i].length) && !(encontre)) {
                if ((this.estacionamiento [i][j] != null) &&(this.estacionamiento[i][j].getPatente().equals(patente))) {
                    encontre = true;
                    piso = i;
                    plaza = j;
                }  
                j++;
            }
            i++;
        }
        String mensaje;
        
        if (encontre)
            mensaje = "El auto esta en el piso "+ piso + "plaza: " + plaza;
        else
            mensaje = "Auto inexistente";
        
        return mensaje;
    }
    
    public String toString() {
        String mensaje = "";
   
        for (int i = 0; i < this.estacionamiento.length; i++) {
            for (int j = 0; j < this.estacionamiento[i].length; j++) {
                if (this.estacionamiento[i][j] == null)
                    mensaje += "Piso: " + i + "Plaza: " + j + ": libre" + "\n";
                else
                    mensaje  += "Piso: " + i + "Plaza: " + j + ": " + this.estacionamiento[i][j].toString() + "\n";
            }
            
            
        }
        
        return mensaje;
    }
    
    
    public int autosPlaza (int plaza) {
        int cant = 0;
        for (int i = 0; i < this.estacionamiento.length; i ++) {
            if (this.estacionamiento [i][plaza] != null)
                cant ++;
            

            
        }
        
        return cant;
    }
    
}


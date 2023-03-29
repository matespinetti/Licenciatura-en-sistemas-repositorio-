/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialteatro;

/**
 *
 * @author Mateo Spinetti
 */
public class Teatro {
    private String nombre, direccion, nombreDueño;
    private Obra [] obras;
    private int dimL;

    public Teatro(String nombre, String direccion, String nombreDueño) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombreDueño = nombreDueño;
        this.obras = new Obra [5];
        this.dimL = 0;
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

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public Obra[] getObras() {
        return obras;
    }

    public void setObras(Obra[] obras) {
        this.obras = obras;
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }
    
    public void agregarObra (Obra obra) {
        if (this.getDimL() < this.getObras().length) {
            this.obras[this.getDimL()] = obra;
            this.setDimL(this.getDimL()+ 1);
        }
    }
    
    public String nombreDirectorObra (String nombreObra) {
        int i = 0;
        boolean encontre = false;
        String mensaje = "La obra no forma parte del teatro";
        
        while ((i < this.getDimL()) && !(encontre)) {
            if (this.getObras()[i].getNombre().equals(nombreObra)) {
                encontre = true;
                mensaje = "El nombre del director es " + this.getObras()[i].getNombreDirector();
                
            }
           i++; 
        }
        
        return mensaje;
    }
    
    
    public Obra menorCantidadActores () {
        int min = 320000;
        Obra minObra = null;
        for (int i = 0; i < this.getDimL(); i++) {
            if (this.getObras()[i].getDimL() < min) {
                min = this.getObras()[i].getDimL();
                minObra = this.getObras() [i];
            }
            
        }
        
        return minObra;
    
    }
    
    
    public String getObraAutor (String nombre, String apellido) {
        int i = 0;
        boolean encontre = false;
        String nombreObra = "El autor no participa en ninguna obra del teatro";
        while((i < this.getDimL()) && !(encontre)) {
            int j = 0;
            while ((j < this.getObras()[i].getDimL()) && !(encontre)) {
                if (this.getObras()[i].getActores()[j].getNombre().equals(nombre)) {
                    if (this.getObras()[i].getActores()[j].getApellido().equals(apellido)) {
                        encontre = true;
                        nombreObra = "El nombre de la obra donde participa el autor es " + this.getObras()[i].getNombre();
                        
                    }
                }
                j++;
            }
            
            i++;
        }
    
        return nombreObra;
    }
    
    
    public String actorConMasEdad () {
        String nombreMaxEdad = "";
        int maxEdad = -1;
        for (int i = 0; i < this.getDimL(); i ++) {
            for (int j = 0; j < this.getObras()[i].getDimL(); j++) {
                if (this.getObras()[i].getActores()[j].getEdad() > maxEdad) {
                    maxEdad = this.getObras()[i].getActores()[j].getEdad();
                    nombreMaxEdad = "Nombre: " + this.getObras()[i].getActores()[j].getNombre() + ", Apellido: " + this.getObras()[i].getActores()[j].getApellido();
                }
            
            }
        }
        
        return nombreMaxEdad;
    
    }
    
}

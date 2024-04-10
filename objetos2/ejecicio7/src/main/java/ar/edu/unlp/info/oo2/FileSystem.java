package ar.edu.unlp.info.oo2;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private Directorio directorioRaiz;

    public FileSystem(Directorio directorioRaiz){
        this.directorioRaiz = directorioRaiz;
    }

    //Implement add element


    public double tamanoTotalOcupado(){
        return this.directorioRaiz.getTamanoBytes();
    }

    public Archivo archivoMasGrande(){
        return this.directorioRaiz.archivoMasGrande();
    }


    public Archivo archivoMasNuevo(){
        return this.directorioRaiz.archivoMasNuevo();
    }

    public Elemento buscar(String nombre){
        return this.directorioRaiz.buscar(nombre);
    }

    public List<Elemento> buscarTodos(String nombre){
        return this.directorioRaiz.buscarTodos(nombre);
    }
    public String listadoDeContenido(){
        return this.directorioRaiz.listadoDeContenido("/");
    }



}

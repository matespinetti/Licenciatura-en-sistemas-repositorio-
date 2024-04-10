package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSystemTest {
    Directorio directorioRaiz;
    FileSystem fileSystem;
    LocalDate currentDate;

    @BeforeEach
    public void setUp() {
        currentDate = LocalDate.of(2021, 1, 1);
        directorioRaiz = new Directorio("root", currentDate);
        fileSystem = new FileSystem(directorioRaiz);
    }

    @Test
    public void testTamanoTotalOcupado() {
        directorioRaiz.addElemento(new Archivo("archivo1", currentDate.plusDays(1), 10));
        directorioRaiz.addElemento(new Archivo("archivo2", currentDate.plusDays(2), 20));
        directorioRaiz.addElemento(new Archivo("archivo3", currentDate.plusDays(3), 30));
        directorioRaiz.addElemento(new Archivo("archivo4", currentDate.plusDays(4), 40));
        assertEquals(132, fileSystem.tamanoTotalOcupado());
    }

    @Test
    public void testArchivoMasGrande(){
        Archivo archivo1 = new Archivo("archivo1", currentDate.plusDays(5), 10);
        Archivo archivo2 = new Archivo("archivo2", currentDate.plusDays(6), 20);
        Archivo archivo3 = new Archivo("archivo3", currentDate.plusDays(7), 30);
        Archivo archivo4 = new Archivo("archivo4", currentDate.plusDays(8), 40);
        Archivo archivo5 = new Archivo("archivo5", currentDate.plusDays(9), 50);
        Archivo archivo6 = new Archivo("archivo6", currentDate.plusDays(10), 60);
        Archivo archivo7 = new Archivo("archivo7", currentDate.plusDays(11), 70);
        Archivo archivo8 = new Archivo("archivo8", currentDate.plusDays(12), 80);

        Directorio d1 = new Directorio("d1", currentDate.plusDays(13));
        d1.addElemento(archivo5);
        d1.addElemento(archivo6);
        Directorio d2 = new Directorio("d2", currentDate.plusDays(14));
        d2.addElemento(archivo7);
        d2.addElemento(archivo8);
        directorioRaiz.addElemento(archivo1);
        directorioRaiz.addElemento(archivo2);
        directorioRaiz.addElemento(archivo3);
        directorioRaiz.addElemento(archivo4);
        directorioRaiz.addElemento(d1);
        directorioRaiz.addElemento(d2);
        assertEquals(archivo8, fileSystem.archivoMasGrande());
    }

    @Test
    public void testArchivoMasNuevo(){
        Archivo archivo1 = new Archivo("archivo1", currentDate.plusDays(5), 10);
        Archivo archivo2 = new Archivo("archivo2", currentDate.plusDays(6), 20);
        Archivo archivo3 = new Archivo("archivo3", currentDate.plusDays(7), 30);
        Archivo archivo4 = new Archivo("archivo4", currentDate.plusDays(8), 40);
        Archivo archivo5 = new Archivo("archivo5", currentDate.plusDays(9), 50);
        Archivo archivo6 = new Archivo("archivo6", currentDate.plusDays(10), 60);
        Archivo archivo7 = new Archivo("archivo7", currentDate.plusDays(11), 70);
        Archivo archivo8 = new Archivo("archivo8", currentDate.plusDays(12), 80);

        Directorio d1 = new Directorio("d1", currentDate.plusDays(13));
        d1.addElemento(archivo5);
        d1.addElemento(archivo6);
        Directorio d2 = new Directorio("d2", currentDate.plusDays(14));
        d2.addElemento(archivo7);
        d2.addElemento(archivo8);
        directorioRaiz.addElemento(archivo1);
        directorioRaiz.addElemento(archivo2);
        directorioRaiz.addElemento(archivo3);
        directorioRaiz.addElemento(archivo4);
        directorioRaiz.addElemento(d1);
        directorioRaiz.addElemento(d2);
        assertEquals(archivo8, fileSystem.archivoMasNuevo());
    }


    @Test
    public void buscarTest(){
        Archivo archivo1 = new Archivo("archivo1", currentDate.plusDays(5), 10);
        Archivo archivo2 = new Archivo("archivo2", currentDate.plusDays(6), 20);
        Archivo archivo3 = new Archivo("archivo3", currentDate.plusDays(7), 30);
        Archivo archivo4 = new Archivo("archivo4", currentDate.plusDays(8), 40);
        Archivo archivo5 = new Archivo("archivo5", currentDate.plusDays(9), 50);
        Archivo archivo6 = new Archivo("archivo6", currentDate.plusDays(10), 60);
        Archivo archivo7 = new Archivo("archivo7", currentDate.plusDays(11), 70);
        Archivo archivo8 = new Archivo("archivo8", currentDate.plusDays(12), 80);

        Directorio d1 = new Directorio("d1", currentDate.plusDays(13));
        d1.addElemento(archivo5);
        d1.addElemento(archivo6);
        Directorio d2 = new Directorio("d2", currentDate.plusDays(14));
        d2.addElemento(archivo7);
        d2.addElemento(archivo8);
        directorioRaiz.addElemento(archivo1);
        directorioRaiz.addElemento(archivo2);
        directorioRaiz.addElemento(archivo3);
        directorioRaiz.addElemento(archivo4);
        directorioRaiz.addElemento(d1);
        directorioRaiz.addElemento(d2);
        assertEquals(archivo8, fileSystem.buscar("archivo8"));1
    }
    @Test
    public void buscarTodosTest(){
        Archivo archivo1 = new Archivo("archivo8", currentDate.plusDays(5), 10);
        Archivo archivo2 = new Archivo("archivo2", currentDate.plusDays(6), 20);
        Archivo archivo3 = new Archivo("archivo3", currentDate.plusDays(7), 30);
        Archivo archivo4 = new Archivo("archivo4", currentDate.plusDays(8), 40);
        Archivo archivo5 = new Archivo("archivo8", currentDate.plusDays(9), 50);
        Archivo archivo6 = new Archivo("archivo6", currentDate.plusDays(10), 60);
        Archivo archivo7 = new Archivo("archivo7", currentDate.plusDays(11), 70);
        Archivo archivo8 = new Archivo("archivo8", currentDate.plusDays(12), 80);

        Directorio d1 = new Directorio("d1", currentDate.plusDays(13));
        d1.addElemento(archivo5);
        d1.addElemento(archivo6);
        Directorio d2 = new Directorio("d2", currentDate.plusDays(14));
        d2.addElemento(archivo7);
        d2.addElemento(archivo8);
        directorioRaiz.addElemento(archivo1);
        directorioRaiz.addElemento(archivo2);
        directorioRaiz.addElemento(archivo3);
        directorioRaiz.addElemento(archivo4);
        directorioRaiz.addElemento(d1);
        directorioRaiz.addElemento(d2);
        List<Elemento> res = fileSystem.buscarTodos("archivo8");
        assertEquals(3, res.size());
    }
}

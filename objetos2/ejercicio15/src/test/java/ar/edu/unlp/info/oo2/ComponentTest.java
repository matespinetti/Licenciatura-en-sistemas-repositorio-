package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ComponentTest {
    FileComponent fileComponent1;
    FileComponent fileComponent2;
    FileComponent fileComponent3;
    FileComponent fileComponent4;

    @BeforeEach
    void setUp(){
        fileComponent1 = new FileOO2("file1", "txt", 25, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 1), "rwx");
        fileComponent2 = new ExtensionDecorator(fileComponent1);
        fileComponent3 = new PermisosDecorator(fileComponent2);
        fileComponent4 = new NombreDecorator(fileComponent3);
    }


    @Test
    void testPrettyPrint(){
        System.out.println(fileComponent4.prettyPrint().substring(0, fileComponent4.prettyPrint().length()-1));
    }

}

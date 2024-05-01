package ar.edu.unlp.info.oo2.accesobd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseProxyTest {
    DatabaseProxy databaseProxy1;
    DatabaseProxy databaseProxy2;
    @BeforeEach
    void setUp() throws Exception {
        this.databaseProxy1 = new DatabaseProxy("admin", "admin");
        this.databaseProxy2 = new DatabaseProxy("dfmda", "gsdgasdga");

    }

    @Test
    void testAuthenticate(){
        assertTrue(databaseProxy1.authenticate());
    }
    @Test
    void testAuthenticateFail(){
        assertFalse(databaseProxy2.authenticate());
    }

    @Test
    void testGetSearchResultsAuthenticated(){
        assertEquals(Arrays.asList("Spiderman", "Marvel"), this.databaseProxy1.getSearchResults("select * from comics where id=1"));
    }
    @Test
    void testGetSearchResultsNotAuthenticated(){
        assertThrows(RuntimeException.class, () -> this.databaseProxy2.getSearchResults("select * from comics where id=1"));
    }
    @Test
    void testInsertNewRowAuthenticated(){
        assertEquals(3, this.databaseProxy1.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
    }
    @Test
    void testInsertNewRowNotAuthenticated(){
        assertThrows(RuntimeException.class, () -> this.databaseProxy2.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
    }

}

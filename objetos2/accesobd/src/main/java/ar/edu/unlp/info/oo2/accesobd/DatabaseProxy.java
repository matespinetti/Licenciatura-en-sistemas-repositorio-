package ar.edu.unlp.info.oo2.accesobd;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DatabaseProxy implements DatabaseAccess {
     private DatabaseRealAccess databaseRealAccess;
     private String username;
     private String password;
     private static final String VALID_USERNAME = "admin";
     private static final String VALID_PASSWORD = "admin";
     public boolean authenticate (){
         return this.username.equals(VALID_USERNAME) && this.password.equals(VALID_PASSWORD);
     }
     public DatabaseProxy(String username, String password){
            this.username = username;
            this.password = password;
            this.databaseRealAccess = new DatabaseRealAccess();
     }
        @Override
        public Collection<String> getSearchResults(String queryString) {
            if (this.authenticate()){
                return this.databaseRealAccess.getSearchResults(queryString);
            }
            throw new RuntimeException("Invalid credentials");
        }

        public int insertNewRow(List<String> rowData) {
            if (this.authenticate()){
                return this.databaseRealAccess.insertNewRow(rowData);
            }
            throw new RuntimeException("Invalid credentials");
        }

}

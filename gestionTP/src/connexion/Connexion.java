
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {
   
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_tp";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    public static synchronized Connection getConnection() throws SQLException {
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introuvable");
            throw new SQLException("Driver JDBC non trouvé", ex);
        }

        
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }
}
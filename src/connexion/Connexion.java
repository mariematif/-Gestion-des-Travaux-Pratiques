/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private static Connexion instance = null;
    private Connection cn = null;
    private final String url = "jdbc:mysql://localhost:3306/gestion_tp";
    private final String login = "root";
    private final String password = "";

    private Connexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion à la base de données établie avec succès !");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erreur : Driver JDBC introuvable !");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Erreur : Connexion à la base de données échouée !");
            ex.printStackTrace();
        }
    }

    public static synchronized Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }

    public Connection getCn() {
        return cn;
    }
}

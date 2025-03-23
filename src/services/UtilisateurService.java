package services;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurService {

    public String checkLogin(String email, String password) {
        String role = null;
        String req = "SELECT role FROM utilisateur WHERE email = ? AND password = ?";
        try {
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
            }
        } catch (SQLException ex) {
            System.out.println("Erreur Authentification : " + ex.getMessage());
        }
        return role;
    }

    public boolean registerUser(String email, String password) {
        boolean success = false;
        try {
            Connection con = Connexion.getConnection();
            String query = "INSERT INTO utilisateur (email, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            int rows = ps.executeUpdate();
            success = rows > 0;
        } catch (SQLException e) {
            System.out.println("Erreur registerUser : " + e.getMessage());
        }
        return success;
    }

    public boolean authenticate(String email, String password) {
        boolean found = false;
        try {
            Connection con = Connexion.getConnection();
            String query = "SELECT * FROM utilisateur WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                found = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur authenticate : " + e.getMessage());
        }
        return found;
    }

    public boolean userExists(String email) {
        boolean exists = false;
        try {
            Connection con = Connexion.getConnection();
            String query = "SELECT email FROM utilisateur WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur userExists : " + e.getMessage());
        }
        return exists;
    }

  
       public boolean updatePassword(String email, String nouveauMotDePasse) {
    boolean updated = false;
    String query = "UPDATE utilisateur SET password=? WHERE email=?";
    
    try {
        Connection con = Connexion.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, nouveauMotDePasse);
        ps.setString(2, email);
        
        int rows = ps.executeUpdate();
        updated = rows > 0;
        
    } catch (SQLException e) {
        System.out.println("Erreur updatePassword : " + e.getMessage());
    }
    
    return updated;
}

    }

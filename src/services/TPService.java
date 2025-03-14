package services;

import beans.TP;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TPService implements IDao<TP> {

    private Connexion connexion;

    public TPService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(TP o) {
        // Requête modifiée sans titre et description
        String req = "INSERT INTO TP (date, salle, matiere) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setDate(1, new java.sql.Date(o.getDate().getTime()));
            ps.setString(2, o.getSalle());
            ps.setString(3, o.getMatiere());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création du TP : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(TP o) {
        String req = "DELETE FROM TP WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression du TP : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(TP o) {
        // Requête modifiée sans titre et description
        String req = "UPDATE TP SET date = ?, salle = ?, matiere = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setDate(1, new java.sql.Date(o.getDate().getTime()));
            ps.setString(2, o.getSalle());
            ps.setString(3, o.getMatiere());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour du TP : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public TP findById(int id) {
        String req = "SELECT * FROM TP WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new TP(
                        rs.getInt("id"),
                        rs.getDate("date"),
                        rs.getString("salle"),
                        rs.getString("matiere")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche du TP : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<TP> findAll() {
        List<TP> tps = new ArrayList<>();
        String req = "SELECT * FROM TP";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tps.add(new TP(
                        rs.getInt("id"),
                        rs.getDate("date"),
                        rs.getString("salle"),
                        rs.getString("matiere")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des TP : " + ex.getMessage());
        }
        return tps;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Etudiant;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import beans.ParticipationTP;
import beans.TP;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class ParticipationTpService implements IDao<ParticipationTP> {
 private EtudiantService es;
    private Connexion connexion;

    public ParticipationTpService() {
        connexion = Connexion.getInstance();
          es = new EtudiantService();
    }

    @Override
    public boolean create(ParticipationTP o) {
        String req = "INSERT INTO ParticipationTP (tp_id, etudiant_id, dateParticipation, note) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getTp().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.setDate(3, new java.sql.Date(o.getDateParticipation().getTime()));
            ps.setFloat(4, o.getNote());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création de la participation : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(ParticipationTP o) {
        String req = "DELETE FROM ParticipationTP WHERE tp_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getTp().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression de la participation : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(ParticipationTP o) {
        String req = "DELETE FROM ParticipationTP WHERE tp_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getTp().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression de la participation : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public ParticipationTP findById(int id) {
        // Cette méthode n'est pas applicable car une participation est identifiée par deux clés (tp_id et etudiant_id)
        throw new UnsupportedOperationException("Non supporté pour ParticipationTP.");
    }

    @Override
    public List<ParticipationTP> findAll() {
        List<ParticipationTP> participations = new ArrayList<>();
        String req = "SELECT * FROM ParticipationTP";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TP tp = new TPService().findById(rs.getInt("tp_id"));
                Etudiant etudiant = new EtudiantService().findById(rs.getInt("etudiant_id"));
                participations.add(new ParticipationTP(
                        tp,
                        etudiant,
                        rs.getDate("dateParticipation"),
                        rs.getFloat("note")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des participations : " + ex.getMessage());
        }
        return participations;
    }

    public List<ParticipationTP> findByTP(TP selectedTP) {
        List<ParticipationTP> participations = new ArrayList<>();
        String req = "SELECT * FROM ParticipationTP WHERE tp_id = ?";
        
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, selectedTP.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Etudiant etudiant = es.findById(rs.getInt("etudiant_id"));
                participations.add(new ParticipationTP(
                    selectedTP, 
                    etudiant,
                    rs.getDate("dateParticipation"),
                    rs.getFloat("note")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("❌ Erreur lors du filtrage par TP : " + ex.getMessage());
        }
        return participations;
    }
    

}

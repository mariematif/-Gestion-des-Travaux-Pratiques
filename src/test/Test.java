package test;

import beans.Etudiant;
import beans.ParticipationTP;
import beans.TP;
import services.EtudiantService;
import services.ParticipationTpService;
import services.TPService;

import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // Initialisation des services
        TPService tpService = new TPService();
        EtudiantService etudiantService = new EtudiantService();
        ParticipationTpService participationTpService = new ParticipationTpService();

        // Création de TP
        TP tp1 = new TP("Java", new Date(), "Salle A");
        TP tp2 = new TP("Python", new Date(), "Salle B");

        tpService.create(tp1);
        tpService.create(tp2);

        // Rechercher un TP par ID
        TP tp = tpService.findById(1);
        if (tp != null) {
            System.out.println("TP trouvé : " + tp.getMatiere());
        }

        TP tpAMettreAJour = tpService.findById(1); // Récupérer le TP à mettre à jour
if (tpAMettreAJour != null) {
    System.out.println("TP avant mise à jour : " + tpAMettreAJour.getMatiere());

        // Lister tous les TP
        List<TP> tps = tpService.findAll();
        System.out.println("Liste des TP :");
        for (TP t : tps) {
            System.out.println(t.getMatiere() + "\t " + t.getDate() + " \t " + t.getSalle());
        }

        // Supprimer un TP
        tpService.delete(tpService.findById(2));
        System.out.println("TP supprimé.");

        // Création d'étudiants
        Etudiant etudiant1 = new Etudiant("Dupont", "Jean", "jean.dupont@example.com");
        Etudiant etudiant2 = new Etudiant("Martin", "Alice", "alice.martin@example.com");

        etudiantService.create(etudiant1);
        etudiantService.create(etudiant2);

        // Rechercher un étudiant par ID
        Etudiant etudiant = etudiantService.findById(1);
        if (etudiant != null) {
            System.out.println("Étudiant trouvé : " + etudiant.getNom() + " " + etudiant.getPrenom());
        }

        // Mettre à jour un étudiant
        etudiant.setPrenom("Pierre");
        etudiantService.update(etudiant);
        System.out.println("Le prénom de l'étudiant mis à jour : " + etudiantService.findById(1).getPrenom());

        // Lister tous les étudiants
        List<Etudiant> etudiants = etudiantService.findAll();
        System.out.println("Liste des étudiants :");
        for (Etudiant e : etudiants) {
            System.out.println(e.getNom() + " " + e.getPrenom() + " \t - " + e.getEmail());
        }

        // Création de participations aux TP
        ParticipationTP participation1 = new ParticipationTP(tpService.findById(1), etudiantService.findById(1), 15.5);
        ParticipationTP participation2 = new ParticipationTP(tpService.findById(1), etudiantService.findById(2), 18.0);

        participationTpService.create(participation1);
        participationTpService.create(participation2);

        // Lister toutes les participations
        List<ParticipationTP> participations = participationTpService.findAll();
        System.out.println("Liste des participations :");
        for (ParticipationTP p : participations) {
            System.out.println("TP ID: " + p.getTpId() + ", Étudiant ID: " + p.getEtudiantId() + ", Note: " + p.getNote());
        }

        // Supprimer une participation
        ParticipationTP participationSupprimee = participationTpService.findAll().get(0);
        participationTpService.delete(participationSupprimee);
        System.out.println("Participation supprimée : TP ID " + participationSupprimee.getTpId() + " - Étudiant ID " + participationSupprimee.getEtudiantId());

        // Afficher les participations restantes
        System.out.println("Participations restantes :");
        for (ParticipationTP p : participationTpService.findAll()) {
            System.out.println("TP ID: " + p.getTpId() + ", Étudiant ID: " + p.getEtudiantId() + ", Note: " + p.getNote());
        }
      }
  }
      }


package test;

import beans.TP;
import services.TPService;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // Initialisation de la classe TPService
        TPService tpService = new TPService();

        // Test de la méthode create() : Création d'un TP
        TP tpCreate = new TP("Mathématiques", new java.util.Date(), "Salle 101");
        if (tpService.create(tpCreate)) {
            System.out.println("✅ TP créé avec succès !");
        } else {
            System.out.println("❌ Échec de la création du TP.");
        }

        // Test de la méthode findAll() : Récupérer tous les TPs
        List<TP> tps = tpService.findAll();
        System.out.println("\n📌 Liste des TPs après création : ");
        for (TP tp : tps) {
            System.out.println(tp);
        }

        // Test de la méthode findById() : Trouver un TP par ID
        if (!tps.isEmpty()) {
            TP firstTP = tps.get(0); // On récupère le premier TP
            TP tpFound = tpService.findById(firstTP.getId());
            if (tpFound != null) {
                System.out.println("\n🔍 TP trouvé : " + tpFound);
            } else {
                System.out.println("\n❌ TP non trouvé.");
            }
        }

        // Test de la méthode update() : Mettre à jour un TP
        if (!tps.isEmpty()) {
            TP tpToUpdate = tps.get(0); // On récupère le premier TP
            tpToUpdate.setMatiere("Informatique");
            tpToUpdate.setDate(new java.util.Date()); // Mettre à jour la date
            tpToUpdate.setSalle("Salle 202");
            if (tpService.update(tpToUpdate)) {
                System.out.println("\n✅ TP mis à jour avec succès !");
            } else {
                System.out.println("\n❌ Échec de la mise à jour du TP.");
            }
        }

        // Test de la méthode findAll() après mise à jour
        tps = tpService.findAll();
        System.out.println("\n📌 Liste des TPs après mise à jour : ");
        for (TP tp : tps) {
            System.out.println(tp);
        }

        // Test de la méthode delete() : Supprimer un TP
        if (!tps.isEmpty()) {
            TP tpToDelete = tps.get(0); // On récupère le premier TP
            if (tpService.delete(tpToDelete)) {
                System.out.println("\n🗑️ TP supprimé avec succès !");
            } else {
                System.out.println("\n❌ Échec de la suppression du TP.");
            }
        }

        // Test de la méthode findAll() après suppression
        tps = tpService.findAll();
        System.out.println("\n📌 Liste des TPs après suppression : ");
        for (TP tp : tps) {
            System.out.println(tp);
        }
    }
}

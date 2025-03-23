# Gestion des Travaux Pratiques (TP)

Ce projet est une application de gestion des travaux pratiques (TP) pour les étudiants. Il permet de gérer les TP, les étudiants et leurs participations aux TP, y compris l'enregistrement des notes. L'application est développée en **Java** avec une base de données **MySQL**.

---

## Fonctionnalités

- **Ajouter un TP** : Permet d'ajouter un nouveau TP avec des détails tels que la matière, la date et la salle.
- **Enregistrer une participation** : Permet d'enregistrer la participation d'un étudiant à un TP, ainsi que sa note.
- **Filtrer par matière** : Permet de lister les TP en fonction de la matière.
- **Rechercher un étudiant** : Permet de rechercher un étudiant par son nom ou prénom.
- **Graphique des moyennes par TP** : Affiche un graphique en barres représentant la moyenne des notes par TP.

---
## ✅ Diagramme de cas d’utilisation (Use Case)
![Image](https://github.com/user-attachments/assets/d35495b8-709f-4746-99bf-7bc11185f4a5)
---
## ✅ Diagramme de classe
![Image](https://github.com/user-attachments/assets/2f3aa477-3a95-40ca-86e6-225e0e136c6c)
---
## Structure de la Base de Données

La base de données MySQL est composée des tables suivantes :

### Table `TP`
```sql

   CREATE TABLE TP (
    id INT PRIMARY KEY AUTO_INCREMENT,
    matiere VARCHAR(100) NOT NULL,
    date DATE NOT NULL,
    salle VARCHAR(50) NOT NULL
);

CREATE TABLE Étudiant (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    prénom VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE ParticipationTP (
    tp_id INT,
    etudiant_id INT,
    dateParticipation DATE,
    note FLOAT,
    PRIMARY KEY (tp_id, etudiant_id),
    FOREIGN KEY (tp_id) REFERENCES TP(id),
    FOREIGN KEY (etudiant_id) REFERENCES Étudiant(id)
);
CREATE TABLE utilisateur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) DEFAULT 'user',
    code_reinitialisation VARCHAR(10) DEFAULT NULL
);

```
## 💻 Technologies utilisées

- **Java SE 8+** : Langage principal de l'application.
- **Swing (`javax.swing`)** : Bibliothèque pour l'interface graphique (UI).
- **JDBC** : Accès à la base de données MySQL.
- **MySQL** : Système de gestion de base de données relationnelle.
- **JFreeChart** : Bibliothèque utilisée pour générer des graphiques statistiques (moyenne par TP).
- **NetBeans IDE** : Environnement de développement intégré (IDE) utilisé pour concevoir les interfaces graphiques (via éditeur visuel) et organiser le projet.
---
## ## 🗂️ Structure du projet

![Image](https://github.com/user-attachments/assets/dbf36e43-7f94-42e9-a85c-f6fbf45f38f3)
---
## ## Vidéo de démonstration
https://github.com/user-attachments/assets/2cb0f086-8c92-4a5b-b45b-a89b911f9cf8

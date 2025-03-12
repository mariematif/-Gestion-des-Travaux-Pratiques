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
    id INT PRIMARY KEY AUTO_INCREMENT,
    tp_id INT,
    etudiant_id INT,
    note FLOAT,
    FOREIGN KEY (tp_id) REFERENCES TP(id),
    FOREIGN KEY (etudiant_id) REFERENCES Étudiant(id)
);

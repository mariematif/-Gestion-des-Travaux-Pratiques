package beans;

import java.util.Date;

public class TP {

    private int id;
    private String matiere;
    private Date date;
    private String salle;

    // Constructeur sans ID (Ajout d'un nouveau TP)
    public TP(String matiere, Date date, String salle) {
        this.matiere = matiere;
        this.date = date;
        this.salle = salle;
    }

    // Constructeur avec ID (Lecture d'un TP existant)
    public TP(int id, String matiere, Date date, String salle) {
        this.id = id;
        this.matiere = matiere;
        this.date = date;
        this.salle = salle;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getMatiere() {
        return matiere;
    }

    public Date getDate() {
        return date;
    }

    public String getSalle() {
        return salle;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "TP{"
                + "id=" + id
                + ", matiere='" + matiere + '\''
                + ", date=" + date
                + ", salle='" + salle + '\''
                + '}';
    }
}

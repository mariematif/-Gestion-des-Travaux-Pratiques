package beans;

import java.util.Date;

public class TP {

    private int id;
    private String titre;
    private String description;
    private Date date;
    private String salle;
    private String matiere;

    public TP(String titre, String description, Date date, String salle, String matiere) {
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.salle = salle;
        this.matiere = matiere;
    }

    public TP(int id, String titre, String description, Date date, String salle, String matiere) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.salle = salle;
        this.matiere = matiere;
    }

    public TP(String titre, Date date, String salle) {
        this.titre = titre;
        this.date = date;
        this.salle = salle;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getSalle() {
        return salle;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    @Override
    public String toString() {
        return "TP{"
                + "id=" + id
                + ", titre='" + titre + '\''
                + ", description='" + description + '\''
                + ", date=" + date
                + ", salle='" + salle + '\''
                + ", matiere='" + matiere + '\''
                + '}';
    }
}

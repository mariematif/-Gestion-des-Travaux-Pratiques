package beans;

import java.util.Date;

public class TP {

    private int id;
    
    private Date date;
    private String salle;
    private String matiere;

    public TP( Date date, String salle, String matiere) {
       
        this.date = date;
        this.salle = salle;
        this.matiere = matiere;
    }

    public TP(int id,  Date date, String salle, String matiere) {
        this.id = id;
       
        this.date = date;
        this.salle = salle;
        this.matiere = matiere;
    }

    public TP( Date date, String salle) {
     
        this.date = date;
        this.salle = salle;
    }

    public int getId() {
        return id;
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
                + ", date=" + date
                + ", salle='" + salle + '\''
                + ", matiere='" + matiere + '\''
                + '}';
    }
}

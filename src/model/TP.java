
package model;


public class TP {
    private int id;
    private String matiere;
    private String date;
    private String salle;

    
  

    public TP(int id, String matiere, String date, String salle) {
        this.id = id;
        this.matiere = matiere;
        this.date = date;
        this.salle = salle;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMatiere() { return matiere; }
    public void setMatiere(String matiere) { this.matiere = matiere; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getSalle() { return salle; }
    public void setSalle(String salle) { this.salle = salle; }

    @Override
    public String toString() {
        return "TP{" +
                "id=" + id +
                ", matiere='" + matiere + '\'' +
                ", date='" + date + '\'' +
                ", salle='" + salle + '\'' +
                '}';
    }
}

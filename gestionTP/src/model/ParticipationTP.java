package model;

public class ParticipationTP {
    private int id;
    private int tp;
    private int etudiant;
    private float note;

  
    public ParticipationTP(int id, int tp, int etudiant, float note) {
        this.id = id;
        this.tp = tp;
        this.etudiant = etudiant;
        this.note = note;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTp() {
        return tp;
    }

    public void setTpId(int tp) {
        this.tp = tp;
    }

    public int getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(int etudiant) {
        this.etudiant = etudiant;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

   
    @Override
    public String toString() {
        return "ParticipationTP{" +
                "id=" + id +
                ", tp=" + tp+
                ", etudiant=" + etudiant +
                ", note=" + note +
                '}';
    }
}
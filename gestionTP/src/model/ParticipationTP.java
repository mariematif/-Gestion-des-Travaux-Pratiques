package model;

public class ParticipationTP {
    private int id;
    private int tpId;
    private int etudiantId;
    private float note;

  
    public ParticipationTP(int id, int tpId, int etudiantId, float note) {
        this.id = id;
        this.tpId = tpId;
        this.etudiantId = etudiantId;
        this.note = note;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTpId() {
        return tpId;
    }

    public void setTpId(int tpId) {
        this.tpId = tpId;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
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
                ", tpId=" + tpId +
                ", etudiantId=" + etudiantId +
                ", note=" + note +
                '}';
    }
}
package beans;

import java.util.Date;

public class ParticipationTP {

    private TP tp;
    private Etudiant etudiant;
    private Date dateParticipation;
    private float note;

    public ParticipationTP(TP tp, Etudiant etudiant, Date dateParticipation, float note) {
        this.tp = tp;
        this.etudiant = etudiant;
        this.dateParticipation = dateParticipation;
        this.note = note;
    }

    public ParticipationTP(TP findById, Etudiant findById0, double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ParticipationTP(TP tp, Etudiant etudiant, Date dateParticipation, String note) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TP getTp() {
        return tp;
    }

    public void setTp(TP tp) {
        this.tp = tp;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Date getDateParticipation() {
        return dateParticipation;
    }

    public void setDateParticipation(Date dateParticipation) {
        this.dateParticipation = dateParticipation;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ParticipationTP{"
                + "tp=" + tp
                + ", etudiant=" + etudiant
                + ", dateParticipation=" + dateParticipation
                + ", note=" + note
                + '}';
    }

    public int getEtudiantId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTpId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

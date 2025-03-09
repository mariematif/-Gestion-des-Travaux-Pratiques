package model;

import java.util.Date;

public class ParticipationTP {
    private TP tp;               // Référence au TP
    private Etudiant etudiant;   // Référence à l'étudiant
    private Date dateParticipation; // Date de participation
    private float note;          // Note obtenue par l'étudiant

    // Constructeur
    public ParticipationTP(TP tp, Etudiant etudiant, Date dateParticipation, float note) {
        this.tp = tp;
        this.etudiant = etudiant;
        this.dateParticipation = dateParticipation;
        this.note = note;
    }

    // Getters et setters
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

    // Méthode toString pour afficher les informations de la participation
    @Override
    public String toString() {
        return "ParticipationTP{" +
                "tp=" + tp +
                ", etudiant=" + etudiant +
                ", dateParticipation=" + dateParticipation +
                ", note=" + note +
                '}';
    }
}
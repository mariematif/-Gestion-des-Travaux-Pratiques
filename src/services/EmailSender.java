/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Hp
 */
public class EmailSender {

    private Connexion connexion;
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

  public String getPasswordByEmail(String email) {
    String password = null;
    try {
        Connection con = Connexion.getConnection(); // Assure-toi que Connexion fonctionne
      String query = "SELECT password FROM utilisateur WHERE email = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            password = rs.getString("password");
        }
    } catch (Exception e) {
        System.out.println("Erreur getPasswordByEmail : " + e.getMessage());
    }
    return password;
}


    // ✅ Méthode pour envoyer l'e-mail avec le mot de passe
    public static void sendEmail(String toEmail, String passwordActuel) {
        final String fromEmail = "assistanom200@gmail.com"; // ⚠️ ton email Gmail ici
        final String password = "guuqjtkkdetyjaki";     // ⚠️ mot de passe d'application généré via Google

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("🧠 Rappel de votre mot de passe");
            message.setText("Bonjour,\n\nVoici votre mot de passe actuel : " + passwordActuel
                    + "\n\nVeuillez le conserver ou le modifier après connexion.\n\nTP Organizer");

            Transport.send(message);
            System.out.println("Email envoyé avec succès.");

        } catch (MessagingException e) {
            throw new RuntimeException("Erreur lors de l'envoi de l'email : " + e.getMessage());
        }
    }
}

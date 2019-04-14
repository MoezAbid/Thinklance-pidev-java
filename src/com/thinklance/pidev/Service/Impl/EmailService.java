/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.Email;
import com.thinklance.pidev.entities.User;
import java.awt.Component;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Wassila
 */
public class EmailService {

    private static final Random RANDOM = new SecureRandom();
    /**
     * Length of password. @see #generateRandomPassword()
     */
    public static final int PASSWORD_LENGTH = 8;
    //partie recoveryEmail
    private Component User_Connexion;
    private Connection connection;

    public EmailService() {
        this.connection = MyConnection.getInstance().getCnx();

    }

    public static String generateRandomPassword() {
     
        String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";

        String pw = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = (int) (RANDOM.nextDouble() * letters.length());
            pw += letters.substring(index, index + 1);
        }
        return pw;
    }

    public void oublieMotdepasseEmail(User user) throws Exception {
       String newpass= generateRandomPassword();
       //Changer user password 
       UserService userDAO=new UserService();
       user.setPassword(newpass);
       userDAO.updatepassworduser(user);
        Email email = new Email();
        String mail = user.getEmail();
        //Création  de la session
        Session session = Session.getInstance(email.getProps(),
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getUsername(), email.getPassword());
            }
        });
        //Création du message
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email.getUsername()));

        InternetAddress toAddress = new InternetAddress(user.getEmail());

        message.addRecipient(javax.mail.Message.RecipientType.TO, toAddress);

        message.setSubject("Votre Identifiant sur ThinkLance");

        message.setText("Bonjour,\n " + "Vous avez recemment tenté de vous connecter sur ThinkLance\n"
                + "Malheureusement vous avez oublié votre mot de passe \n"
                + "Nous sommes donc heureux de pouvoir vous adresser les informations qui vont vous permettre d'avoir à nouveau accès à votre compte\n\n" + newpass);

        //Envoi du message
        Transport transport = session.getTransport("smtp");

        transport.connect(email.getHost(), email.getUsername(), email.getPassword());

        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }

    //Mail Confirmation d'inscription
    public void SendConfirmationEmail(User user) throws Exception {

        Email email = new Email();
        String mail = user.getEmail();
        Session session = Session.getInstance(email.getProps(),
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getUsername(), email.getPassword());
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email.getUsername()));
        InternetAddress toAddress = new InternetAddress(user.getEmail());

        message.addRecipient(javax.mail.Message.RecipientType.TO, toAddress);

        message.setSubject("Bienvenue sur ThinkLance");

        message.setText("Bonjour,\n\n" + "Merci pour votre inscription sur ThinkLance. Votre compte est créé et doit être activé avant que vous  puissiez l'utiliser.\n http://localhost:8082/activate.php?email=" + mail + " \n \nCordialement.");

        Transport transport = session.getTransport("smtp");

        transport.connect(email.getHost(), email.getUsername(), email.getPassword());

        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }

}

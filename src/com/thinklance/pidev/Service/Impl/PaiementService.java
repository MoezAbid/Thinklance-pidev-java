/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.entities.Projet;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.thinklance.pidev.Service.Impl.UserService;
import com.thinklance.pidev.Service.interfaces.IPaiementService;
import com.thinklance.pidev.Utils.MyConnection;
import java.sql.Connection;
import com.thinklance.pidev.Utils.UserManager;
import com.thinklance.pidev.entities.Paiement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Moez
 */
public class PaiementService implements IPaiementService {
    
    private Connection databaseConnection;
    
    public PaiementService() {
        databaseConnection = MyConnection.getInstance().getCnx();
        //Set your secret key: remember to change this to your live secret key in production
        // See your keys here: https://dashboard.stripe.com/account/apikeys
        Stripe.apiKey = "sk_test_pnfuYUNCotWhyq7uOfqDmuGE";
    }
    
    @Override
    public void ajouterPaiement(Paiement nouveauPaiement) {
        try {
            String requeteAjoutPrepared = "INSERT INTO paiement(IdPaiement, dateHeurePaiement, montant, Projet, freelancer, employeur) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstAjoutPaiement = databaseConnection.prepareStatement(requeteAjoutPrepared);
            pstAjoutPaiement.setString(1, nouveauPaiement.getIdPaiement());
            pstAjoutPaiement.setTimestamp(2, new java.sql.Timestamp(nouveauPaiement.getDateHeure().getTime()));
            pstAjoutPaiement.setDouble(3, nouveauPaiement.getMontant());
            pstAjoutPaiement.setInt(4, nouveauPaiement.getProjet());
            pstAjoutPaiement.setInt(5, nouveauPaiement.getIdFreelancer());
            pstAjoutPaiement.setInt(6, nouveauPaiement.getIdEmployeur());
            pstAjoutPaiement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PaiementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void supprimerPaiement(String idPaiement) {
        try {
            String requeteSuppression = "DELETE FROM paiement WHERE IdPaiement=?";
            PreparedStatement pst = databaseConnection.prepareStatement(requeteSuppression);
            pst.setString(1, idPaiement);
            pst.executeUpdate();
            System.out.println("Paiement supprimé.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public ObservableList<Paiement> getListePaiements() {
        System.out.println("Liste d'articles");
        List<Paiement> listeDesPaiements = new ArrayList<>();
        String req = "SELECT * FROM article";
        try {
            Statement selectArticlesStatement = databaseConnection.createStatement();
            ResultSet resultSetListPaiements = selectArticlesStatement.executeQuery(req);
            while (resultSetListPaiements.next()) {
                Paiement paiement = new Paiement();
                paiement.setIdPaiement(resultSetListPaiements.getString("IdPaiement"));
                paiement.setDateHeure(resultSetListPaiements.getTimestamp("dateHeurePaiement"));
                paiement.setMontant(resultSetListPaiements.getDouble("montant"));
                paiement.setProjet(resultSetListPaiements.getInt("Projet"));
                paiement.setIdFreelancer(resultSetListPaiements.getInt("freelancer"));
                paiement.setIdEmployeur(resultSetListPaiements.getInt("employeur"));
                listeDesPaiements.add(paiement);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(listeDesPaiements);
    }
    
    @Override
    public ObservableList<Paiement> getPaiementsFreelancer(int idFreelancer) {
        System.out.println("Liste mes paiements freelancer");
        List<Paiement> listeDesPaiements = new ArrayList<>();
        String req = "SELECT * FROM paiement WHERE freelancer=" + idFreelancer;
        try {
            Statement selectPaiementsFreelancerStatement = databaseConnection.createStatement();
            ResultSet resultSetListPaiements = selectPaiementsFreelancerStatement.executeQuery(req);
            while (resultSetListPaiements.next()) {
                Paiement paiement = new Paiement();
                paiement.setIdPaiement(resultSetListPaiements.getString("IdPaiement"));
                paiement.setDateHeure(resultSetListPaiements.getTimestamp("dateHeurePaiement"));
                paiement.setMontant(resultSetListPaiements.getDouble("montant"));
                paiement.setProjet(resultSetListPaiements.getInt("Projet"));
                paiement.setIdFreelancer(resultSetListPaiements.getInt("freelancer"));
                paiement.setIdEmployeur(resultSetListPaiements.getInt("employeur"));
                listeDesPaiements.add(paiement);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(listeDesPaiements);
    }
    
    @Override
    public ObservableList<Paiement> getPaiementsemployeur(int idEmployeur) {
        System.out.println("Liste mes paiements employeur");
        List<Paiement> listeDesPaiements = new ArrayList<>();
        String req = "SELECT * FROM paiement WHERE employeur=" + idEmployeur;
        try {
            Statement selectPaiementsEmployeurStatement = databaseConnection.createStatement();
            ResultSet resultSetListPaiements = selectPaiementsEmployeurStatement.executeQuery(req);
            while (resultSetListPaiements.next()) {
                Paiement paiement = new Paiement();
                paiement.setIdPaiement(resultSetListPaiements.getString("IdPaiement"));
                paiement.setDateHeure(resultSetListPaiements.getTimestamp("dateHeurePaiement"));
                paiement.setMontant(resultSetListPaiements.getDouble("montant"));
                paiement.setProjet(resultSetListPaiements.getInt("Projet"));
                paiement.setIdFreelancer(resultSetListPaiements.getInt("freelancer"));
                paiement.setIdEmployeur(resultSetListPaiements.getInt("employeur"));
                listeDesPaiements.add(paiement);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(listeDesPaiements);
    }
    
    @Override
    public ObservableList<Paiement> getPaiementsUtilisateurSpecifique(int idUser) {
        System.out.println("Liste paiements d'un utilisateur specifique");
        List<Paiement> listeDesPaiements = new ArrayList<>();
        String req = "SELECT * FROM paiement WHERE employeur=" + idUser + " OR freelancer=" + idUser;
        try {
            Statement selectPaiementsUtilisateurSpecifiqueStatement = databaseConnection.createStatement();
            ResultSet resultSetListPaiements = selectPaiementsUtilisateurSpecifiqueStatement.executeQuery(req);
            while (resultSetListPaiements.next()) {
                Paiement paiement = new Paiement();
                paiement.setIdPaiement(resultSetListPaiements.getString("IdPaiement"));
                paiement.setDateHeure(resultSetListPaiements.getTimestamp("dateHeurePaiement"));
                paiement.setMontant(resultSetListPaiements.getDouble("montant"));
                paiement.setProjet(resultSetListPaiements.getInt("Projet"));
                paiement.setIdFreelancer(resultSetListPaiements.getInt("freelancer"));
                paiement.setIdEmployeur(resultSetListPaiements.getInt("employeur"));
                listeDesPaiements.add(paiement);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(listeDesPaiements);
    }
    
    @Override
    public Paiement getPaiementSpecifique(String idPaiement) {
        Paiement paiement = new Paiement();
        try {
            String requeteSelectArticle = "SELECT * FROM paiement WHERE IdPaiement=?";
            PreparedStatement selectUnArticleStatement = databaseConnection.prepareStatement(requeteSelectArticle);
            selectUnArticleStatement.setString(1, idPaiement);
            
            ResultSet resultSetListPaiements = selectUnArticleStatement.executeQuery();
            
            resultSetListPaiements.next();
            paiement.setIdPaiement(resultSetListPaiements.getString("IdPaiement"));
            paiement.setDateHeure(resultSetListPaiements.getTimestamp("dateHeurePaiement"));
            paiement.setMontant(resultSetListPaiements.getDouble("montant"));
            paiement.setProjet(resultSetListPaiements.getInt("Projet"));
            paiement.setIdFreelancer(resultSetListPaiements.getInt("freelancer"));
            paiement.setIdEmployeur(resultSetListPaiements.getInt("employeur"));
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paiement;
    }
    
    @Override
    public void effectuerPaiement(double montant, int IdProjet) {
        //Récupertion des détails du projet à payer :
        ServiceProjet servProj = new ServiceProjet();
        Projet proj = servProj.getProjetParId(IdProjet);

        //Tratement de la promotion
        //fin du traitement de la promotion
        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", Math.round(proj.getPrix()) * 100);
        chargeMap.put("currency", "eur");
        chargeMap.put("source", "tok_mastercard"); // obtained via Stripe.js
        //Soumission dun paiement et enregistrement dans la BD
        try {
            UserService user = new UserService();
            UserManager um = new UserManager();
            
            Charge charge = Charge.create(chargeMap);
            System.out.println(charge);
            this.ajouterPaiement(new Paiement(charge.getId(), new Date(), proj.getPrix(), proj.getFreelancer(), user.getTheUserIdfromemail(um.getUserConnected()), proj.getIdProjet()));
        } catch (StripeException e) {
            e.printStackTrace();
        }
    }
}

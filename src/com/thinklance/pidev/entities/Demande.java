/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.entities;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class Demande {
     private int id;
    private int freelancer;
    private Date dateDemande;
    private String etatDemande;
    private int idEmployeur;
    private int idProjet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(int freelancer) {
        this.freelancer = freelancer;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getEtatDemande() {
        return etatDemande;
    }

    public void setEtatDemande(String etatDemande) {
        this.etatDemande = etatDemande;
    }

    public int getIdEmployeur() {
        return idEmployeur;
    }

    public void setIdEmployeur(int idEmployeur) {
        this.idEmployeur = idEmployeur;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public Demande(int id, int freelancer, Date dateDemande, String etatDemande, int idEmployeur, int idProjet) {
        this.id = id;
        this.freelancer = freelancer;
        this.dateDemande = dateDemande;
        this.etatDemande = etatDemande;
        this.idEmployeur = idEmployeur;
        this.idProjet = idProjet;
    }

    public Demande() {
    }

    @Override
    public String toString() {
        return "Demande{" + "id=" + id + ", freelancer=" + freelancer + ", dateDemande=" + dateDemande + ", etatDemande=" + etatDemande + ", idEmployeur=" + idEmployeur + ", idProjet=" + idProjet + '}';
    }

    public Demande(int freelancer, Date dateDemande, String etatDemande, int idEmployeur, int idProjet) {
        this.freelancer = freelancer;
        this.dateDemande = dateDemande;
        this.etatDemande = etatDemande;
        this.idEmployeur = idEmployeur;
        this.idProjet = idProjet;
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.entities;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class ExperienceProfessionnel {

    private int id;
    private String titre_exp;
    private Date datedebut;
    private Date datefin;
    private String nom_entreprise;
    private String description;
    private int id_user;

    public ExperienceProfessionnel() {
    }

    public ExperienceProfessionnel(int id, String titre_exp, Date datedebut, Date datefin, String nom_entreprise, String description, int id_user) {
        this.id = id;
        this.titre_exp = titre_exp;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.nom_entreprise = nom_entreprise;
        this.description = description;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public String getTitre_exp() {
        return titre_exp;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public String getDescription() {
        return description;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre_exp(String titre_exp) {
        this.titre_exp = titre_exp;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "ExperienceProfessionnel{" + "id=" + id + ", titre_exp=" + titre_exp + ", datedebut=" + datedebut + ", datefin=" + datefin + ", nom_entreprise=" + nom_entreprise + ", description=" + description + ", id_user=" + id_user + '}';
    }
    
}

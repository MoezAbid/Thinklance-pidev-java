/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.entities;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class Formation {
    private int id;
    private String titre;
    private Date datedebut;
    private Date datefin;
    private String institution;
    private String description;
    private int id_user;

    public Formation(int id, String titre, Date datedebut, Date datefin, String institution, String description, int id_user) {
        this.id = id;
        this.titre = titre;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.institution = institution;
        this.description = description;
        this.id_user = id_user;
    }

    public Formation() {
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public String getInstitution() {
        return institution;
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

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", titre=" + titre + ", datedebut=" + datedebut + ", datefin=" + datefin + ", institution=" + institution + ", description=" + description + ", id_user=" + id_user + '}';
    }
    
}

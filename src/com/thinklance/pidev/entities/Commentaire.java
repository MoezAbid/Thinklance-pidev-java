/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.entities;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Commentaire {

    private int id;
    private String contenu;
    private int id_user;
    private Date date_ajout;
    private int id_employeur;

    public Commentaire() {
    }

    public Commentaire(int id, String contenu, int id_user, int id_employeur) {
        this.id = id;
        this.contenu = contenu;
        this.id_user = id_user;
        this.id_employeur = id_employeur;
    }

    public void setId_employeur(int id_employeur) {
        this.id_employeur = id_employeur;
    }

    public int getId_employeur() {
        return id_employeur;
    }

    public int getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public int getId_user() {
        return id_user;
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", contenu=" + contenu + ", id_user=" + id_user + ", date_ajout=" + date_ajout + '}';
    }

}

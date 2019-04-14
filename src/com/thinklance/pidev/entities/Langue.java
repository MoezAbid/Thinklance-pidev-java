/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.entities;

/**
 *
 * @author ASUS
 */
public class Langue {
    private int id;
    private String languetitre;
    private int id_user;

    public Langue(int id, String languetitre, int id_user) {
        this.id = id;
        this.languetitre = languetitre;
        this.id_user = id_user;
    }

    public Langue() {
    }

    public int getId() {
        return id;
    }

    public String getLanguetitre() {
        return languetitre;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLanguetitre(String languetitre) {
        this.languetitre = languetitre;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Langue{" + "id=" + id + ", languetitre=" + languetitre + ", id_user=" + id_user + '}';
    }
    
}

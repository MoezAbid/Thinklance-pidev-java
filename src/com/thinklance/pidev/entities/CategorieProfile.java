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
public class CategorieProfile {
    private int id;
    private String nom_categorie;
    private String sous_categorie;
    private int id_user;

 

    public CategorieProfile(int id, String nom_categorie, String sous_categorie, int id_user) {
        this.id = id;
        this.nom_categorie = nom_categorie;
        this.sous_categorie = sous_categorie;
        this.id_user = id_user;
    }

    public void setSous_categorie(String sous_categorie) {
        this.sous_categorie = sous_categorie;
    }

    public String getSous_categorie() {
        return sous_categorie;
    }

    public CategorieProfile() {
    }

    public int getId() {
        return id;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nom_categorie=" + nom_categorie + ", sous_categorie=" + sous_categorie + ", id_user=" + id_user + '}';
    }

  
    
    
}

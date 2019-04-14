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
public class Competence {
    private int id;
    private String nom_competence;
    private int id_user;
    private int degre;

    public Competence(int id, String nom_competence, int id_user) {
        this.id = id;
        this.nom_competence = nom_competence;
        this.id_user = id_user;
    }

    public Competence() {
    }

    public void setDegre(int degre) {
        this.degre = degre;
    }

    public int getDegre() {
        return degre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_competence(String nom_competence) {
        this.nom_competence = nom_competence;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public String getNom_competence() {
        return nom_competence;
    }

    public int getId_user() {
        return id_user;
    }

    @Override
    public String toString() {
        return "Competence{" + "id=" + id + ", nom_competence=" + nom_competence + ", id_user=" + id_user + '}';
    }
    
    
}

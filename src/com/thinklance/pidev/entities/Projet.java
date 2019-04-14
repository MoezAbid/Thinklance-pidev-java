/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.entities;

/**
 *
 * @author LENOVO
 */
public class Projet {

    private int idProjet;
    private int employeur;
    private int freelancer;
    private String titreProjet;
    private String description;
    private int nbjours;
    private Double prix;
    private String nomFichiers;
    private String file;
    private int idCategorie;

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getTitreProjet() {
        return titreProjet;
    }

    public void setTitreProjet(String titreProjet) {
        this.titreProjet = titreProjet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbjours() {
        return nbjours;
    }

    public void setNbjours(int nbjours) {
        this.nbjours = nbjours;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getNomFichiers() {
        return nomFichiers;
    }

    public void setNomFichiers(String nomFichiers) {
        this.nomFichiers = nomFichiers;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Projet() {
    }

    public int getEmployeur() {
        return employeur;
    }

    public void setEmployeur(int employeur) {
        this.employeur = employeur;
    }

    public int getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(int freelancer) {
        this.freelancer = freelancer;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Projet(int idProjet, int employeur, String titreProjet, String description, int nbjours, Double prix, String nomFichiers, String file, int idCategorie) {
        this.idProjet = idProjet;
        this.employeur = employeur;

        this.titreProjet = titreProjet;
        this.description = description;
        this.nbjours = nbjours;
        this.prix = prix;
        this.nomFichiers = nomFichiers;
        this.file = file;
        this.idCategorie = idCategorie;
    }

    public Projet(int idProjet, String description) {
        this.idProjet = idProjet;
        this.description = description;
    }

    public Projet(int idProjet, int employeur, int freelancer, String titreProjet, String description, int nbjours, Double prix, String nomFichiers, int idCategorie) {
        this.idProjet = idProjet;
        this.employeur = employeur;
        this.freelancer = freelancer;
        this.titreProjet = titreProjet;
        this.description = description;
        this.nbjours = nbjours;
        this.prix = prix;
        this.nomFichiers = nomFichiers;
        this.idCategorie = idCategorie;
    }

}

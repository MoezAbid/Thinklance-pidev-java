/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.entities;

import javafx.scene.control.CheckBox;

/**
 *
 * @author LENOVO
 */
public class Tache {
    private int id;
    private String nomTache;
    private String etatTache;
    private String typeTache;
    private String estimationTache;
    private int prioriteTache;
    private int idProjet;
    private CheckBox ch;

    public Tache(String nomTache, String etatTache, String typeTache, String estimationTache, int prioriteTache) {
        this.nomTache = nomTache;
        this.etatTache = etatTache;
        this.typeTache = typeTache;
        this.estimationTache = estimationTache;
        this.prioriteTache = prioriteTache;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public String getEtatTache() {
        return etatTache;
    }

    public void setEtatTache(String etatTache) {
        this.etatTache = etatTache;
    }

    public String getTypeTache() {
        return typeTache;
    }

    public void setTypeTache(String typeTache) {
        this.typeTache = typeTache;
    }

    public String getEstimationTache() {
        return estimationTache;
    }

    public void setEstimationTache(String estimationTache) {
        this.estimationTache = estimationTache;
    }

    public int getPrioriteTache() {
        return prioriteTache;
    }

    public void setPrioriteTache(int prioriteTache) {
        this.prioriteTache = prioriteTache;
    }

   

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public Tache() {
    }

    public Tache(int id, String nomTache, String etatTache, String typeTache, String estimationTache, int prioriteTache, int idProjet) {
        this.id = id;
        this.nomTache = nomTache;
        this.etatTache = etatTache;
        this.typeTache = typeTache;
        this.estimationTache = estimationTache;
        this.prioriteTache = prioriteTache;
        this.idProjet = idProjet;
    }

    @Override
    public String toString() {
        return "Tache{" + "id=" + id + ", nomTache=" + nomTache + ", etatTache=" + etatTache + ", typeTache=" + typeTache + ", estimationTache=" + estimationTache + ", prioriteTache=" + prioriteTache + ", idProjet=" + idProjet + '}';
    }

    public Tache(String nomTache, String etatTache) {
        this.nomTache = nomTache;
        this.etatTache = etatTache;
    }
    
    
    
}

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
public class CategorieProjet {
    
     private int id;
    private String titreCategorie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitreCategorie() {
        return titreCategorie;
    }

    public void setTitreCategorie(String titreCategorie) {
        this.titreCategorie = titreCategorie;
    }

    public CategorieProjet() {
    }

    public CategorieProjet(int id, String titreCategorie) {
        this.id = id;
        this.titreCategorie = titreCategorie;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", titreCategorie=" + titreCategorie + '}';
    }
    
    
    
    
}

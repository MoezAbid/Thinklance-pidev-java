/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.service.Interfaces;

import com.thinklance.pidev.entities.Projet;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public interface Iprojet {
    public void addProjet(Projet p);
    public void modifProjet(Projet p, int id);
    public void deleteProjet(Projet p);
    public ObservableList getAllProjets();
    public Projet getProjetParId(int id);
   
    
    
}

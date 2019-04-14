/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.service.Interfaces;

import com.thinklance.pidev.entities.Demande;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public interface IDemande {
     public void addDemande (Demande p);
    public void modifDemande (Demande p, int id);
    public void deleteDemande (Demande p);
    public ObservableList getAllDemande ();
    public ObservableList getDemandeParId(int id);
}

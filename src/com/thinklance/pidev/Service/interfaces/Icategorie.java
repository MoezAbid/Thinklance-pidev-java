/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.service.Interfaces;

import com.thinklance.pidev.entities.CategorieProjet;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public interface Icategorie {
    public void addCategorie(CategorieProjet p);
    public void modifCategorie(CategorieProjet p);
    public void deleteCategorie(CategorieProjet p);
    public ObservableList getAllCategorie();
    public CategorieProjet getCategorieParId(int id);
    
}

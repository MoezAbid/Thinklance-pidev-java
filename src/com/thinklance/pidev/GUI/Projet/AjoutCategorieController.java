/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;


import com.thinklance.pidev.entities.CategorieProjet;
import com.jfoenix.controls.JFXTextField;
import com.thinklance.pidev.Service.Impl.CategorieProjetService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjoutCategorieController implements Initializable {

    @FXML
    private JFXTextField nomcategorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutCategorie(MouseEvent event) {
        
        CategorieProjetService cat = new CategorieProjetService();
        CategorieProjet categorie= new CategorieProjet();
        categorie.setTitreCategorie(nomcategorie.getText());
        cat.addCategorie(categorie);
    }
    
}

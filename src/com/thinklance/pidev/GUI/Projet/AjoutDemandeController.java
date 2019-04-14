/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjoutDemandeController implements Initializable {

    @FXML
    private JFXTextField freelancer;
    @FXML
    private JFXTextField dateDemande;
    @FXML
    private JFXTextField employeur;
    @FXML
    private JFXTextField projet;
    @FXML
    private JFXButton btndemande;
    @FXML
    private JFXCheckBox etatDemande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutDemande(ActionEvent event) {
    }
    
}

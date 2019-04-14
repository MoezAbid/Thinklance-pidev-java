/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author danml
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane holderPane;

    @FXML
    private JFXButton btnContacts;
   
    @FXML
    private JFXButton btnAlerts;
    
    AnchorPane contacts,alerts;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load all fxmls in a cache
        try {
             contacts = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/ListeProjet.fxml"));
            alerts = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/ListDemande.fxml"));
            // pricing = FXMLLoader.load(getClass().getResource("Pricing.fxml"));
           //  profiles = FXMLLoader.load(getClass().getResource("Profiles.fxml"));
           //  widgets = FXMLLoader.load(getClass().getResource("Widgets.fxml"));
            // controls = FXMLLoader.load(getClass().getResource("Controls.fxml"));
        //    setNode(pricing);
        } catch (IOException ex) {
            
        }

    }

    //Set selected node to a content holder
    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }


    @FXML
    private void switchContacts(ActionEvent event) {
        setNode(contacts);
    }


    @FXML
    private void switchAlert(ActionEvent event) {
       setNode(alerts);
    }


}

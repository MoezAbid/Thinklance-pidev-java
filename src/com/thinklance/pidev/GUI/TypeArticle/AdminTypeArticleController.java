/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.TypeArticle;

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
public class AdminTypeArticleController implements Initializable {

    @FXML
    private AnchorPane holderPane;

    @FXML
    private JFXButton btnPricing;

    @FXML
    private JFXButton btnWidgets;
    AnchorPane paiements, typeArticles, ajouterTypeArticle;

    @FXML
    private JFXButton btnControls;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load all fxmls in a cache
        try {
            paiements = FXMLLoader.load(getClass().getResource("Pricing.fxml"));
            typeArticles = FXMLLoader.load(getClass().getResource("ListeTypesArticles.fxml"));
            ajouterTypeArticle = FXMLLoader.load(getClass().getResource("AjouterTypeArticle.fxml"));
            setNode(paiements);
        } catch (IOException ex) {
            Logger.getLogger(AdminTypeArticleController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void switchPaiements(ActionEvent event) {
        setNode(paiements);
    }

    @FXML
    public void switchTypesArticles() {
        setNode(typeArticles);
    }

    public void switchAjouterTypeArticle() {
        setNode(ajouterTypeArticle);
    }
}

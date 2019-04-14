/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.TypeArticle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.thinklance.pidev.Service.Impl.TypeArticleService;

import com.thinklance.pidev.entities.TypeArticle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Moez
 */
public class AjouterTypeArticleController implements Initializable {

    @FXML
    private JFXTextField nomTypeArticle;
    @FXML
    private JFXButton btnAjouter;
    @FXML
    private JFXButton btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouterArticle() {
        String nomTypeArticle = this.nomTypeArticle.getText();
        if (nomTypeArticle.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec de l'opération");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier les champs saisis, ils doivent être remplis.");
            alert.show();
        } else {
            TypeArticle nouveauTypeArticle = new TypeArticle(nomTypeArticle);
            TypeArticleService typeArticleDAO = new TypeArticleService();
            typeArticleDAO.ajouterTypeArticle(nouveauTypeArticle);
        }
    }

}

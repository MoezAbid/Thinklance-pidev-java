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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author Moez
 */
public class ModifierTypeArticleController implements Initializable {

    private TypeArticleService tArtServ = new TypeArticleService();

    @FXML
    private JFXTextField nomTypeArticle;
    @FXML
    private JFXButton btnModifier;

    private int IdancienTypeArticle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void modifierArticle(ActionEvent event) {
        if (nomTypeArticle.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec de l'opération");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier les champs saisis, ils doivent être remplis.");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Modification du type d'article");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir mettre à jour ce type d'article ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (!result.isPresent()) {
                Alert alertRien = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Type d'article non modifié");
                alert.setHeaderText(null);
                alert.setContentText("Le type d'article n'a pas été mis à jour.");
            } else if (result.get() == ButtonType.OK) {
                TypeArticle typeArticleModifie = new TypeArticle(nomTypeArticle.getText());
                tArtServ.modifierTypeArticle(this.IdancienTypeArticle, typeArticleModifie);
            } else if (result.get() == ButtonType.CANCEL) {
                Alert alertRien = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Type d'article non modifié");
                alert.setHeaderText(null);
                alert.setContentText("Le Type d'article n'a pas été mis à jour.");
            }
        }
    }

    public JFXTextField getNomTypeArticle() {
        return nomTypeArticle;
    }

    public void setNomTypeArticle(String nomTypeArticle) {
        this.nomTypeArticle.setText(nomTypeArticle);
    }

    public int getIdancienTypeArticle() {
        return IdancienTypeArticle;
    }

    public void setIdancienTypeArticle(int IdancienTypeArticle) {
        this.IdancienTypeArticle = IdancienTypeArticle;
    }

}

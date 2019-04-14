/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Articles;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.thinklance.pidev.Service.Impl.TypeArticleService;

import com.thinklance.pidev.Utils.MoezUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Moez
 */
public class AfficherArticleController implements Initializable {

    @FXML
    private ImageView imageArticle;
    @FXML
    private Label dateLabel;
    @FXML
    private Label utilisateurLabel;
    @FXML
    private JFXButton btnRetour;
    @FXML
    private Label titreLabel;
    @FXML
    private JFXTextArea texteArticle;
    @FXML
    private Label typeArticle;
    private TypeArticleService tarServ = new TypeArticleService();
    private int idAuteur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void retournerVersListeArticles(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeArticles.fxml"));
            Parent root = loader.load();
            ListeArticlesController icrl = loader.getController();
            titreLabel.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListeArticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ImageView getImageArticle() {
        return imageArticle;
    }

    public void setImageArticle(String imageArticleUri) {
        File file = new File(imageArticleUri);
        Image image = new Image(imageArticleUri);
        this.imageArticle.setImage(image);
    }

    public Label getDateLabel() {
        return dateLabel;
    }

    public void setDateLabel(String dateLabel) {
        try {
            DateFormat dfm = new SimpleDateFormat("yyyy-mm-dd HH:mm");
            this.dateLabel.setText("A : " + dfm.parse(dateLabel).toString() + " écrit par : ");
        } catch (ParseException ex) {
            Logger.getLogger(AfficherArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Label getUtilisateurLabel() {
        return utilisateurLabel;
    }

    public void setUtilisateurLabel(int userId) {
        this.idAuteur = userId;
        MoezUtils mu = new MoezUtils();
        String nomAuteur = mu.getNomUserForArticles(userId);
        this.utilisateurLabel.setText(nomAuteur);
    }

    public JFXButton getBtnRetour() {
        return btnRetour;
    }

    public void setBtnRetour(JFXButton btnRetour) {
        this.btnRetour = btnRetour;
    }

    public Label getTitreLabel() {
        return titreLabel;
    }

    public void setTitreLabel(String titreLabel) {
        this.titreLabel.setText(titreLabel);
    }

    public void setTexteArticle(String texteArticle) {
        this.texteArticle.setText(texteArticle);
    }

    public Label getTypeArticle() {
        return typeArticle;
    }

    public void setTypeArticle(int typeArticle) {
        this.typeArticle.setText(tarServ.getNomTypeArticle(typeArticle));
        switch (typeArticle % 2) {
            case 0:
                this.typeArticle.setStyle("-fx-background-color: #4286f4; -fx-text-fill: white;");
                break;
            case 1:
                this.typeArticle.setStyle("-fx-background-color: #b755fc; -fx-text-fill: white;");
                break;
            default:
                break;
        }
    }

    @FXML
    private void naviguerVersProfilAuteur(MouseEvent event) {
        //Navigation vers le profil de l'auteur
        System.out.println("Navigation vers : profile/" + this.idAuteur);
    }
}

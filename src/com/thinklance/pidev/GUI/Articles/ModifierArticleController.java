/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Articles;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.thinklance.pidev.Service.Impl.ArticleService;
import com.thinklance.pidev.Service.Impl.TypeArticleService;

import com.thinklance.pidev.entities.Article;
import com.thinklance.pidev.entities.TypeArticle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Moez
 */
public class ModifierArticleController implements Initializable {
    
    ArticleService articleDAO = new ArticleService();
    TypeArticleService tArServ = new TypeArticleService();
    
    @FXML
    private TextField titreTextField;
    @FXML
    private TextField typeArticleTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextArea texteTextField;
    @FXML
    private Button btnModifier;
    private int ancienArticleId;
    @FXML
    private JFXButton btnRetour;
    @FXML
    private JFXButton btnPhoto;
    private String photoArticleUrl;
    @FXML
    private JFXComboBox<String> idTypeArticleComboBox;
    private int idTypeArticle = 1;
    @FXML
    private ImageView previewPhotoArticle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idTypeArticleComboBox.setItems(tArServ.getListeNomsTypesArticles());
    }
    
    @FXML
    private void modifierArticle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Modification de l'article");
        alert.setHeaderText(null);
        alert.setContentText("Êtes-vous sûr de vouloir mettre à jour cet article ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (!result.isPresent()) {
            Alert alertRien = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Article non modifié");
            alert.setHeaderText(null);
            alert.setContentText("L'article n'a pas été mis à jour.");
        } else if (result.get() == ButtonType.OK) {
            Article articleModifie = new Article(0, this.ancienArticleId, titreTextField.getText(), descriptionTextField.getText(), new Date(), texteTextField.getText(), this.photoArticleUrl, this.idTypeArticle);
            articleDAO.modifierArticle(this.ancienArticleId, articleModifie);
            retourVersListe();
        } else if (result.get() == ButtonType.CANCEL) {
            Alert alertRien = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Article non modifié");
            alert.setHeaderText(null);
            alert.setContentText("L'article n'a pas été mis à jour.");
        }
    }
    
    public int getAncienArticleId() {
        return ancienArticleId;
    }
    
    public void setAncienArticleId(int ancienArticleId) {
        this.ancienArticleId = ancienArticleId;
    }
    
    public TextField getTitreTextField() {
        return titreTextField;
    }
    
    public void setTitreTextField(String titreTextField) {
        this.titreTextField.setText(titreTextField);
    }
    
    public TextField getTypeArticleTextField() {
        return typeArticleTextField;
    }
    
    public void setTypeArticleTextField(int typeArticleTextField) {
        this.typeArticleTextField.setText(Integer.toString(typeArticleTextField));
    }
    
    public TextField getDescriptionTextField() {
        return descriptionTextField;
    }
    
    public void setDescriptionTextField(String descriptionTextField) {
        this.descriptionTextField.setText(descriptionTextField);
    }
    
    public TextArea getTexteTextField() {
        return texteTextField;
    }
    
    public void setTexteTextField(String texteTextField) {
        this.texteTextField.setText(texteTextField);
    }
    
    @FXML
    private void retourVersListe() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MesArticles.fxml"));
            Parent root = loader.load();
            MesArticlesController icrl = loader.getController();
            texteTextField.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(MesArticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void openFileChooser(ActionEvent event) {
        FileChooser filechooser = new FileChooser();
        File file;
        Image img;
        Node node = (Node) event.getSource();
        file = filechooser.showOpenDialog(node.getScene().getWindow());
        if (file != null) {
            img = new Image(file.toURI().toString(), 100, 150, true, true);
            this.photoArticleUrl = file.toURI().toString();
            this.previewPhotoArticle.setImage(img);
        }
    }
    
    public String getPhotoArticleUrl() {
        return photoArticleUrl;
    }
    
    public void setPhotoArticleUrl(String photoArticleUrl) {
        this.photoArticleUrl = photoArticleUrl;
        previewPhotoArticle.setImage(new Image(photoArticleUrl));
    }
    
    @FXML
    private void comboBoxChanged(ActionEvent event) {
        ObservableList<TypeArticle> listeTypesArticles = tArServ.getListeTypesArticles();
        idTypeArticle = tArServ.getIdOfTypeArticle(idTypeArticleComboBox.getValue());
    }
    
    public int getIdTypeArticle() {
        return idTypeArticle;
    }
    
    public void setIdTypeArticle(int idTypeArticle) {
        this.idTypeArticle = idTypeArticle;
        this.idTypeArticleComboBox.getSelectionModel().select(tArServ.getNomTypeArticle(idTypeArticle));
    }
    
}

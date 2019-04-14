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
import com.thinklance.pidev.Service.Impl.UserService;
import com.thinklance.pidev.Utils.UserManager;

import com.thinklance.pidev.entities.Article;
import com.thinklance.pidev.entities.TypeArticle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.Label;
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
public class AjouterArticleController implements Initializable {

    TypeArticleService tArServ = new TypeArticleService();

    @FXML
    private TextField titreTextField;
    @FXML
    private TextArea texteTextField;
    @FXML
    private Button btnAjouter;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private Button btnPhoto;
    @FXML
    private Label lblAjoutArticle;
    @FXML
    private JFXButton btnRetour;
    private int idTypeArticle = 1;
    private String photoArticleUrl = "/com/thinklance/pidev/ressourses/ImageArticlePlaceHolder.png";
    @FXML
    private JFXComboBox<String> testComboBoxId;
    @FXML
    private ImageView photoArticlePreview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        testComboBoxId.setItems(tArServ.getListeNomsTypesArticles());
    }

    @FXML
    private void ajouterArticle(ActionEvent event) {
        String titre = titreTextField.getText();
        String description = descriptionTextField.getText();
        String texte = texteTextField.getText();

        if (titre.equals("") || description.equals("") || texte.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec de l'opération");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier les champs saisis, ils doivent être remplis.");
            alert.show();
        } else {
            UserService user = new UserService();
            UserManager um = new UserManager();
            
            Article nouvelArticle = new Article(0, user.getTheUserIdfromemail(um.getUserConnected()), titre, description, new Date(), texte, this.photoArticleUrl, this.idTypeArticle);
            ArticleService articleDAO = new ArticleService();
            articleDAO.ajouterArticle(nouvelArticle);
            retourVersListe();
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
            System.out.println(this.photoArticleUrl);
            this.photoArticlePreview.setImage(img);
        }
    }

    @FXML
    private void retourVersListe() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MesArticles.fxml"));
            Parent root = loader.load();
            MesArticlesController icrl = loader.getController();
            texteTextField.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(MesArticlesController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void choisirTypeArticle(ActionEvent event) {
        ObservableList<TypeArticle> listeTypesArticles = tArServ.getListeTypesArticles();
        idTypeArticle = tArServ.getIdOfTypeArticle(testComboBoxId.getValue());
    }

}

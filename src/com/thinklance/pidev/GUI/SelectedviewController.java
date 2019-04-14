/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.jfoenix.controls.JFXButton;
import com.thinklance.pidev.Service.Impl.CategorieService;
import com.thinklance.pidev.Service.Impl.UserService;
import com.thinklance.pidev.Utils.UserManager;
import com.thinklance.pidev.entities.CategorieProfile;
import com.thinklance.pidev.entities.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SelectedviewController implements Initializable {

    @FXML
    private VBox vboxcontent;
    private JFXButton enregistrer;
    @FXML
    private Label titre;
    List<String> listvalues = new ArrayList<String>();
    @FXML
    private JFXButton sortir;
    @FXML
    private JFXButton enregistrer1;
    @FXML
    private VBox vboxx;

    /**
     * Initializes the controller class.
     */
    public void setTitre(String titre) {
        this.titre.setText(titre);
    }

    public void setSortir(JFXButton sortir) {
        this.sortir = sortir;
    }

    public JFXButton getSortir() {
        return sortir;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void enregitrerchoix(ActionEvent event) {
        UserService user = new UserService();
        UserManager usermanager = new UserManager();
        User u = new User();
        CategorieService catservice = new CategorieService();

        for (String s : listvalues) {
            CategorieProfile cat = new CategorieProfile();
            cat.setId_user(user.getTheUserIdfromemail(usermanager.getUserConnected()));
            cat.setNom_categorie(titre.getText());
            cat.setSous_categorie(s);
            catservice.addCategorie(cat);
        }

    }

    public VBox getVboxcontent() {
        return vboxcontent;
    }

    public JFXButton getEnregistrer() {
        return enregistrer;
    }

    public Label getTitre() {
        return titre;
    }

    public void setVboxcontent(VBox vboxcontent) {
        this.vboxcontent = vboxcontent;
    }

    public void setEnregistrer(JFXButton enregistrer) {
        this.enregistrer = enregistrer;
    }

    public void setListvalues(List<String> listvalues) {
        this.listvalues = listvalues;
    }

    public List<String> getListvalues() {
        return listvalues;
    }

    @FXML
    private void sortir(ActionEvent event) {
        CreateProfileController.jfxdialog.close();
    }

}

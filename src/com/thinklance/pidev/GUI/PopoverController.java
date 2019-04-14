/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.jfoenix.controls.JFXButton;
import com.thinklance.pidev.App.Launcher;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PopoverController implements Initializable {

    @FXML
    private VBox options;
    @FXML
    private JFXButton myprofile;
    @FXML
    private JFXButton create_profile;
    @FXML
    private JFXButton parametres;
    @FXML
    private JFXButton logout;

    /**
     * Initializes the controller class.
     */
    public static PopoverController ctrl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ctrl = this;
    }

    @FXML
    private void viewMyProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Profiles.fxml"));
//        Parent root = loader.getController();
        Parent calcRoot = loader.load();
        Scene showCalc = new Scene(calcRoot);
        Stage paranullCalc = new Stage();
        paranullCalc.setScene(showCalc);
        paranullCalc.show();
    


    }

    @FXML
    private void createProfile(ActionEvent event) {
    }

    @FXML
    private void parametersCompte(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {

    }

}

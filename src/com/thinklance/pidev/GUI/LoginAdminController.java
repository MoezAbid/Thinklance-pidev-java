/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.thinklance.pidev.Service.Impl.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class LoginAdminController implements Initializable {

    @FXML
    private AnchorPane anchorMere;
    @FXML
    private JFXTextField emailAdmin;
    @FXML
    private JFXPasswordField passAdmin;
    @FXML
    private Label forgotpassword;
    @FXML
    private JFXButton loginAdmin;
    @FXML
    private Label erreurLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(emailAdmin.getText());

        
        if (!emailAdmin.getText().isEmpty() && m.find() && m.group().equals(emailAdmin.getText())) {
            emailAdmin.getStyleClass().remove("alert-danger");
            emailAdmin.setTooltip(null);

        } else {
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisir un email valide!");
            emailAdmin.getValidators().add(validator);

            emailAdmin.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        emailAdmin.validate();
                    }
                }
            });

        }
        if (!passAdmin.getText().isEmpty()) {
            passAdmin.getStyleClass().remove("alert-danger");
            passAdmin.setTooltip(null);

        } else {
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisir un mot de passe valide!");
            passAdmin.getValidators().add(validator);

            passAdmin.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        passAdmin.validate();
                    }
                }
            });
        }
    }    

    @FXML
    private void forgotpass(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("PasswordForgotten.fxml"));

        Timeline timeline = new Timeline();
        KeyValue keyvalue = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame keyframe = new KeyFrame(Duration.seconds(2), keyvalue);

        anchorMere.getChildren().add(root);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event5) {

                anchorMere.getChildren().remove(anchorMere);

            }
        });
    }

    @FXML
    private void loginemployeur(MouseEvent event) {
        UserService userDAO = new UserService();
        switch (userDAO.authentification(emailAdmin.getText(), passAdmin.getText(), "ADMIN")) {
            case 1:
                erreurLabel.setText("Ce compte n'existe pas ou bien vous n'êtes pas un admin");
                System.out.println(userDAO.authentification(emailAdmin.getText(), passAdmin.getText(), "ADMIN"));
                break;
            case 3:
                erreurLabel.setText("Mot de passe incorrect");
                System.out.println(userDAO.authentification(emailAdmin.getText(), passAdmin.getText(), "ADMIN"));
                break;
            case 4:
                erreurLabel.setText("je suis un ADMIN");
//        Launcher l=new Launcher();
//        l.navigatepages("AccueilFreelancer.fxml");
                System.out.println("je suis un ADMIN");

                break;
        }
    }
    
}

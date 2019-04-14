/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.thinklance.pidev.Service.Impl.UserService;
import com.thinklance.pidev.entities.User;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.thinklance.pidev.Utils.Section;
import com.thinklance.pidev.Utils.SectionManager;
import com.thinklance.pidev.Utils.UserManager;
import com.thinklance.pidev.Service.Impl.EmailService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class InscriptionController implements Initializable {

    private int verifData = 0;
    @FXML
    private AnchorPane anchorMere;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXTextField emailText;
    @FXML
    private JFXPasswordField passwordText;
    @FXML
    private JFXButton btn_signUp;
    @FXML
    private JFXPasswordField passwordVerifText;
    @FXML
    private JFXTextField nomText;
    @FXML
    private JFXTextField prenomText;
    @FXML
    private JFXRadioButton roleEmployeur;
    @FXML
    private JFXRadioButton roleFreelancer;
    @FXML
    private Label labelStatus;
    @FXML
    private Label lblLogin;

    ToggleGroup groupe = new ToggleGroup();
    String role = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(emailText.getText());

        roleEmployeur.setToggleGroup(groupe);
        roleFreelancer.setToggleGroup(groupe);
        if (roleEmployeur.isSelected()) {
            role = "EMPLOYEUR";

        }
        if (roleFreelancer.isSelected()) {
            role = "FREELANCER";

        }

        if (!nomText.getText().isEmpty()) {
            nomText.getStyleClass().remove("alert-danger");
            nomText.setTooltip(null);
        } else {
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisir un nom valide!");
            nomText.getValidators().add(validator);
            System.out.println("oui");

            nomText.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        System.out.println("non");
                        nomText.validate();
                    }
                }
            });
        }
        if (!prenomText.getText().isEmpty()) {
            prenomText.getStyleClass().remove("alert-danger");
            prenomText.setTooltip(null);

        } else {
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisir un Pénom valide!");
            prenomText.getValidators().add(validator);

            prenomText.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        prenomText.validate();
                    }
                }
            });
        }
        if (!emailText.getText().isEmpty() && m.find() && m.group().equals(emailText.getText())) {
            emailText.getStyleClass().remove("alert-danger");
            emailText.setTooltip(null);

        } else {
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisir un email valide!");
            emailText.getValidators().add(validator);

            emailText.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        emailText.validate();
                    }
                }
            });

        }
        if (!passwordText.getText().isEmpty()) {
            passwordText.getStyleClass().remove("alert-danger");
            passwordText.setTooltip(null);

        } else {
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisir un mot de passe valide!");
            passwordText.getValidators().add(validator);

            passwordText.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        passwordText.validate();
                    }
                }
            });
        }

        if ((passwordVerifText.getText().equals(passwordText.getText()) == true) && !passwordVerifText.getText().isEmpty()) {
            passwordVerifText.getStyleClass().remove("alert-danger");
            passwordVerifText.setTooltip(null);
        } else {
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Les mots de passe ne correspondent pas!");
            passwordVerifText.getValidators().add(validator);

            passwordVerifText.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        passwordVerifText.validate();
                    }
                }
            });
        }

    }

    public boolean verifDataEntered(KeyEvent event) {


        return true;
    }

    public boolean verifDataEntered() {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(emailText.getText());
        boolean result;
        if (!nomText.getText().isEmpty()) {
            if (!prenomText.getText().isEmpty()) {
                if (!emailText.getText().isEmpty() && m.find() && m.group().equals(emailText.getText())) {
                    if (!passwordText.getText().isEmpty()) {
                        if ( (passwordVerifText.getText().equals(passwordText.getText()) == true) && !passwordVerifText.getText().isEmpty()) {
                                result= true ;
                        } else {
                           result=  false;
                        }
                    } else {
                        result=  false;
                    }
                } else {
                    result=  false;
                }
            } else {
                result=  false;
            }
        } else {
            result=  false;
        }
        return result;
      

    }
 @FXML
    private void createaccount(MouseEvent event) {
        User user = new User();
        System.out.println("aaaaaaaaa"+verifDataEntered());
        if (verifDataEntered()) {
            labelStatus.setText("Votre compte est créer merci de valider votre compte par email");
            labelStatus.getStyleClass().remove("alert-danger");
            labelStatus.getStyleClass().add("alert-success");
            btn_signUp.setDisable(false);
            UserService userDAO = new UserService();
            Section section = new Section(true,emailText.getText());
            SectionManager.save(section);
            user.setNom(nomText.getText());
            user.setPrenom(prenomText.getText());
            user.setEmail(emailText.getText());
            user.setPassword(passwordText.getText());
            user.setRoles(role);
            UserManager.save(user);
            if (userDAO.addUser(user, emailText.getText())) {
                EmailService em = new EmailService();
                try {
                    em.SendConfirmationEmail(user);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                labelStatus.setText("Ce compte existe Déja!");
                labelStatus.getStyleClass().add("alert-danger");

                //
            }
        } else {
            labelStatus.setText("Verifiez les données saisies!");
            labelStatus.getStyleClass().add("alert-danger");

        }

    }

    @FXML
    private void login(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Timeline timeline = new Timeline();
        KeyValue keyvalue = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame keyframe = new KeyFrame(Duration.seconds(2), keyvalue);

        anchorMere.getChildren().add(root);
        timeline.getKeyFrames().add(keyframe);
        timeline.play();
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event5) {
                anchorMere.getChildren().remove(anchorPane);

            }
        });
    }

   


}

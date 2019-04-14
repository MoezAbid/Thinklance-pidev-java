/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.thinklance.pidev.Utils.Section;
import com.thinklance.pidev.Utils.SectionManager;
import com.thinklance.pidev.Service.Impl.UserService;
import java.io.IOException;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class LoginController implements Initializable {

    @FXML
    private TabPane tabPaneLogin;
    @FXML
    private Tab tabFreeLancer;
    @FXML
    private Tab tabCompany;
    @FXML
    private Label lblCreateAccount;
    @FXML
    private Pane slidingPane;
    @FXML
    private Label lblFreeLancer;
    @FXML
    private Label lblCompany;
    @FXML
    private Label lblStatus;

    private AnchorPane anchorPane;
    @FXML
    private AnchorPane anchorMere;
    @FXML
    private JFXTextField emailfreelancer;
    @FXML
    private JFXPasswordField passfreelancer;
    @FXML
    private JFXButton loginfreelancer;
    @FXML
    private JFXTextField emailemployeur;
    @FXML
    private JFXPasswordField passemployeur;
    @FXML
    private JFXButton loginemployeur;
    @FXML
    private Label erreurLabel;
    @FXML
    private Label forgotpassword;
    @FXML
    private Label lblAdmin;
    @FXML
    private JFXButton loginFacebook;
    @FXML
    private Label forgotpassword1;
    @FXML
    private JFXButton loginFacebook1;
    private ImageView logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void openFreeLancerTab(MouseEvent event) {
        TranslateTransition toLeftAnimation = new TranslateTransition(new Duration(500), lblStatus);
        toLeftAnimation.setToX(slidingPane.getTranslateX());
        toLeftAnimation.play();
        toLeftAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblStatus.setText("FREELANCER");
            }
        });

        tabPaneLogin.getSelectionModel().select(tabFreeLancer);
    }

    @FXML
    private void openCompanyTab(MouseEvent event) {
        TranslateTransition toRightAnimation = new TranslateTransition(new Duration(500), lblStatus);
        toRightAnimation.setToX(slidingPane.getTranslateX() - (slidingPane.getPrefHeight() - lblStatus.getPrefWidth() - 20));
        toRightAnimation.play();
        toRightAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblStatus.setText("EMPLOYEUR");
            }
        });
        tabPaneLogin.getSelectionModel().select(tabCompany);

    }

    @FXML
    private void createaccount(MouseEvent event1) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));

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

    @FXML
    private void loginfreelancer(MouseEvent event) throws IOException {

        UserService userDAO = new UserService();

        switch (userDAO.authentification(emailfreelancer.getText(), passfreelancer.getText(), "FREELANCER")) {
            case 1:
                erreurLabel.setText("Ce compte n'existe pas ou bien vous n'êtes pas un freelancer");
                System.out.println(userDAO.authentification(emailfreelancer.getText(), passfreelancer.getText(), "FREELANCER"));
                break;
            case 2:
                erreurLabel.setText("Votre compte n'est pas activé");
                System.out.println(userDAO.authentification(emailfreelancer.getText(), passfreelancer.getText(), "FREELANCER"));
                break;
            case 3:
                erreurLabel.setText("Mot de passe incorrect");
                System.out.println(userDAO.authentification(emailfreelancer.getText(), passfreelancer.getText(), "FREELANCER"));
                break;
            case 4:
                Section section = new Section();
                section.setLogged(true);
                section.setUserLogged(this.emailfreelancer.getText());
                SectionManager.save(section);
                redirect("AccueilFreelancer.fxml");

                break;

        }

    }

    @FXML
    private void loginemployeur(MouseEvent event) throws IOException {
        UserService userDAO = new UserService();
        switch (userDAO.authentification(emailemployeur.getText(), passemployeur.getText(), "EMPLOYEUR")) {
            case 1:
                erreurLabel.setText("Ce compte n'existe pas ou bien vous n'êtes pas un employeur");
                System.out.println(userDAO.authentification(emailemployeur.getText(), passemployeur.getText(), "EMPLOYEUR"));
                break;
            case 2:
                erreurLabel.setText("Votre compte n'est pas activé");
                System.out.println(userDAO.authentification(emailemployeur.getText(), passemployeur.getText(), "EMPLOYEUR"));
                break;
            case 3:
                erreurLabel.setText("Mot de passe incorrect");
                System.out.println(userDAO.authentification(emailemployeur.getText(), passemployeur.getText(), "EMPLOYEUR"));
                break;
            case 4:
                Section section = new Section();
                section.setLogged(true);
                section.setUserLogged(this.emailemployeur.getText());
                SectionManager.save(section);
                redirect("AccueilFreelancer.fxml");

                break;
        }
    }

    private void redirect(String page) throws IOException {

        loginemployeur.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
//        Parent root = loader.getController();
        Parent calcRoot = loader.load();
        Scene showCalc = new Scene(calcRoot);
        Stage paranullCalc = new Stage();
        paranullCalc.setScene(showCalc);
        paranullCalc.show();
//        Parent root = FXMLLoader.load(getClass().getResource(page));
//
//        Timeline timeline = new Timeline();
//        KeyValue keyvalue = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
//        KeyFrame keyframe = new KeyFrame(Duration.seconds(2), keyvalue);
//
//        anchorMere.getChildren().add(root);
//        timeline.getKeyFrames().add(keyframe);
//        timeline.play();
//        timeline.setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event5) {
//
//                anchorMere.getChildren().remove(anchorPane);
//
//            }
//        });
    }

    @FXML
    private void forgotpass(MouseEvent event) throws IOException {
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

                anchorMere.getChildren().remove(anchorPane);

            }
        });
    }

    @FXML
    private void loginAdmin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginAdmin.fxml"));

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

    @FXML
    private void connectUserfreelancer(ActionEvent event) throws IOException {
        String domain = "https://radixcode.com/";
        String redirect_url = "https://www.facebook.com";
        String app_id = "2269356866670329";
        String access_token = "EAAgP99HoDvkBAMEMuhStZAEYZAePhFOGgriKSn03ZAton1yfJF00YbyyjGLDtEq0fhxiqe2IXoS8THIZAfsiWZB5jTMhrJo4LdNhfOxD4ZCvtyJboe7sOMJKcoqOcbSSijhAqXWP7YYrrmZApnz8lvA0hCjZCxIePu7qzE8qlcLvDYaWZBTejp8TUiF7zPvM6mjTJTsqi8ruVCwZDZD";

        String fburl = "https://www.facebook.com/dialog/oauth?client_id=" + app_id + "&redirect_uri=" + domain;

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(fburl);
        String accessToken;
        while (true) {

            if (!driver.getCurrentUrl().contains("facebook.com")) {
                String url = driver.getCurrentUrl();
                accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");

                FacebookClient fbClient = new DefaultFacebookClient(access_token, Version.LATEST);

                User user = fbClient.fetchObject("me", User.class, Parameter.with("fields", "name,email,picture"));

                System.out.println(user.getPicture().getUrl());
                System.out.println(user);
                //driver.navigate().to(user.getPicture().getUrl());
                //fburl = user.getPicture().getUrl();
                user.getPicture().setHeight(600);
                user.getPicture().setWidth(600);
                driver.navigate().to(user.getPicture().getUrl());
                driver.navigate().to("https://radixcode.com/");
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver.quit();
                redirect("AccueilFreelancer.fxml");
                UserService userservice = new UserService();
                com.thinklance.pidev.entities.User uu = new com.thinklance.pidev.entities.User();
                uu.setNom(user.getName().substring(0, 9));
                uu.setPrenom(user.getName().substring(10, 15));
                uu.setEmail(user.getEmail());
                uu.setImage("E:\\téléchargement.jpg");
                uu.setRoles("FREELANCER");
                userservice.addUser(uu);
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("AccueilFreelancer.fxml"));
//                AccueilFreelancerController accueilfreelancer = (AccueilFreelancerController) loader.getController();
//                //accueilfreelancer.setUserName(user.getUsername());
//                accueilfreelancer.setAvatar("E:\\téléchargement.jpg");
//             
//                File file = new File("E:\\téléchargement.jpg");                
//                File f = new File("F:\\Desktop\\Esprit_3A\\Semestre22\\PIDEV\\JavaFX Pidev\\ThinkLance (2)\\src\\com\\thinklance\\pidev\\ressourses");
//                Files fi  ;
//                ////Files.copy(file.toPath(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
//                Image image = new Image(file.toURI().toString(), 100, 150, true, true);
                Section section = new Section();
                section.setLogged(true);
                section.setUserLogged(user.getEmail());
                SectionManager.save(section);

            }

        }

    }

    @FXML
    private void connectfacebookemployeur(ActionEvent event) throws IOException {
        String domain = "https://radixcode.com/";
        String redirect_url = "https://www.facebook.com";
        String app_id = "2269356866670329";
        String access_token = "EAAgP99HoDvkBADmaVZAwW5eWxQworEA2rqR1P5SvdIGgfgzoSKDWclIFhTA7VJFG9gSSKdhlfYVFUZAzZBtVALiOQEt2PEHHdEnAAXxs0DsEdHguaTVkHXODlywTIlc5LdU1rr0h5clN8GmXZC8G39W64x3djmh9ajQlkhQDslqBJS3UZBK9krePnNDmHepZByxosT3pzMSgZDZD";

        String fburl = "https://www.facebook.com/dialog/oauth?client_id=" + app_id + "&redirect_uri=" + domain;

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(fburl);
        String accessToken;
        while (true) {

            if (!driver.getCurrentUrl().contains("facebook.com")) {
                String url = driver.getCurrentUrl();
                accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");

                FacebookClient fbClient = new DefaultFacebookClient(access_token, Version.LATEST);

                User user = fbClient.fetchObject("me", User.class, Parameter.with("fields", "name,email,picture"));

                System.out.println(user.getPicture().getUrl());
                //driver.navigate().to(user.getPicture().getUrl());
                //fburl = user.getPicture().getUrl();
                user.getPicture().setHeight(600);
                user.getPicture().setWidth(600);
                driver.navigate().to(user.getPicture().getUrl());
                driver.navigate().to("https://radixcode.com/");
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                driver.close();
                redirect("AccueilFreelancer.fxml");
                UserService userservice = new UserService();
                com.thinklance.pidev.entities.User uu = new com.thinklance.pidev.entities.User();
                uu.setNom(user.getName().substring(0, 9));
                uu.setPrenom(user.getName().substring(10, 15));
                uu.setEmail(user.getEmail());
                uu.setImage("E:\\téléchargement.jpg");
                uu.setRoles("EMPLOYEUR");

                userservice.addUser(uu);
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("AccueilFreelancer.fxml"));
//                AccueilFreelancerController accueilfreelancer = (AccueilFreelancerController) loader.getController();
//                //accueilfreelancer.setUserName(user.getUsername());
//                accueilfreelancer.setAvatar("E:\\téléchargement.jpg");
//             
//                File file = new File("E:\\téléchargement.jpg");                
//                File f = new File("F:\\Desktop\\Esprit_3A\\Semestre22\\PIDEV\\JavaFX Pidev\\ThinkLance (2)\\src\\com\\thinklance\\pidev\\ressourses");
//                Files fi  ;
//                ////Files.copy(file.toPath(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
//                Image image = new Image(file.toURI().toString(), 100, 150, true, true);
                Section section = new Section();
                section.setLogged(true);
                section.setUserLogged(user.getEmail());
                SectionManager.save(section);

            }

        }
    }
}

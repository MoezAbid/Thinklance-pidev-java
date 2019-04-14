/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.gn.GNAvatarView;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.thinklance.pidev.Service.Impl.UserService;
import com.thinklance.pidev.Utils.UserManager;
import com.thinklance.pidev.entities.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AccueilFreelancerController implements Initializable {

    @FXML
    private JFXHamburger hamburger;
    @FXML
    private AnchorPane holderPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private VBox drawer1;
    @FXML
    private GNAvatarView avatar;
    @FXML
    private VBox info;
    @FXML
    private Circle cStatus;
    @FXML
    private Label status;
    @FXML
    private ToggleGroup group;
    @FXML
    private HBox searchBox;
    @FXML
    private TextField search;
    @FXML
    private Button clear;
    @FXML
    private SVGPath searchIcon;
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox views;
    @FXML
    private Button homeMenu;
    @FXML
    private TitledPane paymentMenu;
    @FXML
    private TitledPane appointmentMenu;
    @FXML
    private TitledPane charts;
    @FXML
    private Button about;
    private FileChooser filechooser = new FileChooser();
    private File file;
    private Image img;
    @FXML
    private Label UserName;
    @FXML
    private RadioButton dispo;
    @FXML
    private RadioButton occupé;
    @FXML
    private RadioButton absent;
    @FXML
    private TitledPane doctorMenu1;
    @FXML
    private Button Viewprofile;
    @FXML
    private Button createprofile;
    @FXML
    private Button about1;
    private AnchorPane welcome,listeArticles,listeMesArticles,listeDesActualites,listeDesPaiementsFreelancer,listeDesPaiementsEmployeur,statistiquesPaiementsFreelancer,statistiquesPaiementsEmployeur;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserService user = new UserService();
        UserManager um = new UserManager();
        User u = user.getInfoProfileUser(um.getUserConnected());
        UserName.setText(u.getNom() + " " + u.getPrenom());
        File file = new File("F:\\Desktop\\Esprit_3A\\Semestre22\\PIDEV\\JavaFX Pidev\\ThinkLance (2)\\src\\com\\thinklance\\pidev\\ressourses\\user.png");
        if (u.getImage() == null) {

            img = new Image(file.toURI().toString(), 100, 150, true, true);
            avatar.setImage(img);
        } else if (u.getImage() != null) {
            file = new File(u.getImage());

            img = new Image(file.toURI().toString(), 100, 150, true, true);
            avatar.setImage(img);

        }
        if (u.getDisponibilite() == 1) {
            status.setText("Disponible");

        } else if (u.getDisponibilite() == 0) {

            status.setText("Absent");
        } else {
            status.setText("Occupé");
        }

        //pour la disponibilité 
        if (dispo.isSelected()) {

            user.updateDisponibiliteUser(user.getTheUserIdfromemail(um.getUserConnected()), 1);

        }
        if (occupé.isSelected()) {

            user.updateDisponibiliteUser(user.getTheUserIdfromemail(um.getUserConnected()), 2);
        }

        if (absent.isSelected()) {

            user.updateDisponibiliteUser(user.getTheUserIdfromemail(um.getUserConnected()), 0);
        }
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                cStatus.setFill(((RadioButton) newValue).getTextFill());
                status.setText(((RadioButton) newValue).getText());
            }
        });
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            if (drawer.isOpened()) {
                drawer.close();
            } else {
                drawer.open();
            }

        });
        try {
//            //AnchorPane drawer1 = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/Drawer.fxml"));
//
//            AnchorPane doctorsPane = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/Inscription.fxml"));
//            //AnchorPane login = FXMLLoader.load(getClass().getResource(Routes.LOGINVIEW));
//            StackPane payments = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/CreateProfile.fxml"));
//            StackPane appointment = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/CreateProfile.fxml"));
            welcome = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/ListeFEP.fxml"));
            //Articles
             listeArticles = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/Articles/ListeArticles.fxml"));
             listeMesArticles = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/Articles/MesArticles.fxml"));
            //Actualites
             listeDesActualites = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/Actualites/AfficherActualites.fxml"));

            //Paiements
             listeDesPaiementsFreelancer = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/Paiements/ListePaiementsFreelancer.fxml"));
             listeDesPaiementsEmployeur = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/Paiements/ListePaiementsEmployeur.fxml"));
            //Statistiques Paiements
             statistiquesPaiementsFreelancer = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/StatistiquesPaiements/StatistiquesPaiementsFreelancer.fxml"));
             statistiquesPaiementsEmployeur = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/StatistiquesPaiements/StatistiquesPaiementsEmployeur.fxml"));

            setNode(welcome);
            drawer.open();
            drawer.setSidePane(drawer1);

            for (Node node : drawer1.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                        switch (node.getAccessibleText()) {
                            case "homeMenu":
                                drawer.close();
                                setNode(welcome);
                                break;
//                            case "doctorMenu":
//                                drawer.close();
//                                setNode(doctorsPane);
//                                break;
//                            case "paymentMenu":
//                                drawer.close();
//                                setNode(payments);
//                                break;
//                            case "appointmentMenu":
//                                drawer.close();
//                                setNode(appointment);
//                                break;
                        }
                    });
                }

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
    }

    @FXML
    private void clearText(MouseEvent event) {
    }

    @FXML
    private void dashboard(MouseEvent event) {
    }

    @FXML
    private void listerLesEvenements(ActionEvent event) {
    }

    @FXML
    private void setProfile(MouseEvent event) {
    }

    @FXML
    private void listerLesArticles(MouseEvent event) {
         setNode(listeArticles);
    }

    @FXML
    private void mesArticles(MouseEvent event) {
        setNode(listeMesArticles);
    }

    @FXML
    private void afficherActualites(MouseEvent event) {
         setNode(listeDesActualites);
    }

    @FXML
    private void navigateForum(MouseEvent event) {
    }

    @FXML
    private void navigateMessagerie(MouseEvent event) {
    }

    @FXML
    private void navigateMesPaiements(MouseEvent event) {

        UserService userser = new UserService();
        UserManager um = new UserManager();
        User u = userser.getInfoProfileUser(um.getUserConnected());
        if(u.getRoles().equals("FREELANCER")){
        
            setNode(listeDesPaiementsFreelancer);
        
        }else    if(u.getRoles().equals("EMPLOYEUR")){
            setNode(listeDesPaiementsEmployeur);
        
        }

    }

    @FXML
    private void navigateStatistiquePaiement(MouseEvent event) {
           UserService userser = new UserService();
        UserManager um = new UserManager();
        User u = userser.getInfoProfileUser(um.getUserConnected());
        if(u.getRoles().equals("FREELANCER")){
        
            setNode(statistiquesPaiementsFreelancer);
        
        }else    if(u.getRoles().equals("EMPLOYEUR")){
            setNode(statistiquesPaiementsEmployeur);
        
        }
    }

    @FXML
    private void navigatelistReclamation(MouseEvent event) {
    }

    @FXML
    private void navigateEffectuerReclamation(MouseEvent event) {
    }

    @FXML
    private void deconnexion(MouseEvent event) {
    }

}

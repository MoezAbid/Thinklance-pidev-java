/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.thinklance.pidev.Utils.Section;
import com.thinklance.pidev.Utils.UserManager;
import com.thinklance.pidev.Service.Impl.UserService;
import com.thinklance.pidev.entities.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProfileFreelancerEditController implements Initializable {

    @FXML
    private VBox pnl_scroll;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private Label lbl_pending;
    @FXML
    private Label lbl_completed;
    @FXML
    private ImageView image_profile;
    private Image image;
    private Section section;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserService u = new UserService();
        UserManager usermanager = new UserManager();
        String email = usermanager.getUserConnected();
        User myuser = u.getInfoProfileUser(email);

        File file=new File("F:\\Desktop\\Esprit_3A\\Semestre22\\PIDEV\\JavaFX Pidev\\ThinkLance (2)\\src\\com\\thinklance\\pidev\\ressourses\\user.png");
        if (myuser.getImage() == null) {
            
            image = new Image(file.toURI().toString(), 100, 150, true, true);
            image_profile.setImage(image);
        } else if(myuser.getImage()!=null) {
            file = new File(myuser.getImage());
       
            image = new Image(file.toURI().toString(), 100, 150, true, true);
            image_profile.setImage(image);

        }

        refreshNodes();
    }

    private void refreshNodes() {
        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[15];

        for (int i = 0; i < 1; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("InfoProfile.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {

    }

    @FXML
    private void open_informations(MouseEvent event) {
        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[15];

        for (int i = 0; i < 1; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("InfoProfile.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    @FXML
    private void open_competences(MouseEvent event) {
        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[15];

        for (int i = 0; i < 1; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("CompetenceEdit.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    @FXML
    private void open_formations(MouseEvent event) {

        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[15];

        for (int i = 0; i < 1; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("FormationsEdit.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    @FXML
    private void open_experiences(MouseEvent event) {

        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[15];

        for (int i = 0; i < 1; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("ExperienceEdit.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    @FXML
    private void open_portfolio(MouseEvent event) {

        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[15];

        for (int i = 0; i < 1; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("PortofolioEdit.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    @FXML
    private void open_langues(MouseEvent event) {
        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[15];

        for (int i = 0; i < 1; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("LanguesEdit.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

}

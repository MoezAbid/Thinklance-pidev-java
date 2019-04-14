/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.thinklance.pidev.Service.Impl.UserService;
import com.thinklance.pidev.entities.User;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class InfoProfileController implements Initializable {

    @FXML
    private JFXTextField titreprofil;
    @FXML
    private JFXButton btn_choisir;
    @FXML
    private ImageView image_profil;
    @FXML
    private JFXTextField ville;
    @FXML
    private JFXTextField pays;
    @FXML
    private JFXTextField tarif;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXButton btn_valider;
    private FileChooser filechooser = new FileChooser();
    private File file;
    private Image img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void select_image(MouseEvent event) {
        Node node = (Node) event.getSource();
     
            file = filechooser.showOpenDialog(node.getScene().getWindow());
            if (file != null) {

                img = new Image(file.toURI().toString(), 100, 150, true, true);
                image_profil.setImage(img);
                System.out.println(file.getAbsolutePath());
            }

      

    }

    @FXML
    private void valider_info(MouseEvent event) {
        UserService user=new UserService();
        User u=new User();
        u.setIdUser(5);
        u.setTitre_profile(titreprofil.getText());
        u.setPays(pays.getText());
        u.setVille(ville.getText());
        u.setTarif_moyen(Double.parseDouble(tarif.getText()) );
        u.setDescription(description.getText());
        u.setImage(file.getAbsolutePath());
        user.editProfileUser(u);
        
        
    }

}

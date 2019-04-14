/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import static com.thinklance.pidev.GUI.ProfileDescriptionController.jfxdialog;
import com.thinklance.pidev.Service.Impl.ExperienceService;
import com.thinklance.pidev.Service.Impl.FormationService;
import com.thinklance.pidev.entities.ExperienceProfessionnel;
import com.thinklance.pidev.entities.Formation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierExperienceController implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private JFXTextField titreexperience;
    @FXML
    private JFXTextArea descriptionexperience;
    @FXML
    private JFXDatePicker datedebutexperience;
    @FXML
    private JFXDatePicker datefinexperience;
    @FXML
    private JFXTextField entreprise;
    private int idd;

    private VBox vBox;
      public static JFXDialog jfxdialog;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void passvalue(int id) {
        idd = id;
        ExperienceService exp = new ExperienceService();
        ExperienceProfessionnel e = exp.getExperienceById(id);
        titreexperience.setText(e.getTitre_exp());
        descriptionexperience.setText(e.getDescription());
        datedebutexperience.setValue(this.fromDate((Date) e.getDatedebut()));
        datefinexperience.setValue(this.fromDate((Date) e.getDatefin()));
        entreprise.setText(e.getNom_entreprise());

    }

    @FXML
    private void valider_info_experience(MouseEvent event) {

        ExperienceService exp = new ExperienceService();
        ExperienceProfessionnel e = new ExperienceProfessionnel();
        e.setDatedebut(java.sql.Date.valueOf(datedebutexperience.getValue()));
        e.setDatefin(java.sql.Date.valueOf(datefinexperience.getValue()));
        e.setDescription(descriptionexperience.getText());
        e.setNom_entreprise(entreprise.getText());
        e.setTitre_exp(titreexperience.getText());
        e.setId(idd);
        exp.updateExperience(e);
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("ValidAlert.fxml"));
        try {
            // TODO
            vBox = loader.load();
            ValidAlertController profileviewcontroller = (ValidAlertController) loader.getController();
            profileviewcontroller.setPath("Profiles");
            System.out.println(profileviewcontroller);
            profileviewcontroller.setContent("L'expérience a été modifié avec succés!! ");
              profileviewcontroller.setWhichIsLastClicked(2);

        } catch (IOException ex) {
            Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
         jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
        jfxdialog.show();
    }


    @FXML
    private void supprimmer_formation(MouseEvent event) {
        ExperienceService exp = new ExperienceService();
        exp.deleteExperience(idd);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ValidAlert.fxml"));
        try {
            // TODO
            vBox = loader.load();
            ValidAlertController profileviewcontroller = (ValidAlertController) loader.getController();
            profileviewcontroller.setPath("Profiles");
            System.out.println(profileviewcontroller);
            profileviewcontroller.setContent("L'expérience a été supprimé avec succés!! ");
             profileviewcontroller.setWhichIsLastClicked(3);

        } catch (IOException ex) {
            Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
           jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
        jfxdialog.show();
        
        
        
        
        
    }

    public static LocalDate fromDate(Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
                .toLocalDate();
    }

    @FXML
    private void btn_valider(ActionEvent event) {
    }

}

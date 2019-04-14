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
import static com.thinklance.pidev.GUI.ModifierExperienceController.jfxdialog;
import com.thinklance.pidev.Service.Impl.FormationService;
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
public class ModifierFormationController implements Initializable {

    @FXML
    private JFXTextField titreformation;
    @FXML
    private JFXTextArea descriptionforma;
    @FXML
    private JFXDatePicker datedebutform;
    @FXML
    private JFXDatePicker datefinform;
    @FXML
    private JFXTextField institution;

    private int idd;
    @FXML
    private StackPane root;
      private VBox vBox;
           public static JFXDialog jfxdialog;


    /**
     * Initializes the controller class.
     */
    public void passvalue(int id) {
        idd=id;
        FormationService formser = new FormationService();
        Formation form = formser.getFormationById(id);
        titreformation.setText(form.getTitre());
        descriptionforma.setText(form.getDescription());
        datedebutform.setValue(this.fromDate((Date) form.getDatedebut()));
        datefinform.setValue(this.fromDate((Date) form.getDatefin()));
        institution.setText(form.getInstitution());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }

    @FXML
    private void valider_formations(MouseEvent event) {
         FormationService formationservice = new FormationService();
        Formation formation = new Formation();

        formation.setDatedebut(java.sql.Date.valueOf(datedebutform.getValue()));
        formation.setDatefin(java.sql.Date.valueOf(datefinform.getValue()));
        formation.setDescription(descriptionforma.getText());
        formation.setInstitution(institution.getText());
        formation.setTitre(titreformation.getText());
        formation.setId(idd);
        formationservice.updateFormation(formation);
             FXMLLoader loader = new FXMLLoader(getClass().getResource("ValidAlert.fxml"));
        try {
            // TODO
            vBox = loader.load();
            ValidAlertController profileviewcontroller = (ValidAlertController) loader.getController();
            profileviewcontroller.setPath("Profiles");
            System.out.println(profileviewcontroller);
            profileviewcontroller.setContent("La formation a été modifié avec succés!! ");

        } catch (IOException ex) {
            Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
       jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
        jfxdialog.show();
        
        
        
    }

    @FXML
    private void btn_valider(ActionEvent event) {
    }

    @FXML
    private void supprimmer_formation(MouseEvent event) {
             FormationService formationservice = new FormationService();
              formationservice.deleteFormation(idd);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ValidAlert.fxml"));
        try {
            // TODO
            vBox = loader.load();
            ValidAlertController profileviewcontroller = (ValidAlertController) loader.getController();
            profileviewcontroller.setPath("Profiles");
            System.out.println(profileviewcontroller);
            profileviewcontroller.setContent("La formation a été supprimé avec succés!! ");

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

}

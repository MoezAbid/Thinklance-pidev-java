/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;

import com.thinklance.pidev.entities.Projet;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ModifierProjetController implements Initializable {

    @FXML
    private Label lbid;
    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfdecription;
    @FXML
    private TextField tfnbjours;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tffile;
    @FXML
    private Button btnmodif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setValue(int id , String tftitre, String tfdecription, int tfnbjours, Double  tfprix, String tffile)
    { this.lbid.setText(""+id);
    this.tftitre.setText(tftitre);
    this.tfdecription.setText(tfdecription);
    this.tfnbjours.setText(""+tfnbjours);
    this.tfprix.setText(""+tfprix);
    this.tffile.setText(tffile);
    }

    @FXML
    private void modifProjet(ActionEvent event) {
    }
     public void setValueP(int id){
         this.lbid.setText(""+id);
     }
}

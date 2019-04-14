/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.thinklance.pidev.Service.Impl.TacheService;

import com.thinklance.pidev.entities.Tache;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjoutTacheController implements Initializable {

    @FXML
    private Label lbl;
    @FXML
    private JFXTextField nomTache;
    @FXML
    private JFXTextField typeTache;
    @FXML
    private JFXTextField estimationTache;
    @FXML
    private JFXTextField prioritéTache;
    @FXML
    private JFXButton btnt;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Tache tache = new Tache();
       
    }    
    public void setValue(int id,String titre)
    {
        this.lbl.setText(""+id);
    
    }
     Tache tache = new Tache();

    @FXML
    private void addTache(ActionEvent event) {
         TacheService tachdao = new TacheService();
   
      tache.setNomTache(nomTache.getText());
      tache.setTypeTache(typeTache.getText());
      tache.setEstimationTache(estimationTache.getText());
        int p=Integer.parseInt(prioritéTache.getText());
        tache.setIdProjet(Integer.parseInt(lbl.getText()));
        tache.setPrioriteTache(p);
       
        tachdao.addTache(tache);
        
    }
    
}

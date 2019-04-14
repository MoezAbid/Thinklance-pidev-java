/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.thinklance.pidev.Service.Impl.CategorieProjetService;
import com.thinklance.pidev.Service.Impl.ServiceProjet;


import com.thinklance.pidev.entities.Projet;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AjoutProjetController implements Initializable {

    @FXML
    private Button btn;
    private AnchorPane rootpane;
    @FXML
    private JFXTextArea description;
    @FXML
    private JFXTextField employeur;
    private JFXTextField freelancer;
    @FXML
    private JFXTextField titreProjet;
    @FXML
    private JFXTextField nbreJours;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextField idCategorie;
    @FXML
    private JFXTextField nomFichiers;
    @FXML
    private Button ajoutfichiers;
    @FXML
    private Label path;
    @FXML
    private ComboBox<String> ch;
    
    ObservableList<String> oblist;
    @FXML
    private JFXTextField nomcategorie;
// contenu textfield en scenebuild
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          CategorieProjetService pdao = new CategorieProjetService();
        oblist = pdao.getAllCategorie();
        System.out.println(oblist);
        ch.setItems(oblist);
    }    
    
    
    public void getCategorie()
    {
         CategorieProjetService pdao = new CategorieProjetService();
        oblist = pdao.getAllCategorie();
    
    }

    Projet projet = new Projet();
    int savedValue;
    
    private void addProjet(MouseEvent event) throws IOException {
        ServiceProjet proj = new ServiceProjet();
    int emp=Integer.parseInt(employeur.getText());
        System.out.println(emp+emp);
            int nbj=Integer.parseInt(nbreJours.getText());
        Double pr= Double.parseDouble(prix.getText());
        int idc = Integer.parseInt(idCategorie.getText());
      projet.setEmployeur(emp);
      projet.setNbjours(nbj);
      projet.setPrix(pr);
      projet.setFile(path.getText());
        projet.setTitreProjet(titreProjet.getText());
       projet.setDescription(description.getText());
       projet.setDescription(nomFichiers.getText());
      projet.setIdCategorie(idc);
        proj.addProjet(projet);
        
      
    }

    private void moveInterface(ActionEvent event) throws IOException {
        
          Stage stage = new Stage();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("com/thinklance/pidev/GUI/ListCategorie.fxml"));
        rootpane.getChildren().setAll(pane);
        
    }

    private void multiFileChooser(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("pdf files","*.pdf"));
        List<File> f =fc.showOpenMultipleDialog(null);
        for(File file  :f)
        {
            path.setText(file.getAbsolutePath());
            System.out.println(file.getAbsolutePath());
            
        }
    }
    
    
}

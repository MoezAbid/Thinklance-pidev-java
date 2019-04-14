/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;

//import com.Thinklance.pidev.dao.Impl.CategorieServicee;
//import com.Thinklance.pidev.entities.Categorie;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ListCategorieController implements Initializable{

    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> id_categorie;
    @FXML
    private TableColumn<?, ?> titre_categorie;
   // ArrayList<Categorie> l;
    /**
     * Initializes the controller class.
     */
  

    @FXML
    private void InterfaceAjoutCategorie(ActionEvent event) throws IOException {
        
     
          Stage stage = new Stage();
          Parent root1;
        
            root1 = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/AjoutCategorie.fxml"));
            
          stage.setResizable(false);
        stage.centerOnScreen();
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void interfaceCategorie(MouseEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id_categorie.setCellValueFactory(new PropertyValueFactory<>("id"));
         // id_categorie.setCellFactory(TextFieldTableCell.<Categorie> forTableColumn());
        id_categorie.setMinWidth(200);
    }
    
}

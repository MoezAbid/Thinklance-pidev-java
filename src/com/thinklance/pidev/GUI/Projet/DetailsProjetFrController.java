/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;


import com.thinklance.pidev.Service.Impl.TacheService;
import com.thinklance.pidev.entities.Tache;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class DetailsProjetFrController implements Initializable {

    @FXML
    private Label jours;
    @FXML
    private Label titreP;
    @FXML
    private Label prixP;
    @FXML
    private Label fichier;
    @FXML
    private Label description;
    @FXML
    private Label categorie;
    @FXML
    private TableView<Object> tableTache;
    @FXML
    private TableColumn<Tache,String> etat;
    @FXML
    private TableColumn<Tache,String> nom;
      ObservableList<Object> oblist;
      int i;
    @FXML
    private TextField c_id;
    int text;
    private TableColumn<Object,CheckBox> col_etat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
      
    }    
    
    public void setValue(String t,int t2, Double t3, int t4, String t5,String t6,int id){
    this.titreP.setText(t);
    this.categorie.setText(t2+"");
    this.prixP.setText(""+t3);
    this.jours.setText(t4+"");
    this.description.setText(t5+"");
    this.fichier.setText(t6);
        this.c_id.setText(String.valueOf(id));
        
         TacheService pdao = new TacheService();
        oblist = pdao.getTacheParId(id);
        System.out.println(String.valueOf(c_id));
        
         nom.setCellValueFactory(new PropertyValueFactory<Tache, String>("nomTache"));
        etat.setCellValueFactory(new PropertyValueFactory<Tache, String>("etatTache"));
        col_etat = new TableColumn("Etat tâche");
        //col_etat.setCellFactory(new CheckBox("ch"));
        
                
        tableTache.getColumns().add(col_etat);
        tableTache.setItems(oblist);
        
    
    }

    public TextField getC_id() {
        return c_id;
    }

    public void setC_id(TextField c_id) {
        this.c_id = c_id;
    }

    public void affiche(){
        System.out.println(c_id.getText());
    }
}

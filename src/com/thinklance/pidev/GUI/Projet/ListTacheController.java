/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;


import com.thinklance.pidev.Service.Impl.TacheService;
import com.thinklance.pidev.entities.Tache;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ListTacheController implements Initializable {
    
    @FXML
    private Label codeProjet;
    @FXML
    private TableView<Tache> tableTache;
    @FXML
    private TableColumn<Tache, String> c_nonTache;
    @FXML
    private TableColumn<Tache, String> c_typeTache;
    @FXML
    private TableColumn<Tache, String> c_estimationTache;
    @FXML
    private TableColumn<Tache, Integer> c_prioriteTache;
    @FXML
    private TableColumn<Tache, String> c_etatTache;
    
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;
    ObservableList<Tache> oblist;
    @FXML
    private TableColumn<Tache,String> col_supp;
    @FXML
    private TextField txtnomt;
    @FXML
    private TextField txtPriorite;
    @FXML
    private Button enregistrer;
    @FXML
    private ComboBox<String> txttypeTache;
     Tache tache = new Tache();
    @FXML
    private TextField typr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        TacheService pdao = new TacheService();
        // Integer.parseInt(codeProjet.getText());
        // System.out.println("++++++++++++++++++++++++++++++++++++"+Integer.parseInt(codeProjet.getText()));
        
        oblist = pdao.getTacheParId(1);
        codeProjet.setText("");
        c_nonTache.setCellValueFactory(new PropertyValueFactory<Tache, String>("nomTache"));
        
        c_typeTache.setCellValueFactory(new PropertyValueFactory<Tache, String>("typeTache"));
        c_estimationTache.setCellValueFactory(new PropertyValueFactory<Tache, String>("estimationTache"));
        c_prioriteTache.setCellValueFactory(new PropertyValueFactory<Tache, Integer>("prioriteTache"));
        c_etatTache.setCellValueFactory(new PropertyValueFactory<Tache, String>("etatTache"));
        
        
        javafx.util.Callback<TableColumn<Tache, String>, TableCell<Tache, String>> cellFactory
                = //
                new Callback<TableColumn<Tache, String>, TableCell<Tache, String>>() {
            @Override
            public TableCell call(final TableColumn<Tache, String> param) {
                final TableCell<Tache, String> cell = new TableCell<Tache, String>() {

               final      Button btn = new Button("Delete");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                Tache cn = getTableView().getItems().get(getIndex());
                                System.out.println(cn.getNomTache());
                                TacheService cs = new TacheService();
                                cs.deleteTache(cn);

                                Parent root;
                                try {
                                    root = FXMLLoader.load(getClass().getResource("ListTache.fxml"));
                                    btn.getScene().setRoot(root);
                                } catch (IOException ex) {

                                }
                            });
                          
                          setGraphic(btn);
                           setText(null);
                        }
                    }
                };
                return cell;
            }
        };
        col_supp.setCellFactory(cellFactory);
         tableTache.getColumns().add(col_supp);
        
        tableTache.setItems(oblist);
        
        modifierNomTache();
      //  modifierTypeTache();
      //  modifierEstimationTache();
      //  modifierPrioriteTache();
       // modifierEtatTache();
        
       
       txttypeTache.getItems().addAll("projet administratif","Gestion des employeurs","paiement en ligne");
    }
    
    
    public void modifierNomTache() {
        c_nonTache.setCellFactory(TextFieldTableCell.forTableColumn());

        c_nonTache.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setNomTache(e.getNewValue());
            final int row = tableTache.getEditingCell().getRow();
            System.out.println("_______________" + row);

            System.out.println("Titre projet __________ " + tableTache.getItems().get(row).getNomTache());
            System.out.println("PRIORITE __________ " + tableTache.getItems().get(row).getPrioriteTache());
            TacheService proj = new TacheService();
            proj.updateNomT(tableTache.getItems().get(row));
        });
        tableTache.setEditable(true);
    }
    
    private void supprimerTache(ActionEvent event) {
        
        ObservableList<Tache> allProjet, singleProjet;
        allProjet = tableTache.getItems();
        singleProjet = tableTache.getSelectionModel().getSelectedItems();
        
        Tache p = (Tache) tableTache.getSelectionModel().getSelectedItem();
        TacheService pdao = new TacheService();
        pdao.deleteTache(p);
        singleProjet.forEach(allProjet::remove);
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ListeTache.fxml"));
            loader.setController(new ListeProjetController());
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
        }
    }

    public Label getCodeProjet() {
        return codeProjet;
    }

    public void setCodeProjet(Label codeProjet) {
        this.codeProjet = codeProjet;
    }

   

  

  //public void seta(int a){this.codeProjet.setText(String.valueOf(a));}

    public void  setValue(int id){
    this.codeProjet.setText(String.valueOf(id));
        
}

    @FXML
    private void plusTache(ActionEvent event) {
        
          TacheService tachdao = new TacheService();
   
      tache.setNomTache(txtnomt.getText());
      
      tache.setTypeTache(typr.getText());
        int p=Integer.parseInt(txtPriorite.getText());
       // tache.setIdProjet(Integer.parseInt(codeProjet.getText()));
        tache.setPrioriteTache(p);
       
        tachdao.addTache2(tache);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;

import com.thinklance.pidev.Utils.MyConnection;

import com.thinklance.pidev.entities.Projet;
import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.MySQLConnection;
import com.thinklance.pidev.Service.Impl.ServiceProjet;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ListeProjetController implements Initializable {

    @FXML
    private Button btnAjouter;
    @FXML
    private TableView<Projet> tableProjet;
    @FXML
    private TableColumn<Projet, Integer> col_id_projet;
    @FXML
    private TableColumn<Projet, Integer> col_employeur;
    @FXML
    private TableColumn<Projet, Integer> col_freelancer;
    @FXML
    private TableColumn<Projet, String> col_titreprojet;
    @FXML
    private TableColumn<Projet, String> col_description;
    @FXML
    private TableColumn<Projet, Integer> col_nbrejours;
    @FXML
    private TableColumn<Projet, Double> col_prix;
    @FXML
    private TableColumn<Projet, String> col_nomfichiers;
    @FXML
    private TableColumn<Projet, Integer> col_id_categorie;
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;
    ObservableList<Projet> oblist;

    private TableColumn<Projet, String> col_delete;
    private TableColumn<Projet, String> col_addTache;
    @FXML
    private JFXButton btnfile;
    @FXML
    private ImageView delete;
    @FXML
    private ImageView btnEdit;
    @FXML
    private Button deletebtn;
    @FXML
    private Button btnmodif;
    private boolean EDIT = false, ADD = false;
    @FXML
    private TextField txtTitre;
    @FXML
    private TextField txtNbj;
    @FXML
    private TextField txtPrix;
    @FXML
    private TextArea txtDescription;
    @FXML
    private Button btnTache;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceProjet pdao = new ServiceProjet();
        oblist = pdao.getAllProjets();

        col_id_projet.setCellValueFactory(new PropertyValueFactory<Projet, Integer>("idProjet"));

        col_employeur.setCellValueFactory(new PropertyValueFactory<Projet, Integer>("employeur"));
        col_freelancer.setCellValueFactory(new PropertyValueFactory<Projet, Integer>("freelancer"));
        col_titreprojet.setCellValueFactory(new PropertyValueFactory<Projet, String>("titreProjet"));
        col_description.setCellValueFactory(new PropertyValueFactory<Projet, String>("description"));
        col_nbrejours.setCellValueFactory(new PropertyValueFactory<Projet, Integer>("nbrejours"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Projet, Double>("prix"));
        col_nomfichiers.setCellValueFactory(new PropertyValueFactory<Projet, String>("nomfichiers"));
        col_id_categorie.setCellValueFactory(new PropertyValueFactory<Projet, Integer>("idCategorie"));
        // col_delete = new TableColumn("SUPPRIMER");
        col_addTache = new TableColumn("Tâches");
        /*    javafx.util.Callback<TableColumn<Projet, String>, TableCell<Projet, String>> cellFactory
                = //
                new Callback<TableColumn<Projet, String>, TableCell<Projet, String>>() {
            @Override
            public TableCell call(final TableColumn<Projet, String> param) {
                final TableCell<Projet, String> cell = new TableCell<Projet, String>() {

               final      Button btn = new Button("Delete");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                Projet cn = getTableView().getItems().get(getIndex());
                                System.out.println(cn.getIdProjet());
                                ProjetServicee cs = new ProjetServicee();
                                cs.deleteProjet(cn);

                                Parent root;
                                try {
                                    root = FXMLLoader.load(getClass().getResource("ListeProjet.fxml"));
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
        };*/

        javafx.util.Callback<TableColumn<Projet, String>, TableCell<Projet, String>> cellFactory1
                = //
                new Callback<TableColumn<Projet, String>, TableCell<Projet, String>>() {
            @Override
            public TableCell call(final TableColumn<Projet, String> param) {
                final TableCell<Projet, String> cell = new TableCell<Projet, String>() {

                    final Button btntache = new Button(" + ");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btntache.setOnAction(event -> {
                                try {
                                    Projet p = getTableView().getItems().get(getIndex());
                                    System.out.println(p.getIdProjet());
                                    int id = p.getIdProjet();
                                    String titre = p.getTitreProjet();
                                    Stage stage = new Stage();
                                    FXMLLoader l = new FXMLLoader();
                                    l.setLocation(getClass().getResource("/com/thinklance/pidev/GUI/AjoutTache.fxml"));
                                    l.load();
                                    Parent root1 = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/AjoutTache.fxml"));
                                    //AjoutTacheController tc = l.getController();
                                    //tc.setValue(id, titre);

                                    Parent part = l.getRoot();
                                    stage.centerOnScreen();
                                    Scene scene = new Scene(part);

                                    Label lbl;
                                    stage.setTitle("Ajouter les tâches");
                                    stage.setScene(scene);
                                    stage.showAndWait();

                                } catch (IOException ex) {
                                }
                            });
                            setGraphic(btntache);
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        };
        col_addTache.setCellFactory(cellFactory1);
        tableProjet.getColumns().add(col_addTache);
        // col_delete.setCellFactory(cellFactory);
        // tableProjet.getColumns().add(col_delete);

        tableProjet.setItems(oblist);

        btnmodif.setOnAction(e -> {
            // ADD= false;
            editProjet();
        });

        btnTache.setOnAction(e -> {
            try {
                //ADD= false;
                afficheTache();
            } catch (IOException ex) {
                Logger.getLogger(ListeProjetController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        
    }
    
    
    
    
    static int idd;

    public void editProjet() {

        String q = "update projet set titreprojet=? ,description=?,nbrejours=?,prix=? where id='" + idd + "' ";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(q);
            pst.setString(1, txtTitre.getText());
            pst.setString(2, txtDescription.getText());
            pst.setInt(3, Integer.parseInt(txtNbj.getText()));
            pst.setDouble(4, Double.parseDouble(txtPrix.getText()));
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void afficheTache() throws IOException {

        Projet p = (Projet) tableProjet.getSelectionModel().getSelectedItem();
        try {

          
                                    System.out.println(p.getIdProjet());
                                    int id =(Integer) p.getIdProjet();
                                    String titre = p.getTitreProjet();
                                    Stage stage = new Stage();
                                    FXMLLoader l = new FXMLLoader();
                                    l.setLocation(getClass().getResource("/com/Thinklance/pidev/GUI/ListTache.fxml"));
                                    l.load();
                                    Parent root1 = FXMLLoader.load(getClass().getResource("/com/Thinklance/pidev/GUI/ListTache.fxml"));
                                //    ListTacheController tc = l.getController();
                                   // tc.setValue(id);

                                    Parent part = l.getRoot();
                                    stage.centerOnScreen();
                                    Scene scene = new Scene(part);

                                    Label lbl;
                                    stage.setTitle("Ajouter les tâches");
                                    stage.setScene(scene);
                                    stage.showAndWait();

        } catch (IOException ex) {
        }

    }

    @FXML
    private void interfaceAjoutProjet(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/AjoutProjet.fxml"));
        stage.setResizable(false);
        stage.centerOnScreen();
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ajoutTache(MouseEvent event) throws IOException {
        /*Projet p= (Projet) tableProjet.getSelectionModel().getSelectedItem();
        String q ="select * from projet";
        try {
            pst=connection.prepareStatement(q);
        } catch (SQLException ex) {
            Logger.getLogger(ListeProjetController.class.getName()).log(Level.SEVERE, null, ex);
        }
      Projet p = (Projet) tableProjet.getSelectionModel().getSelectedItem();
        System.out.println(p.getIdProjet());
        int id = p.getIdProjet();
        String titre = p.getTitreProjet();
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader();
      //  l.setLocation(getClass().getResource("/com/Thinklance/pidev/GUI/AjoutTache.fxml"));
//        l.load();
//  Parent root1 = FXMLLoader.load(getClass().getResource("/com/Thinklance/pidev/GUI/AjoutTache.fxml"));
        AjoutTacheController tc = l.getController();
        tc.setValue(id, titre);

        Parent part = l.getRoot();
        stage.centerOnScreen();
        Scene scene = new Scene(part);

        Label lbl;
        stage.setTitle("Ajouter les tâches");
        stage.setScene(scene);
        stage.showAndWait();*/

    }

    @FXML
    private void deleteProjet(MouseEvent event) {
        ObservableList<Projet> allProjet, singleProjet;
        allProjet = tableProjet.getItems();
        singleProjet = tableProjet.getSelectionModel().getSelectedItems();

        Projet p = (Projet) tableProjet.getSelectionModel().getSelectedItem();
        ServiceProjet pdao = new ServiceProjet();
        pdao.deleteProjet(p);
        singleProjet.forEach(allProjet::remove);

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ListeProjet.fxml"));
            loader.setController(new ListeProjetController());
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {

        }
    }

    @FXML
    private void afficheDetails(MouseEvent event) throws IOException {

        Projet p = (Projet) tableProjet.getSelectionModel().getSelectedItem();
        //int id=p.getIdProjet();
        System.out.println(p.getIdProjet() + "id------------");
        System.out.println("okkkkkkkkkkkkkkkkkkkkkk");
        System.out.println(p.getIdProjet());
        String titre = p.getTitreProjet();
        Stage stage = new Stage();
        FXMLLoader l = new FXMLLoader();
        l.setLocation(getClass().getResource("/com/thinklance/pidev/GUI/ModifierProjet.fxml"));
     //   ModifierProjetController tc = l.getController();
      //  tc.setValueP(p.getIdProjet());

        Parent part = l.getRoot();
        stage.centerOnScreen();
        Scene scene = new Scene(part);

        Label lbl;
        stage.setTitle("Ajouter les tâches");
        stage.setScene(scene);
        stage.showAndWait();

    }

    @FXML
    private void setOnClick() {
        Projet selected = tableProjet.getSelectionModel().getSelectedItem();
        idd = selected.getIdProjet();
        txtTitre.setText(selected.getTitreProjet());
        txtNbj.setText(selected.getNbjours() + "");
        txtPrix.setText(selected.getPrix() + "");
        txtDescription.setText(selected.getDescription());

    }

}

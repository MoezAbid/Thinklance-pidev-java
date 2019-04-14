/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;

import com.thinklance.pidev.entities.Demande;
import com.jfoenix.controls.JFXTextField;

import com.jfoenix.controls.JFXButton;

import com.thinklance.pidev.Service.Impl.DemandeService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ListDemandeController implements Initializable {

    @FXML
    private JFXTextField tfR;
    @FXML
    private TableColumn<Demande, Integer> freelancer;
    @FXML
    private TableColumn<Demande, Integer> employeur;
    @FXML
    private TableColumn<Demande, Date> dateDemande;
    @FXML
    private TableColumn<Demande, String> etatdemande;
    @FXML
    private TableColumn<Demande, Integer> projet;
    @FXML
    private TableView<Demande> tableDemande;
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;
    ObservableList<Demande> oblist;
    @FXML
    private TableColumn<Demande, Integer> id;
    @FXML
    private JFXButton delete;

    private TableColumn<Demande, String> col_delete;
    private TableColumn<Demande, String> col_refus;
    @FXML
    private Label lbid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DemandeService pdao = new DemandeService();
        //IdUserController idd=new IdUserController();
        // System.out.println(idd.getVal());

//   int  idu=Integer.parseInt(lbid.getText());
        // System.out.println(idd.getIduser());
        oblist = pdao.getDemandeParId(1);

        id.setCellValueFactory(new PropertyValueFactory<Demande, Integer>("id"));
        freelancer.setCellValueFactory(new PropertyValueFactory<Demande, Integer>("freelancer"));

        employeur.setCellValueFactory(new PropertyValueFactory<Demande, Integer>("idEmployeur"));
        dateDemande.setCellValueFactory(new PropertyValueFactory<Demande, Date>("dateDemande"));
        etatdemande.setCellValueFactory(new PropertyValueFactory<Demande, String>("etatDemande"));
        projet.setCellValueFactory(new PropertyValueFactory<Demande, Integer>("idProjet"));
        tableDemande.setItems(oblist);
        col_delete = new TableColumn("Actions");
        col_refus = new TableColumn("Actions");

        javafx.util.Callback<TableColumn<Demande, String>, TableCell<Demande, String>> cellFactory
                = //
                new Callback<TableColumn<Demande, String>, TableCell<Demande, String>>() {
            @Override
            public TableCell call(final TableColumn<Demande, String> param) {
                final TableCell<Demande, String> cell = new TableCell<Demande, String>() {

                    final Button btn = new Button("Accepter");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                Demande cn = getTableView().getItems().get(getIndex());
                                DemandeService dao = new DemandeService();
                                System.out.println(cn.getId());

                                dao.modifDemande(cn, cn.getId());
                                
                    Parent root1;
                                try {
                                    root1 = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/FXMLDocument.fxml"));
                                      this.getScene().setRoot(root1);
       
                                } catch (IOException ex) {
                                    Logger.getLogger(ListDemandeController.class.getName()).log(Level.SEVERE, null, ex);
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

        javafx.util.Callback<TableColumn<Demande, String>, TableCell<Demande, String>> cellFactory1
                = //
                new Callback<TableColumn<Demande, String>, TableCell<Demande, String>>() {
            @Override
            public TableCell call(final TableColumn<Demande, String> param) {
                final TableCell<Demande, String> cell = new TableCell<Demande, String>() {

                    final Button btn = new Button("Refuser");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                Demande cn = getTableView().getItems().get(getIndex());
                                System.out.println(cn.getIdProjet());
                                DemandeService cs = new DemandeService();
                                cs.deleteDemande(cn);

                                Parent root2;
                                try {
                                    root2 = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/ListeDemande.fxml"));
                                    btn.getScene().setRoot(root2);
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

        col_delete.setCellFactory(cellFactory);
        tableDemande.getColumns().add(col_delete);
        col_refus.setCellFactory(cellFactory1);
        tableDemande.getColumns().add(col_refus);

    }

    @FXML
    private void InterfaceAjoutDemande(MouseEvent event) throws IOException {

        Stage stage = new Stage();

        FXMLLoader root1 = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/AjoutDemande.fxml"));
        Parent root = root1.load();

        AjoutDemandeController hc = root1.getController();

        stage.show();

    }

    @FXML
    private void deleteDemande(ActionEvent event) throws SQLException {
        Demande d = (Demande) tableDemande.getSelectionModel().getSelectedItem();
        String q = "delete from demande where id=?";
        pst = connection.prepareStatement(q);
        pst.setInt(1, d.getId());
        pst.executeUpdate();
        rs.close();

    }

    public void setId(String id) {
        this.lbid.setText(id);
    }
}

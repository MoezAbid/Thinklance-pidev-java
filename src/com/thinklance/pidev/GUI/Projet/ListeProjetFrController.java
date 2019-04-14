/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Projet;


import com.thinklance.pidev.entities.Demande;
import com.thinklance.pidev.entities.Projet;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.thinklance.pidev.Service.Impl.DemandeService;
import com.thinklance.pidev.Service.Impl.ServiceProjet;
import java.io.IOException;
import static java.lang.String.format;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;
import static java.lang.String.format;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ListeProjetFrController implements Initializable {

    private JFXListView<Projet> listView;
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
    private TableColumn<Projet, Integer> col_id_categorie;
    @FXML
    private TableColumn<Projet, String> col_nomfichiers;
      @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    ObservableList<Projet> oblist;
    private TableColumn<Projet, String> col_addDemande;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServiceProjet pdao = new ServiceProjet();
        oblist = pdao.getAllProjets();

        col_id_projet.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("idProjet"));

        col_employeur.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("employeur"));
        col_freelancer.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("freelancer"));
        col_titreprojet.setCellValueFactory(new PropertyValueFactory<Projet,String>("titreProjet"));
        col_description.setCellValueFactory(new PropertyValueFactory<Projet,String>("description"));
        col_nbrejours.setCellValueFactory(new PropertyValueFactory<Projet, Integer>("nbrejours"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Projet, Double>("prix"));
        col_nomfichiers.setCellValueFactory(new PropertyValueFactory<Projet, String>("nomfichiers"));
        col_id_categorie.setCellValueFactory(new PropertyValueFactory<Projet,Integer>("idCategorie"));
        col_addDemande = new TableColumn("Tâches");
        javafx.util.Callback<TableColumn<Projet, String>, TableCell<Projet, String>> cellFactory1
                = //
                new Callback<TableColumn<Projet, String>, TableCell<Projet, String>>() {
            @Override
            public TableCell call(final TableColumn<Projet, String> param) {
                final TableCell<Projet, String> cell = new TableCell<Projet, String>() {

                    final Button btntache = new Button(" Envoyer Demande ");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btntache.setOnAction(event -> {

                                Projet p = getTableView().getItems().get(getIndex());
                                System.out.println(p.getIdProjet());
                                int id = p.getIdProjet();
                                int employeur = p.getEmployeur();
                                DemandeService d = new DemandeService();
                                System.out.println(employeur);
                                System.out.println(id+"idkj,kl;m:ù!");
                              Demande demande = new Demande();
                                demande.setIdEmployeur(employeur);
                                demande.setFreelancer(5);
                                demande.setIdProjet(id);
                                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                                Date datc = null;
                                String s="25-12-2010";
                                //System.out.println(s);
                              //  Date dp=(Date)Date.valueOf(s);
                                //Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(s);  
                               // System.out.println(Date.parse(s));
                               String startDate="01-02-2013";
SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
java.util.Date date;
                                try {
                                    date = sdf1.parse(startDate);
                                    java.sql.Date sqlStartDate = new java.sql.Date(System.currentTimeMillis()); 
                                
                                    System.out.println(sqlStartDate);
                                    Date n= (Date)sqlStartDate;
                                    System.out.println(n);
                                    demande.setDateDemande(n);
                                } catch (ParseException ex) {
                                    Logger.getLogger(ListeProjetFrController.class.getName()).log(Level.SEVERE, null, ex);
                                }
 
                               
//                                try {
//                                    
////                                    datc = (Date) df.parse("25-12-2010");
//                                    System.out.println(datc);
//                                } catch (ParseException e) {
//                                    
//                                }

                                
                                d.addDemande(demande);
                                
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                             alert.setHeaderText(null);
                                             alert.setTitle("Demande envoyée");
                                             alert.setContentText("Votre demande est en attente");

                                             alert.showAndWait();

                            });
                            setGraphic(btntache);
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        };
        col_addDemande.setCellFactory(cellFactory1);
        tableProjet.getColumns().add(col_addDemande);
        // col_delete.setCellFactory(cellFactory);
        // tableProjet.getColumns().add(col_delete);

        tableProjet.setItems(oblist);

        /*   ProjetServicee proj = new ProjetServicee();
        Projet projet = new Projet();
        ObservableList<Projet> list = FXCollections.observableArrayList();
        list=proj.getAllProjets();
        ObservableList <Projet> listp=proj.getAllProjets();
    for(Projet p : list)
    {
       // Label lb= new Label();
       // lb.setText(p.getTitreProjet());
        listView.getItems().add(p);
    }*/
    }

    @FXML
    public void afficheDteailsProjet() throws IOException {

        Projet p = (Projet) tableProjet.getSelectionModel().getSelectedItem();
        try {

            System.out.println(p.getIdProjet());
            String t = p.getTitreProjet();
            int t2 = p.getIdCategorie();
            Double t3 = p.getPrix();
            int t4 = p.getNbjours();
            String t5 = p.getDescription();
            String t6 = p.getNomFichiers();
            String titre = p.getTitreProjet();
            int id = p.getIdProjet();

            Stage stage = new Stage();
            FXMLLoader l = new FXMLLoader();
            l.setLocation(getClass().getResource("/com/thinklance/pidev/GUI/DetailsProjetFr.fxml"));
            l.load();
            //   Parent root1 = FXMLLoader.load(getClass().getResource("/com/Thinklance/pidev/GUI/DetailsProjetFr.fxml"));
            DetailsProjetFrController tc = l.getController();
            System.out.println(id + "okkkk");
            tc.setValue(t, t2, t3, t4, t5, t6, id);

            Parent part = l.getRoot();
            stage.centerOnScreen();
            Scene scene = new Scene(part);

            Label lbl;
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
        }

    }

}

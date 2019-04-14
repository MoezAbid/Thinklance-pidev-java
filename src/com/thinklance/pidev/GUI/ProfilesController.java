/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextArea;
import com.thinklance.pidev.Service.Impl.CommentaireService;
import com.thinklance.pidev.Service.Impl.CompetenceService;
import com.thinklance.pidev.Service.Impl.ExperienceService;
import com.thinklance.pidev.Service.Impl.FormationService;
import com.thinklance.pidev.Service.Impl.PortfolioService;
import com.thinklance.pidev.Service.Impl.UserService;

import com.thinklance.pidev.Utils.BadWordFilter;
import com.thinklance.pidev.Utils.UserManager;
import com.thinklance.pidev.entities.Commentaire;
import com.thinklance.pidev.entities.Competence;
import com.thinklance.pidev.entities.ExperienceProfessionnel;
import com.thinklance.pidev.entities.Formation;
import com.thinklance.pidev.entities.Portfolio;
import com.thinklance.pidev.entities.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProfilesController implements Initializable {


    private StackPane slideShowPane;
    private VBox vBox;

    /**
     * Initializes the controller class.
     */
    @FXML
    private StackPane root;
//    DecorationPane decorationPane = new DecorationPane();
//decorationPane.getChildren().add(vBox);
//getDialogPane().setContent(decorationPane);
//    
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private AnchorPane anchorepaneexperience;
    @FXML
    private AnchorPane anchorepaneCommentaire;
    @FXML
    private AnchorPane anchorpaneformations;
    @FXML
    private AnchorPane anchorpaneportfolio;
    @FXML
    private ImageView image_profile;
    @FXML
    private Label NomPrenom;
    @FXML
    private Label PaysVille;
    @FXML
    private Label titreprofile;
    @FXML
    private Rating rating;
    @FXML
    private Label note;
    ListView<CommentairesListBase> listViewcommentaires = new ListView<>();
    ObservableList<CommentairesListBase> liscomment = FXCollections.observableArrayList();
    ListView<ListFormationBase> listViewformations = new ListView<>();
    ObservableList<ListFormationBase> lisforma = FXCollections.observableArrayList();
    ListView<ListExperienceBase> listViewexperiences = new ListView<>();
    ObservableList<ListExperienceBase> lisexp = FXCollections.observableArrayList();
    ListView<competencelistBase> listViewcompetences = new ListView<>();
    ObservableList<competencelistBase> liscomp = FXCollections.observableArrayList();
    final HBox labelFile = new HBox();
    @FXML
    private Label descriptionprofile;
    @FXML
    private AnchorPane anchorcompetences;
    @FXML
    private Label tarifprofile;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserService user = new UserService();
        UserManager usermanager = new UserManager();

        //Pour les competences
        CompetenceService competenceService = new CompetenceService();
        List<Competence> listcompe = new ArrayList<>();
        List<competencelistBase> listcompp = new ArrayList<>();

        listcompe = competenceService.listerCompetences(user.getTheUserIdfromemail(usermanager.getUserConnected()));

        Iterator<Competence> it7 = listcompe.iterator();

        while (it7.hasNext()) {
            Competence f = it7.next();

            competencelistBase aa = new competencelistBase(f.getId(),f.getNom_competence(), f.getDegre());
            listcompp.add(aa);

        }

        listViewcompetences.getItems().addAll(listcompp);
        listViewcompetences.setOrientation(Orientation.VERTICAL);
        listViewcompetences.setPrefSize(259, 181);
        TableView tableView5 = new TableView();
        tableView5.getItems().addAll(listcompp);
        StackPane root5 = new StackPane(listViewcompetences);
        root5.setAlignment(Pos.CENTER);
        root5.setPrefSize(259, 181);
        anchorcompetences.getChildren().add(root5);
        root5.getStylesheets().add("/com/thinklance/pidev/css/style.css");
//Pour les portfolio
        PortfolioService port = new PortfolioService();
        List<Portfolio> listportfolio = new ArrayList<>();
        listportfolio = port.listerPortfolios(user.getTheUserIdfromemail(usermanager.getUserConnected()));
        Iterator<Portfolio> it5 = listportfolio.iterator();

        while (it5.hasNext()) {
            Portfolio u = it5.next();

            File file = new File(u.getImage());

            Image image = new Image(file.toURI().toString(), 100, 150, true, true);
            ImageView imageview = new ImageView();
            imageview.setImage(image);

            labelFile.getChildren().add(imageview);
        }
        anchorpaneportfolio.getChildren().add(labelFile);
//

        User us = user.getUserById(user.getTheUserIdfromemail(usermanager.getUserConnected()));
        NomPrenom.setText(us.getNom() + "  " + us.getPrenom());
        PaysVille.setText(us.getPays() + "," + us.getVille());
        titreprofile.setText(us.getTitre_profile());
        tarifprofile.setText(String.valueOf(us.getTarif_moyen()));
        note.setText(String.valueOf(us.getNote()));
        descriptionprofile.setText(us.getDescription());

        File file = new File("F:\\Desktop\\Esprit_3A\\Semestre22\\PIDEV\\JavaFX Pidev\\ThinkLance (2)\\src\\com\\thinklance\\pidev\\ressourses\\user.png");
        if (us.getImage() == null) {

            Image img = new Image(file.toURI().toString(), 100, 150, true, true);
            image_profile.setImage(img);
        } else if (us.getImage() != null) {
            file = new File(us.getImage());

            Image img = new Image(file.toURI().toString(), 100, 150, true, true);
            image_profile.setImage(img);

        }
//Pour les commentaires
        CommentaireService commentService = new CommentaireService();
        List<Commentaire> listcommentaires = new ArrayList<>();
        List<CommentairesListBase> list = new ArrayList<>();
        listcommentaires = commentService.getAllcomments(user.getTheUserIdfromemail(usermanager.getUserConnected()));

        Iterator<Commentaire> it = listcommentaires.iterator();

        while (it.hasNext()) {
            Commentaire u = it.next();

            User myuser = user.getUserById(u.getId_user());

            CommentairesListBase a = new CommentairesListBase(u.getContenu(), myuser.getNom(), myuser.getPrenom(), myuser.getImage());
            System.out.println(a);
            list.add(a);
        }
        listViewcommentaires.getItems().addAll(list);
        listViewcommentaires.setOrientation(Orientation.VERTICAL);
        listViewcommentaires.setPrefSize(150, 300);

        TableView tableView = new TableView();
        tableView.getItems().addAll(list);
        StackPane root = new StackPane(listViewcommentaires);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(845, 216);
        anchorepaneCommentaire.getChildren().add(root);
        //pour les formations

        FormationService formationService = new FormationService();
        List<Formation> listformations = new ArrayList<>();
        List<ListFormationBase> listfor = new ArrayList<>();

        listformations = formationService.listerFormations(user.getTheUserIdfromemail(usermanager.getUserConnected()));
        System.out.println(listformations);
        Iterator<Formation> it1 = listformations.iterator();

        while (it1.hasNext()) {
            Formation f = it1.next();

            ListFormationBase aa = new ListFormationBase(f.getId(),f.getTitre(), f.getInstitution(), f.getDatedebut().toString(), f.getDatefin().toString(), f.getDescription());

            listfor.add(aa);

        }
        listViewformations.getItems().addAll(listfor);
        listViewformations.setOrientation(Orientation.VERTICAL);
        listViewformations.setPrefSize(150, 300);
        listViewformations.getStyleClass().add("-fx-background-color: white;");
        listViewformations.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ListFormationBase>() {
            @Override
            public void changed(ObservableValue<? extends ListFormationBase> observable, ListFormationBase oldValue, ListFormationBase newValue) {
              System.out.println("Selected item: " + newValue.getId_cat());
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierFormation.fxml"));
                Parent root;
                try {
                    root = loader.load();
                    ModifierFormationController modifiercat = loader.getController();
                    modifiercat.passvalue(newValue.getId_cat());
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Modifier Formation");
                    Stage stage2 = (Stage) AnchorPane.getScene().getWindow();
                    stage2.close();
                    stage.show();

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        root.getStylesheets().add("/com/thinklance/pidev/css/style.css");

        TableView tableView1 = new TableView();
        tableView1.getItems().addAll(listfor);
        StackPane root1 = new StackPane(listViewformations);
        root1.setAlignment(Pos.CENTER);
        root1.setPrefSize(845, 216);
        anchorpaneformations.getChildren().add(root1);

        //Pour les expériencespro
        ExperienceService experienceService = new ExperienceService();
        List<ExperienceProfessionnel> listexperiences = new ArrayList<>();
        List<ListExperienceBase> listexpp = new ArrayList<>();

        listexperiences = experienceService.listerExperiences(user.getTheUserIdfromemail(usermanager.getUserConnected()));

        Iterator<ExperienceProfessionnel> it2 = listexperiences.iterator();

        while (it2.hasNext()) {
            ExperienceProfessionnel f = it2.next();

            ListExperienceBase aa = new ListExperienceBase(f.getId(),f.getTitre_exp(), f.getNom_entreprise(), f.getDatedebut().toString(), f.getDatefin().toString(), f.getDescription());

            listexpp.add(aa);

        }
        listViewexperiences.getItems().addAll(listexpp);
        listViewexperiences.setOrientation(Orientation.VERTICAL);
        listViewexperiences.setPrefSize(150, 300);
           listViewexperiences.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ListExperienceBase>() {
            @Override
            public void changed(ObservableValue<? extends ListExperienceBase> observable, ListExperienceBase oldValue, ListExperienceBase newValue) {
           
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierExperience.fxml"));
                Parent root;
                try {
                    root = loader.load();
                    ModifierExperienceController modifiercat = loader.getController();
                    modifiercat.passvalue(newValue.getId_exp());
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Modifier Experience");
                    Stage stage2 = (Stage) AnchorPane.getScene().getWindow();
                    stage2.close();
                    stage.show();

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        TableView tableView2 = new TableView();
        tableView2.getItems().addAll(listfor);
        StackPane root2 = new StackPane(listViewexperiences);
        root2.setAlignment(Pos.CENTER);
        root2.setPrefSize(845, 216);
        anchorepaneexperience.getChildren().add(root2);
        root1.getStylesheets().add("/com/thinklance/pidev/css/style.css");
        root2.getStylesheets().add("/com/thinklance/pidev/css/style.css");

    }


 

}

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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProfileDescriptionController implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Label descriptionprofile;
    @FXML
    private AnchorPane anchorepaneexperience;
    @FXML
    private AnchorPane anchorepaneCommentaire;
    @FXML
    private JFXTextArea textmessage;
    @FXML
    private JFXButton commenter;
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
    private Label tarifprofile;
    @FXML
    private Rating rating;
    @FXML
    private AnchorPane anchorcompetences;
    @FXML
    private AnchorPane anchorpanepourcommenter;
    @FXML
    private ImageView image_badge;
    @FXML
    private Label nom_badge;
    @FXML
    private Label email;
    ListView<CommentairesListBase> listViewcommentaires = new ListView<>();
    ObservableList<CommentairesListBase> liscomment = FXCollections.observableArrayList();
    ListView<ListFormationBase> listViewformations = new ListView<>();
    ObservableList<ListFormationBase> lisforma = FXCollections.observableArrayList();
    ListView<ListExperienceBase> listViewexperiences = new ListView<>();
    ObservableList<ListExperienceBase> lisexp = FXCollections.observableArrayList();
    ListView<competencelistBase> listViewcompetences = new ListView<>();
    ObservableList<competencelistBase> liscomp = FXCollections.observableArrayList();
    final HBox labelFile = new HBox();
    private int idu;
    @FXML
    private Label nbrpersonne;
    @FXML
    private Button btnreclamer;
    @FXML
    private Button btn_noter;

    public void transferMessage(int iduu) {
        idu = iduu;
        textmessage.setVisible(false);
        commenter.setVisible(false);
        btn_noter.disableProperty().set(true);
        btnreclamer.disableProperty().set(true);
        UserService userser = new UserService();
        UserManager um = new UserManager();
        User u=userser.getUserById(idu);
        User uu = userser.getInfoProfileUser(um.getUserConnected());

        if (uu.getRoles().equals("EMPLOYEUR")) {
            btn_noter.disableProperty().set(false);
            btnreclamer.disableProperty().set(false);
            textmessage.setVisible(true);
            commenter.setVisible(true);

        }
        UserService userdao = new UserService();
        NomPrenom.setText(u.getPrenom() + " " + u.getNom());
        titreprofile.setText(u.getTitre_profile());
        nbrpersonne.setText("(" + userdao.getNbVote(idu) + ")");
        rating.setDisable(true);
        rating.ratingProperty().set(u.getNote());
        email.setText(u.getEmail());
        PaysVille.setText(u.getPays() + "," + u.getVille());
        email.setText(u.getEmail());
        tarifprofile.setText("" + u.getTarif_moyen());
        if (u.getNbr_point() >= 100) {
            File filebadgebronze = new File("F:\\Desktop\\Esprit_3A\\Semestre22\\PIDEV\\JavaFX Pidev\\ThinkLance (2)\\src\\com\\thinklance\\pidev\\ressourses\\Bronze.png");
            Image img = new Image(filebadgebronze.toURI().toString(), 100, 150, true, true);
            image_badge.setImage(img);
            nom_badge.setText("Bronze");

        } else if (u.getNbr_point() >= 200) {
            File filebadgesilver = new File("F:\\Desktop\\Esprit_3A\\Semestre22\\PIDEV\\JavaFX Pidev\\ThinkLance (2)\\src\\com\\thinklance\\pidev\\ressourses\\silver.png");
            Image img = new Image(filebadgesilver.toURI().toString(), 100, 150, true, true);
            image_badge.setImage(img);
            nom_badge.setText("Silver");
        } else if (u.getNbr_point() >= 500) {
            File filebadgegold = new File("F:\\Desktop\\Esprit_3A\\Semestre22\\PIDEV\\JavaFX Pidev\\ThinkLance (2)\\src\\com\\thinklance\\pidev\\ressourses\\Gold.png");

            Image img = new Image(filebadgegold.toURI().toString(), 100, 150, true, true);
            image_badge.setImage(img);
            nom_badge.setText("Gold");
        }

        File file = new File("F:\\Desktop\\Esprit_3A\\Semestre22\\PIDEV\\JavaFX Pidev\\ThinkLance (2)\\src\\com\\thinklance\\pidev\\ressourses\\user.png");
        if (u.getImage() == null) {

            Image img = new Image(file.toURI().toString(), 100, 150, true, true);
            image_profile.setImage(img);
        } else if (u.getImage() != null) {
            file = new File(u.getImage());

            Image img = new Image(file.toURI().toString(), 100, 150, true, true);
            image_profile.setImage(img);

        }
        //Pour les competences
        CompetenceService competenceService = new CompetenceService();
        List<Competence> listcompe = new ArrayList<>();
        List<competencelistBase> listcompp = new ArrayList<>();

        listcompe = competenceService.listerCompetences(iduu);

        Iterator<Competence> it7 = listcompe.iterator();

        while (it7.hasNext()) {
            Competence f = it7.next();

            competencelistBase aa = new competencelistBase(f.getId(), f.getNom_competence(), f.getDegre());
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
        listportfolio = port.listerPortfolios(iduu);
        Iterator<Portfolio> it5 = listportfolio.iterator();

        while (it5.hasNext()) {
            Portfolio portt = it5.next();

            File file1 = new File(u.getImage());

            Image image = new Image(file.toURI().toString(), 100, 150, true, true);
            ImageView imageview = new ImageView();
            imageview.setImage(image);

            labelFile.getChildren().add(imageview);
        }
        anchorpaneportfolio.getChildren().add(labelFile);
        //Pour les commentaires
        CommentaireService commentService = new CommentaireService();
        List<Commentaire> listcommentaires = new ArrayList<>();
        List<CommentairesListBase> list = new ArrayList<>();
        listcommentaires = commentService.getAllcomments(iduu);

        Iterator<Commentaire> it = listcommentaires.iterator();

        while (it.hasNext()) {
            Commentaire comment = it.next();

            User myuser = userdao.getUserById(comment.getId_employeur());

            CommentairesListBase a = new CommentairesListBase(comment.getContenu(), myuser.getNom(), myuser.getPrenom(), myuser.getImage());
      
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

        listformations = formationService.listerFormations(iduu);
        System.out.println(listformations);
        Iterator<Formation> it1 = listformations.iterator();

        while (it1.hasNext()) {
            Formation f = it1.next();

            ListFormationBase aa = new ListFormationBase(f.getId(), f.getTitre(), f.getInstitution(), f.getDatedebut().toString(), f.getDatefin().toString(), f.getDescription());

            listfor.add(aa);

        }
        listViewformations.getItems().addAll(listfor);
        listViewformations.setOrientation(Orientation.VERTICAL);
        listViewformations.setPrefSize(150, 300);
        listViewformations.getStyleClass().add("-fx-background-color: white;");

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

        listexperiences = experienceService.listerExperiences(iduu);

        Iterator<ExperienceProfessionnel> it2 = listexperiences.iterator();

        while (it2.hasNext()) {
            ExperienceProfessionnel f = it2.next();
            ListExperienceBase aa = new ListExperienceBase(f.getId(), f.getTitre_exp(), f.getNom_entreprise(), f.getDatedebut().toString(), f.getDatefin().toString(), f.getDescription());
            listexpp.add(aa);
        }
        listViewexperiences.getItems().addAll(listexpp);
        listViewexperiences.setOrientation(Orientation.VERTICAL);
        listViewexperiences.setPrefSize(150, 300);
        TableView tableView2 = new TableView();
        tableView2.getItems().addAll(listfor);
        StackPane root2 = new StackPane(listViewexperiences);
        root2.setAlignment(Pos.CENTER);
        root2.setPrefSize(845, 216);
        anchorepaneexperience.getChildren().add(root2);
        root1.getStylesheets().add("/com/thinklance/pidev/css/style.css");
        root2.getStylesheets().add("/com/thinklance/pidev/css/style.css");

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void reclamer(MouseEvent event) {
    }
    public static JFXDialog jfxdialog;
    private VBox vBox;

    @FXML
    private void noter(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NoterUser.fxml"));

        try {
            // TODO
            vBox = loader.load();
            NoterUserController selectedview = (NoterUserController) loader.getController();
            selectedview.setIduser(idu);
        } catch (IOException ex) {
            Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
        jfxdialog.show();

    }

    @FXML
    private void addComment(MouseEvent event) {
     
        String output = BadWordFilter.getCensoredText(textmessage.getText());
        if (output.contains("**")) {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("InvalidAlert.fxml"));
        try {
            // TODO
            vBox = loader.load();
            InvalidAlertController profileviewcontroller = (InvalidAlertController) loader.getController();
            profileviewcontroller.setPath("ProfileDescription");
         
            System.out.println(profileviewcontroller);
            profileviewcontroller.setContent("Attention! N'utilisez pas des gros mots s'il vous plait");

        } catch (IOException ex) {
            Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
            textmessage.setText(output);
              jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
              jfxdialog.show();

        } else {

            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("ValidAlert.fxml"));
            try {
                // TODO
                vBox = loader1.load();
                ValidAlertController profileviewcontroller1 = (ValidAlertController) loader1.getController();
                profileviewcontroller1.setPath("ProfileDescription");
                profileviewcontroller1.setContent("Votre commentaire a été ajouté avec suucés!");
                profileviewcontroller1.setWhichIsLastClicked(1);

            } catch (IOException ex) {
                Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CommentaireService commentser = new CommentaireService();
        Commentaire c = new Commentaire();
        c.setContenu(output);
        c.setDate_ajout(new Date());
        UserService userser = new UserService();
        UserManager um = new UserManager();
        User u = userser.getInfoProfileUser(um.getUserConnected());
        if (u.getRoles().equals("EMPLOYEUR")) {

            c.setId_user(idu);
            c.setId_employeur(userser.getTheUserIdfromemail(um.getUserConnected()));
            commentser.addComment(c);
        jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
        jfxdialog.show();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Articles;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.thinklance.pidev.GUI.ProfileDescriptionController;
import com.thinklance.pidev.Service.Impl.ArticleService;
import com.thinklance.pidev.Service.Impl.TypeArticleService;
import com.thinklance.pidev.Service.Impl.UserService;
import com.thinklance.pidev.Utils.MoezUtils;
import com.thinklance.pidev.Utils.UserManager;
import com.thinklance.pidev.entities.Article;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Moez
 */
public class ListeArticlesController implements Initializable {

    @FXML
    private TableView<Article> articlesTable;
    @FXML
    private TableColumn<Article, String> titreColonne;
    @FXML
    private TableColumn<Article, String> descriptionColonne;
    @FXML
    private TableColumn<Article, Date> dateColonne;
    @FXML
    private JFXButton btnAjouter;
    @FXML
    private JFXButton btnRefresh;

    private ArticleService articleService;
    @FXML
    private JFXButton btnMaListeArticles;
    @FXML
    private JFXTextField rechercheTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        articleService = new ArticleService();
        articlesTable.setItems(articleService.getListeAllArticles());
        addPhotoViewToTable();
        addTypeArticleToTable();
        addAuteurToTable();
        addLireButtonToTable();

        titreColonne.setCellValueFactory(new PropertyValueFactory("titre"));
        descriptionColonne.setCellValueFactory(new PropertyValueFactory("description"));
        dateColonne.setCellValueFactory(new PropertyValueFactory("dateHeure"));

        //Formatege de la date
        dateColonne.setCellFactory(column -> {
            TableCell<Article, Date> cell = new TableCell<Article, Date>() {
                private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");

                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(format.format(item));
                    }
                }
            };

            return cell;
        });
    }

    @FXML
    private void refresh() {
        articlesTable.setItems(articleService.getListeAllArticles());
        System.out.println("Liste des articles rafraichie.");
    }

    public void naviguarVersPageDeModification(int idArticle) {

        System.out.println("Naviguar : " + idArticle);
        Article showMe = articleService.getArticleSpecifique(idArticle);
        System.out.println(showMe);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierArticle.fxml"));
            Parent root = loader.load();
            ModifierArticleController maratctrl = loader.getController();
            maratctrl.setDescriptionTextField(showMe.getDescription());
            maratctrl.setTexteTextField(showMe.getTexte());
            maratctrl.setTitreTextField(showMe.getTitre());
            maratctrl.setTypeArticleTextField(showMe.getType());
            maratctrl.setAncienArticleId(showMe.getId());
            btnRefresh.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListeArticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void addPhotoViewToTable() {
        TableColumn<Article, Void> photoColonne = new TableColumn("Photo article");
        Callback<TableColumn<Article, Void>, TableCell<Article, Void>> cellFactory = new Callback<TableColumn<Article, Void>, TableCell<Article, Void>>() {
            @Override
            public TableCell<Article, Void> call(final TableColumn<Article, Void> param) {
                final TableCell<Article, Void> cell = new TableCell<Article, Void>() {
                    @FXML
                    private ImageView imageArticle;

                    {
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            Article article = getTableView().getItems().get(getIndex());
                            imageArticle = new ImageView(article.getPhotoArticle());
                            imageArticle.setFitHeight(100);
                            imageArticle.setFitWidth(100);
                            setGraphic(imageArticle);
                        }
                    }
                };
                return cell;
            }
        };
        photoColonne.setCellFactory(cellFactory);
        articlesTable.getColumns().add(photoColonne);
    }

    @FXML
    private void naviguerVersAjouter(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterArticle.fxml"));
            Parent root = loader.load();
            AjouterArticleController ajartctrl = loader.getController();
            btnAjouter.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListeArticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void naviguerVersMesArticles(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MesArticles.fxml"));
            Parent root = loader.load();
            MesArticlesController mesartsctrl = loader.getController();
            btnAjouter.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(MesArticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void naviguerVersLectureArticle(int idArticle) {

        System.out.println("Naviguar lecture Article : " + idArticle);
        Article showMe = articleService.getArticleSpecifique(idArticle);
        System.out.println(showMe);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherArticle.fxml"));
            Parent root = loader.load();
            AfficherArticleController affArtCtrl = loader.getController();
            affArtCtrl.setImageArticle(showMe.getPhotoArticle());
            affArtCtrl.setTexteArticle(showMe.getTexte());
            affArtCtrl.setDateLabel(showMe.getDateHeure() + " écrit par : ");
            affArtCtrl.setUtilisateurLabel(showMe.getUtilisateur());
            affArtCtrl.setTitreLabel(showMe.getTitre());
            affArtCtrl.setTypeArticle(showMe.getType());
            btnAjouter.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficherResultatRecherche(KeyEvent event) {
        if (rechercheTextField.getText() != "") {
            articlesTable.setItems(articleService.rechercheArticles(rechercheTextField.getText()));
        }
    }

    private void addLireButtonToTable() {
        TableColumn<Article, Void> lireBtn = new TableColumn("Lire");
        Callback<TableColumn<Article, Void>, TableCell<Article, Void>> cellFactory = new Callback<TableColumn<Article, Void>, TableCell<Article, Void>>() {
            @Override
            public TableCell<Article, Void> call(final TableColumn<Article, Void> param) {
                final TableCell<Article, Void> cell = new TableCell<Article, Void>() {
                    @FXML
                    private final JFXButton btn = new JFXButton("Lire");

                    {
                        FontAwesomeIconView fview = new FontAwesomeIconView(FontAwesomeIcon.EDIT);
                        fview.setStyle("-fx-fill: white;");
                        btn.setButtonType(JFXButton.ButtonType.RAISED);
                        btn.setGraphic(fview);
                        btn.setStyle("-fx-background-color: \"#4286f4\";\n"
                                + "-fx-text-fill: white;");
                        btn.setOnAction((ActionEvent event) -> {
                            Article article = getTableView().getItems().get(getIndex());
                            //Appel de la méthode de modification ici :
                            System.out.println("Article à modifier: " + article.getId());
                            naviguerVersLectureArticle(article.getId());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        lireBtn.setCellFactory(cellFactory);
        articlesTable.getColumns().add(lireBtn);
    }

    private void addTypeArticleToTable() {
        TableColumn<Article, Void> typeArticle = new TableColumn("Type d'article");
        Callback<TableColumn<Article, Void>, TableCell<Article, Void>> cellFactory = new Callback<TableColumn<Article, Void>, TableCell<Article, Void>>() {
            @Override
            public TableCell<Article, Void> call(final TableColumn<Article, Void> param) {
                final TableCell<Article, Void> cell = new TableCell<Article, Void>() {
                    @FXML
                    private Label lblType = new Label();

                    {
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            Article article = getTableView().getItems().get(getIndex());
                            TypeArticleService tArtServ = new TypeArticleService();

                            lblType.setText(" " + tArtServ.getNomTypeArticle(article.getType()) + " ");
                            switch (article.getType() % 2) {
                                case 0:
                                    lblType.setStyle("-fx-background-color: #4286f4; -fx-text-fill: white;");
                                    break;
                                case 1:
                                    lblType.setStyle("-fx-background-color: #b755fc; -fx-text-fill: white;");
                                    break;
                                default:
                                    break;
                            }
                            setGraphic(lblType);
                        }
                    }
                };
                return cell;
            }
        };
        typeArticle.setCellFactory(cellFactory);
        articlesTable.getColumns().add(typeArticle);
    }

    private void addAuteurToTable() {
        TableColumn<Article, Void> auteurArticle = new TableColumn("Auteur");
        Callback<TableColumn<Article, Void>, TableCell<Article, Void>> cellFactory = new Callback<TableColumn<Article, Void>, TableCell<Article, Void>>() {
            @Override
            public TableCell<Article, Void> call(final TableColumn<Article, Void> param) {
                final TableCell<Article, Void> cell = new TableCell<Article, Void>() {
                    @FXML
                    private Label lblAuteur = new Label();

                    {
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            Article article = getTableView().getItems().get(getIndex());
                            MoezUtils mu = new MoezUtils();
                            lblAuteur.setText(mu.getNomUserForArticles(article.getUtilisateur()));
                            lblAuteur.setOnMouseClicked((event) -> {
                                //Navigation vers le profil de l'auteur
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/thinklance/pidev/GUI/ProfileDescription.fxml"));
                                Parent root;
                                try {
                                    root = loader.load();
                                    ProfileDescriptionController profileviewcontroller = loader.getController();
                                    UserService user = new UserService();
                                    UserManager um = new UserManager();

                                    profileviewcontroller.transferMessage(user.getTheUserIdfromemail(um.getUserConnected()));
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(root));
                                    stage.setTitle("Profile User");
                                    Stage stage2 = (Stage) btnRefresh.getScene().getWindow();
                                    stage2.close();
                                    stage.show();

                                } catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                                }

                            });
                            setGraphic(lblAuteur);
                        }
                    }
                };
                return cell;
            }
        };
        auteurArticle.setCellFactory(cellFactory);
        articlesTable.getColumns().add(auteurArticle);
    }
}

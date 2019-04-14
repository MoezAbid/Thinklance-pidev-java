/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.TypeArticle;

import com.jfoenix.controls.JFXButton;
import com.thinklance.pidev.App.Launcher;
import com.thinklance.pidev.Service.Impl.TypeArticleService;

import com.thinklance.pidev.entities.TypeArticle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author Moez
 */
public class ListeTypesArticlesController implements Initializable {

    @FXML
    private TableView<TypeArticle> tableTypeAritcles;
    @FXML
    private TableColumn<TypeArticle, Integer> idTypeArticleColonne;
    @FXML
    private TableColumn<TypeArticle, String> nomTypeArticleColonne;
    @FXML
    private JFXButton btnAjouterTypeArticle;

    private TypeArticleService tarService = new TypeArticleService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableTypeAritcles.setItems(tarService.getListeTypesArticles());
        idTypeArticleColonne.setCellValueFactory(new PropertyValueFactory("id"));
        nomTypeArticleColonne.setCellValueFactory(new PropertyValueFactory("nom"));
        addModifierButtonToTable();
        addSupprimerButtonToTable();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                refresh();
            }
        }, 0, 2 * 1000);
    }

    @FXML
    private void ajouterTypeArticle(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/thinklance/pidev/GUI/TypeArticle/AjouterTypeArticle.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addModifierButtonToTable() {
        TableColumn<TypeArticle, Void> modifierBtn = new TableColumn("Modifier");
        Callback<TableColumn<TypeArticle, Void>, TableCell<TypeArticle, Void>> cellFactory = new Callback<TableColumn<TypeArticle, Void>, TableCell<TypeArticle, Void>>() {
            @Override
            public TableCell<TypeArticle, Void> call(final TableColumn<TypeArticle, Void> param) {
                final TableCell<TypeArticle, Void> cell = new TableCell<TypeArticle, Void>() {
                    @FXML
                    private final JFXButton btn = new JFXButton("Modifier");

                    {
                        final ImageView buttonModifImage = new ImageView("/com/thinklance/pidev/ressourses/ModifierButtonArticle.png");
                        FontAwesomeIconView fview = new FontAwesomeIconView(FontAwesomeIcon.EDIT);
                        fview.setStyle("-fx-fill: white;");
                        buttonModifImage.setScaleX(0.65);
                        buttonModifImage.setScaleY(0.65);
                        btn.setButtonType(JFXButton.ButtonType.RAISED);
                        btn.setGraphic(fview);
                        btn.setStyle("-fx-background-color: \"#4286f4\";\n"
                                + "-fx-text-fill: white;");
                        btn.setOnAction((ActionEvent event) -> {
                            TypeArticle typeArticle = getTableView().getItems().get(getIndex());
                            //Appel de la méthode de modification ici :
                            System.out.println("Type d'article à modifier: " + typeArticle.getId());
                            naviguarVersPageDeModification(typeArticle.getId());
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
        modifierBtn.setCellFactory(cellFactory);
        tableTypeAritcles.getColumns().add(modifierBtn);
    }

    private void addSupprimerButtonToTable() {
        TableColumn<TypeArticle, Void> supprimerBtn = new TableColumn("Supprimer");
        Callback<TableColumn<TypeArticle, Void>, TableCell<TypeArticle, Void>> cellFactory = new Callback<TableColumn<TypeArticle, Void>, TableCell<TypeArticle, Void>>() {
            @Override
            public TableCell<TypeArticle, Void> call(final TableColumn<TypeArticle, Void> param) {
                final TableCell<TypeArticle, Void> cell = new TableCell<TypeArticle, Void>() {
                    @FXML
                    private final JFXButton btn = new JFXButton("Supprimer");

                    {
                        final ImageView buttonModifImage = new ImageView("/com/thinklance/pidev/ressourses/SupprimerButtonArticle.png");
                        FontAwesomeIconView fview = new FontAwesomeIconView(FontAwesomeIcon.REMOVE);
                        fview.setStyle("-fx-fill: white;");
                        btn.setButtonType(JFXButton.ButtonType.RAISED);
                        btn.setGraphic(fview);
                        btn.setStyle("-fx-background-color: \"#ff8e7a\";\n"
                                + "-fx-text-fill: white;");
                        btn.setOnAction((ActionEvent event) -> {
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Suppression de de type d'article");
                            alert.setHeaderText(null);
                            alert.setContentText("Êtes-vous sûr de supprimer ce type d'article ?");
                            Optional<ButtonType> result = alert.showAndWait();
                            if (!result.isPresent()) {
                                Alert alertRien = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Type d'article non supprimé");
                                alert.setHeaderText(null);
                                alert.setContentText("Le type d'article n'a pas été supprimé.");
                            } else if (result.get() == ButtonType.OK) {
                                TypeArticle typeArticle = getTableView().getItems().get(getIndex());
                                //Appel de la méthode de modification ici :
                                tarService.supprimerTypeArticle(typeArticle.getId());
                                refresh();
                            } else if (result.get() == ButtonType.CANCEL) {
                                Alert alertRien = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Article non modifié");
                                alert.setHeaderText(null);
                                alert.setContentText("L'article n'a pas supprimé.");
                            }
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
        supprimerBtn.setCellFactory(cellFactory);
        tableTypeAritcles.getColumns().add(supprimerBtn);
    }

    private void naviguarVersPageDeModification(int id) {
        System.out.println("Naviguar : " + id);
        TypeArticle showMe = tarService.getTypeArticleSpecifique(id);
        System.out.println("SHOW ME : " + showMe);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierTypeArticle.fxml"));
            Parent root1 = (Parent) loader.load();
            ModifierTypeArticleController mTyAratCtrl = loader.getController();

            mTyAratCtrl.setNomTypeArticle(showMe.getNom());
            mTyAratCtrl.setIdancienTypeArticle(showMe.getId());
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ModifierTypeArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refresh() {
        tableTypeAritcles.setItems(this.tarService.getListeTypesArticles());
        System.out.println("Liste des types d'articles rafraichie.");
    }

}

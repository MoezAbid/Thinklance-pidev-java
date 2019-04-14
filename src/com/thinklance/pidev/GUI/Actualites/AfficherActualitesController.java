/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI.Actualites;

import com.jfoenix.controls.JFXButton;
import com.thinklance.pidev.Services.Impl.ActualitesService;
import com.thinklance.pidev.Utils.MoezUtils;
import com.thinklance.pidev.entities.Actualite;
import com.thinklance.pidev.entities.Article;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * FXML Controller class
 *
 * @author Moez
 */
public class AfficherActualitesController implements Initializable {

    //Table Actualités Technologies
    @FXML
    private TableView<Actualite> actuTableTech;
    @FXML
    private TableColumn<Actualite, String> titreColonneTech;
    @FXML
    private TableColumn<Actualite, String> descriptionColonneTech;
    @FXML
    private TableColumn<Actualite, Integer> auteurColonneTech;
    @FXML
    private TableColumn<Actualite, Date> datePublicationColonneTech;
    //Table Actualités Programmation/Applications
    @FXML
    private TableView<Actualite> actuTableProg;
    @FXML
    private TableColumn<Actualite, String> titreColonneProg;
    @FXML
    private TableColumn<Actualite, String> descriptionColonneProg;
    @FXML
    private TableColumn<Actualite, Integer> auteurColonneProg;
    @FXML
    private TableColumn<Actualite, Date> datePublicationColonneProg;
    @FXML
    private TableView<Actualite> actuTableFreelance;
    @FXML
    private TableColumn<Actualite, String> titreColonneFreelance;
    @FXML
    private TableColumn<Actualite, String> descriptionColonneFreelance;
    @FXML
    private TableColumn<Actualite, Integer> auteurColonneFreelance;
    @FXML
    private TableColumn<Actualite, Date> datePublicationColonneFreelance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Table Actualités Technologies
        ActualitesService actualitesService = new ActualitesService();
        actuTableTech.setItems(actualitesService.getTechnologies());
        addPhotoViewToTechnologiesTable();
        addLireActualiteToTechnologiesTable();
        titreColonneTech.setCellValueFactory(new PropertyValueFactory("titre"));
        descriptionColonneTech.setCellValueFactory(new PropertyValueFactory("description"));
        auteurColonneTech.setCellValueFactory(new PropertyValueFactory("auteur"));
        datePublicationColonneTech.setCellValueFactory(new PropertyValueFactory("datePublication"));
        //Table Actualités Programmation/Applications
        actuTableProg.setItems(actualitesService.getProgrammationEtApplications());
        addPhotoViewToProgrammationTable();
        addLireActualiteToProgrammationTable();
        titreColonneProg.setCellValueFactory(new PropertyValueFactory("titre"));
        descriptionColonneProg.setCellValueFactory(new PropertyValueFactory("description"));
        auteurColonneProg.setCellValueFactory(new PropertyValueFactory("auteur"));
        datePublicationColonneProg.setCellValueFactory(new PropertyValueFactory("datePublication"));
        //Table Actualités Freelance
        actuTableFreelance.setItems(actualitesService.getFreelanceActualites());
        addPhotoViewToFreelanceTable();
        addLireActualiteToFreelanceTable();
        titreColonneFreelance.setCellValueFactory(new PropertyValueFactory("titre"));
        descriptionColonneFreelance.setCellValueFactory(new PropertyValueFactory("description"));
        auteurColonneFreelance.setCellValueFactory(new PropertyValueFactory("auteur"));
        datePublicationColonneFreelance.setCellValueFactory(new PropertyValueFactory("datePublication"));
    }

    private void addPhotoViewToTechnologiesTable() {
        TableColumn<Actualite, Void> colonnePhoto = new TableColumn("Photo");
        Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>> cellFactory = new Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>>() {
            @Override
            public TableCell<Actualite, Void> call(final TableColumn<Actualite, Void> param) {
                final TableCell<Actualite, Void> cell = new TableCell<Actualite, Void>() {
                    @FXML
                    private ImageView imageActualite;

                    {
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            MoezUtils.getTrustManagerSSL();
                            Actualite act = getTableView().getItems().get(getIndex());
                            BufferedImage imageS = null;
                            try {
                                URL url = new URL(act.getImage());
                                imageS = ImageIO.read(url);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            Image imageFinal = SwingFXUtils.toFXImage(imageS, null);
                            imageActualite = new ImageView(imageFinal);
                            imageActualite.setFitHeight(200);
                            imageActualite.setFitWidth(200);
                            setGraphic(imageActualite);
                        }
                    }
                };
                return cell;
            }
        };
        colonnePhoto.setCellFactory(cellFactory);
        actuTableTech.getColumns().add(colonnePhoto);
    }

    private void addLireActualiteToTechnologiesTable() {
        TableColumn<Actualite, Void> lireBtn = new TableColumn("Lire");
        Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>> cellFactory = new Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>>() {
            @Override
            public TableCell<Actualite, Void> call(final TableColumn<Actualite, Void> param) {
                final TableCell<Actualite, Void> cell = new TableCell<Actualite, Void>() {
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
                            Actualite actualite = getTableView().getItems().get(getIndex());
                            //Appel de la méthode de modification ici :
                            MoezUtils.openWebpage(URI.create(actualite.getUrlToAcualite()));
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
        actuTableTech.getColumns().add(lireBtn);
    }

    private void addLireActualiteToProgrammationTable() {
        TableColumn<Actualite, Void> lireBtn = new TableColumn("Lire");
        Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>> cellFactory = new Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>>() {
            @Override
            public TableCell<Actualite, Void> call(final TableColumn<Actualite, Void> param) {
                final TableCell<Actualite, Void> cell = new TableCell<Actualite, Void>() {
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
                            Actualite actualite = getTableView().getItems().get(getIndex());
                            //Appel de la méthode de modification ici :
                            MoezUtils.openWebpage(URI.create(actualite.getUrlToAcualite()));
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
        actuTableProg.getColumns().add(lireBtn);
    }

    private void addPhotoViewToFreelanceTable() {
        TableColumn<Actualite, Void> colonnePhoto = new TableColumn("Photo");
        Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>> cellFactory = new Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>>() {
            @Override
            public TableCell<Actualite, Void> call(final TableColumn<Actualite, Void> param) {
                final TableCell<Actualite, Void> cell = new TableCell<Actualite, Void>() {
                    @FXML
                    private ImageView imageActualite;

                    {
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            MoezUtils.getTrustManagerSSL();
                            Actualite act = getTableView().getItems().get(getIndex());
                            BufferedImage imageS = null;
                            try {
                                URL url = new URL(act.getImage());
                                imageS = ImageIO.read(url);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            Image imageFinal = SwingFXUtils.toFXImage(imageS, null);
                            imageActualite = new ImageView(imageFinal);
                            imageActualite.setFitHeight(200);
                            imageActualite.setFitWidth(200);
                            setGraphic(imageActualite);
                        }
                    }
                };
                return cell;
            }
        };
        colonnePhoto.setCellFactory(cellFactory);
        actuTableFreelance.getColumns().add(colonnePhoto);
    }

    private void addLireActualiteToFreelanceTable() {
        TableColumn<Actualite, Void> lireBtn = new TableColumn("Lire");
        Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>> cellFactory = new Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>>() {
            @Override
            public TableCell<Actualite, Void> call(final TableColumn<Actualite, Void> param) {
                final TableCell<Actualite, Void> cell = new TableCell<Actualite, Void>() {
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
                            Actualite actualite = getTableView().getItems().get(getIndex());
                            //Appel de la méthode de modification ici :
                            MoezUtils.openWebpage(URI.create(actualite.getUrlToAcualite()));
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
        actuTableFreelance.getColumns().add(lireBtn);
    }

    private void addPhotoViewToProgrammationTable() {
        TableColumn<Actualite, Void> colonnePhoto = new TableColumn("Photo");
        Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>> cellFactory = new Callback<TableColumn<Actualite, Void>, TableCell<Actualite, Void>>() {
            @Override
            public TableCell<Actualite, Void> call(final TableColumn<Actualite, Void> param) {
                final TableCell<Actualite, Void> cell = new TableCell<Actualite, Void>() {
                    @FXML
                    private ImageView imageActualite;

                    {
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            MoezUtils.getTrustManagerSSL();
                            Actualite act = getTableView().getItems().get(getIndex());
                            BufferedImage imageS = null;
                            try {
                                URL url = new URL(act.getImage());
                                imageS = ImageIO.read(url);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            Image imageFinal = SwingFXUtils.toFXImage(imageS, null);
                            imageActualite = new ImageView(imageFinal);
                            imageActualite.setFitHeight(200);
                            imageActualite.setFitWidth(200);
                            setGraphic(imageActualite);
                        }
                    }
                };
                return cell;
            }
        };
        colonnePhoto.setCellFactory(cellFactory);
        actuTableProg.getColumns().add(colonnePhoto);
    }
}

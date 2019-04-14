/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.gn.GNCarousel;
import com.thinklance.pidev.Utils.ListViewService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.thinklance.pidev.Service.Impl.CompetenceService;
import com.thinklance.pidev.Service.Impl.ExperienceService;
import com.thinklance.pidev.Service.Impl.FormationService;
import com.thinklance.pidev.Service.Impl.PortfolioService;
import com.thinklance.pidev.Service.Impl.UserService;
import com.thinklance.pidev.Utils.ListViewItem;
import com.thinklance.pidev.Utils.UserManager;
import com.thinklance.pidev.entities.Competence;
import com.thinklance.pidev.entities.ExperienceProfessionnel;
import com.thinklance.pidev.entities.Formation;
import com.thinklance.pidev.entities.Portfolio;
import com.thinklance.pidev.entities.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CreateProfileController implements Initializable {

    @FXML
    private JFXButton btnNextCategories;
    @FXML
    private JFXButton btnPreviousInformationsPersonnelles;
    @FXML
    private JFXButton btnNextCompetences;
    @FXML
    private JFXButton btnPreviousCategories;
    @FXML
    private JFXButton btnNext;
    @FXML
    private JFXButton btnPreviousCompetences;
    @FXML
    private JFXButton btnNextExperiencesProfessionnelles;
    @FXML
    private JFXButton btnPrevious;
    @FXML
    private JFXButton btnNextPotfolio;
    @FXML
    private JFXButton btnPreviousExperiencesProfessionnelles;
    @FXML
    private JFXButton btnNextLangue;
    @FXML
    private JFXButton btnPreviousPotfolio;
    @FXML
    private Tab TabInformationsPersonnelles;
    @FXML
    private Tab TabCategories;
    @FXML
    private Tab TabCompetences;
    @FXML
    private Tab TabFormations;
    @FXML
    private Tab TabExperiencesProfessionnelles;
    @FXML
    private Tab TabPotfolio;
    @FXML
    private Tab TabLangue;
    @FXML
    private TabPane TabPaneCreateProfile;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private JFXTextField titreprofil;
    @FXML
    private JFXTextField tarif;
    @FXML
    private JFXComboBox pays;
    @FXML
    private JFXComboBox ville;
    @FXML
    private JFXButton btn_refrech;
    @FXML
    private JFXTextArea description;
    @FXML
    private ImageView image_profil;
    @FXML
    private Button btn_choisir;
    @FXML
    private JFXTextField tarifReel;
    @FXML
    private ListView listView;
    @FXML
    private JFXButton btn_refrech1;
    @FXML
    private JFXButton create;
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField titreformation;
    @FXML
    private JFXButton btn_refrech2;
    private JFXDatePicker datedebut;
    private JFXDatePicker datefin;
    @FXML
    private JFXTextField institution;
    @FXML
    private JFXButton btn_refrech3;
    @FXML
    private JFXTextField entreprise;
    @FXML
    private ImageView files;
    @FXML
    private ListView listView1;
    @FXML
    private JFXButton btn_refrech11;
    @FXML
    private JFXButton create1;
    @FXML
    private JFXButton save1;
    @FXML
    private JFXButton delete1;
    @FXML
    private JFXTextField Langue;

    private FileChooser filechooser = new FileChooser();
    private File file;
    private Image img;
    private VBox vBox;
    @FXML
    private StackPane root;
    @FXML
    private AnchorPane developpeursIntegrateurs;
    @FXML
    private AnchorPane designers;
    @FXML
    private AnchorPane redacteurs;
    @FXML
    private AnchorPane graphistes;
    @FXML
    private AnchorPane Chefprojet;
    @FXML
    private AnchorPane consultants;
    Optional<ListViewItem> currentListItemEntity = Optional.ofNullable(null);
    @FXML
    private JFXSlider progressval;
    @FXML
    private JFXTextArea descriptionforma;
    @FXML
    private JFXDatePicker datedebutform;
    @FXML
    private JFXDatePicker datefinform;
    @FXML
    private JFXTextField titreexperience;
    @FXML
    private JFXTextArea descriptionexperience;
    @FXML
    private JFXDatePicker datedebutexperience;
    @FXML
    private JFXDatePicker datefinexperience;
    @FXML
    private JFXButton selectimageprotfolio;
    @FXML
    private AnchorPane anchorportfolio;
    @FXML
    private JFXButton btn_valider_portfolio;
    @FXML
    private JFXButton btn_valider_portfolio1;
    private boolean informationspersonnelles = true;
    private boolean formation = true;
    private boolean experiencesProfessionnelles = true;
    private boolean competences = true;
    private boolean langue = true;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // test des champs d' Informationspersonnelles
        if (!titreprofil.getText().isEmpty()) {
            titreprofil.getStyleClass().remove("alert-danger");
            titreprofil.setTooltip(null);
        } else {
            informationspersonnelles = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez un titre valide!");
            titreprofil.getValidators().add(validator);

            titreprofil.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        titreprofil.validate();
                    }
                }
            });
        }

        if (!tarif.getText().isEmpty()) {
            tarif.getStyleClass().remove("alert-danger");
            tarif.setTooltip(null);
        } else {
            informationspersonnelles = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez un tarif valide!");
            tarif.getValidators().add(validator);

            tarif.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        tarif.validate();
                    }
                }
            });
        }
        if (!description.getText().isEmpty()) {
            description.getStyleClass().remove("alert-danger");
            description.setTooltip(null);
        } else {
            informationspersonnelles = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez une description valide!");
            description.getValidators().add(validator);

            description.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        description.validate();
                    }
                }
            });
        }
        if (pays.getValue() == "") {
            pays.getStyleClass().remove("alert-danger");
            pays.setTooltip(null);
        } else {
            informationspersonnelles = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez un pays valide!");
            pays.getValidators().add(validator);

            pays.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        pays.validate();
                    }
                }
            });
        }
        if (ville.getValue() == "") {
            ville.getStyleClass().remove("alert-danger");
            ville.setTooltip(null);
        } else {
            informationspersonnelles = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez une ville valide!");
            ville.getValidators().add(validator);

            ville.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        ville.validate();
                    }
                }
            });
        }
        if (image_profil.imageProperty().getValue().toString().contains("javafx.scene.image.")) {
            informationspersonnelles = false;
        }

        //
        // test des champs du Formation
        //
        if (!titreformation.getText().isEmpty()) {
            titreformation.getStyleClass().remove("alert-danger");
            titreformation.setTooltip(null);
        } else {
            formation = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez un titre de formation valide!");
            titreformation.getValidators().add(validator);

            titreformation.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        titreformation.validate();
                    }
                }
            });
        }

        if (!institution.getText().isEmpty()) {
            institution.getStyleClass().remove("alert-danger");
            institution.setTooltip(null);
        } else {
            formation = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez un institution valide!");
            institution.getValidators().add(validator);

            institution.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        institution.validate();
                    }
                }
            });
        }
        if (!descriptionforma.getText().isEmpty()) {
            descriptionforma.getStyleClass().remove("alert-danger");
            descriptionforma.setTooltip(null);
        } else {
            formation = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez une description de formation valide!");
            descriptionforma.getValidators().add(validator);

            descriptionforma.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        descriptionforma.validate();
                    }
                }
            });
        }
        if (datedebutform.getValue() != null) {
            datedebutform.getStyleClass().remove("alert-danger");
            datedebutform.setTooltip(null);
        } else {
            formation = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez une date de debut de formation valide!");
            datedebutform.getValidators().add(validator);

            datedebutform.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        datedebutform.validate();
                    }
                }
            });
        }
        if (datefinform.getValue() != null) {
            datefinform.getStyleClass().remove("alert-danger");
            datefinform.setTooltip(null);
            System.out.println(datefinform.getValue());

        } else {
            formation = false;
            System.out.println(datefinform.getValue());

            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez une date de fin de formation valide!");
            datefinform.getValidators().add(validator);

            datefinform.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        datefinform.validate();
                    }
                }
            });

        }

        //
        // test des champs d'Expériences professionnelles
        //
        if (!titreexperience.getText().isEmpty()) {
            titreexperience.getStyleClass().remove("alert-danger");
            titreexperience.setTooltip(null);
        } else {
            experiencesProfessionnelles = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez un titre d'experience valide!");
            titreexperience.getValidators().add(validator);

            titreexperience.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        titreexperience.validate();
                    }
                }
            });
        }

        if (!entreprise.getText().isEmpty()) {
            entreprise.getStyleClass().remove("alert-danger");
            entreprise.setTooltip(null);
        } else {
            experiencesProfessionnelles = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez une entreprise valide!");
            entreprise.getValidators().add(validator);

            entreprise.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        entreprise.validate();
                    }
                }
            });
        }
        if (!descriptionexperience.getText().isEmpty()) {
            descriptionexperience.getStyleClass().remove("alert-danger");
            descriptionexperience.setTooltip(null);
        } else {
            experiencesProfessionnelles = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez un description d'experience valide!");
            descriptionexperience.getValidators().add(validator);

            descriptionexperience.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        descriptionexperience.validate();
                    }
                }
            });
        }
        if (datedebutexperience.getValue() != null) {
            datedebutexperience.getStyleClass().remove("alert-danger");
            datedebutexperience.setTooltip(null);
        } else {
            experiencesProfessionnelles = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez une date de debut d'experience valide!");
            datedebutexperience.getValidators().add(validator);

            datedebutexperience.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        datedebutexperience.validate();
                    }
                }
            });
        }
        if (datefinexperience.getValue() != null) {
            datefinexperience.getStyleClass().remove("alert-danger");
            datefinexperience.setTooltip(null);

        } else {
            experiencesProfessionnelles = false;
            System.out.println(datefinexperience.getValue());

            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez une date de fin d'experience valide!");
            datefinexperience.getValidators().add(validator);

            datefinexperience.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        datefinexperience.validate();
                    }
                }
            });

        }

        if (!name.getText().isEmpty()) {
            name.getStyleClass().remove("alert-danger");
            name.setTooltip(null);
        } else {
            competences = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez une Competence valide!");
            name.getValidators().add(validator);

            name.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        name.validate();
                    }
                }
            });
        }

        if (!Langue.getText().isEmpty()) {
            Langue.getStyleClass().remove("alert-danger");
            Langue.setTooltip(null);
        } else {
            langue = false;
            RequiredFieldValidator validator = new RequiredFieldValidator();
            validator.setMessage("Saisissez un Langue valide!");
            Langue.getValidators().add(validator);

            Langue.focusedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        Langue.validate();
                    }
                }
            });
        }
        pays.setEditable(true);
        ville.setEditable(true);
        String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisie", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};
        String[] competences = new String[]{"Ada", "C++", "C#", "Delphi", "Fortran", "Eiffel", "Gambas 3", "Java", "Kylix", "Objective-C", "Objective Caml", "Perl", "PHP", "Python", "SmallTalk", "Ruby", "Visual Basic", "JavaScript", "Angular", "SQL"};
        TextFields.bindAutoCompletion(name, competences);
        pays.getItems().addAll(countries);
        TextFields.bindAutoCompletion(pays.getEditor(), pays.getItems());
        pays.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        System.out.println("Value is: " + newValue);
                        if (newValue.equals("France")) {
                            String[] citiesfrances = new String[]{"Paris", "Lyon", "Marseille", "Lille", "Nice", "Toulouse", "Bordeaux", "Rouen", "Strasbourg", "Nantes", "Metz", "Grenoble", "Toulon", "Montpellier", "Nancy", "Saint-Étienne", "Melun", "Le Havre", "Tours", "Clermont-Ferrand", "Orléans", "Mulhouse", "Rennes", "Reims", "Caen", "Angers", "Dijon"};
                            ville.getItems().clear();
                            ville.getItems().addAll(citiesfrances);
                            TextFields.bindAutoCompletion(ville.getEditor(), ville.getItems());
                        } else if (newValue.equals("Tunisie")) {
                            String[] citiestunisia = new String[]{"Béja", "Ben Arous", "Bizerte", "Gabes", "Mahdia", "Médenine", "Monastir", "Nabeul", "Sfax", "Sidi Bouzid", "Siliana", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan", "Jendouba", "Kairouan", "Kasserine", "Kebili", "La Manouba", "Le Kef",};
                            ville.getItems().clear();
                            ville.getItems().addAll(citiestunisia);
                            TextFields.bindAutoCompletion(ville.getEditor(), ville.getItems());
                        } else {
                            ville.getItems().clear();
                            ville.setValue("");
                        }

                    }
                });

        //Pour les  competences
        listService = ListViewService.getInstance();
        listService.init();
        listView.setItems(listService.observableListViewItems);
        currentListItemEntity = Optional.of(listService.observableListViewItems.get(0));

        updateFields();

        // Handle TextField text changes.
        name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (currentListItemEntity.get().getName().equals(newValue)) {
                save.setDisable(true);
            } else {
                save.setDisable(false);
            }
        });
        // Handle TextField text changes.
        name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (currentListItemEntity.get().getValue().equals(newValue)) {
                save.setDisable(true);
            } else {
                save.setDisable(false);
            }
        });
        save.setDisable(true);

    }

    @FXML
    public void PreviousInformationsPersonnelles(ActionEvent event) {
        System.out.println("aa");
        TabPaneCreateProfile.getSelectionModel().select(TabInformationsPersonnelles);
    }

    @FXML
    public void NextCategories(ActionEvent event) {
        System.out.println("aa");
        TabPaneCreateProfile.getSelectionModel().select(TabCategories);
    }

    @FXML
    public void PreviousCategories(ActionEvent event) {
        TabPaneCreateProfile.getSelectionModel().select(TabCategories);
    }

    @FXML
    public void NextCompetences(ActionEvent event) {
        TabPaneCreateProfile.getSelectionModel().select(TabCompetences);
    }

    @FXML
    public void PreviousCompetences(ActionEvent event) {
        TabPaneCreateProfile.getSelectionModel().select(TabCompetences);
    }

    @FXML
    public void NextFormations(ActionEvent event) {
        TabPaneCreateProfile.getSelectionModel().select(TabFormations);
    }

    @FXML
    public void PreviousFormations(ActionEvent event) {
        TabPaneCreateProfile.getSelectionModel().select(TabFormations);
    }

    @FXML
    public void NextExperiencesProfessionnelles(ActionEvent event) {
        TabPaneCreateProfile.getSelectionModel().select(TabExperiencesProfessionnelles);
    }

    @FXML
    public void PreviousExperiencesProfessionnelles(ActionEvent event) {
        TabPaneCreateProfile.getSelectionModel().select(TabExperiencesProfessionnelles);
    }

    @FXML
    public void NextPotfolio(ActionEvent event) {
        TabPaneCreateProfile.getSelectionModel().select(TabPotfolio);
    }

    @FXML
    public void PreviousPotfolio(ActionEvent event) {
        TabPaneCreateProfile.getSelectionModel().select(TabPotfolio);
    }

    @FXML
    public void NextLangue(ActionEvent event) {
        TabPaneCreateProfile.getSelectionModel().select(TabLangue);
    }

    @FXML
    private void reset_fields(MouseEvent event) {
    }

    @FXML
    private void valider_info(MouseEvent event) {
    }

    @FXML
    private void btn_valider(ActionEvent event) {
    }

    @FXML
    private void select_image(MouseEvent event) {
        Node node = (Node) event.getSource();

        file = filechooser.showOpenDialog(node.getScene().getWindow());
        if (file != null) {

            img = new Image(file.toURI().toString(), 100, 150, true, true);
            image_profil.setImage(img);
            System.out.println(file.getAbsolutePath());
        }

    }
    public static JFXDialog jfxdialog;

    @FXML
    private void developpeurscat(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Selectedview.fxml"));

        try {

            // TODO
            vBox = loader.load();
            SelectedviewController selectedview = (SelectedviewController) loader.getController();

            selectedview.setTitre("Sous Categorie Développeurs,Intégrateurs & Data scientists");
            JFXCheckBox box1 = new JFXCheckBox("Développeur Back-End");
            JFXCheckBox box2 = new JFXCheckBox("Data Scientist");
            JFXCheckBox box3 = new JFXCheckBox("Développeur Front-End / Intégrateur Web");
            JFXCheckBox box4 = new JFXCheckBox("Développeur Mobile");
            JFXCheckBox box5 = new JFXCheckBox("Webmaster");
            selectedview.getVboxcontent().getChildren().add(box1);
            selectedview.getVboxcontent().getChildren().add(box2);
            selectedview.getVboxcontent().getChildren().add(box3);
            selectedview.getVboxcontent().getChildren().add(box4);
            selectedview.getVboxcontent().getChildren().add(box5);

            box1.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }

                }
            });
            box2.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box3.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box4.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box4.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box4.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box5.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box5.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box5.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
        jfxdialog.show();

    }

    @FXML
    private void designerscateg(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Selectedview.fxml"));
        try {
            // TODO
            vBox = loader.load();
            SelectedviewController selectedview = (SelectedviewController) loader.getController();

            selectedview.setTitre("Sous Categorie Motion Designers Réalisateurs");
            JFXCheckBox box1 = new JFXCheckBox("Réalisateur");
            JFXCheckBox box2 = new JFXCheckBox("Game Designer");
            JFXCheckBox box3 = new JFXCheckBox("Motion Designer");
            JFXCheckBox box4 = new JFXCheckBox("Sound Designer");

            selectedview.getVboxcontent().getChildren().add(box1);
            selectedview.getVboxcontent().getChildren().add(box2);
            selectedview.getVboxcontent().getChildren().add(box3);
            selectedview.getVboxcontent().getChildren().add(box4);
            box1.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }

                }
            });
            box2.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box3.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box4.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box4.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box4.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
        jfxdialog.show();

    }

    @FXML
    private void redecateurcat(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Selectedview.fxml"));
        try {
            // TODO
            vBox = loader.load();
            SelectedviewController selectedview = (SelectedviewController) loader.getController();

            selectedview.setTitre("Sous Categorie Rédacteurs,Traducteurs,Community Managers");
            JFXCheckBox box1 = new JFXCheckBox("Community Manager");
            JFXCheckBox box2 = new JFXCheckBox("Pigiste");
            JFXCheckBox box3 = new JFXCheckBox("Traducteur");
            JFXCheckBox box4 = new JFXCheckBox("Rédacteur Web");

            selectedview.getVboxcontent().getChildren().add(box1);
            selectedview.getVboxcontent().getChildren().add(box2);
            selectedview.getVboxcontent().getChildren().add(box3);
            selectedview.getVboxcontent().getChildren().add(box4);
            box1.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }

                }
            });
            box2.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box3.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box4.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box4.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box4.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
        jfxdialog.show();
    }

    @FXML
    private void graphistescateg(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Selectedview.fxml"));
        try {
            // TODO
            vBox = loader.load();
            SelectedviewController selectedview = (SelectedviewController) loader.getController();

            selectedview.setTitre("Sous Categorie Graphistes,Designers,Photographes");
            JFXCheckBox box1 = new JFXCheckBox("Graphiste");
            JFXCheckBox box2 = new JFXCheckBox("Illustrateur");
            JFXCheckBox box3 = new JFXCheckBox("Photographe");
            JFXCheckBox box4 = new JFXCheckBox("UX Designer");
            JFXCheckBox box5 = new JFXCheckBox("Webdesigner");
            JFXCheckBox box6 = new JFXCheckBox("Directeur artistique");

            selectedview.getVboxcontent().getChildren().add(box1);
            selectedview.getVboxcontent().getChildren().add(box2);
            selectedview.getVboxcontent().getChildren().add(box3);
            selectedview.getVboxcontent().getChildren().add(box4);
            selectedview.getVboxcontent().getChildren().add(box5);
            selectedview.getVboxcontent().getChildren().add(box6);

            box1.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }

                }
            });
            box2.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box3.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box4.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box4.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box4.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box5.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box5.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box5.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });

            box6.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box6.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box6.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
        jfxdialog.show();
    }

    @FXML
    private void chefprojetcateg(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Selectedview.fxml"));
        try {
            // TODO
            vBox = loader.load();
            SelectedviewController selectedview = (SelectedviewController) loader.getController();

            selectedview.setTitre("Sous Categorie Chefs de Projet & Coachs Agile");
            JFXCheckBox box1 = new JFXCheckBox("Coach Agile");
            JFXCheckBox box2 = new JFXCheckBox("Product Manager");
            JFXCheckBox box3 = new JFXCheckBox("Chef de Projet");
            JFXCheckBox box4 = new JFXCheckBox("Scrum Master");

            selectedview.getVboxcontent().getChildren().add(box1);
            selectedview.getVboxcontent().getChildren().add(box2);
            selectedview.getVboxcontent().getChildren().add(box3);
            selectedview.getVboxcontent().getChildren().add(box4);
            box1.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }

                }
            });
            box2.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box3.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box4.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box4.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box4.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
        jfxdialog.show();
    }

    @FXML
    private void consultantsstrategiescat(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Selectedview.fxml"));
        try {
            // TODO
            vBox = loader.load();
            SelectedviewController selectedview = (SelectedviewController) loader.getController();

            selectedview.setTitre("Sous Categorie Consultants en Stratégie, Progiciel, Communication");
            JFXCheckBox box1 = new JFXCheckBox("Business Developer");
            JFXCheckBox box2 = new JFXCheckBox("Consultant en Communication");
            JFXCheckBox box3 = new JFXCheckBox("Consultant en Stratégie");
            selectedview.getVboxcontent().getChildren().add(box1);
            selectedview.getVboxcontent().getChildren().add(box2);
            selectedview.getVboxcontent().getChildren().add(box3);
            box1.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box1.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }

                }
            });
            box2.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box2.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });
            box3.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {

                        selectedview.getListvalues().add(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());
                    } else {

                        selectedview.getListvalues().remove(box3.getText());
                        System.out.println(selectedview.getListvalues().toString());

                    }
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(ProfilesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        jfxdialog = new JFXDialog(root, vBox, JFXDialog.DialogTransition.CENTER);
        jfxdialog.show();
    }

    @FXML
    private void reset_fields_info_perso(MouseEvent event) {

        titreprofil.setText("");
        pays.setValue("");
        ville.setValue("");
        tarif.setText("");
        description.setText("");
        file = new File("F:\\Desktop\\Esprit_3A\\Semestre22\\PIDEV\\JavaFX Pidev\\ThinkLance (2)\\src\\com\\thinklance\\pidev\\ressourses\\user.png");
        img = new Image(file.toURI().toString(), 200, 200, true, true);
        image_profil.setImage(img);

    }

    @FXML
    private void valider_info_perso(MouseEvent event) {
        UserService user = new UserService();
        UserManager usermanager = new UserManager();
        User u = new User();
        u.setIdUser(user.getTheUserIdfromemail(usermanager.getUserConnected()));
        u.setTitre_profile(titreprofil.getText());
        u.setPays(pays.getValue().toString());
        u.setVille(ville.getValue().toString());
        u.setTarif_moyen(Double.parseDouble(tarif.getText()));
        u.setDescription(description.getText());
        u.setImage(file.getAbsolutePath());
        user.editProfileUser(u);
    }

    @FXML
    private void listViewMouseClick(Event event) {
        //userSaveAnyChangesOption(event);
        ObservableList item = listView.getSelectionModel().getSelectedItems();
        currentListItemEntity = Optional.ofNullable((ListViewItem) item.get(0));
        updateFields();

    }

    private void userSaveAnyChangesOption(Event event) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Save current changes");
        alert.setContentText(" Item " + currentListItemEntity.get().toString() + " has been updated do you want to save changes?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.saveAction(event);
        }

    }

    @FXML
    private void createAction(ActionEvent event) {
        currentListItemEntity = Optional.ofNullable(listService.createNewEmptyItem());
        updateFields();
        listView.getSelectionModel().selectLast();
    }

    @FXML
    private void saveAction(Event event) {

        this.currentListItemEntity.get().updateValues(name.getText(), name.getText());
        save.setDisable(true);
    }

    @FXML
    private void deleteAction(ActionEvent event) {

        // Confirm action with user
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Confirmation de suppression");
        alert.setContentText("La valeur à supprimer " + currentListItemEntity.get().toString());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            listService.observableListViewItems.remove(currentListItemEntity.get());
        }
        ObservableList item = listView.getSelectionModel().getSelectedItems();
        currentListItemEntity = Optional.ofNullable((ListViewItem) item.get(0));
        updateFields();

    }

    ListViewService listService;

    private void updateFields() {
        if (currentListItemEntity.isPresent()) {
            name.setText(currentListItemEntity.get().getValue());
            name.setText(currentListItemEntity.get().getName());
            //id.setText(currentListItemEntity.get().getId());

        } else {
            //value.setText("");
            name.setText("");
            //id.setText("");
        }

    }

    @FXML
    private void valider_competences(ActionEvent event) {

        System.out.println(listView.getItems().toString());
        UserService user = new UserService();
        UserManager usermanager = new UserManager();
        User u = new User();
        CompetenceService compservice = new CompetenceService();

        for (Object list : listView.getItems()) {
            Competence c = new Competence();
            c.setNom_competence(list.toString());
            c.setId_user(user.getTheUserIdfromemail(usermanager.getUserConnected()));
            c.setDegre((int) progressval.getValue());
            compservice.addCompetence(c);
        }

    }

    @FXML
    private void reset_listview_competences(MouseEvent event) {
        listView.getItems().clear();
        name.setText("");

    }

    @FXML
    private void reset_fields_formations(MouseEvent event) {

        descriptionforma.setText("");
        institution.setText("");
        titreformation.setText("");
        datedebutform.setValue(null);
        datefinform.setValue(null);

    }

    @FXML
    private void valider_formations(MouseEvent event) {
                if (datefinform.getValue().compareTo(datedebutform.getValue())<=0) {
                formation = false;
}
        UserService user = new UserService();
        UserManager usermanager = new UserManager();
        User u = new User();
        FormationService formationservice = new FormationService();
        Formation formation = new Formation();

        formation.setDatedebut(java.sql.Date.valueOf(datedebutform.getValue()));
        formation.setDatefin(java.sql.Date.valueOf(datefinform.getValue()));
        formation.setDescription(descriptionforma.getText());
        formation.setInstitution(institution.getText());
        formation.setTitre(titreformation.getText());
        formation.setId_user(user.getTheUserIdfromemail(usermanager.getUserConnected()));
        formationservice.addFormation(formation);

    }

    @FXML
    private void reset_fields_experience(MouseEvent event) {
    }

    @FXML
    private void valider_info_experience(MouseEvent event) {
        if (datefinexperience.getValue().compareTo(datedebutexperience.getValue()) <= 0) {
            experiencesProfessionnelles = false;
        }
        UserService user = new UserService();
        UserManager usermanager = new UserManager();
        User u = new User();
        ExperienceService exp = new ExperienceService();
        ExperienceProfessionnel e = new ExperienceProfessionnel();
        e.setDatedebut(java.sql.Date.valueOf(datedebutexperience.getValue()));
        e.setDatefin(java.sql.Date.valueOf(datefinexperience.getValue()));
        e.setDescription(descriptionexperience.getText());
        e.setNom_entreprise(entreprise.getText());
        e.setTitre_exp(titreexperience.getText());
        
        e.setId_user(user.getTheUserIdfromemail(usermanager.getUserConnected()));
        exp.addExperience(e);

    }
    List<File> fileList;
    final HBox labelFile = new HBox();

    @FXML
    private void selectImagePotfolio(ActionEvent event) {
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All files", "*.*");

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(extFilter);

        /* Show open file dialog to select multiple files. */
        fileList = fileChooser.showOpenMultipleDialog(null);
        if (fileList != null && fileList.size() > 0) {

            labelFile.getChildren().clear();
            labelFile.setPrefWidth(726);
            labelFile.setPrefHeight(203);
            //anchorportfolio.getChildren().clear();
            for (File file : fileList) {

                //System.out.println(file.getPath());
                ImageView imageview = new ImageView();
                imageview.setImage(new Image(file.toURI().toString(), 200, 300, true, true));
                labelFile.setAlignment(Pos.TOP_LEFT);
                labelFile.getChildren().add(imageview);
                files.setVisible(false);
                List<String> list = new ArrayList<>();

                list.add(file.getPath());
           
                anchorportfolio.getChildren().add(labelFile);
                btn_valider_portfolio.setOnAction(e -> {
                    PortfolioService port = new PortfolioService();
                    Portfolio portt = new Portfolio();
                    for (String l : list) {
                        portt.setImage(l);
            
                    }

                    UserService user = new UserService();
                    UserManager usermanager = new UserManager();
                    User u = new User();
                    portt.setId_user(user.getTheUserIdfromemail(usermanager.getUserConnected()));
                    port.addPortfolio(portt);

                });

            }
        }

    }

    @FXML
    private void valider_iportfolio(MouseEvent event) {
    }

    @FXML
    private void rafraichir_portfolio(MouseEvent event) {
        labelFile.getChildren().clear();
          files.setVisible(true);
        
        
        
        
        
    }

}

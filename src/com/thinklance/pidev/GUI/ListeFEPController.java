/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;
import com.thinklance.pidev.Service.Impl.CategorieService;
import com.thinklance.pidev.Service.Impl.UserService;
import com.thinklance.pidev.entities.CategorieProfile;
import com.thinklance.pidev.entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ListeFEPController implements Initializable {

    @FXML
    private AnchorPane anchorMere;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private JFXSlider prixmin;
    @FXML
    private JFXSlider prixmax;
    @FXML
    private JFXToggleButton disponibilite;
    @FXML
    private JFXComboBox searchpays;
    @FXML
    private JFXComboBox searchRegion;
    @FXML
    private JFXCheckBox catDevelopement;
    @FXML
    private JFXCheckBox catDesigners;
    @FXML
    private JFXCheckBox catRedacteurs;
    @FXML
    private JFXCheckBox catGraphistes;
    @FXML
    private JFXCheckBox CatChefsprojets;
    @FXML
    private JFXCheckBox CatConsultants;
    @FXML
    private JFXButton btnNextCategories1;
    @FXML
    private JFXButton btnPreviousInformationsPersonnelles1;
    @FXML
    private JFXButton btnPreviousInformationsPersonnelles;
    @FXML
    private JFXButton btnNextEmployeurs;
    @FXML
    private TabPane TabPaneListeFEP;
    @FXML
    private Tab Freelancers;
    @FXML
    private Tab Employeurs;
    @FXML
    private Tab Projets;

    ListView<Cardlist> listView = new ListView<>();
    ObservableList<Cardlist> lis = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //FF
        String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisie", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};
        searchpays.getItems().addAll(countries);
        
        UserService user = new UserService();
        List<User> listuser = new ArrayList<>();
        List<Cardlist> list = new ArrayList<>();
        listuser = user.getAllFreelancers();
        Iterator<User> it = listuser.iterator();
        searchpays.setEditable(true);
        searchRegion.setEditable(true);
        TextFields.bindAutoCompletion(searchpays.getEditor(), searchpays.getItems());
        while (it.hasNext()) {
            User u = it.next();

            Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
            list.add(a);
        }
        searchpays.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        if (newValue.equals("France")) {
                            String[] citiesfrances = new String[]{"Paris", "Lyon", "Marseille", "Lille", "Nice", "Toulouse", "Bordeaux", "Rouen", "Strasbourg", "Nantes", "Metz", "Grenoble", "Toulon", "Montpellier", "Nancy", "Saint-Étienne", "Melun", "Le Havre", "Tours", "Clermont-Ferrand", "Orléans", "Mulhouse", "Rennes", "Reims", "Caen", "Angers", "Dijon"};
                            searchRegion.getItems().clear();
                            searchRegion.getItems().addAll(citiesfrances);
                            TextFields.bindAutoCompletion(searchRegion.getEditor(), searchRegion.getItems());
                        } else if (newValue.equals("Tunisie")) {
                            String[] citiestunisia = new String[]{"Béja", "Ben Arous", "Bizerte", "Gabes", "Mahdia", "Médenine", "Monastir", "Nabeul", "Sfax", "Sidi Bouzid", "Siliana", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan", "Jendouba", "Kairouan", "Kasserine", "Kebili", "La Manouba", "Le Kef",};
                            searchRegion.getItems().clear();
                            searchRegion.getItems().addAll(citiestunisia);
                            TextFields.bindAutoCompletion(searchRegion.getEditor(), searchRegion.getItems());
                        } else {
                            searchRegion.getItems().clear();
                            searchRegion.setValue("");
                        }

                    }
                });
        //Pour la recherche disponibilite 
        disponibilite.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    UserService user = new UserService();
                    List<User> listuser = new ArrayList<>();
                    List<Cardlist> list = new ArrayList<>();

                    listuser = user.getAllFreelancers();

                    Iterator<User> it = listuser.iterator();
                    while (it.hasNext()) {

                        User u = it.next();

                        if (u.getDisponibilite() == 1) {
                            listView.getItems().clear();
                            Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
                            list.add(a);
                            listView.getItems().addAll(list);
                        }
                    }
                } else {

                    UserService user = new UserService();
                    List<User> listuser = new ArrayList<>();
                    List<Cardlist> list = new ArrayList<>();

                    listuser = user.getAllFreelancers();

                    Iterator<User> it = listuser.iterator();
                    while (it.hasNext()) {
                        User u = it.next();
                        listView.getItems().clear();
                        Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
                        list.add(a);
                        listView.getItems().addAll(list);

                    }

                }
            }
        });
        //search By pays
        searchpays.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        if (newValue != null) {
                            UserService user = new UserService();
                            List<User> listuser = new ArrayList<>();
                            List<Cardlist> list = new ArrayList<>();

                            listuser = user.getAllFreelancers();

                            Iterator<User> it = listuser.iterator();
                            while (it.hasNext()) {

                                User u = it.next();

                                if (u.getPays().equals(newValue)) {
                                    listView.getItems().clear();
                                    Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));

                                    list.add(a);

                                    listView.getItems().addAll(list);

                                }

                            }

                        } else {
                            listView.getItems().clear();

                        }
                    }
                });
        //search By ville
        searchRegion.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener() {
                    @Override
                    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                        UserService user = new UserService();
                        List<User> listuser = new ArrayList<>();
                        List<Cardlist> list = new ArrayList<>();

                        listuser = user.getAllFreelancers();

                        Iterator<User> it = listuser.iterator();
                        while (it.hasNext()) {
                            User u = it.next();
                            System.out.println(u);
                            if (u.getVille().equals(newValue)) {
                                Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
                                list.add(a);
                                listView.getItems().clear();
                                listView.getItems().addAll(list);

                            }

                        }

                    }
                });
        //Pour les checkbox 
        catDevelopement.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {

                    UserService user = new UserService();
                    CategorieService catt = new CategorieService();
                    List<User> listuser = new ArrayList<>();
                    List<Cardlist> list = new ArrayList<>();
                    List<CategorieProfile> listcategories = new ArrayList<>();
                    listuser = user.getAllFreelancers();
                    listcategories = catt.listerparNomcat("Sous Categorie Développeurs,Intégrateurs & Data scientists");
                    Iterator<User> it = listuser.iterator();
                    Iterator<CategorieProfile> itcat = listcategories.iterator();
                    while (itcat.hasNext()) {
                        CategorieProfile ca = itcat.next();
                        while (it.hasNext()) {
                            User u = it.next();
                            if (u.getIdUser() == ca.getId_user()) {

                                Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
                                list.add(a);
                                listView.getItems().clear();
                                listView.getItems().addAll(list);

                            }

                        }
                    }

                }

            }
        });
        catDesigners.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {

                    UserService user = new UserService();
                    CategorieService catt = new CategorieService();
                    List<User> listuser = new ArrayList<>();
                    List<Cardlist> list = new ArrayList<>();
                    List<CategorieProfile> listcategories = new ArrayList<>();
                    listuser = user.getAllFreelancers();
                    listcategories = catt.listerparNomcat("Sous Categorie Motion Designers Réalisateurs");
                    Iterator<User> it = listuser.iterator();
                    Iterator<CategorieProfile> itcat = listcategories.iterator();
                    while (itcat.hasNext()) {
                        CategorieProfile ca = itcat.next();
                        while (it.hasNext()) {
                            User u = it.next();
                            if (u.getIdUser() == ca.getId_user()) {

                                Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
                                list.add(a);
                                listView.getItems().clear();
                                listView.getItems().addAll(list);

                            }

                        }
                    }

                }

            }
        });
        catRedacteurs.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {

                    UserService user = new UserService();
                    CategorieService catt = new CategorieService();
                    List<User> listuser = new ArrayList<>();
                    List<Cardlist> list = new ArrayList<>();
                    List<CategorieProfile> listcategories = new ArrayList<>();
                    listuser = user.getAllFreelancers();
                    listcategories = catt.listerparNomcat("Sous Categorie Rédacteurs,Traducteurs,Community Managers");
                    Iterator<User> it = listuser.iterator();
                    Iterator<CategorieProfile> itcat = listcategories.iterator();
                    while (itcat.hasNext()) {
                        CategorieProfile ca = itcat.next();
                        while (it.hasNext()) {
                            User u = it.next();
                            if (u.getIdUser() == ca.getId_user()) {

                                Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
                                list.add(a);
                                listView.getItems().clear();
                                listView.getItems().addAll(list);

                            }

                        }
                    }

                }

            }
        });
        catGraphistes.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {

                    UserService user = new UserService();
                    CategorieService catt = new CategorieService();
                    List<User> listuser = new ArrayList<>();
                    List<Cardlist> list = new ArrayList<>();
                    List<CategorieProfile> listcategories = new ArrayList<>();
                    listuser = user.getAllFreelancers();
                    listcategories = catt.listerparNomcat("Sous Categorie Graphistes,Designers,Photographes");
                    Iterator<User> it = listuser.iterator();
                    Iterator<CategorieProfile> itcat = listcategories.iterator();
                    while (itcat.hasNext()) {
                        CategorieProfile ca = itcat.next();
                        while (it.hasNext()) {
                            User u = it.next();
                            if (u.getIdUser() == ca.getId_user()) {

                                Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
                                list.add(a);
                                listView.getItems().clear();
                                listView.getItems().addAll(list);

                            }

                        }
                    }

                }

            }
        });
        CatChefsprojets.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {

                    UserService user = new UserService();
                    CategorieService catt = new CategorieService();
                    List<User> listuser = new ArrayList<>();
                    List<Cardlist> list = new ArrayList<>();
                    List<CategorieProfile> listcategories = new ArrayList<>();
                    listuser = user.getAllFreelancers();
                    listcategories = catt.listerparNomcat("Sous Categorie Chefs de Projet & Coachs Agile");
                    Iterator<User> it = listuser.iterator();
                    Iterator<CategorieProfile> itcat = listcategories.iterator();
                    while (itcat.hasNext()) {
                        CategorieProfile ca = itcat.next();
                        while (it.hasNext()) {
                            User u = it.next();
                            if (u.getIdUser() == ca.getId_user()) {

                                Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
                                list.add(a);
                                listView.getItems().clear();
                                listView.getItems().addAll(list);

                            }

                        }
                    }

                }

            }
        });
        CatConsultants.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {

                    UserService user = new UserService();
                    CategorieService catt = new CategorieService();
                    List<User> listuser = new ArrayList<>();
                    List<Cardlist> list = new ArrayList<>();
                    List<CategorieProfile> listcategories = new ArrayList<>();
                    listuser = user.getAllFreelancers();
                    listcategories = catt.listerparNomcat("Sous Categorie Consultants en Stratégie, Progiciel, Communication");
                    Iterator<User> it = listuser.iterator();
                    Iterator<CategorieProfile> itcat = listcategories.iterator();
                    while (itcat.hasNext()) {
                        CategorieProfile ca = itcat.next();
                        while (it.hasNext()) {
                            User u = it.next();
                            if (u.getIdUser() == ca.getId_user()) {

                                Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
                                list.add(a);
                                listView.getItems().clear();
                                listView.getItems().addAll(list);

                            }

                        }
                    }

                }

            }
        });

        //Pour le search prixMin
        prixmin.setMax(5000);
        prixmin.setBlockIncrement(100);
        prixmax.setMax(5000);
        prixmax.setBlockIncrement(100);
        prixmin.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    System.out.println(newValue);
                    UserService user = new UserService();
                    List<User> listuser = new ArrayList<>();
                    List<Cardlist> list = new ArrayList<>();

                    listuser = user.getAllFreelancers();

                    Iterator<User> it = listuser.iterator();
                    while (it.hasNext()) {
                        User u = it.next();

                        System.out.println(u);

                        if (u.getTarif_moyen() > (double) newValue) {
                            Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
                            list.add(a);
                            listView.getItems().clear();
                            listView.getItems().addAll(list);

                        }

                    }

                }
            }
        });
        //Pour le search prixMax
        prixmax.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    System.out.println(newValue);
                    UserService user = new UserService();
                    List<User> listuser = new ArrayList<>();
                    List<Cardlist> list = new ArrayList<>();

                    listuser = user.getAllFreelancers();

                    Iterator<User> it = listuser.iterator();
                    while (it.hasNext()) {
                        User u = it.next();

                        System.out.println(u);

                        if (u.getTarif_moyen() < (double) newValue) {
                            Cardlist a = new Cardlist(u.getIdUser(), u.getImage(), u.getNom(), u.getPrenom(), u.getPays(), u.getVille(), u.getTitre_profile(), String.valueOf(u.getTarif_moyen()));
                            list.add(a);
                            listView.getItems().clear();
                            listView.getItems().addAll(list);

                        }

                    }

                }
            }
        });
        listView.getItems().addAll(list);
        listView.setOrientation(Orientation.VERTICAL);
        listView.setPrefSize(150, 300);
        TableView tableView = new TableView();
        tableView.getItems().addAll(list);
        StackPane root = new StackPane(listView);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(1200, 800);
        listView.getStylesheets().add(getClass().getResource("/com/thinklance/pidev/css/custom-scroll.css").toExternalForm());
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cardlist>() {
            @Override
            public void changed(ObservableValue<? extends Cardlist> observable, Cardlist oldValue, Cardlist newValue) {
                System.out.println("Selected item: " + newValue.getId_user());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfileDescription.fxml"));
                Parent root;
                try {
                    root = loader.load();
                    ProfileDescriptionController profileviewcontroller = loader.getController();
                    profileviewcontroller.transferMessage(newValue.getId_user());
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Profile User");
                    Stage stage2 = (Stage) AnchorPane.getScene().getWindow();
                    stage2.close();
                    stage.show();

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        AnchorPane.getChildren().add(root);
    }

    @FXML
    private void NextEmployeurs(ActionEvent event) {
        TabPaneListeFEP.getSelectionModel().select(Employeurs);
    }

    @FXML
    private void NextProjets(ActionEvent event) {
        TabPaneListeFEP.getSelectionModel().select(Projets);
    }

    @FXML
    private void previousFreelancers(ActionEvent event) {
        TabPaneListeFEP.getSelectionModel().select(Freelancers);
    }

    @FXML
    private void PreviousEmployeurs(ActionEvent event) {
        TabPaneListeFEP.getSelectionModel().select(Employeurs);
    }

}

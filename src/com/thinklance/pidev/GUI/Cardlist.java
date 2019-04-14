package com.thinklance.pidev.GUI;

import java.io.File;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Cardlist extends AnchorPane {

    protected final HBox hBox;
    protected final ImageView image_profile;
    protected final VBox vBox;
    protected final Label nomPrenom;
    protected final Label titre_profile;
    protected final ImageView imageView;
    protected final Label paysVille;
    protected final ImageView imageView0;
    protected final VBox vBox0;
    protected final Label TarifMoyen;
    protected final ImageView imageView1;
    private int id_user;

    public Cardlist(int id, String nom_image, String username, String firstname, String pays, String ville,String titrepro,String tarif) {
        id_user = id;
        hBox = new HBox();
        image_profile = new ImageView();
        vBox = new VBox();
        nomPrenom = new Label();
        titre_profile = new Label();
        imageView = new ImageView();
        paysVille = new Label();
        imageView0 = new ImageView();
        vBox0 = new VBox();
        TarifMoyen = new Label();
        imageView1 = new ImageView();

        setPrefHeight(102.0);
        setPrefWidth(574.0);

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(96.0);
        hBox.setPrefWidth(350.0);
        hBox.setSpacing(10.0);
        File file = new File(nom_image);
        Image image = new Image(file.toURI().toString(), 365.0, 136, true, true);
        image_profile.setImage(image);
        nomPrenom.setText(firstname + " " + username);
        paysVille.setText(pays + "," + ville);

        image_profile.setFitHeight(63.0);
        image_profile.setFitWidth(65.0);
        image_profile.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        image_profile.setPickOnBounds(true);
        image_profile.setPreserveRatio(true);
        //image_profile.setImage(new Image(getClass().getResource("../ressourses/user.png").toExternalForm()));

        vBox.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        vBox.setPrefHeight(102.0);
        vBox.setPrefWidth(252.0);
        vBox.setStyle("-fx-border-color: -separator-color; -fx-background-color: -background-color;");
        vBox.getStyleClass().add("raised");

        nomPrenom.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        nomPrenom.setLayoutX(27.0);
        nomPrenom.setLayoutY(223.0);
        nomPrenom.setPrefHeight(25.0);
        nomPrenom.setPrefWidth(276.0);
        nomPrenom.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #000000;");
        //nomPrenom.setText("Dan Mlayah");

        titre_profile.setPrefHeight(20.0);
        titre_profile.setPrefWidth(265.0);
        titre_profile.setStyle("-fx-font-size: 14; -fx-text-fill: #000000;");
        titre_profile.setText(titrepro);
        titre_profile.setCursor(Cursor.MOVE);

        imageView.setFitHeight(18);
        imageView.setFitWidth(15);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/com/thinklance/pidev/ressourses/portfolio.png").toExternalForm()));
        titre_profile.setGraphic(imageView);

        paysVille.setPrefHeight(20.0);
        paysVille.setPrefWidth(268.0);
        paysVille.setStyle("-fx-font-size: 14; -fx-text-fill: #000000;");
        //paysVille.setText(pays+","+ville);

        imageView0.setFitHeight(18);
        imageView0.setFitWidth(15);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/com/thinklance/pidev/ressourses/map-marker.png").toExternalForm()));
        paysVille.setGraphic(imageView0);

        TarifMoyen.setPrefHeight(20.0);
        TarifMoyen.setPrefWidth(268.0);
        TarifMoyen.setStyle("-fx-font-size: 14; -fx-text-fill: #000000;");
        TarifMoyen.setText(tarif);

        imageView1.setFitHeight(18);
        imageView1.setFitWidth(15);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("/com/thinklance/pidev/ressourses/money-bag-with-dollar-symbol.png").toExternalForm()));
        TarifMoyen.setGraphic(imageView1);

        hBox.getChildren().add(image_profile);
        vBox.getChildren().add(nomPrenom);
        vBox.getChildren().add(titre_profile);
        vBox.getChildren().add(paysVille);
        vBox.getChildren().add(vBox0);
        vBox.getChildren().add(TarifMoyen);
        hBox.getChildren().add(vBox);
        getChildren().add(hBox);

    }

    public ImageView getImage_profile() {
        return image_profile;
    }

    public Label getNomPrenom() {
        return nomPrenom;
    }

    public Label getTitre_profile() {
        return titre_profile;
    }

    public Label getPaysVille() {
        return paysVille;
    }

    public int getId_user() {
        return id_user;
    }
}

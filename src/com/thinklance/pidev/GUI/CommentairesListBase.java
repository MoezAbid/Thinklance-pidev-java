package com.thinklance.pidev.GUI;

import java.io.File;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Separator;

public class CommentairesListBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final HBox hBox;
    protected final VBox vBox;
    protected final Label nomPrenom;
    protected final Label contenucoment;
    protected final VBox vBox0;
    protected final ImageView image_profile;
    protected final Separator sep;

    public CommentairesListBase(String contenu, String nom, String prenom, String image) {

        anchorPane = new AnchorPane();
        hBox = new HBox();
        vBox = new VBox();
        nomPrenom = new Label();
        contenucoment = new Label();
        vBox0 = new VBox();
        image_profile = new ImageView();
        sep = new Separator();
        
        sep.setPrefWidth(574.0);

        setId("AnchorPane");
        setPrefHeight(106.0);
        setPrefWidth(445.0);

        anchorPane.setLayoutX(10.0);
        anchorPane.setLayoutY(10.0);
        anchorPane.setPrefHeight(73.0);
        anchorPane.setPrefWidth(574.0);

        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(96.0);
        hBox.setPrefWidth(345.0);
        hBox.setSpacing(10.0);

        vBox.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        vBox.setPrefHeight(125.0);
        vBox.setPrefWidth(345.0);

        nomPrenom.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        nomPrenom.setLayoutX(27.0);
        nomPrenom.setLayoutY(223.0);
        nomPrenom.setPrefHeight(25.0);
        nomPrenom.setPrefWidth(276.0);
        nomPrenom.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #000000;");
        nomPrenom.setText(nom + "  " + prenom);

        contenucoment.setPrefHeight(93.0);
        contenucoment.setPrefWidth(283.0);
        contenucoment.setStyle("-fx-font-size: 14; -fx-text-fill: #000000;");
        contenucoment.setCursor(Cursor.MOVE);
        contenucoment.setText(contenu);

        image_profile.setFitHeight(63.0);
        image_profile.setFitWidth(65.0);
        image_profile.setLayoutX(10.0);
        image_profile.setLayoutY(10.0);
        image_profile.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        image_profile.setPickOnBounds(true);
        image_profile.setPreserveRatio(true);
        //image_profile.setImage(new Image(getClass().getResource("/com/thinklance/pidev/ressourses/user.png").toExternalForm()));
        File file = new File(image);
        Image img = new Image(file.toURI().toString(), 365.0, 136, true, true);
        image_profile.setImage(img);
        vBox.getChildren().add(nomPrenom);
        vBox.getChildren().add(contenucoment);
        vBox.getChildren().add(vBox0);
        hBox.getChildren().add(vBox);
        anchorPane.getChildren().add(hBox);
        
        getChildren().add(anchorPane);
        getChildren().add(image_profile);        
        
        getChildren().add(sep);

    }
}

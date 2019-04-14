package com.thinklance.pidev.GUI;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public  class ListFormationBase extends AnchorPane {

    protected final Label titreformation;
    protected final ImageView image_profile;
    protected final Label descriptionformation;
    protected final Label datedebutdatefin;
    protected final Label institution;
   private int id_cat;
    public ListFormationBase(int idcat,String titreforma,String instit,String datedebut,String datefin,String descriform) {
   id_cat = idcat;
        titreformation = new Label();
        image_profile = new ImageView();
        descriptionformation = new Label();
        datedebutdatefin = new Label();
        institution = new Label();

        setId("AnchorPane");
        setPrefHeight(95.0);
        setPrefWidth(463.0);

        titreformation.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        titreformation.setLayoutX(58.0);
        titreformation.setLayoutY(2.0);
        titreformation.setPrefHeight(25.0);
        titreformation.setPrefWidth(276.0);
        titreformation.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #000000;");
        titreformation.setText(titreforma);

        image_profile.setFitHeight(62.0);
        image_profile.setFitWidth(47.0);
        image_profile.setLayoutY(2.0);
        image_profile.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);
        image_profile.setPickOnBounds(true);
        image_profile.setPreserveRatio(true);
        //image_profile.setImage(new Image(getClass().getResource("/com/thinklance/pidev/GUI/ressourses/students.png").toExternalForm()));
        image_profile.setImage(new Image(getClass().getResource("/com/thinklance/pidev/ressourses/students.png").toExternalForm()));
        descriptionformation.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        descriptionformation.setLayoutX(57.0);
        descriptionformation.setLayoutY(44.0);
        descriptionformation.setPrefHeight(47.0);
        descriptionformation.setPrefWidth(276.0);
        descriptionformation.setStyle("-fx-font-size: 14; -fx-font-weight: regular; -fx-text-fill: #000000;");
        descriptionformation.setText(descriform);

        datedebutdatefin.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        datedebutdatefin.setLayoutX(57.0);
        datedebutdatefin.setLayoutY(26.0);
        datedebutdatefin.setPrefHeight(25.0);
        datedebutdatefin.setPrefWidth(150.0);
        datedebutdatefin.setStyle("-fx-font-size: 12; -fx-font-weight: regular; -fx-text-fill: #000000;");
        datedebutdatefin.setText(datedebut+"-"+datefin);

        institution.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        institution.setLayoutX(200.0);
        institution.setLayoutY(26.0);
        institution.setPrefHeight(25.0);
        institution.setPrefWidth(89.0);
        institution.setStyle("-fx-font-size: 12; -fx-font-weight: regular; -fx-text-fill: #000000;");
        institution.setText(instit);

        getChildren().add(titreformation);
        getChildren().add(image_profile);
        getChildren().add(descriptionformation);
        getChildren().add(datedebutdatefin);
        getChildren().add(institution);

    }

    public int getId_cat() {
        return id_cat;
    }

   
}

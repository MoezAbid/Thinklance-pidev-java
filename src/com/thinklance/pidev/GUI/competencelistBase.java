package com.thinklance.pidev.GUI;

import com.jfoenix.controls.JFXProgressBar;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public  class competencelistBase extends AnchorPane {

    protected final VBox vBox;
    protected final Label titrecompetence;
    protected final ProgressBar degreprogress;
    private int id_com;

    public competencelistBase(int idcom,String nom,int progress) {
id_com=idcom;
        vBox = new VBox();
        titrecompetence = new Label();
        degreprogress = new JFXProgressBar();

        setId("AnchorPane");
        setPrefHeight(39.0);
        setPrefWidth(211.0);

        vBox.setLayoutX(7.0);
        vBox.setLayoutY(4.0);

        titrecompetence.setPrefHeight(20.0);
        titrecompetence.setPrefWidth(149.0);
        titrecompetence.setStyle("-fx-font-size: 14; -fx-text-fill: #6a7d9a;");
        titrecompetence.setText(nom);

        degreprogress.setMinHeight(USE_PREF_SIZE);
        degreprogress.setPrefHeight(10.0);
        degreprogress.setPrefWidth(200.0);
        double a=progress/100;
        Platform.runLater(new Runnable() {
            @Override public void run() {
                degreprogress.setProgress(progress/100);
            }
        });
        //degreprogress.setProgress(a);
        degreprogress.getStyleClass().add("mprogress-bar");

        vBox.getChildren().add(titrecompetence);
        vBox.getChildren().add(degreprogress);
        getChildren().add(vBox);

    }

    public int getId_com() {
        return id_com;
    }
}

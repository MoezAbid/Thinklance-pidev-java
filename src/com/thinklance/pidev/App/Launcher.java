/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.App;

import com.thinklance.pidev.Utils.MyConnection;

import com.thinklance.pidev.Service.Impl.CategorieService;
import com.thinklance.pidev.Service.Impl.EmailService;
import com.thinklance.pidev.Service.Impl.UserService;
import com.thinklance.pidev.entities.CategorieProfile;
import com.thinklance.pidev.entities.User;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ASUS
 */
public class Launcher extends Application {

   @Override
    public void start(Stage stage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Parent root1 = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/AccueilFreelancer.fxml"));
        stage.setResizable(false);
        stage.centerOnScreen();
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

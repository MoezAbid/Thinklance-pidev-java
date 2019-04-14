/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ValidAlertController implements Initializable {

    @FXML
    private Label content;
    private String path;
     int whichIsLastClicked =0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }

    @FXML
    private void onDone(ActionEvent event) {
//                 Stage stage = (Stage) (content.getScene().getWindow());
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("/com/thinklance/pidev/GUI/"+path+".fxml"));
//            stage.setScene(new Scene(root));
//        } catch(IOException ioe) {
//            ioe.printStackTrace();
//        }
if(whichIsLastClicked==1){
    ProfileDescriptionController.jfxdialog.close();
}else if(whichIsLastClicked==2){
ModifierExperienceController.jfxdialog.close();

}else if(whichIsLastClicked==3){
    ModifierFormationController.jfxdialog.close();
}




    }

    public void setWhichIsLastClicked(int whichIsLastClicked) {
        this.whichIsLastClicked = whichIsLastClicked;
    }

    public Label getContent() {
        return content;
    }

    public void setContent(String con) {
        content.setText(con);

    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}

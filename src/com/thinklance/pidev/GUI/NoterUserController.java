/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.GUI;

import com.jfoenix.controls.JFXButton;
import com.thinklance.pidev.Service.Impl.UserService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class NoterUserController implements Initializable {

    @FXML
    private Rating ratecommunication;
    @FXML
    private Rating rateQualite;
    @FXML
    private Rating ratingrespectdelais;
    @FXML
    private JFXButton sortir;
    @FXML
    private JFXButton enregistrer1;
    private double resultatcomm;
    private double resultatqualite;
    private double resultatrespectdelais;
    private double resfinale;
    private int iduser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resfinale = 0;
        // TODO
                   rateQualite.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                resultatqualite = (double) newValue;
                   resfinale+=resultatqualite*4;
            }
        });  
        ratecommunication.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               resultatcomm = (double) newValue;
                resfinale+=resultatcomm*3;
               
        
      
            }
           
        });
                   ratingrespectdelais.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                resultatrespectdelais =  (double) newValue;
                resfinale+=resultatrespectdelais*4;
                  System.out.println("res finale"+resfinale);
            }
        });
       
       
           
    }

    @FXML
    private void sortir(ActionEvent event) {
    }

    @FXML
    private void enregitrerchoix(ActionEvent event) {
        UserService userservice=new UserService();
        double res = 0;
        int nbvote = userservice.getNbVote(iduser);
        res=(double) (resfinale/11);
        double notebase=userservice.getNoteUser(iduser);
        double nbrpoints=userservice.getNbPointUser(iduser);
                System.out.println("out nb vote = "+nbvote);

        if (nbvote == 0){
            nbvote++;
        userservice.updateuserpointsAndNote(res,res*100+nbrpoints , getIduser(),nbvote);
        System.out.println("nb0 nb vote = "+nbvote);
        System.out.println("nb0 res finale = "+resfinale);
        System.out.println("nb0 note base  = "+notebase);
        System.out.println("nb0 note res = "+res);
        }
        else{
            nbvote++;
        userservice.updateuserpointsAndNote((res+notebase)/2,res*100+nbrpoints , getIduser(),nbvote);
        System.out.println("res finale = "+resfinale);        
        System.out.println("nb vote = "+nbvote);
        System.out.println("note base  = "+notebase);
        System.out.println("note res = "+res);
        System.out.println("last res = "+((res+notebase)/2));
        }
        resfinale=0;
        

        
    }
    

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIduser() {
        return iduser;
    }

}

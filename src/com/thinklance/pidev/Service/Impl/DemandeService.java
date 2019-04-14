/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.Demande;
import com.thinklance.pidev.entities.Projet;
import com.thinklance.pidev.service.Interfaces.IDemande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class DemandeService implements IDemande{
    
     private Connection connection;
     private Statement st ;
    private ResultSet rs ;
    private PreparedStatement pst;

    public DemandeService() {
        this.connection = MyConnection.getInstance().getCnx();
    }

    @Override
    public void addDemande(Demande p) {
       String req = "INSERT INTO demande (freelancer,dateDemande,etatDemande,idEmployeur,idProjet) VALUES (?,?,?,?,?) ";
        //pour executer req Statement et PreparedStatement
        try {
            PreparedStatement st = connection.prepareStatement(req);
            st.setInt(1, p.getFreelancer());
            st.setDate(2, p.getDateDemande());
            st.setString(3,"en attente");
            st.setInt(4, p.getIdEmployeur());
            st.setInt(5, p.getIdProjet());
           
            st.executeUpdate();
            System.out.println("Demande ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void modifDemande(Demande p, int id)
    {
        String req2="UPDATE demande SET etatDemande=? WHERE id=?";
        try {
            PreparedStatement pst=MyConnection.getInstance().getCnx().prepareStatement(req2);
             pst.setString(1,"Accepter");
            
            pst.setInt(2,id);
            System.out.println("Demande acceptée");
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteDemande(Demande p) {
        try {
        String requete =
                "DELETE FROM demande where demande.id='"
                +p.getId()
                +"'";
                st =connection.createStatement();
                st.executeUpdate(requete);
                System.out.println(" Demande refuséé");
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }

    @Override
    public ObservableList getAllDemande() {
         ObservableList<Demande> list = FXCollections.observableArrayList();
        String requete = "select * from demande";
        try {
            st =connection.createStatement();
            rs= st.executeQuery(requete);
            while(rs.next()){
                list.add(new Demande(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getInt(5),rs.getInt(6)));
               
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  list ;
    }

    @Override
    public ObservableList getDemandeParId(int id) {
         ObservableList<Demande> list = FXCollections.observableArrayList();
        String requete = "select * from demande where idEmployeur="+id;
        try {
            st =connection.createStatement();
            rs= st.executeQuery(requete);
            while(rs.next()){
                list.add(new Demande(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getString(4),rs.getInt(5),rs.getInt(6)));
               
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  list ;
    }

   
}

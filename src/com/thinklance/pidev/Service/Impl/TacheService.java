/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.service.Interfaces.ITache;
import com.thinklance.pidev.entities.Tache;
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
public class TacheService  implements ITache{
     private Connection connection;
     private Statement st ;
    private ResultSet rs ;
    private PreparedStatement pst;

    public TacheService() {
        this.connection = MyConnection.getInstance().getCnx();
    }



    @Override
    public void addTache(Tache p) {
         String req = "INSERT INTO tache (nomTache,typeTache,estimationTache,prioriteTache,idProjet) VALUES (?,?,?,?,?) ";
        //pour executer req Statement et PreparedStatement
        try {
            PreparedStatement st = connection.prepareStatement(req);
            st.setString(1, p.getNomTache());
           
            st.setString(2, p.getTypeTache());
            st.setString(3, p.getEstimationTache());
            st.setInt(4, p.getPrioriteTache());
            st.setInt(5, p.getIdProjet());
           
            st.executeUpdate();
            System.out.println("tache ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void modifTache(Tache p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTache(Tache p) {
         try {
        String requete =
                "DELETE FROM tache where tache.nomTache='"
                +p.getNomTache()
                +"'";
                st =connection.createStatement();
                st.executeUpdate(requete);
                System.out.println("tâche supprimée");
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }

    @Override
    public ArrayList getAllTache() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList getTacheParId(int id) {
        ObservableList<Tache> list = FXCollections.observableArrayList();
        String requete = "select * from tache where idProjet="+id;
        try {
            st =connection.createStatement();
            rs= st.executeQuery(requete);
            while(rs.next()){
                list.add(new Tache(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
               
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  list ;
    }

   public void updateNomT(Tache p) {
             String requete = "update tache set   nomTache=?  where prioriteTache= ?";
       try {
            pst= connection.prepareStatement(requete);
            
            pst.setString(1 ,p.getNomTache());
            pst.setInt(2,p.getPrioriteTache());            
                     
            pst.executeUpdate();
            System.out.println("tache Modifier avec succé: "); 
            
        } catch (SQLException ex) {
          
        }
        
        
    }
   
    public void addTache2(Tache p) {
         String req = "INSERT INTO tache (nomTache,typeTache,prioriteTache) VALUES (?,?,?) ";
        //pour executer req Statement et PreparedStatement
        try {
            PreparedStatement st = connection.prepareStatement(req);
            st.setString(1, p.getNomTache());
           
            st.setString(2, p.getTypeTache());
            st.setInt(3, p.getPrioriteTache());
          
           
            st.executeUpdate();
            System.out.println("tache ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public ObservableList getTacheParTitre(String titre) {
        ObservableList<Tache> list = FXCollections.observableArrayList();
        String requete = "select * from tache where nomTache="+titre;
        try {
            st =connection.createStatement();
            rs= st.executeQuery(requete);
            while(rs.next()){
                list.add(new Tache(rs.getString(2),rs.getString(3)));
               
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  list ;
    }
    
}

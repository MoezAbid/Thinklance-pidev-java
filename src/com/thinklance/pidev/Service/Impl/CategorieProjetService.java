package com.thinklance.pidev.Service.Impl;


import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.service.Interfaces.Icategorie;
import com.thinklance.pidev.entities.CategorieProjet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class CategorieProjetService implements Icategorie {
    
     private Connection connection;
     private Statement st ;
    private ResultSet rs ;

    public CategorieProjetService() {
         this.connection = MyConnection.getInstance().getCnx();
    }
    
    

    @Override
    public void addCategorie(CategorieProjet p) {
         String req = "INSERT INTO categorie (titreCategorie) VALUES (?) ";
        //pour executer req Statement et PreparedStatement
        try {
            PreparedStatement st = connection.prepareStatement(req);
            st.setString(1, p.getTitreCategorie());
            st.executeUpdate();
            System.out.println("categorie ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void modifCategorie(CategorieProjet p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategorie(CategorieProjet p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList getAllCategorie() {
         ObservableList<CategorieProjet> l = FXCollections.observableArrayList();
        String req4="SELECT * FROM categorie";
        try {
           Statement pst2=connection.createStatement();
           ResultSet rs=pst2.executeQuery(req4);
           while(rs.next()){
                   CategorieProjet p = new CategorieProjet();
                   p.setId(rs.getInt("id"));
                   p.setTitreCategorie(rs.getString(2));
                  l.add(p);
    }
            
         
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       return (ObservableList) l;
    }

    @Override
    public CategorieProjet getCategorieParId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

   
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.CategorieProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.thinklance.pidev.Service.interfaces.ICategorieService;

/**
 *
 * @author ASUS
 */
public class CategorieService implements ICategorieService {

    private Connection connection;

    public CategorieService() {
        this.connection = MyConnection.getInstance().getCnx();
    }

    @Override
    public void addCategorie(CategorieProfile cat) {

        try {
            String requete = "INSERT INTO categorie(nom_categorie,sous_categorie,id_user) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, cat.getNom_categorie());
              ps.setString(2, cat.getSous_categorie());
            ps.setInt(3,cat.getId_user());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void updateCategorie(CategorieProfile cat) {
        try {
            String req = "UPDATE categorie set (nom_categorie) values (?) where id = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, cat.getNom_categorie());
            ps.setString(2, "" + cat.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteCategorie(int id) {
        String reqDel="DELETE FROM categorie WHERE id=? ";
         try {
            PreparedStatement preparedStatement = connection.prepareStatement(reqDel);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }  
    }

    @Override
    public List<CategorieProfile> listerCategories() {
        List<CategorieProfile> categories = new ArrayList<>();
        try {
            String req = "select * from categorie";
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                CategorieProfile commentaire = new CategorieProfile(rs.getInt(1),rs.getString(3),rs.getString(4),rs.getInt(2));
                categories.add(commentaire);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<CategorieProfile> listerparNomcat(String nomcat) {
           List<CategorieProfile> categories = new ArrayList<>();
        try {
            String req = "select * from categorie where nom_categorie='"+nomcat+"'";
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                      CategorieProfile commentaire = new CategorieProfile(rs.getInt(1),rs.getString(3),rs.getString(4),rs.getInt(2));
                categories.add(commentaire);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categories;
    }

}

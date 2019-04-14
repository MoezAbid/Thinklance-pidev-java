/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.CategorieProfile;
import com.thinklance.pidev.entities.ExperienceProfessionnel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.thinklance.pidev.Service.interfaces.IExperienceProfessionelService;

/**
 *
 * @author ASUS
 */
public class ExperienceService implements IExperienceProfessionelService {

    private Connection connection;

    public ExperienceService() {
        this.connection = MyConnection.getInstance().getCnx();
    }

    @Override
    public void addExperience(ExperienceProfessionnel exp) {
        try {
            String requete = "INSERT INTO experience_pro(id_user,titre_exp,DateDebut,DateFin,entreprise,description) values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(requete);
         ps.setInt(1, exp.getId_user());
            ps.setString(2, exp.getTitre_exp());
            ps.setString(3, "" + exp.getDatedebut());
            ps.setString(4, "" + exp.getDatefin());
            ps.setString(5, "" + exp.getNom_entreprise());
            ps.setString(6, "" + exp.getDescription());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void updateExperience(ExperienceProfessionnel exp) {
        try {
            String req = "UPDATE experience_pro set titre_exp=?,DateDebut=?,DateFin=?,entreprise=?,description=?  where id = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, exp.getTitre_exp());
            ps.setDate(2, (Date) exp.getDatedebut());
            ps.setDate(3, (Date) exp.getDatefin());
            ps.setString(4, exp.getNom_entreprise());
            ps.setString(5, exp.getDescription());
             ps.setInt(6,exp.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteExperience(int id) {
              String reqDel="DELETE FROM experience_pro WHERE id=? ";
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
    public List<ExperienceProfessionnel> listerExperiences(int id) {
           List<ExperienceProfessionnel> exp = new ArrayList<>();
        try {
            String req = "select * from experience_pro where id_user="+id;
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ExperienceProfessionnel commentaire = new ExperienceProfessionnel(rs.getInt(1),rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getInt(2));
                exp.add(commentaire);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exp;
    }

    @Override
    public ExperienceProfessionnel getExperienceById(int id) {
        ExperienceProfessionnel commentaire=new ExperienceProfessionnel();
            try {
            String req = "select * from experience_pro where id="+id;
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                commentaire = new ExperienceProfessionnel(rs.getInt(1),rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getInt(2));
           return commentaire;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return commentaire;
    }

}

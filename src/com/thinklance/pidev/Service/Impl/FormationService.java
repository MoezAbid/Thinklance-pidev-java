/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.ExperienceProfessionnel;
import com.thinklance.pidev.entities.Formation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.thinklance.pidev.Service.interfaces.IFormationService;

/**
 *
 * @author ASUS
 */
public class FormationService implements IFormationService {

    private Connection connection;

    public FormationService() {
        this.connection = MyConnection.getInstance().getCnx();

    }

    @Override
    public void addFormation(Formation form) {
        try {
            String requete = "INSERT INTO formation(id_user,titre,DateDebut,DateFin,institution,description) values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setInt(1, form.getId_user());
            ps.setString(2, "" + form.getTitre());
            ps.setDate(3, (Date) form.getDatedebut());
            ps.setDate(4, (Date) form.getDatefin());
            ps.setString(5, "" + form.getInstitution());
            ps.setString(6, "" + form.getDescription());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void updateFormation(Formation form) {

            try {
            String req = "UPDATE formation set titre=? , DateDebut=? , DateFin=? , institution=? , description=? where id = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, form.getTitre());
            ps.setDate(2, (Date) form.getDatedebut());
            ps.setDate(3, (Date) form.getDatefin());
            ps.setString(4,form.getInstitution());
            ps.setString(5, form.getDescription());
             ps.setInt(6,form.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteFormation(int id) {
                   String reqDel="DELETE FROM formation WHERE id=?";
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
    public List<Formation> listerFormations(int id) {
                List<Formation> exp = new ArrayList<>();
        try {
            String req = "select * from formation where id_user="+id;
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Formation commentaire = new Formation(rs.getInt(1),rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getInt(2));
                exp.add(commentaire);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exp;
    }

    @Override
    public Formation getFormationById(int id) {
      Formation form=new Formation();
         try {
            String req = "select * from formation where id="+id;
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

               form = new Formation(rs.getInt(1),rs.getString(3),rs.getDate(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getInt(2));
           return form;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return form;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.CategorieProfile;
import com.thinklance.pidev.entities.Competence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.thinklance.pidev.Service.interfaces.ICompetenceService;

/**
 *
 * @author ASUS
 */
public class CompetenceService implements ICompetenceService {

    private Connection connection;

    public CompetenceService() {
        this.connection = MyConnection.getInstance().getCnx();

    }

    @Override
    public void addCompetence(Competence comp) {

        try {
            String requete = "INSERT INTO competence(nom_competence,id_user,degre) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(requete);
      
            ps.setString(1, comp.getNom_competence());
            ps.setInt(2,comp.getId_user());
            ps.setInt(3,comp.getDegre());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void updateCompetence(Competence comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCompetence(int id) {
        String reqDel = "DELETE FROM competence WHERE id=? ";
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
    public List<Competence> listerCompetences(int id) {
        List<Competence> competences = new ArrayList<>();
        try {
            String req = "select * from competence where id_user="+id;
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Competence competence = new Competence(rs.getInt(1), rs.getString(2), rs.getInt(3));
                competences.add(competence);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return competences;
    }

}

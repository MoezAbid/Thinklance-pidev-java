/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.Formation;
import com.thinklance.pidev.entities.Langue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.thinklance.pidev.Service.interfaces.ILangueService;

/**
 *
 * @author ASUS
 */
public class LangueService implements ILangueService {

    private Connection connection;

    public LangueService() {

        this.connection = MyConnection.getInstance().getCnx();

    }

    @Override
    public void addLangue(Langue langue) {
        try {
            String requete = "INSERT INTO langue(id,langue_titre) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, "" + langue.getId());

            ps.setString(2, "" + langue.getLanguetitre());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateLangue(Langue form) {
        try {
            String req = "UPDATE langue set (langue_titre) values (?) where id = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, form.getLanguetitre());

            ps.setInt(3, form.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteLangue(int id) {
        String reqDel="DELETE FROM langue WHERE id=? ";
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
    public List<Langue> listerLangues() {
                   List<Langue> exp = new ArrayList<>();
        try {
            String req = "select * from langue";
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Langue commentaire = new Langue(rs.getInt(1),rs.getString(3),rs.getInt(2));
                exp.add(commentaire);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exp;
    }

}

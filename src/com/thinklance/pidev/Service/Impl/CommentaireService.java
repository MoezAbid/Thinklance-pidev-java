/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Service.interfaces.ICommentaireService;
import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.Commentaire;
import com.thinklance.pidev.entities.Competence;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CommentaireService implements ICommentaireService {

    private Connection connection;

    public CommentaireService() {
        this.connection = MyConnection.getInstance().getCnx();

    }

    @Override
    public List<Commentaire> getAllcomments(int id) {
        List<Commentaire> commentaires = new ArrayList<>();
        try {
            String req = "select * from commentaire where id_employeur=" + id;
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Commentaire comment = new Commentaire(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(5));
                commentaires.add(comment);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return commentaires;
    }

    @Override
    public void addComment(Commentaire com) {
        try {
            String requete = "INSERT INTO commentaire(contenu,date_ajout,id_user,id_employeur) values (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, com.getContenu());
            java.util.Date utilDate =com.getDate_ajout();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(2,sqlDate);
            ps.setInt(3, com.getId_user());
            ps.setInt(4, com.getId_employeur());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}

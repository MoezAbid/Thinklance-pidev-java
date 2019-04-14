/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.Projet;
import com.thinklance.pidev.service.Interfaces.Iprojet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class ServiceProjet implements Iprojet {

    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;

    public ServiceProjet() {
        this.connection = MyConnection.getInstance().getCnx();
    }

    @Override
    public void addProjet(Projet p) {

        String req = "INSERT INTO projet (employeur,titreprojet,description,nbrejours,prix,nomfichiers,file,idCategorie) VALUES (?,?,?,?,?,?,?,?) ";
        //pour executer req Statement et PreparedStatement
        try {
            PreparedStatement st = connection.prepareStatement(req);
            st.setInt(1, p.getEmployeur());
            st.setString(2, p.getTitreProjet());
            st.setString(3, p.getDescription());
            st.setInt(4, p.getNbjours());
            st.setDouble(5, p.getPrix());
            st.setString(6, p.getNomFichiers());
            st.setString(7, p.getFile());
            st.setInt(8, p.getIdCategorie());
            st.executeUpdate();
            System.out.println("projet ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void modifProjet(Projet p, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProjet(Projet p) {
        try {
            String requete
                    = "DELETE FROM projet where projet.id='"
                    + p.getIdProjet()
                    + "'";
            st = connection.createStatement();
            st.executeUpdate(requete);
            System.out.println("projet supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ObservableList getAllProjets() {
        ObservableList<Projet> list = FXCollections.observableArrayList();
        String requete = "select * from projet";
        try {
            st = connection.createStatement();
            rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new Projet(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDouble(7),
                        rs.getString(8), rs.getInt(10)));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Projet getProjetParId(int id) {
        Projet projet = new Projet();
        try {
            String requeteSelectArticle = "SELECT * FROM projet WHERE id=?";
            PreparedStatement selectUnArticleStatement = this.connection.prepareStatement(requeteSelectArticle);
            selectUnArticleStatement.setInt(1, id);

            ResultSet resultSetListArticles = selectUnArticleStatement.executeQuery();

            resultSetListArticles.next();
            projet.setIdProjet(resultSetListArticles.getInt("id"));
            projet.setEmployeur(resultSetListArticles.getInt("employeur"));
            projet.setFreelancer(resultSetListArticles.getInt("freelancer"));
            projet.setTitreProjet(resultSetListArticles.getString("titreprojet"));
            projet.setDescription(resultSetListArticles.getString("description"));
            projet.setNbjours(resultSetListArticles.getInt("nbrejours"));
            projet.setPrix(resultSetListArticles.getDouble("prix"));
            projet.setNomFichiers(resultSetListArticles.getString("nnomfichiers"));
            projet.setFile(resultSetListArticles.getString("file"));
            projet.setIdCategorie(resultSetListArticles.getInt("IdCategorie"));
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projet;
    }

    public void updateTitre(Projet p) {
        String requete = "update projet set   titreprojet=? "
                + "  where id= ?";
        try {
            pst = connection.prepareStatement(requete);

            pst.setString(1, p.getTitreProjet());
            pst.setInt(2, p.getIdProjet());

            pst.executeUpdate();
            System.out.println("indemnite Modifier avec succé: ");

        } catch (SQLException ex) {

        }

    }
}

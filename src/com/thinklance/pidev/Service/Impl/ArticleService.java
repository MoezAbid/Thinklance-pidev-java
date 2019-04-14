/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Service.interfaces.IArticleService;
import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.Article;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 *
 * @author Moez
 */
public class ArticleService implements IArticleService {

    private Connection databaseConnection;

    public ArticleService() {
        databaseConnection = MyConnection.getInstance().getCnx();
    }

    @Override
    public void ajouterArticle(Article nouvelArticle) {
        try {
            String requeteAjoutPrepared = "INSERT INTO article(utilisateur, titre, description, dateHeure, texte, photo_article, type) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pstAjoutArticle = databaseConnection.prepareStatement(requeteAjoutPrepared);
            pstAjoutArticle.setInt(1, nouvelArticle.getUtilisateur());
            pstAjoutArticle.setString(2, nouvelArticle.getTitre());
            pstAjoutArticle.setString(3, nouvelArticle.getDescription());
            pstAjoutArticle.setTimestamp(4, new java.sql.Timestamp(nouvelArticle.getDateHeure().getTime()));
            pstAjoutArticle.setString(5, nouvelArticle.getTexte());
            pstAjoutArticle.setString(6, nouvelArticle.getPhotoArticle());
            pstAjoutArticle.setInt(7, nouvelArticle.getType());
            pstAjoutArticle.executeUpdate();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Succés de l'opération");
            alert.setHeaderText(null);
            alert.setContentText("Article ajouté avec succés!");
            alert.show();
            System.out.println("Article ajouté.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Echec de l'opération");
            alert.setHeaderText(null);
            alert.setContentText("Erreur lors de l'ajout de l'article.");
            alert.show();
        }
    }

    @Override
    public void modifierArticle(int id, Article articleModifie) {
        try {
            String requeteModifPrepared = "UPDATE article SET titre=?,description=?,texte=?,photo_article=?,type=? WHERE id=?";

            PreparedStatement pstAjoutArticle = databaseConnection.prepareStatement(requeteModifPrepared);
            pstAjoutArticle.setString(1, articleModifie.getTitre());
            pstAjoutArticle.setString(2, articleModifie.getDescription());
            pstAjoutArticle.setString(3, articleModifie.getTexte());
            pstAjoutArticle.setString(4, articleModifie.getPhotoArticle());
            pstAjoutArticle.setInt(5, articleModifie.getType());
            pstAjoutArticle.setInt(6, id);
            pstAjoutArticle.executeUpdate();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Succés de l'opération");
            alert.setHeaderText(null);
            alert.setContentText("Article modifié avec succés!");
            alert.show();

            System.out.println("Article Modifié.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Echec de l'opération");
            alert.setHeaderText(null);
            alert.setContentText("Erreur lors de la modification de l'article.");
            alert.show();
        }
    }

    @Override
    public ObservableList<Article> getListeAllArticles() {
        System.out.println("Liste d'articles");
        List<Article> listeDesArticles = new ArrayList<>();
        String req = "SELECT * FROM article";
        try {
            Statement selectArticlesStatement = databaseConnection.createStatement();
            ResultSet resultSetListArticles = selectArticlesStatement.executeQuery(req);
            while (resultSetListArticles.next()) {
                Article article = new Article();
                article.setId(resultSetListArticles.getInt("id"));
                article.setUtilisateur(resultSetListArticles.getInt("utilisateur"));
                article.setTitre(resultSetListArticles.getString("titre"));
                article.setDescription(resultSetListArticles.getString("description"));
                article.setDateHeure(resultSetListArticles.getTimestamp("dateHeure"));
                article.setTexte(resultSetListArticles.getString("texte"));
                article.setPhotoArticle(resultSetListArticles.getString("photo_article"));
                article.setType(resultSetListArticles.getInt("type"));
                listeDesArticles.add(article);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(listeDesArticles);
    }

    @Override
    public ObservableList<Article> getListeMesArticles(int idUtilisateur) {
        System.out.println("Liste mes articles");
        List<Article> listeDesArticles = new ArrayList<>();
        String req = "SELECT * FROM article WHERE utilisateur=" + idUtilisateur;
        try {
            Statement selectArticlesStatement = databaseConnection.createStatement();
            ResultSet resultSetListArticles = selectArticlesStatement.executeQuery(req);
            while (resultSetListArticles.next()) {
                Article article = new Article();
                article.setId(resultSetListArticles.getInt("id"));
                article.setUtilisateur(resultSetListArticles.getInt("utilisateur"));
                article.setTitre(resultSetListArticles.getString("titre"));
                article.setDescription(resultSetListArticles.getString("description"));
                article.setDateHeure(resultSetListArticles.getTimestamp("dateHeure"));
                article.setTexte(resultSetListArticles.getString("texte"));
                article.setPhotoArticle(resultSetListArticles.getString("photo_article"));
                article.setType(resultSetListArticles.getInt("type"));
                listeDesArticles.add(article);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(listeDesArticles);
    }

    @Override
    public void supprimerArticle(int id) {
        try {
            String requeteSuppression = "DELETE FROM article WHERE id=?";
            PreparedStatement pst = databaseConnection.prepareStatement(requeteSuppression);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Article supprimé.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Article getArticleSpecifique(int idArticle) {
        Article article = new Article();
        try {
            String requeteSelectArticle = "SELECT * FROM article WHERE id=?";
            PreparedStatement selectUnArticleStatement = databaseConnection.prepareStatement(requeteSelectArticle);
            selectUnArticleStatement.setInt(1, idArticle);

            ResultSet resultSetListArticles = selectUnArticleStatement.executeQuery();

            resultSetListArticles.next();
            article.setId(resultSetListArticles.getInt("id"));
            article.setUtilisateur(resultSetListArticles.getInt("utilisateur"));
            article.setTitre(resultSetListArticles.getString("titre"));
            article.setDescription(resultSetListArticles.getString("description"));
            article.setDateHeure(resultSetListArticles.getTimestamp("dateHeure"));
            article.setTexte(resultSetListArticles.getString("texte"));
            article.setPhotoArticle(resultSetListArticles.getString("photo_article"));
            article.setType(resultSetListArticles.getInt("type"));
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return article;
    }

    @Override
    public ObservableList<Article> rechercheArticles(String motCle) {
        System.out.println("Liste articles recherche");
        List<Article> listeDesArticles = new ArrayList<>();
        String req = "SELECT * FROM article WHERE titre LIKE '%" + motCle + "%'";
        //String req = "SELECT * FROM article WHERE titre LIKE '%" + motCle + "%' OR description LIKE '%"+motCle+"%' OR texte LIKE '%"+motCle+"%'";
        try {
            Statement selectArticlesStatement = databaseConnection.createStatement();
            ResultSet resultSetListArticles = selectArticlesStatement.executeQuery(req);
            while (resultSetListArticles.next()) {
                Article article = new Article();
                article.setId(resultSetListArticles.getInt("id"));
                article.setUtilisateur(resultSetListArticles.getInt("utilisateur"));
                article.setTitre(resultSetListArticles.getString("titre"));
                article.setDescription(resultSetListArticles.getString("description"));
                article.setDateHeure(resultSetListArticles.getTimestamp("dateHeure"));
                article.setTexte(resultSetListArticles.getString("texte"));
                article.setPhotoArticle(resultSetListArticles.getString("photo_article"));
                article.setType(resultSetListArticles.getInt("type"));
                listeDesArticles.add(article);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(listeDesArticles);
    }

    @Override
    public ObservableList<Article> rechercheDansMesArticles(String motCle, int idUtilisateur) {
        System.out.println("Liste mes articles recherche");
        List<Article> listeDesArticles = new ArrayList<>();
        String req = "SELECT * FROM article WHERE titre LIKE '%" + motCle + "%' AND utilisateur="+idUtilisateur;
        try {
            Statement selectArticlesStatement = databaseConnection.createStatement();
            ResultSet resultSetListArticles = selectArticlesStatement.executeQuery(req);
            while (resultSetListArticles.next()) {
                Article article = new Article();
                article.setId(resultSetListArticles.getInt("id"));
                article.setUtilisateur(resultSetListArticles.getInt("utilisateur"));
                article.setTitre(resultSetListArticles.getString("titre"));
                article.setDescription(resultSetListArticles.getString("description"));
                article.setDateHeure(resultSetListArticles.getTimestamp("dateHeure"));
                article.setTexte(resultSetListArticles.getString("texte"));
                article.setPhotoArticle(resultSetListArticles.getString("photo_article"));
                article.setType(resultSetListArticles.getInt("type"));
                listeDesArticles.add(article);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(listeDesArticles);
    }
}

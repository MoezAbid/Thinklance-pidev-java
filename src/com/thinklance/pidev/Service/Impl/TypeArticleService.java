/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Services.interfaces.ITypeArticleService;
import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.Article;
import com.thinklance.pidev.entities.TypeArticle;
import java.sql.Connection;
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

/**
 *
 * @author Moez
 */
public class TypeArticleService implements ITypeArticleService {

    private Connection databaseConnection;

    public TypeArticleService() {
        databaseConnection = MyConnection.getInstance().getCnx();
    }

    @Override
    public void ajouterTypeArticle(TypeArticle nouveauTypeArticle) {
        String requeteTypeAjoutPrepared = "INSERT INTO type_article(id, nom) VALUES (?,?)";
        try {
            PreparedStatement pstAjoutTypeArticle = databaseConnection.prepareStatement(requeteTypeAjoutPrepared);
            pstAjoutTypeArticle.setInt(1, nouveauTypeArticle.getId());
            pstAjoutTypeArticle.setString(2, nouveauTypeArticle.getNom());
            pstAjoutTypeArticle.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succés de l'opération");
            alert.setHeaderText(null);
            alert.setContentText("Type d'article ajouté avec succés!");
            alert.show();
            System.out.println("Type d'article ajouté.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec de l'opération");
            alert.setHeaderText(null);
            alert.setContentText("Erreur lors de l'ajout du type d'article.");
            alert.show();
        }
    }

    @Override
    public void modifierTypeArticle(int id, TypeArticle typeArticleModifie) {
        try {
            String requeteModifPrepared = "UPDATE type_article SET nom=? WHERE id=?";

            PreparedStatement pstAjoutArticle = databaseConnection.prepareStatement(requeteModifPrepared);
            pstAjoutArticle.setString(1, typeArticleModifie.getNom());
            pstAjoutArticle.setInt(2, id);
            pstAjoutArticle.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succés de l'opération");
            alert.setHeaderText(null);
            alert.setContentText("Type d'article modifié avec succés!");
            alert.show();

            System.out.println("Type d'rticle Modifié.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Echec de l'opération");
            alert.setHeaderText(null);
            alert.setContentText("Erreur lors de la modification du type d'article.");
            alert.show();
        }
    }

    @Override
    public void supprimerTypeArticle(int id) {
        try {
            String requeteSuppression = "DELETE FROM type_article WHERE id=?";
            PreparedStatement pst = databaseConnection.prepareStatement(requeteSuppression);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Type d'article supprimé.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<TypeArticle> getListeTypesArticles() {
        System.out.println("Liste mes articles");
        List<TypeArticle> listeDesArticles = new ArrayList<>();
        String req = "SELECT * FROM type_article";
        try {
            Statement selectArticlesStatement = databaseConnection.createStatement();
            ResultSet resultSetListArticles = selectArticlesStatement.executeQuery(req);
            while (resultSetListArticles.next()) {
                TypeArticle typeArticle = new TypeArticle();
                typeArticle.setId(resultSetListArticles.getInt("id"));
                typeArticle.setNom(resultSetListArticles.getString("nom"));
                listeDesArticles.add(typeArticle);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(listeDesArticles);
    }

    @Override
    public TypeArticle getTypeArticleSpecifique(int idArticle) {
        TypeArticle typeArticle = new TypeArticle();
        try {
            String requeteSelectArticle = "SELECT * FROM type_article WHERE id=?";
            PreparedStatement selectUnArticleStatement = databaseConnection.prepareStatement(requeteSelectArticle);
            selectUnArticleStatement.setInt(1, idArticle);

            ResultSet resultSetListArticles = selectUnArticleStatement.executeQuery();

            resultSetListArticles.next();
            typeArticle.setId(resultSetListArticles.getInt("id"));
            typeArticle.setNom(resultSetListArticles.getString("nom"));
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return typeArticle;

    }

    @Override
    public String getNomTypeArticle(int idTypeArticle) {
        String nomTypeArticle = "";
        try {
            String requeteSelectArticle = "SELECT nom FROM type_article WHERE id=?";
            PreparedStatement selectUnArticleStatement = databaseConnection.prepareStatement(requeteSelectArticle);
            selectUnArticleStatement.setInt(1, idTypeArticle);
            ResultSet resultSetListArticles = selectUnArticleStatement.executeQuery();
            resultSetListArticles.next();
            nomTypeArticle = resultSetListArticles.getString("nom");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomTypeArticle;
    }

    @Override
    public ObservableList<String> getListeNomsTypesArticles() {
        List<String> listeDesNomsDesTypesDArticles = new ArrayList<>();
        String req = "SELECT nom FROM type_article";
        try {
            Statement selectArticlesStatement = databaseConnection.createStatement();
            ResultSet resultSetListArticles = selectArticlesStatement.executeQuery(req);
            while (resultSetListArticles.next()) {
                listeDesNomsDesTypesDArticles.add(resultSetListArticles.getString("nom"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(listeDesNomsDesTypesDArticles);
    }

    @Override
    public ObservableList<Integer> getIdentitiantsNomsTypesArticles() {
        List<Integer> listeDesNomsDesTypesDArticles = new ArrayList<>();
        String req = "SELECT id FROM type_article";
        try {
            Statement selectArticlesStatement = databaseConnection.createStatement();
            ResultSet resultSetListArticles = selectArticlesStatement.executeQuery(req);
            while (resultSetListArticles.next()) {
                listeDesNomsDesTypesDArticles.add(resultSetListArticles.getInt("id"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return FXCollections.observableArrayList(listeDesNomsDesTypesDArticles);
    }

    @Override
    public int getIdOfTypeArticle(String nomType) {
        int idTypeArticle = 1;
        try {
            String requeteSelectArticle = "SELECT * FROM type_article WHERE nom=?";
            PreparedStatement selectUnArticleStatement = databaseConnection.prepareStatement(requeteSelectArticle);
            selectUnArticleStatement.setString(1, nomType);
            ResultSet resultSetListArticles = selectUnArticleStatement.executeQuery();
            resultSetListArticles.next();
            idTypeArticle = resultSetListArticles.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idTypeArticle;
    }
}

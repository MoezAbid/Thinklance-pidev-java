/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.interfaces;

import com.thinklance.pidev.entities.Article;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Moez
 */
public interface IArticleService {

    public void ajouterArticle(Article nouvelArticle);

    public void modifierArticle(int id, Article articleModifie);
    
    public void supprimerArticle(int id);

    public ObservableList<Article> getListeAllArticles();

    public ObservableList<Article> getListeMesArticles(int idUtilisateur);
    
    public Article getArticleSpecifique(int idArticle);
    
    public ObservableList<Article> rechercheArticles(String motCle);
    
    public ObservableList<Article> rechercheDansMesArticles(String motCle, int idUtilisateur);
}

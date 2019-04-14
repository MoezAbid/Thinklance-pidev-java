/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Services.interfaces;

import com.thinklance.pidev.entities.TypeArticle;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Moez
 */
public interface ITypeArticleService {

    public void ajouterTypeArticle(TypeArticle nouveauTypeArticle);

    public void modifierTypeArticle(int id, TypeArticle typeArticleModifie);

    public void supprimerTypeArticle(int id);

    public ObservableList<TypeArticle> getListeTypesArticles();

    public TypeArticle getTypeArticleSpecifique(int idTypeArticle);

    public String getNomTypeArticle(int idTypeArticle);

    public ObservableList<String> getListeNomsTypesArticles();

    public ObservableList<Integer> getIdentitiantsNomsTypesArticles();
    
    public int getIdOfTypeArticle(String nomType);
}

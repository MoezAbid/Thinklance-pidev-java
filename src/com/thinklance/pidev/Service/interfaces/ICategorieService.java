/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.interfaces;

import com.thinklance.pidev.entities.CategorieProfile;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ICategorieService {

    void addCategorie(CategorieProfile cat);

    void updateCategorie(CategorieProfile cat);

    void deleteCategorie(int id);

    List<CategorieProfile> listerCategories();
    List<CategorieProfile> listerparNomcat(String nomcat);

}

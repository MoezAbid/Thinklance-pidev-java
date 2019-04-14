/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.interfaces;

import com.thinklance.pidev.entities.ExperienceProfessionnel;
import com.thinklance.pidev.entities.Formation;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IFormationService {

    void addFormation(Formation form);

    void updateFormation(Formation form);

    void deleteFormation(int id);

    List<Formation> listerFormations(int id );
    Formation getFormationById(int id);
}

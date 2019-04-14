/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.interfaces;

import com.thinklance.pidev.entities.Competence;
import com.thinklance.pidev.entities.ExperienceProfessionnel;
import com.thinklance.pidev.entities.Formation;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IExperienceProfessionelService {

    void addExperience(ExperienceProfessionnel exp);

    void updateExperience(ExperienceProfessionnel exp);

    void deleteExperience(int id);

    List<ExperienceProfessionnel> listerExperiences(int id);
     ExperienceProfessionnel getExperienceById(int id);
}

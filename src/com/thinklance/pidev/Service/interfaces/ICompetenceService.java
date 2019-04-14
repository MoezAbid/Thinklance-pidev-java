/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.interfaces;

import com.thinklance.pidev.entities.Competence;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ICompetenceService {

    void addCompetence(Competence comp);

    void updateCompetence(Competence comp);

    void deleteCompetence(int id);

    List<Competence> listerCompetences(int id);
}

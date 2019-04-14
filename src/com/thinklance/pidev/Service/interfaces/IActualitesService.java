/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.interfaces;

import com.thinklance.pidev.entities.Actualite;
import javafx.collections.ObservableList;

/**
 *
 * @author Moez
 */
public interface IActualitesService {
    public ObservableList<Actualite> getTechnologies();
    public ObservableList<Actualite> getProgrammationEtApplications();
    public ObservableList<Actualite> getFreelanceActualites();
}

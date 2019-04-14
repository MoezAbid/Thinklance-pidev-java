/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.service.Interfaces;

import com.thinklance.pidev.entities.Tache;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public interface ITache {
    public void addTache(Tache p);
    public void modifTache(Tache p);
    public void deleteTache(Tache p);
    public ArrayList getAllTache();
    public ObservableList getTacheParId(int id);
}

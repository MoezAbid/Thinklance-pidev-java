/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.interfaces;

import com.thinklance.pidev.entities.Paiement;
import javafx.collections.ObservableList;

/**
 *
 * @author Moez
 */
public interface IPaiementService {

    public void ajouterPaiement(Paiement nouveauPaiement);

    public void supprimerPaiement(String idPaiement);

    public ObservableList<Paiement> getListePaiements();

    public Paiement getPaiementSpecifique(String idPaiement);

    public ObservableList<Paiement> getPaiementsFreelancer(int idFreelancer);

    public ObservableList<Paiement> getPaiementsemployeur(int idEmployeur);

    public ObservableList<Paiement> getPaiementsUtilisateurSpecifique(int idUser);

    public void effectuerPaiement(double montant, int idProjet);
}

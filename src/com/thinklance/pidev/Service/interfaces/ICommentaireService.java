/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.interfaces;

import com.thinklance.pidev.entities.Commentaire;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ICommentaireService {
    
    List<Commentaire> getAllcomments(int id);
    void addComment(Commentaire com);
    
    
}

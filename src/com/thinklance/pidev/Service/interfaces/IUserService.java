/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.interfaces;

import com.thinklance.pidev.entities.User;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IUserService {

    boolean addUser(User user, String pass);

    int authentification(String username, String password, String roles);

    void updatepassworduser(User u);

    void editProfileUser(User u);

    User getInfoProfileUser(String email);

    List<User> getAllFreelancers();

    List<User> getAllEmployeurs();

    int countFreelancers();

    int countEmployers();

    User getUserById(int id);

    int getTheUserIdfromemail(String email);

    void updateDisponibiliteUser(int iduser, int dispo);

    void updateuserpointsAndNote(double note, double points, int iduser, int nbvote) ;

    int getNbPointUser(int iduser);

    double getNoteUser(int iduser);
    
    int getNbVote(int idu);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.entities;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class NotificationCommentaire {
    private int id;
    private String title;
    private String description;
    private Date notification_date;
    private int id_employeur;
    private int id_freelancer;

    public int getId_employeur() {
        return id_employeur;
    }

    public int getId_freelancer() {
        return id_freelancer;
    }

    public void setId_employeur(int id_employeur) {
        this.id_employeur = id_employeur;
    }

    public void setId_freelancer(int id_freelancer) {
        this.id_freelancer = id_freelancer;
    }
    

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getNotification_date() {
        return notification_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNotification_date(Date notification_date) {
        this.notification_date = notification_date;
    }

    public NotificationCommentaire(int id, String title, String description, Date notification_date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.notification_date = notification_date;
    }

    public NotificationCommentaire() {
    }

    @Override
    public String toString() {
        return "NotificationCommentaire{" + "id=" + id + ", title=" + title + ", description=" + description + ", notification_date=" + notification_date + '}';
    }
    
    
}

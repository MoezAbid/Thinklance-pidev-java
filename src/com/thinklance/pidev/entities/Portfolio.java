/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.entities;

/**
 *
 * @author ASUS
 */
public class Portfolio {
    private int id;
    private String image;
    private int id_user;

    public Portfolio(int id,  int id_user,String image) {
        this.id = id;
        this.image = image;
        this.id_user = id_user;
    }

    public Portfolio() {
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Portfolio{" + "id=" + id + ", image=" + image + ", id_user=" + id_user + '}';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class MyConnection {

    String url = "jdbc:mysql://localhost:3306/thinklancedb";
    String login = "root";
    String mdp = "";
    Connection cnx;
    static MyConnection mycnx;

    private MyConnection() {

        try {
            cnx = DriverManager.getConnection(url, login, mdp);
            System.out.println("Connexion etablie!");
        } catch (SQLException ex) {
            System.out.println("Problème de connexion :" + ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static MyConnection getInstance() {
        if (mycnx == null) {

            mycnx = new MyConnection();
        }
        return mycnx;

    }
}

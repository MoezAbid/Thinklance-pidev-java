/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.entities.Portfolio;
import java.util.List;
import com.thinklance.pidev.Service.interfaces.IPortfolioService;
import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.entities.ExperienceProfessionnel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class PortfolioService implements IPortfolioService{
    private Connection connection;

    public PortfolioService() {
        this.connection = MyConnection.getInstance().getCnx();
    }

    @Override
    public void addPortfolio(Portfolio port) {
               try {
            String requete = "INSERT INTO port_folio(id_user,nom_image) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(requete);
              ps.setInt(1, port.getId_user());
            ps.setString(2, port.getImage());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updatePortfolio(Portfolio form) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePortfolio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Portfolio> listerPortfolios(int id) {
             List<Portfolio> exp = new ArrayList<>();
        try {
            String req = "select * from port_folio where id_user="+id;
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Portfolio commentaire = new Portfolio(rs.getInt(1),rs.getInt(2),rs.getString(3));
                exp.add(commentaire);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exp;
    }
    
}

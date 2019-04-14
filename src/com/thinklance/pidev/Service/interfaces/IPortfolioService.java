/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.interfaces;

import com.thinklance.pidev.entities.Portfolio;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IPortfolioService {

    void addPortfolio(Portfolio langue);

    void updatePortfolio(Portfolio form);

    void deletePortfolio(int id);

    List<Portfolio> listerPortfolios(int id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Services.Impl;

import com.thinklance.pidev.Service.interfaces.IActualitesService;
import com.thinklance.pidev.entities.Actualite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Moez
 */
public class ActualitesService implements IActualitesService {

    //2019-04-10T13:00:40Z
    private SimpleDateFormat jsonDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    @Override
    public ObservableList<Actualite> getTechnologies() {
        List<Actualite> listeDesActualites = new ArrayList<>();
        try {
            URL url = new URL("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=548006773cb541218d1f486de78f76f1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            String inlineResult = "";
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNext()) {
                inlineResult += sc.nextLine();
            }
            sc.close();
            JSONObject resultJson = new JSONObject(inlineResult);
            JSONArray articlesArray = resultJson.getJSONArray("articles");
            for (int i = 0; i < articlesArray.length(); i++) {
                Actualite newActualite = new Actualite();
                newActualite.setAuteur(articlesArray.getJSONObject(i).getString("author"));
                newActualite.setDatePublication(jsonDateFormat.parse((articlesArray.getJSONObject(i).getString("publishedAt"))));
                newActualite.setDescription(articlesArray.getJSONObject(i).getString("description"));
                newActualite.setImage(articlesArray.getJSONObject(i).getString("urlToImage"));
                newActualite.setTitre(articlesArray.getJSONObject(i).getString("title"));
                newActualite.setUrlToAcualite(articlesArray.getJSONObject(i).getString("url"));
                listeDesActualites.add(newActualite);
            }
            System.out.println("This is the array list : ");
            System.out.println(listeDesActualites);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FXCollections.observableArrayList(listeDesActualites);
    }

    @Override
    public ObservableList<Actualite> getProgrammationEtApplications() {

        List<Actualite> listeDesActualites = new ArrayList<>();
        try {
            URL url = new URL("https://newsapi.org/v2/everything?q=programming&sortBy=popularity&apiKey=548006773cb541218d1f486de78f76f1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            String inlineResult = "";
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNext()) {
                inlineResult += sc.nextLine();
            }
            sc.close();
            JSONObject resultJson = new JSONObject(inlineResult);
            JSONArray articlesArray = resultJson.getJSONArray("articles");
            for (int i = 0; i < articlesArray.length(); i++) {
                Actualite newActualite = new Actualite();
                newActualite.setAuteur(articlesArray.getJSONObject(i).getString("author"));
                newActualite.setDatePublication(jsonDateFormat.parse((articlesArray.getJSONObject(i).getString("publishedAt"))));
                newActualite.setDescription(articlesArray.getJSONObject(i).getString("description"));
                newActualite.setImage(articlesArray.getJSONObject(i).getString("urlToImage"));
                newActualite.setTitre(articlesArray.getJSONObject(i).getString("title"));
                newActualite.setUrlToAcualite(articlesArray.getJSONObject(i).getString("url"));
                listeDesActualites.add(newActualite);
            }
            System.out.println("This is the array list : ");
            System.out.println(listeDesActualites);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FXCollections.observableArrayList(listeDesActualites);
    }

    @Override
    public ObservableList<Actualite> getFreelanceActualites() {

        List<Actualite> listeDesActualites = new ArrayList<>();
        try {
            URL url = new URL("https://newsapi.org/v2/everything?q=freelance&sortBy=popularity&apiKey=548006773cb541218d1f486de78f76f1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            String inlineResult = "";
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNext()) {
                inlineResult += sc.nextLine();
            }
            sc.close();
            JSONObject resultJson = new JSONObject(inlineResult);
            JSONArray articlesArray = resultJson.getJSONArray("articles");
            for (int i = 0; i < articlesArray.length(); i++) {
                Actualite newActualite = new Actualite();
                newActualite.setAuteur(articlesArray.getJSONObject(i).getString("author"));
                newActualite.setDatePublication(jsonDateFormat.parse((articlesArray.getJSONObject(i).getString("publishedAt"))));
                newActualite.setDescription(articlesArray.getJSONObject(i).getString("description"));
                newActualite.setImage(articlesArray.getJSONObject(i).getString("urlToImage"));
                newActualite.setTitre(articlesArray.getJSONObject(i).getString("title"));
                newActualite.setUrlToAcualite(articlesArray.getJSONObject(i).getString("url"));
                listeDesActualites.add(newActualite);
            }
            System.out.println("This is the array list : ");
            System.out.println(listeDesActualites);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ActualitesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FXCollections.observableArrayList(listeDesActualites);
    }
}

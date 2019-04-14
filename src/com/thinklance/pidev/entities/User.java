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
public class User {

    private int idUser;
    private String nom;
    private String prenom;
    private String password;
    private String email;
    private String adresse;
    private String titre_profile;
    private String pays;
    private String ville;
    private String description;
    private int disponibilite;
    private double note;
    private String specialite;
    private String nom_entreprise;
    private int nbr_point;
    private String check_profile;
    private double tarif_moyen;
    private int nbr_mission;
    private String tel;
    private String image;
    private String roles;

    public double getTarif_moyen() {
        return tarif_moyen;
    }

    public void setTarif_moyen(double tarif_moyen) {
        this.tarif_moyen = tarif_moyen;
    }

    public void setTitre_profile(String titre_profile) {
        this.titre_profile = titre_profile;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public void setNbr_point(int nbr_point) {
        this.nbr_point = nbr_point;
    }

    public void setCheck_profile(String check_profile) {
        this.check_profile = check_profile;
    }

    public void setNbr_mission(int nbr_mission) {
        this.nbr_mission = nbr_mission;
    }

    public String getTitre_profile() {
        return titre_profile;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getDescription() {
        return description;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public double getNote() {
        return note;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public int getNbr_point() {
        return nbr_point;
    }

    public String getCheck_profile() {
        return check_profile;
    }

    public int getNbr_mission() {
        return nbr_mission;
    }

    public User(int idUser, String nom, String prenom, String password, String email, String adresse, String tel, String image, String roles) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.email = email;
        this.adresse = adresse;
        this.tel = tel;
        this.image = image;
        this.roles = roles;
    }

    public User(String nom, String prenom, String password, String email, String roles) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }
    

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public String getImage() {
        return image;
    }

    public String getRoles() {
        return roles;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", email=" + email + ", adresse=" + adresse + ", tel=" + tel + ", image=" + image + ", roles=" + roles + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

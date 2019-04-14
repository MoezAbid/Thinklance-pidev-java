/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.Service.Impl;

import com.thinklance.pidev.Utils.MyConnection;
import com.thinklance.pidev.Utils.BCrypt;
import com.thinklance.pidev.entities.User;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.thinklance.pidev.Service.interfaces.IUserService;

/**
 *
 * @author ASUS
 */
public class UserService implements IUserService {

    private Connection connection;
    private FileInputStream fis;
    private File file;

    public UserService() {
        this.connection = MyConnection.getInstance().getCnx();
    }

    @Override
    public boolean addUser(User user, String email) {

        String query = "select * from fos_user where email='" + email + "';";
        String passdb = "";
        try {
            System.out.println("email saisi " + email);
            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            while (result.next()) {
                passdb = result.getString("email");
                System.out.println("email de la base " + passdb);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        if (passdb.equals(email) == false) {

            try {

                String req = "insert into fos_user(username,first_name,email,password,roles) values (?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(req);
                ps.setString(1, user.getPrenom());
                ps.setString(2, user.getNom());
                ps.setString(3, user.getEmail());
                String pw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(13));
                ps.setString(4, pw);
                ps.setString(5, user.getRoles()
                );
                ps.executeUpdate();
                System.out.println("user ajouté avec succès");
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }

        return false;

    }

    @Override
    public int authentification(String username, String password, String roles) {
        int exist = 3;

        try {
            String query = "select * from fos_user  where email =? and roles=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, roles);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            if (!rs.next()) {
                return 1;
            } else {
                query = "select * from fos_user  where email =? and enabled=1 and roles=?";
                ps = connection.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, roles);
                rs = ps.executeQuery();
                i = 0;
                if (!rs.next()) {
                    return 2;
                } else {
                    query = "select password from fos_user  where email =? and enabled=1 and roles=?";
                    ps = connection.prepareStatement(query);
                    ps.setString(1, username);
                    ps.setString(2, roles);
                    rs = ps.executeQuery();
                    i = 0;

                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                        System.out.println(BCrypt.hashpw(password, BCrypt.gensalt(13)));
                        if (BCrypt.checkpw(password, rs.getString(1)) == true) {
                            return 4;
                        } else {
                            return 3;
                        }
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return exist;
    }

    @Override
    public void updatepassworduser(User u) {
        String pw = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt(13));
        String query_pass_set = "update fos_user set password=? where email=?";
        try {
            PreparedStatement ps2 = connection.prepareStatement(query_pass_set);
            ps2.setString(1, pw);
            ps2.setString(2, u.getEmail());
            ps2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void editProfileUser(User u) {

        String query_pass_set = "update fos_user set titre_profile=?, pays=? , ville=? , tarif_moyen=? , description=? , nom_image=? , checkprofile=1 where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query_pass_set);
            ps.setString(1, u.getTitre_profile());
            ps.setString(2, u.getPays());
            ps.setString(3, u.getVille());
            ps.setDouble(4, u.getTarif_moyen());
            ps.setString(5, u.getDescription());
            ps.setString(6, u.getImage());
            ps.setInt(7, u.getIdUser());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    @Override
    public User getInfoProfileUser(String email) {
        String query = "select * from fos_user where email='" + email + "'";

        User u = new User();
        try {

            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            while (result.next()) {

                String a = result.getString("nom_image");

                u.setImage(a);
                u.setIdUser(result.getInt("id"));
                u.setNom(result.getString("username"));
                u.setPrenom(result.getString("first_name"));
                u.setPays(result.getString("pays"));
                u.setVille(result.getString("ville"));
                u.setTitre_profile(result.getString("titre_profile"));
                u.setEmail(result.getString("email"));
                u.setTarif_moyen(result.getDouble("tarif_moyen"));
                u.setDisponibilite(result.getInt("disponibilite"));
                    u.setRoles(result.getString("roles"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return u;
    }

    @Override
    public List<User> getAllFreelancers() {
        String query = "select * from fos_user where roles='FREELANCER' and checkprofile=1";
        List<User> listfreelancers = new ArrayList<>();

        try {

            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            while (result.next()) {
                User u = new User();
                u.setIdUser(result.getInt("id"));
                u.setImage(result.getString("nom_image"));
                u.setNom(result.getString("username"));
                u.setPrenom(result.getString("first_name"));
                u.setPays(result.getString("pays"));
                u.setVille(result.getString("ville"));
                u.setTitre_profile(result.getString("titre_profile"));
                u.setEmail(result.getString("email"));
                u.setDisponibilite(result.getInt("disponibilite"));
                u.setDescription(result.getString("description"));
                Double dValue = result.getDouble("tarif_moyen");

                if (!dValue.isNaN()) {
                    u.setTarif_moyen(result.getDouble("tarif_moyen"));
                }

                listfreelancers.add(u);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return listfreelancers;
    }

    @Override
    public List<User> getAllEmployeurs() {
        String query = "select * from fos_user where roles='EMPLOYEUR' and checkprofile=1";
        List<User> listemployeurs = new ArrayList<>();

        try {

            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            while (result.next()) {
                User u = new User();
                u.setIdUser(result.getInt("id"));
                u.setImage(result.getString("nom_image"));
                u.setNom(result.getString("username"));
                u.setPrenom(result.getString("first_name"));
                u.setPays(result.getString("pays"));
                u.setVille(result.getString("ville"));
                u.setTitre_profile(result.getString("titre_profile"));
                u.setEmail(result.getString("email"));
                u.setDisponibilite(result.getInt("disponibilite"));
                u.setDescription(result.getString("description"));
                Double dValue = result.getDouble("tarif_moyen");

                if (!dValue.isNaN()) {
                    u.setTarif_moyen(result.getDouble("tarif_moyen"));
                }

                listemployeurs.add(u);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return listemployeurs;
    }

    @Override
    public int countFreelancers() {
        String requete = "select count(*) from fos_user where roles='FREELANCER' and checkprofile=1";
        int count = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(requete);

            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                count = resultat.getInt(1);
            }
            return count;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return 0;
        }
    }

    @Override
    public int countEmployers() {
        String requete = "select count(*) from fos_user where roles='EMPLOYEUR' and checkprofile=1";
        int count = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(requete);

            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                count = resultat.getInt(1);
            }
            return count;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des Users " + ex.getMessage());
            return 0;
        }
    }

    @Override
    public User getUserById(int id) {
        String query = "select * from fos_user where id=" + id;

        User u = new User();
        try {

            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            while (result.next()) {

                u.setIdUser(result.getInt("id"));
                u.setImage(result.getString("nom_image"));
                u.setNom(result.getString("username"));
                u.setPrenom(result.getString("first_name"));
                u.setPays(result.getString("pays"));
                u.setVille(result.getString("ville"));
                u.setTitre_profile(result.getString("titre_profile"));
                u.setEmail(result.getString("email"));
                u.setDescription(result.getString("description"));
                u.setTarif_moyen(result.getDouble("tarif_moyen"));
                u.setNote(result.getDouble("note"));
                u.setNbr_point(result.getInt("nbr_points"));
                u.setDisponibilite(result.getInt("disponibilite"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return u;

    }

    @Override
    public int getTheUserIdfromemail(String email) {
        String query = "select id from fos_user where email='" + email + "'";
        int id = 0;

        try {

            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            while (result.next()) {
                id = result.getInt("id");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return id;
    }

//login fb 
    public void addUser(User uu) {
        try {
            String requete = "INSERT INTO fos_user(username,first_name,email,nom_image,password,roles,disponibilite) values (?,?,?,?,'******',?,1)";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, uu.getNom());
            ps.setString(2, uu.getPrenom());
            ps.setString(3, uu.getEmail());
            ps.setString(4, uu.getImage());
            ps.setString(5, uu.getRoles());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void updateDisponibiliteUser(int iduser, int dispo) {

        String query_pass_set = "update fos_user set disponibilite=" + dispo + " where id=" + iduser;
        try {
            PreparedStatement ps2 = connection.prepareStatement(query_pass_set);
            ps2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void updateuserpointsAndNote(double note, double points,int iduser, int nbvote) {
           String query_pass_set = "update fos_user set note=" + note + ",nbr_points="+points+",nbvote="+nbvote+ " where id=" + iduser;
        try {
            PreparedStatement ps2 = connection.prepareStatement(query_pass_set);
            ps2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public int getNbPointUser(int iduser) {
        String query = "select nbr_points from fos_user where id="+ iduser;
        int id = 0;

        try {

            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            while (result.next()) {
                id = result.getInt("nbr_points");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return id;
    }

    @Override
    public double getNoteUser(int iduser) {
            String query = "select note from fos_user where id="+ iduser;
        double id = 0;

        try {

            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            while (result.next()) {
                id = result.getDouble("note");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return id;
    }

    @Override
    public int getNbVote(int idu) {
         String query = "select nbvote from fos_user where id="+ idu;
        int id = 0;

        try {

            PreparedStatement prep = connection.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            while (result.next()) {
                id = result.getInt("nbvote");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return id;
    }

}

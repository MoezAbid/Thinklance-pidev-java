/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.pidev.entities;

import java.util.Properties;

/**
 *
 * @author ASUS
 */
public class Email {
    
    final String username = "thinklance2019@gmail.com";
    final String password = "Think2019";
    Properties props = System.getProperties();
    String host = "smtp.gmail.com";
 
    public Email(){
        
        
        props.put("mail.smtp.starttls.enable","true");
        /* mail.smtp.ssl.trust is needed in script to avoid error "Could not convert socket to TLS"  */
        props.setProperty("mail.smtp.ssl.trust", host);
        props.put("mail.smtp.auth", "true");      
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
    
        System.out.println(props.getProperty("mail.smtp.password"));
    }

    public Properties getProps() {
        return props;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }
    

}


/*
 * Copyright (C) Gleidson Neves da Silveira
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.thinklance.pidev.Utils;



import com.thinklance.pidev.entities.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class UserManager {

    public static User get(String name){
        try {
            File file = new File("user/" + name + ".properties");
            Properties properties = new Properties();

            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            User user = new User();

            user.setEmail(properties.getProperty("email"));
            return user;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
        public static String getUserConnected(){
        try {
            File file = new File("thinklance.properties");
            Properties properties = new Properties();

            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            User user = new User();
            return properties.getProperty("userLogged");
    
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void save(User user) {
        try {
            File file = new File("user/" + user.getNom() + ".properties");
            Properties properties = new Properties();
            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            FileOutputStream outputStream = new FileOutputStream(file);
            properties.setProperty("email", user.getEmail());
            properties.store(outputStream, "Update Section");
            properties.clear();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    

}

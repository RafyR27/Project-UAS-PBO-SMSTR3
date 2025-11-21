/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.*;
import models.ModelUser;
import utils.Databases;


/**
 *
 * @author Rafy1
 */
public class Auth extends Databases {
    
    ModelUser user = new ModelUser();
        
    
    public int registerService(String fullname, String email, String password) {
        String sql = "INSERT INTO user(fullname, email, password) VALUES('"+ fullname + "','" + email + "','" + password + "')"; 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con.prepareCall(sql).executeUpdate();
            
            return 200;
        } catch (SQLException ex) {
            return 500;
        } catch (ClassNotFoundException ex) {
            return 505;
        }
    }
    
    public int loginService(String email, String password){
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                user.setId(rs.getInt("id_user"));
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setPassword(null);
                user.setConfirmPassword(null);
                return 200;
            } else {
                return 404;
            }
        } catch (SQLException ex) {
            return 500;
        } catch (ClassNotFoundException ex) {                               
            return 505;
        }
    }
}

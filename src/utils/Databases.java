/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.*;

/**
 *
 * @author Rafy1
 */
public abstract class Databases {
    private String URL = "jdbc:mysql://localhost:3307/latihan_ecommerce_pbo";
    private String USER = "root";
    private String PASSWORD = "";
    protected Connection con;
    
    public Databases(){
        connect();
    }
    
    private void connect(){
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.getLogger(Databases.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } 
    }
    
}

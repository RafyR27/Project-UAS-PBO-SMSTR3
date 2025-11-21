/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.*;
import models.ModelAlamat;
import utils.Databases;

/**
 *
 * @author Rafy1
 */
public class UserServices extends Databases {
    public int getAlamatUser(int id_user){
        String sql = "select * from user_alamat where id_user = ?;";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id_user);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                ModelAlamat ma = new ModelAlamat();
                ma.setId(rs.getInt("id_alamat"));
                ma.setAlamat(rs.getString("alamat"));
                ma.setNo_telp(rs.getString("no_telp"));
                ma.setKode_pos(rs.getString("kode_pos"));
                return 200;
            } else {
                return 404;
            }
        } catch (SQLException ex) {
            return 500;
        }
    }
    
    public int setAlamatUser(int id_user, String alamat, String no_telp, String kode_pos){
        String sql = "INSERT INTO user_alamat (id_user, alamat, no_telp, kode_pos) VALUES (?, ?, ?, ?);";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id_user);
            pst.setString(2, alamat);
            pst.setString(3, no_telp);
            pst.setString(4, kode_pos);
            
            int rows = pst.executeUpdate();
            
            if(rows > 0){
                return 200;
            } else {
                return 404;
            }
        } catch (SQLException ex) {
            return 500;
        }
    }
    
    public int updateAlamatUser(int id_user, String alamat, String no_telp, String kode_pos){
        String sql = "update user_alamat set alamat = ?, no_telp = ?, kode_pos = ? where id_user = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, alamat);
            pst.setString(2, no_telp);
            pst.setString(3, kode_pos);
            pst.setInt(4, id_user);
            
            int rows = pst.executeUpdate();
            
            if(rows > 0){
                return 200;
            } else {
                return 404;
            }
        } catch (SQLException ex) {
            return 500;
        } 
    }
}

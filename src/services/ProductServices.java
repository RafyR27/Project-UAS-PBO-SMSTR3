/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import models.ModelProduct;
import utils.Databases;

/**
 *
 * @author Rafy1
 */
public class ProductServices extends Databases {
    public ArrayList<ModelProduct> getAllProductService(){
        ArrayList<ModelProduct> list = new ArrayList<>();
        String sql = "SELECT * FROM product where stok > 0";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                byte[] imgBytes = rs.getBytes("gambar");

                ImageIcon icon = new ImageIcon(imgBytes);
                
                
                list.add(new ModelProduct(rs.getInt("id_product"), rs.getString("product"), rs.getInt("harga"), rs.getString("deskripsi"), rs.getInt("stok"), icon));
            }
            
            
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return list;
    }
    
    public int buyProductService(int id_user, int id_product, int jumlah){
            String sqlCheck = "SELECT t.id_transaksi, t.jumlah, p.stok FROM transaksi t JOIN product p ON t.id_product = p.id_product WHERE t.id_user = ? AND t.id_product = ? AND t.transaction_status = 0;";
            String sqlInsert = "INSERT INTO transaksi(id_user, id_product, jumlah) VALUES (?, ?, ?)";
            String sqlUpdate = "UPDATE transaksi SET jumlah = jumlah + ? WHERE id_transaksi = ?";

            try {
                PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
                pstCheck.setInt(1, id_user);
                pstCheck.setInt(2, id_product);
                ResultSet rs = pstCheck.executeQuery();

                if (rs.next()) {
                    int jumlahSaatIni = rs.getInt("jumlah");
                    int stok = rs.getInt("stok");
                    int jumlahBaru = jumlahSaatIni + jumlah;

                    if (jumlahBaru > 10) {
                        return 505; 
                    }
                    
                    if(jumlahBaru > stok) {
                        return 506;
                    }
                    
                    int transaksiId = rs.getInt("id_transaksi");
                    PreparedStatement pstUpdate = con.prepareStatement(sqlUpdate);
                    pstUpdate.setInt(1, jumlah);
                    pstUpdate.setInt(2, transaksiId);
                    
                    int rows = pstUpdate.executeUpdate();
                    return rows > 0 ? 200 : 404;
                } else {
                    PreparedStatement pstInsert = con.prepareStatement(sqlInsert);
                    pstInsert.setInt(1, id_user);
                    pstInsert.setInt(2, id_product);
                    pstInsert.setInt(3, jumlah);
                    
                    int rows = pstInsert.executeUpdate();
                    return rows > 0 ? 201 : 404;
                }

            } catch (SQLException ex) {
                return 500;
            }
    }
    
    public ArrayList<ModelProduct> getProductService(int id_product){
        ArrayList<ModelProduct> list = new ArrayList<>();
        String sql = "select * from product where id_product = ?";
        try {
            PreparedStatement pstCheck = con.prepareStatement(sql);
            pstCheck.setInt(1, id_product);
            ResultSet rs = pstCheck.executeQuery();

            while(rs.next()){
                byte[] imgBytes = rs.getBytes("gambar");

                ImageIcon icon = new ImageIcon(imgBytes);
                
                list.add(new ModelProduct(rs.getInt("id_product"), rs.getString("product"), rs.getInt("harga"), rs.getString("deskripsi"), rs.getInt("stok"), icon));
            }
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return list;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import models.ModelProduct;
import models.ModelTransactionAdmin;
import models.ModelTransaction;
import utils.Databases;

/**
 *
 * @author Rafy1
 */
public class AdminServices extends Databases {
    public ArrayList<ModelProduct> getAllProduct(){
        ArrayList<ModelProduct> list = new ArrayList<>();
        String sql = "select * from product";
        
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
    
    public int addProduct(String product, int harga, int stok, String deskripsi, byte[] gambar){
        String sqlSelect = "select * from product where product = ?";
        String sql = "INSERT INTO product (product, deskripsi, harga, stok, gambar) VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pstSelect = con.prepareStatement(sqlSelect);
            pstSelect.setString(1, product);
            
            ResultSet rs = pstSelect.executeQuery();
            
            if(rs.next()){
                return 505;
            }
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, product);
            pst.setString(2, deskripsi);
            pst.setInt(3, harga);
            pst.setInt(4, stok);
            pst.setBytes(5, gambar);
            
            int rows = pst.executeUpdate();
            
            if(rows > 0){
                return 200;
            } else {
                return 505;
            }
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return 500;
        }
    }
    
    public ArrayList<ModelProduct> getProductById(int id_product){
        ArrayList<ModelProduct> list = new ArrayList<>();
        String sqlSelect = "select * from product where id_product = ?";
        
        try {    
            PreparedStatement pstSelect = con.prepareStatement(sqlSelect);
            pstSelect.setInt(1, id_product);
            
            ResultSet rs = pstSelect.executeQuery();
            
            while(rs.next()){
                
                byte[] imgBytes = rs.getBytes("gambar");

                ImageIcon icon = new ImageIcon(imgBytes);
                
                ModelProduct mp = new ModelProduct(rs.getInt("id_product"), rs.getString("product"), rs.getInt("harga"), rs.getString("deskripsi"), rs.getInt("stok"), icon);
                mp.setImgBytes(imgBytes);
                list.add(mp);
            } 
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return list;
    }
    
    public int updateProduct(int id_product, String product, int harga, int stok, String deskripsi, byte[] gambar){
        String sql = "update product set product = ?, deskripsi = ?, harga = ?, stok = ?, gambar = ? where id_product = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, product);
            pst.setString(2, deskripsi);
            pst.setInt(3, harga);
            pst.setInt(4, stok);
            pst.setBytes(5, gambar);
            pst.setInt(6, id_product);
            
            int rows = pst.executeUpdate();
            
            if(rows > 0){
                return 200;
            } else {
                return 404;
            }
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return 500;
        }
    }
    
    public int hapusProduct(int id_product){
        String sql = "delete from product where id_product = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id_product);
            
            int rows = pst.executeUpdate();
            
            if(rows > 0){
                return 200;
            } else {
                return 404;
            }
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return 500;
        }
    }
    
    public ArrayList<ModelTransactionAdmin> getTransaction(){
        ArrayList<ModelTransactionAdmin> list = new ArrayList<>();
        String sql = "SELECT py.order_id, py.order_status, py.total_price, py.time, a.alamat, u.fullname FROM payment py JOIN transaksi t ON py.order_id = t.order_id JOIN user u ON t.id_user = u.id_user JOIN user_alamat a ON a.id_user = u.id_user group by t.order_id;";
        
        try {    
            PreparedStatement pstSelect = con.prepareStatement(sql);
            
            ResultSet rs = pstSelect.executeQuery();
            
            while(rs.next()){
                list.add(new ModelTransactionAdmin(rs.getString("order_id"), rs.getString("fullname"), rs.getString("alamat"), rs.getString("time"), rs.getString("order_status"), rs.getInt("total_price")));
            } 
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return list;
    }
    
    public ArrayList<ModelTransaction> getTransactionProduct(String fullname, String order_id){
        String sql = "select p.product, p.id_product, p.harga, p.gambar, p.deskripsi, p.stok, t.jumlah from transaksi t join product p on t.id_product = p.id_product join user u on u.id_user = t.id_user where u.fullname = ? and t.order_id = ?;";
        ArrayList<ModelTransaction> list = new ArrayList<>();
        
        try {    
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, fullname);
            pst.setString(2, order_id);

            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                byte[] imgBytes = rs.getBytes("gambar");

                ImageIcon icon = new ImageIcon(imgBytes);
                
                ModelTransaction mp = new ModelTransaction(rs.getInt("id_product"), rs.getString("product"), rs.getInt("jumlah"), rs.getInt("stok"), rs.getInt("stok"), icon);
                
                list.add(mp);
            } 
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return list;
    }
    
    public int updateOrderStatus(String order_id){
        String sql = "update payment set order_status = 'selesai' where order_id = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, order_id);
            
            int rows = pst.executeUpdate();
            
            if(rows > 0){
                return 200;
            } else {
                return 404;
            }
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return 500;
        }
    }
}

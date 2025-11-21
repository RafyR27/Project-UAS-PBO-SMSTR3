/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import models.ModelPayment;
import models.ModelTransaction;
import utils.Databases;

/**
 *
 * @author Rafy1
 */
public class TransactionServices extends Databases {    
    public ArrayList<ModelTransaction> getTransaction(int id_user){
        ArrayList<ModelTransaction> list = new ArrayList<>();
        String sql = "SELECT p.id_product, p.product, p.stok, p.gambar, t.jumlah AS total_jumlah, SUM(p.harga * t.jumlah) AS total_harga FROM transaksi t JOIN product p ON p.id_product = t.id_product WHERE t.id_user = ? AND t.transaction_status = 0 AND t.jumlah > 0 GROUP BY p.id_product, p.product;";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, id_user);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                 byte[] imgBytes = rs.getBytes("gambar");

                ImageIcon icon = new ImageIcon(imgBytes);
                
                list.add(new ModelTransaction(rs.getInt("id_product"), rs.getString("product"), rs.getInt("total_jumlah"),rs.getInt("total_harga"), rs.getInt("stok"), icon));
            }
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return list;
    }
    
    public int updateOrderId(String orderId, int id_user){
        String sql = "UPDATE transaksi SET order_id = ?, transaction_status = 1 WHERE id_user = ? AND transaction_status = 0 AND jumlah > 0";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, orderId);
            pst.setInt(2, id_user);

            int rows = pst.executeUpdate();
            return rows > 0 ? 200 : 404;

        } catch (SQLException ex) {
            return 500;
        }
    }
    
    public int paymentService(String order_id, String metode_pembayaran, int total){
        String sql = "insert into payment(order_id, payment_status, metode_pembayaran, total_price) values(? , 'pending' , ?, ?)";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, order_id);
            pst.setString(2, metode_pembayaran);
            pst.setInt(3, total);

            int rows = pst.executeUpdate();
            return rows > 0 ? 200 : 404;

        } catch (SQLException ex) {
            return 500;
        }
    }
    
    public int updatePaymentService(String order_id){
        String sqlUpdatePayment = "UPDATE payment SET payment_status = 'success' WHERE order_id = ?";
        String sqlSelectTransaksi = "SELECT id_product, jumlah FROM transaksi WHERE order_id = ?";
        String sqlUpdateProduct = "UPDATE product SET stok = stok - ? WHERE id_product = ?";

        try {
            PreparedStatement pstUpdate = con.prepareStatement(sqlUpdatePayment);
            pstUpdate.setString(1, order_id);

            int rows = pstUpdate.executeUpdate();
            if (rows <= 0) {
                return 404;
            }

            PreparedStatement pstSelect = con.prepareStatement(sqlSelectTransaksi);
            pstSelect.setString(1, order_id);
            ResultSet rs = pstSelect.executeQuery();

            while (rs.next()) {
                int idProduct = rs.getInt("id_product");
                int jumlah = rs.getInt("jumlah");

                PreparedStatement pstUpdateProduct = con.prepareStatement(sqlUpdateProduct);
                pstUpdateProduct.setInt(1, jumlah);
                pstUpdateProduct.setInt(2, idProduct);

                pstUpdateProduct.executeUpdate();
            }

            return 200;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 500;
        }
    }
    
    public ArrayList<ModelPayment> getAllPayment(int id_user){
        ArrayList<ModelPayment> list = new ArrayList<>();
        String sql = "SELECT t.order_id, py.payment_status, py.metode_pembayaran, py.total_price FROM transaksi t JOIN payment py ON t.order_id = py.order_id WHERE t.id_user = ? AND t.transaction_status = 1 GROUP BY t.order_id;";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, id_user);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                list.add(new ModelPayment(rs.getInt("total_price"), rs.getString("order_id"),rs.getString("payment_status"), rs.getString("metode_pembayaran")));
            }
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return list;
    }
    
    public ArrayList<ModelTransaction> getProductPayment(int id_user, String order_id){
        ArrayList<ModelTransaction> list = new ArrayList<>();
        String sql = "SELECT SUM(t.jumlah) AS total_jumlah, SUM(t.jumlah * p.harga) AS total_harga, p.product, p.id_product, p.stok, p.gambar FROM transaksi t JOIN product p ON t.id_product = p.id_product WHERE t.id_user = ? AND t.order_id = ? GROUP BY p.product, p.id_product, p.stok, p.gambar;";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, id_user);
            pst.setString(2, order_id);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                byte[] imgBytes = rs.getBytes("gambar");

                ImageIcon icon = new ImageIcon(imgBytes);
                
                list.add(new ModelTransaction(rs.getInt("id_product"), rs.getString("product"),rs.getInt("total_jumlah"), rs.getInt("total_harga"), rs.getInt("stok"), icon));
            }
        } catch (SQLException ex) {
            System.getLogger(ProductServices.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return list;
    }
}

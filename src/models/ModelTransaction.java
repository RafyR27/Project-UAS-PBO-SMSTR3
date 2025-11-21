/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.swing.Icon;

/**
 *
 * @author Rafy1
 */
public class ModelTransaction {
    private int idProduct;
    private String product;
    private int total_jumlah;
    private int total_harga;
    private int stok;
    private Icon gambar;

    public ModelTransaction(int idProduct, String product, int total_jumlah, int total_harga, int stok, Icon gambar) {
        this.idProduct = idProduct;
        this.product = product;
        this.total_jumlah = total_jumlah;
        this.total_harga = total_harga;
        this.stok = stok;
        this.gambar = gambar;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getNamaProduct() {
        return product;
    }

    public int getTotal_jumlah() {
        return total_jumlah;
    }

    public int getTotal_harga() {
        return total_harga;
    }
    
    public int getStok() {
        return stok;
    }

    public Icon getGambar() {
        return gambar;
    }
    
    
}

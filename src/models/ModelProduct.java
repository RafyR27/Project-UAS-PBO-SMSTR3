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
public class ModelProduct {
    private int Id;
    private String namaProduct;
    private int price;
    private Icon image;
    private String deskripsi;
    private int stok;
    private byte[] imgBytes;
    
    public ModelProduct(int Id, String namaProduct, int price, String deskripsi, int stok, Icon image) {
        this.Id = Id;
        this.namaProduct = namaProduct;
        this.price = price;
        this.image = image;
        this.deskripsi = deskripsi;
        this.stok = stok;
    }
    
    
    public int getId() {
        return Id;
    }

    public String getNamaProduct() {
        return namaProduct;
    }

    public int getPrice() {
        return price;
    }

    public Icon getImage() {
        return image;
    }
    
    public String getDeskripsi() {
        return deskripsi;
    }
    
    public int getStok() {
        return stok;
    }

    public byte[] getImgBytes() {
        return imgBytes;
    }

    public void setImgBytes(byte[] imgBytes) {
        this.imgBytes = imgBytes;
    }

    
    
    
    
}

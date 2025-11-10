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
public class ModelItem {
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNamaProduct() {
        return namaProduct;
    }

    public void setNamaProduct(String namaProduct) {
        this.namaProduct = namaProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public ModelItem(int Id, String namaProduct, double price, Icon image) {
        this.Id = Id;
        this.namaProduct = namaProduct;
        this.price = price;
        this.image = image;
    }
    
    private int Id;
    private String namaProduct;
    private double price;
    private Icon image;
}

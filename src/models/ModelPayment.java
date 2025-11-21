/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Rafy1
 */
public class ModelPayment {
    private int total_price; 
    private String order_id;
    private String payment_status;
    private String metode_pembayaran;
 
    
    public ModelPayment(int total_price, String order_id, String payment_status, String metode_pembayaran) {
        this.total_price = total_price;
        this.order_id = order_id;
        this.payment_status = payment_status;
        this.metode_pembayaran = metode_pembayaran;
    }

    public int getTotal_price() {
        return total_price;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    
    
}

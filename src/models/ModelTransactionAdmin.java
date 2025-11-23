/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Rafy1
 */
public class ModelTransactionAdmin {
    private String order_id;
    private String nama_user;
    private String alamat;
    private String tanggal_pesanan;
    private String order_status;
    private int total;

    public ModelTransactionAdmin(String order_id, String nama_user, String alamat, String tanggal_pesanan, String order_status, int total) {
        this.order_id = order_id;
        this.nama_user = nama_user;
        this.alamat = alamat;
        this.tanggal_pesanan = tanggal_pesanan;
        this.order_status = order_status;
        this.total = total;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getNama_user() {
        return nama_user;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTanggal_pesanan() {
        return tanggal_pesanan;
    }

    public String getOrder_status() {
        return order_status;
    }

    public int getTotal() {
        return total;
    }

    
}

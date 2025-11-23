/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components;

import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import models.ModelTransaction;
import models.ModelTransactionAdmin;
import services.AdminServices;

/**
 *
 * @author Rafy1
 */
public class AdminTransaksiCardSelesai extends javax.swing.JPanel {

    private ModelTransactionAdmin data;
    private AdminServices adminServices = new AdminServices();
    
    NumberFormat nf = NumberFormat.getInstance(Locale.of("id", "ID"));
    
    public AdminTransaksiCardSelesai() {
        initComponents();
    }

    public void setData(ModelTransactionAdmin data){
        this.data = data;
        lbNamaUser.setText(data.getNama_user());
        lbAlamat.setText(data.getAlamat());
        lbTanggal.setText(data.getTanggal_pesanan());
        lbTotal_price.setText("Rp. " + nf.format(data.getTotal()));
        
        ArrayList<ModelTransaction> product = adminServices.getTransactionProduct(data.getNama_user(), data.getOrder_id());
        
        containerProduct.removeAll();
        
        for(ModelTransaction item : product){
            AdminTransaksiListProduct a = new AdminTransaksiListProduct();
            a.setData(item);
            containerProduct.add(a);
        }
        
        containerProduct.revalidate();
        containerProduct.repaint();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        lbTotal_price = new javax.swing.JLabel();
        lbAlamat = new javax.swing.JLabel();
        lbTanggal = new javax.swing.JLabel();
        lbNamaUser = new javax.swing.JLabel();
        containerProduct = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Total Pesanan");

        lbTotal_price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotal_price.setForeground(new java.awt.Color(0, 101, 248));
        lbTotal_price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotal_price.setText("Rp. 200.000.000");

        lbAlamat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbAlamat.setText("Alamat");

        lbTanggal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTanggal.setText("Tanggal");

        lbNamaUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNamaUser.setText("Nama User");

        containerProduct.setLayout(new javax.swing.BoxLayout(containerProduct, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(containerProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotal_price, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNamaUser)
                    .addComponent(lbTanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAlamat)
                .addGap(14, 14, 14)
                .addComponent(containerProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbTotal_price))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerProduct;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel lbAlamat;
    private javax.swing.JLabel lbNamaUser;
    private javax.swing.JLabel lbTanggal;
    private javax.swing.JLabel lbTotal_price;
    // End of variables declaration//GEN-END:variables
}

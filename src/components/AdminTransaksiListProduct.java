/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components;

import models.ModelTransaction;

/**
 *
 * @author Rafy1
 */
public class AdminTransaksiListProduct extends javax.swing.JPanel {

    private ModelTransaction data;
    
    public AdminTransaksiListProduct() {
        initComponents();
    }

    public void setData(ModelTransaction data){
        this.data = data;
        lbJumlah.setText("x" + Integer.toString(data.getTotal_jumlah()));
        lbNamaProduct.setText(data.getNamaProduct());
        pic.setImage(data.getGambar());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new components.PictureBox();
        lbNamaProduct = new javax.swing.JLabel();
        lbJumlah = new javax.swing.JLabel();

        pic.setImage(new javax.swing.ImageIcon(getClass().getResource("/images/p1.png"))); // NOI18N

        lbNamaProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNamaProduct.setText("Nama Product");

        lbJumlah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbJumlah.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbJumlah.setText("x1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNamaProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNamaProduct)
                            .addComponent(lbJumlah))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbJumlah;
    private javax.swing.JLabel lbNamaProduct;
    private components.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}

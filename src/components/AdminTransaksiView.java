/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.SwingUtilities;
import main.MainFrame;
import models.ModelTransactionAdmin;
import services.AdminServices;


public class AdminTransaksiView extends javax.swing.JPanel {

    private AdminServices adminServices = new AdminServices();
    
    public AdminTransaksiView() {
        initComponents();
        
        containerDikirim.setVisible(false);
        containerSelesai.setVisible(false);
        
        CardDikirim.setVisible(false);
        CardSelesai.setVisible(false);
    }

    public void getAllTransaction(){
        ArrayList<ModelTransactionAdmin> product = adminServices.getTransaction();
        
        CardDikirim.setVisible(false);
        CardSelesai.setVisible(false);
        
        containerDikirim.removeAll();
        containerSelesai.removeAll();
        
        for(ModelTransactionAdmin item : product){
            if(item.getOrder_status().equals("dikirim")){
                containerDikirim.setVisible(true);
                CardDikirim.setVisible(true);
                AdminTransaksiCardDikirim a = new AdminTransaksiCardDikirim();
                a.setData(item);
                containerDikirim.add(a);
                containerDikirim.add(Box.createRigidArea(new Dimension(0, 10)));
            } else if(item.getOrder_status().equals("selesai")) {
                containerSelesai.setVisible(true);
                CardSelesai.setVisible(true);
                AdminTransaksiCardSelesai a = new AdminTransaksiCardSelesai();
                a.setData(item);
                containerSelesai.add(a);
                containerSelesai.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }
       
        containerDikirim.revalidate();
        containerDikirim.repaint();
        containerSelesai.revalidate();
        containerSelesai.repaint();

        this.revalidate();
        this.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonProduct = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        buttonProduct1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        buttonProduct2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CardDikirim = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        containerDikirim = new javax.swing.JPanel();
        CardSelesai = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        containerSelesai = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 101, 248));
        jLabel1.setText("ELTRON");

        buttonProduct.setBackground(new java.awt.Color(204, 204, 204));
        buttonProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonProductMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Product");

        javax.swing.GroupLayout buttonProductLayout = new javax.swing.GroupLayout(buttonProduct);
        buttonProduct.setLayout(buttonProductLayout);
        buttonProductLayout.setHorizontalGroup(
            buttonProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonProductLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonProductLayout.setVerticalGroup(
            buttonProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonProduct1.setBackground(new java.awt.Color(153, 153, 153));
        buttonProduct1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonProduct1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonProduct1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonProduct1MouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Transaksi");

        javax.swing.GroupLayout buttonProduct1Layout = new javax.swing.GroupLayout(buttonProduct1);
        buttonProduct1.setLayout(buttonProduct1Layout);
        buttonProduct1Layout.setHorizontalGroup(
            buttonProduct1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonProduct1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonProduct1Layout.setVerticalGroup(
            buttonProduct1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonProduct1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonProduct2.setBackground(new java.awt.Color(204, 204, 204));
        buttonProduct2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonProduct2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonProduct2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonProduct2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonProduct2MouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 102));
        jLabel5.setText("Logout");

        javax.swing.GroupLayout buttonProduct2Layout = new javax.swing.GroupLayout(buttonProduct2);
        buttonProduct2.setLayout(buttonProduct2Layout);
        buttonProduct2Layout.setHorizontalGroup(
            buttonProduct2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonProduct2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonProduct2Layout.setVerticalGroup(
            buttonProduct2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonProduct2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonProduct1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonProduct2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(buttonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonProduct2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 101, 248));
        jLabel2.setText("ELTRON TRANSAKSI");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Dikirim");

        containerDikirim.setLayout(new javax.swing.BoxLayout(containerDikirim, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout CardDikirimLayout = new javax.swing.GroupLayout(CardDikirim);
        CardDikirim.setLayout(CardDikirimLayout);
        CardDikirimLayout.setHorizontalGroup(
            CardDikirimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CardDikirimLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(CardDikirimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(containerDikirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        CardDikirimLayout.setVerticalGroup(
            CardDikirimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardDikirimLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(containerDikirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Selesai");

        containerSelesai.setLayout(new javax.swing.BoxLayout(containerSelesai, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout CardSelesaiLayout = new javax.swing.GroupLayout(CardSelesai);
        CardSelesai.setLayout(CardSelesaiLayout);
        CardSelesaiLayout.setHorizontalGroup(
            CardSelesaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardSelesaiLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(CardSelesaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(containerSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        CardSelesaiLayout.setVerticalGroup(
            CardSelesaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardSelesaiLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(containerSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 542, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CardDikirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CardSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CardSelesai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CardDikirim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProductMouseEntered
        buttonProduct.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_buttonProductMouseEntered

    private void buttonProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProductMouseExited
        buttonProduct.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_buttonProductMouseExited

    private void buttonProduct1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProduct1MouseEntered
        buttonProduct1.setBackground(new java.awt.Color(0,202,255));
    }//GEN-LAST:event_buttonProduct1MouseEntered

    private void buttonProduct1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProduct1MouseExited
        buttonProduct1.setBackground(new java.awt.Color(153,153,153));
    }//GEN-LAST:event_buttonProduct1MouseExited

    private void buttonProduct2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProduct2MouseClicked
        MainFrame main = (MainFrame) SwingUtilities.getWindowAncestor(this);
        main.logout();
    }//GEN-LAST:event_buttonProduct2MouseClicked

    private void buttonProduct2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProduct2MouseEntered
        buttonProduct2.setBackground(new java.awt.Color(255,204,204));
    }//GEN-LAST:event_buttonProduct2MouseEntered

    private void buttonProduct2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProduct2MouseExited
        buttonProduct2.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_buttonProduct2MouseExited

    private void buttonProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProductMouseClicked
        MainFrame main = (MainFrame) SwingUtilities.getWindowAncestor(this);
        main.showAdminProductPage("admin");
    }//GEN-LAST:event_buttonProductMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardDikirim;
    private javax.swing.JPanel CardSelesai;
    private javax.swing.JPanel buttonProduct;
    private javax.swing.JPanel buttonProduct1;
    private javax.swing.JPanel buttonProduct2;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonTambah1;
    private javax.swing.JButton buttonTambah2;
    private javax.swing.JButton buttonTambah3;
    private javax.swing.JButton buttonTambah4;
    private javax.swing.JPanel containerDikirim;
    private javax.swing.JPanel containerSelesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import main.MainFrame;
import models.ModelProduct;
import services.AdminServices;

/**
 *
 * @author Rafy1
 */
public class adminView extends javax.swing.JPanel {

    private AdminServices adminServices = new AdminServices();
    private String REGEX = "[0-9]+";
    
    public adminView() {
        initComponents();
    }

    public void showProductAdmin(){
        ArrayList<ModelProduct> product = adminServices.getAllProduct();
        
        containerProduct.removeAll();
        
        for(ModelProduct item : product){
            AdminCardProduct a = new AdminCardProduct();
            a.setData(item);
            containerProduct.add(a);
        }
        
        containerProduct.revalidate();
        containerProduct.repaint();
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
        containerProduct = new javax.swing.JPanel();
        buttonTambah = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 101, 248));
        jLabel1.setText("ELTRON");

        buttonProduct.setBackground(new java.awt.Color(153, 153, 153));
        buttonProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonProduct.addMouseListener(new java.awt.event.MouseAdapter() {
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

        buttonProduct1.setBackground(new java.awt.Color(204, 204, 204));
        buttonProduct1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonProduct1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonProduct1MouseClicked(evt);
            }
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 101, 248));
        jLabel2.setText("ELTRON ADMIN");

        containerProduct.setBackground(new java.awt.Color(255, 255, 255));
        containerProduct.setLayout(new java.awt.GridLayout(0, 2, 10, 10));

        buttonTambah.setBackground(new java.awt.Color(0, 101, 248));
        buttonTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonTambah.setForeground(new java.awt.Color(255, 255, 255));
        buttonTambah.setText("Tambah Product");
        buttonTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(containerProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(581, 581, 581))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addComponent(buttonTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(containerProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProductMouseEntered
        buttonProduct.setBackground(new java.awt.Color(0,202,255));
    }//GEN-LAST:event_buttonProductMouseEntered

    private void buttonProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProductMouseExited
        buttonProduct.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_buttonProductMouseExited

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        JTextField namaField = new JTextField(30);
        JTextField hargaField = new JTextField(30);
        JTextField stokField = new JTextField(30);
        JTextArea deskripsiField = new JTextArea(5, 29);
        deskripsiField.setPreferredSize(new Dimension(250, 500));
        deskripsiField.setLineWrap(true);
        deskripsiField.setWrapStyleWord(true);

        JButton chooseImgBtn = new JButton("Pilih Gambar");
        JLabel imgPathLabel = new JLabel("Belum ada file");

        final File[] selectedFile = {null};

        chooseImgBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image Files (JPG, PNG)", "jpg", "jpeg", "png"
            );
            chooser.setFileFilter(filter);
            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile[0] = chooser.getSelectedFile();
                imgPathLabel.setText(selectedFile[0].getName());
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        gbc.gridx = 0; 
        gbc.gridy = row;
        panel.add(new JLabel("Nama"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        panel.add(namaField, gbc);

        row++;
        gbc.gridx = 0; 
        gbc.gridy = row;
        panel.add(new JLabel("Harga"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        panel.add(hargaField, gbc);

        row++;
        gbc.gridx = 0; 
        gbc.gridy = row;
        panel.add(new JLabel("Stok"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        panel.add(stokField, gbc);

        row++;
        gbc.gridx = 0; 
        gbc.gridy = row;
        panel.add(new JLabel("Deskripsi"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        JScrollPane deskripsiScroll = new JScrollPane(deskripsiField);
        deskripsiScroll.setPreferredSize(new Dimension(250, 200));
        panel.add(deskripsiScroll, gbc);

        row++;
        gbc.gridx = 0; 
        gbc.gridy = row;
        panel.add(new JLabel("Gambar"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        panel.add(chooseImgBtn, gbc);

        row++;
        gbc.gridx = 1; 
        gbc.gridy = row;
        panel.add(imgPathLabel, gbc);

        int result = JOptionPane.showConfirmDialog(
                SwingUtilities.windowForComponent(this),
                panel,
                "Tambah Produk",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            if (selectedFile[0] == null) {
                JOptionPane.showMessageDialog(null, "Gambar belum dipilih!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(namaField.getText().trim().isEmpty() || deskripsiField.getText().trim().isEmpty() || hargaField.getText().trim().isEmpty() || stokField.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (deskripsiField.getText().trim().length() > 2000){
                JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Field deskripsi hanya boleh 2000 kata!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(!hargaField.getText().trim().matches(REGEX) || !stokField.getText().trim().matches(REGEX)){
                JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Harga dan stok harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nama = namaField.getText().trim();
            int harga = Integer.parseInt(hargaField.getText().trim());
            int stok = Integer.parseInt(stokField.getText().trim());
            String deskripsi = deskripsiField.getText().trim();
            File gambar = selectedFile[0];
            
            byte[] imageByte;

            try (FileInputStream fis = new FileInputStream(gambar)) {
                imageByte = fis.readAllBytes();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "File gambar tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Gagal membaca file gambar!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int resultInsert = adminServices.addProduct(nama, harga, stok, deskripsi, imageByte);
            
            if(resultInsert == 200){
                JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Product berhasil ditambahkan!", "Success", JOptionPane.INFORMATION_MESSAGE);
                MainFrame main = (MainFrame) SwingUtilities.windowForComponent(this);
                main.showAdminProductPage("admin");
            } else if(resultInsert == 505){
                JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Product sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Internal Server Error!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonProduct2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProduct2MouseEntered
        buttonProduct2.setBackground(new java.awt.Color(255,204,204));
    }//GEN-LAST:event_buttonProduct2MouseEntered

    private void buttonProduct2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProduct2MouseClicked
        MainFrame main = (MainFrame) SwingUtilities.getWindowAncestor(this);
        main.logout();
    }//GEN-LAST:event_buttonProduct2MouseClicked

    private void buttonProduct2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProduct2MouseExited
        buttonProduct2.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_buttonProduct2MouseExited

    private void buttonProduct1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProduct1MouseEntered
        buttonProduct1.setBackground(new java.awt.Color(153,153,153));
    }//GEN-LAST:event_buttonProduct1MouseEntered

    private void buttonProduct1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProduct1MouseExited
        buttonProduct1.setBackground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_buttonProduct1MouseExited

    private void buttonProduct1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonProduct1MouseClicked
        MainFrame main = (MainFrame) SwingUtilities.windowForComponent(this);
        main.showAdminTransactionPage("admin");
    }//GEN-LAST:event_buttonProduct1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonProduct;
    private javax.swing.JPanel buttonProduct1;
    private javax.swing.JPanel buttonProduct2;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JPanel containerProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}

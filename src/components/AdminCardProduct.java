/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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
public class AdminCardProduct extends javax.swing.JPanel {

    private ModelProduct data;
    private AdminServices adminServices = new AdminServices();
    
    private String REGEX = "[0-9]+";
    private int id_product;
    
                
    String nama;
    int harga;
    int stok;
    String deskripsi;
    byte[] imageByte;
    
    NumberFormat nf = NumberFormat.getInstance(Locale.of("id", "ID"));
    
    JPopupMenu popMenu = new JPopupMenu();
    
    public AdminCardProduct() {
        initComponents();
        
        JMenuItem editProduct = new JMenuItem("Edit");
        JMenuItem hapusProduct = new JMenuItem("Hapus");
        hapusProduct.setForeground(Color.red);

        popMenu.add(editProduct);
        popMenu.add(hapusProduct);
        
        editProduct.addActionListener(e -> {
            ArrayList<ModelProduct> product = adminServices.getProductById(id_product);
            
            JTextField namaField = new JTextField(30);
            JTextField hargaField = new JTextField(30);
            JTextField stokField = new JTextField(30);
            JTextArea deskripsiField = new JTextArea(5, 29);
            deskripsiField.setPreferredSize(new Dimension(250, 500));
            deskripsiField.setLineWrap(true);
            deskripsiField.setWrapStyleWord(true);
            
            for(ModelProduct item : product){
                nama = item.getNamaProduct();
                harga = item.getPrice();
                stok = item.getStok();
                deskripsi = item.getDeskripsi();
                imageByte = item.getImgBytes();
            }

            JButton chooseImgBtn = new JButton("Pilih Gambar");
            JLabel imgPathLabel = new JLabel("Belum ada file");

            final File[] selectedFile = {null};

            chooseImgBtn.addActionListener(click -> {
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
            
            
            namaField.setText(nama);
            hargaField.setText(Integer.toString(harga));
            stokField.setText(Integer.toString(stok));
            deskripsiField.setText(deskripsi);

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
                    "Update Produk",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
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

                nama = namaField.getText().trim();
                harga = Integer.parseInt(hargaField.getText().trim());
                stok = Integer.parseInt(stokField.getText().trim());
                deskripsi = deskripsiField.getText().trim();
                File gambar = selectedFile[0];
                
                if(!(selectedFile[0] == null)){
                    try (FileInputStream fis = new FileInputStream(gambar)) {
                        imageByte = fis.readAllBytes();
                    } catch (FileNotFoundException en) {
                        JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "File gambar tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } catch (IOException en) {
                        JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Gagal membaca file gambar!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                
                int resultInsert = adminServices.updateProduct(id_product ,nama, harga, stok, deskripsi, imageByte);

                if(resultInsert == 200){
                    JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Produk berhasil diedit!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    MainFrame main = (MainFrame) SwingUtilities.windowForComponent(this);
                    main.showAdminProductPage("admin");
                } else if (resultInsert == 404){
                   JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Produk tidak ditemukan!", "Error!", JOptionPane.ERROR_MESSAGE);
               } else {
                    JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Internal Server Error!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        hapusProduct.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(SwingUtilities.windowForComponent(this), "Apakah anda yakin ingin menghapus produk ini?", "Hapus Produk", JOptionPane.OK_CANCEL_OPTION);
            
            if(result == JOptionPane.OK_OPTION){
               int resultDelete = adminServices.hapusProduct(id_product);
               
               if(resultDelete == 200){
                   JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Produk berhasil dihapus!", "Success", JOptionPane.INFORMATION_MESSAGE);
                   MainFrame main = (MainFrame) SwingUtilities.windowForComponent(this);
                   main.showAdminProductPage("admin");
               } else if (resultDelete == 404){
                   JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Produk tidak ditemukan!", "Error!", JOptionPane.ERROR_MESSAGE);
               } else {
                   JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(this), "Internal Server Error!", "Error!", JOptionPane.ERROR_MESSAGE);
               }
            }
        });
    }

    public void setData(ModelProduct data){
        this.data = data;
        lbProduct.setText(data.getNamaProduct());
        lbStok.setText("Stok " + Integer.toString(data.getStok()));
        lbHarga.setText("Rp. " + nf.format(data.getPrice()));
        pic.setImage(data.getImage());
        id_product = data.getId();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new components.PictureBox();
        lbProduct = new javax.swing.JLabel();
        lbHarga = new javax.swing.JLabel();
        lbStok = new javax.swing.JLabel();
        buttonSetting = new javax.swing.JButton();

        pic.setImage(new javax.swing.ImageIcon(getClass().getResource("/images/p1.png"))); // NOI18N

        lbProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbProduct.setText("Nama Product");

        lbHarga.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHarga.setText("Rp. 200.000");

        lbStok.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbStok.setText("Stok 500");

        buttonSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setting.png"))); // NOI18N
        buttonSetting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSettingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbStok, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSetting)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lbProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSetting))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStok)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSettingActionPerformed
        popMenu.show(buttonSetting, -20, buttonSetting.getHeight());
    }//GEN-LAST:event_buttonSettingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSetting;
    private javax.swing.JLabel lbHarga;
    private javax.swing.JLabel lbProduct;
    private javax.swing.JLabel lbStok;
    private components.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}

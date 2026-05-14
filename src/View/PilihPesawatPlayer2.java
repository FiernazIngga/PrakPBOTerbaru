/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ExceptionHandlingController.ExceptionUsernameKosong;
import DAO.DataHistoryGameDAO;
import Model.ModelHistoryGame.TempDataHistory;
import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author M S I
 */
public class PilihPesawatPlayer2 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GameProjectPlay.class.getName());
    private TempDataHistory tempDataMasuk;
    private String username;
    private String namaPesawat;

    public PilihPesawatPlayer2(TempDataHistory tempDataMasuk) {
        initComponents();
        this.tempDataMasuk = tempDataMasuk;
        setImage(jLabel2, "/Asset/Resource/Image/musuhAlien.png");
        jLabel2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); 
        comboBoxPesawat();
        DataHistoryGameDAO dao = new DataHistoryGameDAO();
        String defaultNama =  dao.data("namaPilot2");
        String defaultPesawat = dao.data("namaPesawat2");
        System.out.println(defaultNama);
        System.out.println(defaultPesawat);

        // default username
        if (defaultNama != null) {
            jTextField1.setText(defaultNama);
            this.username = defaultNama;
        }

        // default combobox
        if (defaultPesawat != null) {

            jComboBox1.setSelectedItem(defaultPesawat);

            this.namaPesawat = defaultPesawat;

            // update gambar otomatis
            if (defaultPesawat.equals("Pesawat Alien")) {

                setImage(
                    jLabel2,
                    "/Asset/Resource/Image/musuhAlien.png"
                );

            } else if (defaultPesawat.equals("Pesawat Darker")) {

                setImage(
                    jLabel2,
                    "/Asset/Resource/Image/musuhDarker.png"
                );

            } else if (defaultPesawat.equals("Pesawat Phantom")) {

                setImage(
                    jLabel2,
                    "/Asset/Resource/Image/musuhPhantom.png"
                );
            }

        } else {

            // kalau DB kosong
            this.namaPesawat =
                (String) jComboBox1.getSelectedItem();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(47, 53, 66));
        jPanel1.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Resource/Image/pesawatIndonesia.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 130, 370, 250);

        jButton4.setBackground(new java.awt.Color(44, 190, 80));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LANJUTKAN");
        jButton4.setFocusable(false);
        jButton4.addActionListener(this::jButton4ActionPerformed);
        jPanel1.add(jButton4);
        jButton4.setBounds(650, 330, 340, 60);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(650, 140, 340, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pilih Pesawat:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(650, 210, 340, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PILIH PESAWAT USER PERTAMA");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 40, 1080, 32);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pesawat Alien", "Pesawat Darker", "Pesawat Phantom" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(650, 240, 340, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Pilot:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(650, 110, 340, 20);

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Kembali");
        jButton1.setFocusable(false);
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 20, 110, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        exceptionHandlingUsername();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PilihPesawatPlayer pesawatPlayer1 = new PilihPesawatPlayer(tempDataMasuk);
        pesawatPlayer1.setVisible(true);
        pesawatPlayer1.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new GameProjectPlay().setVisible(true));
    }
    
    public void setImage(JLabel label, String path) {

        ImageIcon icon = new ImageIcon(
            getClass().getResource(path)
        );

        Image img = icon.getImage().getScaledInstance(
            label.getWidth() - 70,
            label.getHeight() - 50,
            Image.SCALE_SMOOTH
        );

        label.setIcon(new ImageIcon(img));
    }
    
    public void comboBoxPesawat() {

        jComboBox1.addActionListener(e -> {

            String pesawat = (String) jComboBox1.getSelectedItem();
            tempDataMasuk.setNamaPesawat2(pesawat);
            if (pesawat.equals("Pesawat Alien")) {
                setImage(jLabel2, "/Asset/Resource/Image/musuhAlien.png");
            } else if (pesawat.equals("Pesawat Darker")) {
                setImage(jLabel2, "/Asset/Resource/Image/musuhDarker.png");
            } else if (pesawat.equals("Pesawat Phantom")) {
                setImage(jLabel2, "/Asset/Resource/Image/musuhPhantom.png");
            }
        });
    }
    
    public void validasiUsername() throws ExceptionUsernameKosong {
        String username = jTextField1.getText().trim();
        tempDataMasuk.setNamaPilot2(username);
        if (username.isEmpty()) {
            throw new ExceptionUsernameKosong(
                "Nama pilot tidak boleh kosong!"
            );
        }
    }
    
    public void exceptionHandlingUsername() {
        try {
            validasiUsername();
            ArenaPerangFrame main = new ArenaPerangFrame(false, tempDataMasuk);
            main.setVisible(true);
            main.setLocationRelativeTo(null);
            this.setVisible(false);
        } catch (ExceptionUsernameKosong ex) {
            JOptionPane.showMessageDialog(
                this,
                ex.getMessage()
            );
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

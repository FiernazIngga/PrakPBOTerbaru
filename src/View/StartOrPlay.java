/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

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
public class StartOrPlay extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GameProjectPlay.class.getName());
    private TempDataHistory tempDataMasuk = new TempDataHistory();
    
    public StartOrPlay() {
        initComponents();

        setImage(jLabel2, "/Asset/Resource/Image/pesawatIndonesia.png");
        setImage(jLabel1, "/Asset/Resource/Image/musuhPhantom.png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(47, 53, 66));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Resource/Image/musuhPhantom.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(920, 180, 120, 120);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Resource/Image/pesawatIndonesia.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 180, 120, 120);

        jButton1.setBackground(new java.awt.Color(44, 190, 80));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LAWAN AI");
        jButton1.setFocusable(false);
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel1.add(jButton1);
        jButton1.setBounds(380, 220, 430, 60);

        jButton2.setBackground(new java.awt.Color(44, 190, 80));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("HISTORI PERMAINAN");
        jButton2.setFocusable(false);
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel1.add(jButton2);
        jButton2.setBounds(380, 300, 430, 60);

        jButton4.setBackground(new java.awt.Color(44, 190, 80));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LAWAN PLAYER");
        jButton4.setFocusable(false);
        jButton4.addActionListener(this::jButton4ActionPerformed);
        jPanel1.add(jButton4);
        jButton4.setBounds(380, 140, 430, 60);

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
        PilihPesawatPlayer pesawatPlayer1 = new PilihPesawatPlayer(tempDataMasuk);
        pesawatPlayer1.setVisible(true);
        pesawatPlayer1.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArenaPerangFrame main = new ArenaPerangFrame(true, tempDataMasuk);
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DataHistoryGameDAO dao = new DataHistoryGameDAO();

        if (dao.getAll().isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "Data history kosong, tidak bisa dibuka!",
                "Info",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        LihatHistory lh = new LihatHistory();
        lh.setVisible(true);
        lh.setLocationRelativeTo(null);
        lh.loadData();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new GameProjectPlay().setVisible(true));
    }
    
    public void setImage(JLabel label, String path) {

        ImageIcon icon = new ImageIcon(
            getClass().getResource(path)
        );

        Image img = icon.getImage().getScaledInstance(
            label.getWidth(),
            label.getHeight(),
            Image.SCALE_SMOOTH
        );

        label.setIcon(new ImageIcon(img));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

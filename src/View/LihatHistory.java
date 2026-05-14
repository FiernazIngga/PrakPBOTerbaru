package View;

import DAO.DataHistoryGameDAO;
import Model.ModelHistoryGame.DataHistoryGame;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class LihatHistory extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LihatHistory.class.getName());
    public List<DataHistoryGame> list;
    private int selectedId;

    public LihatHistory() {
        initComponents();
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(47, 53, 66));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hisroti Permainan Game Pesawat Bertengkar");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 30, 1120, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Nama Pilot 1", "Nama Pesawat 1", "Nama Pilot 2", "Nama Pesawat 2", "Waktu Permainan", "Waktu Mulai", "Catatan", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 1120, 400);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Hapus");
        jButton1.setFocusable(false);
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel1.add(jButton1);
        jButton1.setBounds(990, 80, 140, 30);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(900, 80, 64, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("No yang dihapus:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(780, 80, 120, 30);

        jButton2.setBackground(new java.awt.Color(0, 153, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Kembali");
        jButton2.setFocusable(false);
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 10, 120, 40);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        StartOrPlay play = new StartOrPlay();
        play.setVisible(true);
        play.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.getSelectedRow();

        String id = jTable1.getValueAt(baris, 0).toString();

        selectedId = Integer.parseInt(id);
        System.out.println(selectedId);

        String no = jTable1.getValueAt(baris, 1).toString();
        jTextField1.setText(no);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (selectedId < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Pilih data dulu!");
            return;
        }

        DataHistoryGameDAO dao = new DataHistoryGameDAO();
        dao.delete(selectedId);

        javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil dihapus");

        loadData(); 

        selectedId = -1;
        jTextField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new LihatHistory().setVisible(true));
    }
    
    public void loadData() {

        DataHistoryGameDAO dao = new DataHistoryGameDAO();
        List<DataHistoryGame> list = dao.getAll();

        if (list == null || list.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Tidak ada data history!",
                    "Info",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
            );
            jTable1.setModel(new DefaultTableModel());
            StartOrPlay play = new StartOrPlay();
            play.setVisible(true);
            play.setLocationRelativeTo(null);
            this.setVisible(false);
        }

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID"); 
        model.addColumn("No");
        model.addColumn("Nama Pilot 1");
        model.addColumn("Nama Pesawat 1");
        model.addColumn("Nama Pilot 2");
        model.addColumn("Nama Pesawat 2");
        model.addColumn("Waktu Permainan");
        model.addColumn("Waktu Selesai");
        model.addColumn("Catatan");

        int no = 1;

        for (DataHistoryGame h : list) {
            model.addRow(new Object[]{
                h.getId(),
                no++,
                h.getNamaPilot1(),
                h.getNamaPesawat1(),
                h.getNamaPilot2(),
                h.getNamaPesawat2(),
                h.getWaktu_mulai(),
                h.getWaktu_selesai(),
                h.getCatatan()
            });
        }

        jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        jTable1.getColumnModel().getColumn(1).setMinWidth(40);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);

        jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(150);

        jTable1.getColumnModel().getColumn(8).setPreferredWidth(300);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.PermainanController.GameController;
import Controller.PermainanController.GamePesawat;
import Model.ModelHistoryGame.TempDataHistory;
import Model.ModelJalanGame.GameState;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author M S I
 */
public class ArenaPerangFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ArenaPerangFrame.class.getName());
    
    public ArenaPerangFrame(boolean isBot, TempDataHistory tempDataMasuk) {
        setTitle("Game Pesawat");

        initComponents();
        GameState model = new GameState();
        GameController logic = new GameController(model, tempDataMasuk);
        GamePesawat input = new GamePesawat(logic, isBot);

        PanelArenaGame panel = new PanelArenaGame(model, input, this, isBot, tempDataMasuk);

        gamePanelContainer.setLayout(new BorderLayout());
        gamePanelContainer.add(panel);

        setSize(1136, 525);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanelContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout gamePanelContainerLayout = new javax.swing.GroupLayout(gamePanelContainer);
        gamePanelContainer.setLayout(gamePanelContainerLayout);
        gamePanelContainerLayout.setHorizontalGroup(
            gamePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1136, Short.MAX_VALUE)
        );
        gamePanelContainerLayout.setVerticalGroup(
            gamePanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamePanelContainer;
    // End of variables declaration//GEN-END:variables
}

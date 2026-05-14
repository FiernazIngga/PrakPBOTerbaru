package View;

import Asset.Resource.LoadFile.Ledakan;
import Controller.PermainanController.GamePesawat;
import Model.ModelEntity.Bullet;
import Model.ModelHistoryGame.TempDataHistory;
import Model.ModelJalanGame.GameState;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.util.Random;

public class PanelArenaGame extends javax.swing.JPanel {

    private GameState model;
    private GamePesawat controller;
    private Image background;
    private Image pesawat1;
    private Image pesawat2;
    private javax.swing.JFrame parentFrame;
    private boolean isbot;
    private int pilihan;
    private TempDataHistory tempDataMasuk;
    String pathPesawat1, pathPesawat2;
    private boolean sudahInsert = false;
    
    public PanelArenaGame(GameState model,GamePesawat controller,JFrame frame,boolean isbot,TempDataHistory tempDataMasuk) {

    this.tempDataMasuk = tempDataMasuk;
    this.isbot = isbot;
    this.model = model;
    this.controller = controller;
    this.parentFrame = frame;

    if (isbot) {

        String[] pesawatBot = {
            "Pesawat Alien",
            "Pesawat Darker",
            "Pesawat Phantom"
        };

        Random random = new Random();

        String pesawatRandom = pesawatBot[
            random.nextInt(pesawatBot.length)
        ];
        String namaPilot = tempDataMasuk.getNamaPilot1() == null ? "Pengguna" : tempDataMasuk.getNamaPilot1();
        tempDataMasuk.setNamaPilot1(namaPilot);
        tempDataMasuk.setNamaPilot2("BOT Sistem");
        tempDataMasuk.setNamaPesawat1("Pesawat Indonesia");
        tempDataMasuk.setNamaPesawat2(pesawatRandom);
    }

    LocalDateTime sekarang = LocalDateTime.now();

    tempDataMasuk.setWaktu_mulai(sekarang);
    tempDataMasuk.setWaktu_sekarang(sekarang);

    initComponents();

    setFocusable(true);
    addKeyListener(controller);

    background = new ImageIcon(
        getClass().getResource(
            "/Asset/Resource/BackgroundImage/background1.png"
        )
    ).getImage();

    pesawat1 = new ImageIcon(
        getClass().getResource(
            pathPesawat(tempDataMasuk.getNamaPesawat1())
        )
    ).getImage();

    pesawat2 = new ImageIcon(
        getClass().getResource(
            pathPesawat(tempDataMasuk.getNamaPesawat2())
        )
    ).getImage();

    startLoop();
}
    
    private void startLoop() {
        new Thread(() -> {
            while (!model.gameOver) {

                controller.update();
                repaint();

                try {
                    Thread.sleep(16); 
                } catch (Exception e) {}
            }
            if (model.gameOver && !sudahInsert) {
                sudahInsert = true;
                tempDataMasuk.setWaktu_selesai(LocalDateTime.now());

                String lawan = isbot ? "Bot" : model.kalah;

                String catatanGame =
                    "Pemenang: " + model.pemenang +
                    " | Melawan: " + lawan;

                tempDataMasuk.setCatatan(catatanGame);
                tempDataMasuk.insertHistoryGame();
                if (!isbot) {
                    pilihan = JOptionPane.showConfirmDialog(
                        this,
                        "Pemenangnya adalah " + model.pemenang + " Mau main lagi?",
                        "Game Selesai",
                        JOptionPane.YES_NO_OPTION
                    );
                } else {
                    String msg = model.gameWin ? "Yeayyy anda menang, mau main lagi?" : "Game Over, mau main lagi?";

                    pilihan = JOptionPane.showConfirmDialog(
                        this,
                        msg,
                        "Game Selesai",
                        JOptionPane.YES_NO_OPTION
                    );
                }

                if (pilihan == JOptionPane.YES_OPTION) {
                    StartOrPlay main = new StartOrPlay();
                    main.setVisible(true);
                    main.setLocationRelativeTo(null);

                    this.setVisible(false);
                    parentFrame.setVisible(false);
                } else {
                    System.exit(0);
                }
            }
        }).start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(background, 0, 0, getWidth(), getHeight(), null);

        drawHealthBar(g2, 20, 30, model.player.hp, "Player 1");
        drawHealthBar(g2, getWidth() - 220, 30, model.enemy.hp, "Player 2");
        
        for (Bullet b : model.bullets) {
            if (b.fromPlayer) {
                g2.setColor(Color.YELLOW); // peluru player
            } else {
                g2.setColor(Color.RED); // peluru enemy
            }

            g2.fillRect(b.x, b.y, 10, 5);
        }
        
        g2.drawImage(pesawat1, model.player.x, model.player.y+5, 120, 80, null);
        g2.drawImage(pesawat2, model.enemy.x, model.enemy.y, 120, 80, null);

        for (Ledakan l : model.ledakans) {
            l.draw(g2);
        }
    }
    
    private void drawHealthBar(Graphics2D g2, int x, int y, int hp, String label) {
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(x, y, 200, 20);

        g2.setColor(Color.GREEN);
        g2.fillRect(x, y, hp * 2, 20);

        g2.setColor(Color.WHITE);
        g2.drawRect(x, y, 200, 20);

        String text = label + " HP: " + hp;

        g2.setFont(new Font("Arial", Font.BOLD, 14));
        FontMetrics fm = g2.getFontMetrics();

        int textX = x;
        int textY = y - 5;

        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();

        g2.setColor(new Color(0, 0, 0, 150)); 
        g2.fillRect(textX - 5, textY - textHeight + 5, textWidth + 10, textHeight);

        g2.setColor(Color.WHITE);
        g2.drawString(text, textX, textY);
    }
    
    public String pathPesawat(String namaPesawat) {

        if ("Pesawat Amerika".equals(namaPesawat)) {
            return "/Asset/Resource/Image/pesawatAmerika.png";

        } else if ("Pesawat Jepang".equals(namaPesawat)) {
            return "/Asset/Resource/Image/pesawatJepang.png";

        } else if ("Pesawat Indonesia".equals(namaPesawat)) {
            return "/Asset/Resource/Image/pesawatIndonesia.png";

        } else if ("Pesawat Alien".equals(namaPesawat)) {
            return "/Asset/Resource/Image/musuhAlien.png";

        } else if ("Pesawat Darker".equals(namaPesawat)) {
            return "/Asset/Resource/Image/musuhDarker.png";

        } else if ("Pesawat Phantom".equals(namaPesawat)) {
            return "/Asset/Resource/Image/musuhPhantom.png";
        }

        return "/Asset/Resource/Image/pesawatIndonesia.png";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(1136, 525));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1136, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

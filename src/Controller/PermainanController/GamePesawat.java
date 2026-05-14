package Controller.PermainanController;

import Asset.Resource.LoadFile.SoundPlayer;
import Model.ModelEntity.Bullet;
import Model.ModelEntity.Enemy;
import Model.ModelEntity.Player;
import Model.ModelJalanGame.GameState;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePesawat implements KeyListener {

    private GameController controller;

    boolean up1, down1, up2, down2;
    boolean tembak1, tembak2;

    long cd1 = 0;
    long cd2 = 0;
    final int cooldown = 300;

    boolean isBotMode;

    public GamePesawat(GameController controller, boolean isBotMode) {
        this.controller = controller;
        this.isBotMode = isBotMode;
    }
    
    public void update() {
        GameState model = controller.getModel();

        // player 1
        if (up1) model.player.moveUp();
        if (down1) model.player.moveDown();

        // player 2 / bot
        if (isBotMode) {
            controller.updateAI();
        } else {
            if (up2) model.enemy.moveUp();
            if (down2) model.enemy.moveDown();
        }

        long now = System.currentTimeMillis();

        // shoot P1
        if (tembak1 && now - cd1 > cooldown) {
            model.bullets.add(new Bullet(
                model.player.x + 60,
                model.player.y + 40,
                17,
                true
            ));
            new SoundPlayer("/Asset/Resource/Sound/MentahanSound.wav").play();
            cd1 = now;
        }

        // shoot P2
        if (!isBotMode && tembak2 && now - cd2 > cooldown) {
            model.bullets.add(new Bullet(
                model.enemy.x + 40,
                model.enemy.y + 40,
                -17,
                false
            ));
            new SoundPlayer("/Asset/Resource/Sound/MentahanSound.wav").play();
            cd2 = now;
        }

        controller.update();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_W -> up1 = true;
            case KeyEvent.VK_S -> down1 = true;
            case KeyEvent.VK_SPACE -> tembak1 = true;

            case KeyEvent.VK_UP -> up2 = true;
            case KeyEvent.VK_DOWN -> down2 = true;
            case KeyEvent.VK_ENTER -> tembak2 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_W -> up1 = false;
            case KeyEvent.VK_S -> down1 = false;
            case KeyEvent.VK_SPACE -> tembak1 = false;

            case KeyEvent.VK_UP -> up2 = false;
            case KeyEvent.VK_DOWN -> down2 = false;
            case KeyEvent.VK_ENTER -> tembak2 = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
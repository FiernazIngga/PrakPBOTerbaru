package Controller.PermainanController;

import Asset.Resource.LoadFile.Ledakan;
import Asset.Resource.LoadFile.SoundPlayer;
import Model.ModelEntity.Bullet;
import Model.ModelEntity.Collison;
import Model.ModelHistoryGame.TempDataHistory;
import Model.ModelJalanGame.GameState;
import javax.swing.ImageIcon;

public class GameController {

    private GameState model;
    private TempDataHistory tempDataMasuk;

    public GameController(GameState model, TempDataHistory tempDataMasuk) {
        this.model = model;
        this.tempDataMasuk = tempDataMasuk;
        model.gambarLedakan = new ImageIcon(
            getClass().getResource("/Asset/Resource/Image/mentahanLedakanFiks.png")
        ).getImage();
    }

    // --- AI enemy ---
    public void updateAI() {
        model.enemy.followPlayer(model.player);

        if (Math.random() < 0.03) {
            SoundPlayer soundPlay =
                new SoundPlayer("/Asset/Resource/Sound/MentahanSound.wav");

            int bulletX = model.enemy.x - 10;
            int bulletY = model.enemy.y + model.enemy.height - 95;

            soundPlay.play();
            model.bullets.add(new Bullet(bulletX, bulletY, -17, false));
        }
    }
    
    public GameState getModel() {
        return model;
    }

    // --- update game utama ---
    public void update() {
        if (model.gameOver) return;
        
        for (int i = 0; i < model.bullets.size(); i++) {
            Bullet b = model.bullets.get(i);
            b.move();
            boolean kena = false;

            // PLAYER -> ENEMY
            if (b.fromPlayer &&
                Collison.check(b.x, b.y, 10, 5,
                        model.enemy.x + 50,
                        model.enemy.y + 20,
                        model.enemy.width - 100,
                        model.enemy.height - 40)) {
                
                model.enemy.hp -= 10;

                model.ledakans.add(
                    new Ledakan(b.x, b.y-50, model.gambarLedakan)
                );
                
                kena = true;
            }

            // ENEMY -> PLAYER
            else if (!b.fromPlayer &&
                Collison.check(b.x, b.y, 10, 5,
                        model.player.x - 80,
                        model.player.y,
                        model.player.width - 50,
                        model.player.height - 40)) {

                model.player.hp -= 10;

                model.ledakans.add(
                    new Ledakan(b.x, b.y - 35, model.gambarLedakan)
                );

                kena = true;
            }

            if (kena || b.x > 1136 || b.x < 0) {
                model.bullets.remove(i);
                i--;
            }
        }

        for (int i = 0; i < model.ledakans.size(); i++) {
            Ledakan l = model.ledakans.get(i);
            l.update();

            if (l.isHabis()) {
                model.ledakans.remove(i);
                i--;
            }
        }

        if (model.player.hp <= 0 && model.enemy.hp <= 0) {
            model.gameOver = true;
            model.gameWin = false;
            model.pemenang = "Seri";
        }
        else if (model.player.hp <= 0) {
            model.gameOver = true;
            model.gameWin = false;
            model.pemenang = tempDataMasuk.getNamaPilot2();
            model.kalah = tempDataMasuk.getNamaPilot1();
        }
        else if (model.enemy.hp <= 0) {
            model.gameOver = true;
            model.gameWin = true;
            model.pemenang = tempDataMasuk.getNamaPilot1();
            model.kalah = tempDataMasuk.getNamaPilot2();
        }
    }
}
package Model.ModelJalanGame;

import Asset.Resource.LoadFile.Ledakan;
import Model.ModelEntity.Bullet;
import Model.ModelEntity.Enemy;
import Model.ModelEntity.Player;
import java.awt.Image;
import java.util.ArrayList;

public class GameState {
    public Player player = new Player(600);
    public Enemy enemy = new Enemy(1200, 600);

    public ArrayList<Bullet> bullets = new ArrayList<>();
    public ArrayList<Ledakan> ledakans = new ArrayList<>();

    public boolean gameOver;
    public boolean gameWin;
    public String pemenang;
    public String kalah;
    public Image gambarLedakan;
}

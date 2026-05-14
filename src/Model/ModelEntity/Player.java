package Model.ModelEntity;

public class Player extends Pesawat {
    public int speed = 8; 
    public Player(int panelHeight) {
        this.width = 200;
        this.height = 130;
        this.x = 100; 
        this.y = 200; 
        this.hp = 100;
    }
    public void moveUp() {
        y -= speed;
        if (y < 0) y = 0; 
    }
    public void moveDown() {
        y += speed;
        // 600 adalah tinggi layar
        if (y > 600 - height) y = 600 - height; 
    }
}

package Model.ModelEntity;

public class Enemy extends Pesawat {
    public int speed = 5; // Tambahkan variabel speed agar konsisten dengan Player
    public Enemy(int panelWidth, int panelHeight) {
        this.width = 200;
        this.height = 130;
        this.x = 900; 
        this.y = 200; 
        this.hp = 100;
    }
    
    public void moveUp() {
        y -= speed;
        if (y < 0) y = 0; 
    }
    public void moveDown() {
        y += speed;
        if (y > 600 - height) y = 600 - height; 
    }
    
    public void followPlayer(Player player) {
        if (this.y < player.y) this.y += 2;
        else if (this.y > player.y) this.y -= 2;
        
        // Jaga agar AI juga tidak keluar layar
        if (y < 0) y = 0;
        if (y > 600 - height) y = 600 - height;
    }
}

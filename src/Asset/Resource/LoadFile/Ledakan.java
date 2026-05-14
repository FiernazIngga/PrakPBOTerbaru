package Asset.Resource.LoadFile;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Ledakan {
    public int x, y;
    int frame = 0;
    public int maxFrame = 5; 

    Image ledak;

    public Ledakan(int x, int y, Image ledak) {
        this.x = x;
        this.y = y;
        this.ledak = ledak;
    }

    public void update() {
        frame++;
    }

    public boolean isHabis() {
        return frame > maxFrame;
    }

    public void draw(Graphics g) {
        g.drawImage(ledak, x, y, 80, 80, null);
    }
}
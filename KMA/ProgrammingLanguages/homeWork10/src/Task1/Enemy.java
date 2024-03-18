package Task1;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GRect;

import java.awt.*;
import java.util.Random;

public class Enemy extends GCompound {
    public static final int height = 50;
    public static final int width = 50;
    public static final double moveSpeed = 1;

    public Enemy() {
        init();
        Random r = new Random();
        setLocation(r.nextInt(Runner.WINDOWWIDTH - this.width*2), height / 2);
    }

    private void init() {
        GImage enemyImg = new GImage("bombImage.png");
        enemyImg.setSize(width, height);
        add(enemyImg);
    }
}

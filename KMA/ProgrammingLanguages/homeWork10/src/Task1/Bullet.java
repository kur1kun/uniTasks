package Task1;

import acm.graphics.GCompound;
import acm.graphics.GRect;

import java.awt.*;

public class Bullet extends GCompound {
    public static final double bulletHeight = 10;
    public static final double bulletWidth = 5;
    public static final double moveSpeed = 10;
    private static final Color color = Color.RED;

    public Bullet(double x, double y) {
        init();
        setLocation(x, y);
    }

    private void init() {
        GRect bullet = new GRect(bulletWidth, bulletHeight);
        bullet.setFilled(true);
        bullet.setColor(color);
        bullet.setFillColor(color);
        add(bullet);
    }
}

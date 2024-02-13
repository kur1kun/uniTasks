package Task1;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Player extends GCompound {
    public static final double height = 55;
    public static final double width = 58;
    public static final double moveSpeed = 35;

    public Player(double x, double y) {
        init();
        setLocation(x, y);
    }

    private void init() {
        GImage planeImg = new GImage("planeImg.png");
        planeImg.setSize(width, height);
        add(planeImg);
    }
}

package Task2;

import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GRect;

import java.awt.*;
import java.util.Random;

public class Dice extends GCompound {
    public static final int diceSize = 40;
    public boolean diceChecked = false;
    private int diceValue;
    private final int x, y;
    private final Color diceOwnColor = Color.BLACK;
    private final Color diceCheckedColor = Color.RED;

    public Dice(int x, int y) {
        Random r = new Random();
        diceValue = r.nextInt(5) + 1;
        this.x = x;
        this.y = y;
        draw(diceValue, x, y, diceOwnColor);
    }

    public int getValue() {
        return diceValue;
    }

    public void getChecked() {
        diceChecked = !diceChecked;
        draw(diceValue, this.x, this.y, (diceChecked) ? diceCheckedColor : diceOwnColor);
    }

    private void draw(int dotNum, int x, int y, Color color) {
        GCompound dice = new GCompound();

        GRect diceBorder = new GRect(diceSize, diceSize);
        diceBorder.setColor(color);
        diceBorder.setFilled(true);
        diceBorder.setFillColor(Color.WHITE);
        dice.add(diceBorder);

        double dotsSize = diceSize * 0.15;
        double dotsMargin = (diceSize - 4 * dotsSize) / 2;
        switch (dotNum) {
            case 1:
                dice.add(Dot((diceSize - dotsSize) / 2, (diceSize - dotsSize) / 2, dotsSize, color));
                break;
            case 2:
                dice.add(Dot(dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                break;
            case 3:
                dice.add(Dot(dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot((diceSize - dotsSize) / 2, (diceSize - dotsSize) / 2, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                break;
            case 4:
                dice.add(Dot(dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                break;
            case 5:
                dice.add(Dot(dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                dice.add(Dot((diceSize - dotsSize) / 2, (diceSize - dotsSize) / 2, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                break;
            case 6:
                dice.add(Dot(dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                dice.add(Dot(dotsMargin, (diceSize - dotsSize) / 2, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, (diceSize - dotsSize) / 2, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                break;
        }
        dice.setLocation(x, y);
        add(dice);
    }

    private GOval Dot(double x, double y, double r, Color color) {
        GOval dot = new GOval(x, y, r, r);
        dot.setColor(color);
        dot.setFilled(true);
        dot.setFillColor(color);
        return dot;
    }
}
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
        this.x = x;
        this.y = y;
        drawWithNewValue();
    }

    public int getValue() {
        return diceValue;
    }

    public void getChecked() {
        diceChecked = !diceChecked;
        draw(diceValue, this.x, this.y, (diceChecked) ? diceCheckedColor : diceOwnColor);
    }

    public void drawWithNewValue(){
        Random r = new Random();
        diceValue =  r.nextInt(5) + 1;
        draw(diceValue, x, y, diceOwnColor);
    }

    private void draw(int dotNum, int x, int y, Color color) {
        GCompound dice = new GCompound();

        GRect diceBorder = new GRect(diceSize, diceSize);
        diceBorder.setColor(color);
        diceBorder.setFilled(true);
        diceBorder.setFillColor(Color.WHITE);
        dice.add(diceBorder);

        double dotsSize = diceSize * 0.15;
        double firstColumnMargin = (diceSize - 4 * dotsSize) / 2;
        double centerMargin = (diceSize - dotsSize) / 2;
        double secondColumnMargin = diceSize - dotsSize - firstColumnMargin;

        switch (dotNum) {
            case 1:
                dice.add(Dot(centerMargin, centerMargin, dotsSize, color));
                break;
            case 2:
                dice.add(Dot(firstColumnMargin, firstColumnMargin, dotsSize, color));
                dice.add(Dot(secondColumnMargin, secondColumnMargin, dotsSize, color));
                break;
            case 3:
                dice.add(Dot(firstColumnMargin, firstColumnMargin, dotsSize, color));
                dice.add(Dot(centerMargin, centerMargin, dotsSize, color));
                dice.add(Dot(secondColumnMargin, secondColumnMargin, dotsSize, color));
                break;
            case 4:
                dice.add(Dot(firstColumnMargin, firstColumnMargin, dotsSize, color));
                dice.add(Dot(firstColumnMargin, secondColumnMargin, dotsSize, color));
                dice.add(Dot(secondColumnMargin, firstColumnMargin, dotsSize, color));
                dice.add(Dot(secondColumnMargin, secondColumnMargin, dotsSize, color));
                break;
            case 5:
                dice.add(Dot(firstColumnMargin, firstColumnMargin, dotsSize, color));
                dice.add(Dot(firstColumnMargin, secondColumnMargin, dotsSize, color));
                dice.add(Dot(centerMargin, centerMargin, dotsSize, color));
                dice.add(Dot(secondColumnMargin, firstColumnMargin, dotsSize, color));
                dice.add(Dot(secondColumnMargin, secondColumnMargin, dotsSize, color));
                break;
            case 6:
                dice.add(Dot(firstColumnMargin, firstColumnMargin, dotsSize, color));
                dice.add(Dot(firstColumnMargin, secondColumnMargin, dotsSize, color));
                dice.add(Dot(firstColumnMargin, centerMargin, dotsSize, color));
                dice.add(Dot(secondColumnMargin, centerMargin, dotsSize, color));
                dice.add(Dot(secondColumnMargin, firstColumnMargin, dotsSize, color));
                dice.add(Dot(secondColumnMargin, secondColumnMargin, dotsSize, color));
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
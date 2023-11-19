import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GRect;

import java.awt.*;
import java.util.Random;

public class Dice extends GCompound{
    private final int diceValue;
    public Dice (int x, int y){
        Random r = new Random();
        diceValue = r.nextInt(5)+1;
        draw(diceValue, x, y, Color.BLACK);
    }

    public int getValue() {
        return diceValue;
    }

    public void draw(int dotNum, int x, int y, Color color) {
        final int diceSize = 100;
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

    private GOval Dot(double x, double y, double r, Color color){
        GOval dot = new GOval(x, y, r, r);
        dot.setColor(color);
        dot.setFilled(true);
        dot.setFillColor(color);
        return dot;
    }
}

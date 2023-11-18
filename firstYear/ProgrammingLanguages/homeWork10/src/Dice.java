import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GRect;

import java.awt.*;

public class Dice extends GCompound{
    public final int diceSize = 100;
    public GCompound draw(int dotNum, int x, int y, Color color) {
        GCompound dice = new GCompound();

        GRect diceBorder = new GRect(diceSize, diceSize);
        diceBorder.setColor(color);
        diceBorder.setFilled(true);
        diceBorder.setFillColor(Color.WHITE);
        dice.add(diceBorder);

        double dotsSize = diceSize * 0.15;
        double dotsMargin = diceSize - dotNum * dotsSize;
        switch (dotNum) {
            case 1:
                dotsMargin /= 2;
                dice.add(Dot(dotsMargin, dotsMargin, dotsSize, color));
                break;
            case 2:
                dotsMargin = (diceSize - 4 * dotsSize) / 2;
                dice.add(Dot(dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                break;
            case 3:
                dotsMargin /= 4;
                dice.add(Dot(dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(2 * dotsMargin + dotsSize, 2 * dotsMargin + dotsSize, dotsSize, color));
                dice.add(Dot(3 * dotsMargin + 2 * dotsSize, 3 * dotsMargin + 2 * dotsSize, dotsSize, color));
                break;
            case 4:
                dotsMargin /= 2;
                dice.add(Dot(dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                break;
            case 5:
                dotsMargin = (diceSize - 4 * dotsSize) / 2;
                dice.add(Dot(dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                dice.add(Dot((diceSize - dotsSize) / 2, (diceSize - dotsSize) / 2, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                break;
            case 6:
                dotsMargin = (diceSize - 4 * dotsSize) / 2;
                dice.add(Dot(dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                dice.add(Dot(dotsMargin, (diceSize - dotsSize) / 2, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, (diceSize - dotsSize) / 2, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, dotsMargin, dotsSize, color));
                dice.add(Dot(diceSize - dotsSize - dotsMargin, diceSize - dotsSize - dotsMargin, dotsSize, color));
                break;
        }
        dice.setLocation(x, y);
        return dice;
    }

    private GOval Dot(double x, double y, double r, Color color){
        GOval dot = new GOval(x, y, r, r);
        dot.setColor(color);
        dot.setFilled(true);
        dot.setFillColor(color);
        return dot;
    }
}

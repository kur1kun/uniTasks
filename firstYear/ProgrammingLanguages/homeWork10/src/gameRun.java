import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

public class gameRun extends GraphicsProgram {
    public final int diceSize = 100;
    public final int dotsSize = 10;

    public void run() {

        drawDice(1, 100, 100);
        //addMouseListeners();
    }

    public void drawDice(int dotNum, int x, int y){
        GCompound dice = new GCompound();
        dice.add(new GRect(diceSize,diceSize));

        switch(dotNum){
            case 1:
                int dotsMargin = (diceSize-dotsSize)/2;
                dice.add(new GOval(dotsMargin, dotsMargin, dotsSize, dotsSize));
                break;
            case 2:
                int
                        
        }
        dice.setLocation(x, y);
        add(dice);
    }

    public void mouseClicked(MouseEvent e) {

    }

    private GLabel label;
}


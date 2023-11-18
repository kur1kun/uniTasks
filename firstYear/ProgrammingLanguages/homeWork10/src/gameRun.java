import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class gameRun extends GraphicsProgram {
    private ArrayList<Dice> firstPlayerDices = new ArrayList<>();
    public void run() {
        Dice dice = new Dice();

        add(dice.draw(1, 100, 100, Color.BLACK));

        add(dice.draw(1,100,100, Color.BLUE));

        add(dice.draw(2, 210, 100, Color.BLACK));
        //addMouseListeners();
    }

    public void mouseClicked(MouseEvent e) {
        if(e.)
    }

    private GLabel label;
}


package Task2;

import acm.graphics.GLabel;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Runner extends GraphicsProgram {
    public static Hand firstPlayer = new Hand();
    public static Hand secondPlayer = new Hand();
    public static boolean gameIsRunning = true;
    private final int WINDOWWIDTH = 1000;
    private final int WINDOWHEIGHT = 400;
    private final Button rerollButton = new Button();
    private final Font winSansS = new Font("SansSerif", Font.BOLD, 40);

    public void run() {
        this.setSize(WINDOWWIDTH, WINDOWHEIGHT);

        //Adaptive sizes
        Dice.diceSize = WINDOWWIDTH * 0.0717;
        final double dicesMarginTop = WINDOWHEIGHT * 0.20;
        final double dicesMarginBetween = Dice.diceSize / 4;
        final double playersMarginBetween = Dice.diceSize * 1.2;
        Button.buttonWidth = WINDOWWIDTH * 0.30;
        Button.buttonHeight = WINDOWHEIGHT * 0.15;
        final double buttonsMarginTop = WINDOWHEIGHT * 0.6;
        final double buttonsMarginLeft = (WINDOWWIDTH - Button.buttonWidth) / 2.04;

        //Creating Players dices
        firstPlayer.setupAndDrawHand(dicesMarginBetween, dicesMarginTop, dicesMarginBetween, this);
        secondPlayer.setupAndDrawHand(playersMarginBetween + 5 * (dicesMarginBetween + Dice.diceSize), dicesMarginTop, dicesMarginBetween, this);

        //Reroll Button appears
        rerollButton.draw(buttonsMarginLeft, buttonsMarginTop);
        add(rerollButton);

        addMouseListeners();
    }

    public void finish() {
        remove(rerollButton);

        firstPlayer.changeCheckedDices();
        secondPlayer.changeCheckedDices();

        GLabel winnerLabelText = null;
        int betterThan = firstPlayer.isBetterThan(secondPlayer);
        if (betterThan > 0) {
            winnerLabelText = new GLabel("First player wins!");
        } else if (betterThan == 0) {
            winnerLabelText = new GLabel("Its a tie");
        } else if (betterThan < 0) {
            winnerLabelText = new GLabel("Second player wins!");
        }
        winnerLabelText.setFont(winSansS);
        winnerLabelText.setColor(Color.ORANGE);
        winnerLabelText.setLocation((WINDOWWIDTH - winnerLabelText.getWidth()) / 2, WINDOWHEIGHT * 0.7);
        add(winnerLabelText);

        gameIsRunning = false;
    }

    public void mousePressed(MouseEvent e) {
        if (gameIsRunning) {
            GPoint last = new GPoint(e.getPoint());
            try {
                Dice dice = (Dice) getElementAt(last);
                dice.getChecked();
            } catch (Exception ignored) {
                try {
                    Button button = (Button) getElementAt(last);
                    button.getPressed(this);
                } catch (Exception ignoredToo) {
                }
            }
        }
    }
}
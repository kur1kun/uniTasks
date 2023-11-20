package Task2;

import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

public class Runner extends GraphicsProgram {
    private final int MARGINTOP = 50;
    private final int MARGINBETWEEN = 10;
    private final int MARGINBETWEENPLAYERS = 40;

    public void run() {
        Hand firstPlayer = new Hand();
        Hand secondPlayer = new Hand();

        firstPlayer.setupAndDrawHand(MARGINBETWEEN, MARGINTOP, MARGINBETWEEN, this);
        secondPlayer.setupAndDrawHand(5 * (MARGINBETWEEN + Dice.diceSize) + MARGINBETWEENPLAYERS, MARGINTOP, MARGINBETWEEN, this);

        //firstPlayer.getDicesValues();

        Button rerollButton = new Button();
        rerollButton.draw(20,200);
        add(rerollButton);

        addMouseListeners();
    }

    public void mousePressed(MouseEvent e) {
        GPoint last = new GPoint(e.getPoint());
        System.out.print("Clicked on ");
        try {
            Dice dice = (Dice) getElementAt(last);
            System.out.println("dice " + dice.getValue());
            dice.getChecked();
        } catch (Exception ignored) {
            try {
                Button button = (Button) getElementAt(last);
                System.out.println("button");
                button.getPressed();
            } catch (Exception ignoredToo){
                System.out.println("nothing");
            }
        }
    }
}
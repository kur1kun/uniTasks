package Task2;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Dice> playerDices = new ArrayList<>();

    public void setupAndDrawHand(int x, int y, int distBetween, Runner run) {
        for (int i = 0; i < 5; i++) {
            Dice dice = new Dice(x + i * distBetween + i * Dice.diceSize, y);
            playerDices.add(dice);
            run.add(dice);
        }
    }

    public void getDicesValues(){
        for (int i = 0; i < 5; i++) {
            System.out.println(playerDices.get(i).getValue());
        }
    }
}

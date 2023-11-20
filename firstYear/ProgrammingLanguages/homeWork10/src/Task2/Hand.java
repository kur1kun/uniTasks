package Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hand {
    private ArrayList<Dice> playerDices = new ArrayList<>();

    public void setupAndDrawHand(double x, double y, double distBetween, Runner run) {
        for (int i = 0; i < 5; i++) {
            Dice dice = new Dice(x + i * distBetween + i * Dice.diceSize, y);
            playerDices.add(dice);
            run.add(dice);
        }
    }

    public void changeCheckedDices() {
        for (int i = 0; i < 5; i++) {
            if (playerDices.get(i).diceChecked) playerDices.get(i).drawWithNewValue();
        }
    }

    private int[] getDicesValues() {
        int[] arr = new int[6];
        for (int i = 0; i < 5; i++) {
            arr[i] = playerDices.get(i).getValue();
        }
        return arr;
    }

    private Map<Integer, Integer> buildMap(int[] hand) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int value : hand) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }
        return frequencyMap;
    }

    public int isBetterThan(Hand secondPlayer) {
        int[] hand1 = getDicesValues();
        int[] hand2 = secondPlayer.getDicesValues();

        Map<Integer, Integer> mapHand1 = buildMap(hand1);
        Map<Integer, Integer> mapHand2 = buildMap(hand2);

        return getComparisonValue(mapHand1) - getComparisonValue(mapHand2);
    }

    private int getComparisonValue(Map<Integer, Integer> hand) {
        if (hand.containsValue(5)) {
            return getKey(hand, 5, -1) * 100000;
        } else if (hand.containsValue(4)) {
            return getKey(hand, 4, -1) * 10000;
        } else if (hand.containsValue(3) && hand.containsValue(2)) {
            return getKey(hand, 3, -1) * 1000 + getKey(hand, 2, -1) * 100;
        } else if (hand.containsValue(3)) {
            return getKey(hand, 3, -1) * 100;
        } else if (hand.containsValue(2)) {
            int key = getKey(hand, 2, -1);
            return (getKey(hand, 2, key) == -1) ? key * 10 : 99;
        } else if (!hand.containsKey(1) || !hand.containsKey(6)) {
            return (hand.containsKey(6)) ? 900 : 800;
        }
        return 0;
    }

    private int getKey(Map<Integer, Integer> hand, int value, int ignKey) {
        for (int i = 1; i <= 6; i++) {
            if (hand.containsKey(i)) {
                if (hand.get(i) == value && i != ignKey) {
                    return i;
                }
            }
        }
        return -1;
    }
}
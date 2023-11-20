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

        System.out.println(getComparisonValue(mapHand1));
        System.out.println(getComparisonValue(mapHand2));
        return getComparisonValue(mapHand1) - getComparisonValue(mapHand2);
    }

    private int getComparisonValue(Map<Integer, Integer> hand) {
        if (hand.containsValue(5)) {
            return getKey(hand, 5, -1, -1) * 1000000;
        } else if (hand.containsValue(4)) {
            return getKey(hand, 4, -1, -1) * 100000 + getKey(hand, 1, -1, -1);
        } else if (hand.containsValue(3) && hand.containsValue(2)) {
            return getKey(hand, 3, -1, -1) * 10000 + getKey(hand, 2, -1, -1) * 1000;
        } else if (hand.containsValue(3)) {
            int keySet = getKey(hand, 3, -1, -1);
            int keyFirst = getKey(hand, 1, -1, -1);
            return keySet * 1000 + Math.max(keyFirst, getKey(hand, 1, keyFirst, -1));
        } else if (hand.containsValue(2)) {
            int keyFirstPair = getKey(hand, 2, -1, -1);
            int keySecondPair = getKey(hand, 2, keyFirstPair, -1);
            if (keySecondPair != -1) { // it is Two Pairs
                return keySecondPair*100 + keyFirstPair*10 + getKey(hand, 1, -1, -1);
            } else{ // it is One Pair
                int keyThirdEl = getKey(hand, 1, -1, -1);
                int keyFourthEl = getKey(hand, 1, keyThirdEl, -1);
                int keyFifthEl = getKey(hand, 1, keyThirdEl, keyFourthEl);
                return keyFirstPair*10+Math.max(keyThirdEl, Math.max(keyFourthEl, keyFifthEl));
            }
        } else if (!hand.containsKey(1) || !hand.containsKey(6)) {
            return (hand.containsKey(6)) ? 900 : 800;
        }
        return (hand.containsKey(6))? (hand.containsKey(5))? (hand.containsKey(4))? (hand.containsKey(3))? (hand.containsKey(2))? 1 : 2 : 3 : 4 : 5 : 6;
    }

    private int getKey(Map<Integer, Integer> hand, int value, int ignKey, int ignSecKey) {
        for (int i = 1; i <= 6; i++) {
            if (hand.containsKey(i)) {
                if (hand.get(i) == value && i != ignKey && i != ignSecKey) {
                    return i;
                }
            }
        }
        return -1;
    }
}
package contest.leetcode20220501;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an integer array cards where cards[i] represents the value of the ith card. A pair of cards are matching if the cards have the same value.
 *
 * Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards. If it is impossible to have matching cards, return -1.
 */
public class MinimumConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        int minCard = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];
            if (idxMap.containsKey(card)) {
                int idx = idxMap.get(card);
                minCard = Math.min(minCard, i - idx + 1);
            }
            idxMap.put(card, i);
        }
        return minCard == Integer.MAX_VALUE ? -1 : minCard;
    }

    public static void main(String[] args) {
        MinimumConsecutiveCardsToPickUp mcc = new MinimumConsecutiveCardsToPickUp();
//        int[] cards = new int[] {3,4,2,3,4,7};
        int[] cards = new int[] {1,0,5,3};
        System.out.println(mcc.minimumCardPickup(cards));
    }
}

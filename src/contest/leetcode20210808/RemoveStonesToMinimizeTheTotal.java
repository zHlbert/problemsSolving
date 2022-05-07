package contest.leetcode20210808;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:
 *
 * Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
 * Notice that you can apply the operation on the same pile more than once.
 *
 * Return the minimum possible total number of stones remaining after applying the k operations.
 *
 * floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).
 */
public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        for (int i = 0; i < k; i++) {
            int max = 0;
            int maxI = 0;
            int len = piles.length;
            for (int j = 0; j < len; j++) {
                if (piles[j] >= max) {
                    max = piles[j];
                    maxI = j;
                }
            }
            piles[maxI] = piles[maxI] - piles[maxI] / 2;
        }

        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        return sum;
    }

    public int minStoneSum1(int[] piles, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            p.offer(pile);
        }
        for (int i = 0; i < k; i++) {
            Integer top = p.poll();
            top -= top / 2;
            p.offer(top);
        }

        int sum = 0;
        for (int pile : p) {
            sum += pile;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] piles = new int[] {4,3,6,7};
        RemoveStonesToMinimizeTheTotal r = new RemoveStonesToMinimizeTheTotal();
        System.out.println(r.minStoneSum1(piles, 3));
    }
}

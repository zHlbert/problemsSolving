package contest.leetcode20220611;

import utils.ArrayUtils;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            // 二分查找
            int left = 0, right = m - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if ((long) spell * potions[mid] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            boolean hasSucceed = ((long) spell * potions[left] >= success);
            res[i] = hasSucceed ? m - left: 0;
        }
        return res;
    }

    public static void main(String[] args) {
        SuccessfulPairsOfSpellsAndPotions sp = new SuccessfulPairsOfSpellsAndPotions();
//        int[] spells = new int[] {5,1,3};
//        int[] potions = new int[] {1,2,3,4,5};
//        int success = 7;
        int[] spells = new int[] {3,1,2};
        int[] potions = new int[] {8,5,8};
        int success = 16;
        ArrayUtils.printArray(sp.successfulPairs(spells, potions, success));
    }
}

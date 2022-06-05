package contest.leetcode20220605;

import utils.ArrayUtils;

/**
 * https://leetcode.cn/contest/weekly-contest-296/problems/min-max-game/
 */
public class MinMaxGame {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int cur = n;
//        int i = 0;
        while (cur > 1) {
            for (int i = 0; i <= (cur - 1) / 2; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[2 * i], (2 * i + 1 < cur ? nums[2 * i + 1] : Integer.MAX_VALUE));
                } else {
                    nums[i] = Math.max(nums[2 * i], (2 * i + 1 < cur ? nums[2 * i + 1] : 0));
                }
            }
//            ArrayUtils.printArray(nums);
            cur = (cur + 1) >> 1;
        }
        return nums[0];
    }

    public static void main(String[] args) {
        MinMaxGame mmg = new MinMaxGame();
//        int[] nums = new int[] {1,3,5,2,4,8,2,2};
//        int[] nums = new int[] {1,3,5,2,4,8,2};
        int[] nums = new int[] {3};
        System.out.println(mmg.minMaxGame(nums));
    }
}

package leetcode._462;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // target 选 nums[n / 2]时移动次数最少
        int target = nums[n >> 1];
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - target);
        }
        return moves;
    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElementsII mm = new MinimumMovesToEqualArrayElementsII();
        int[] nums = new int[] {1,0,0,8,6};
        System.out.println(mm.minMoves2(nums));
    }
}

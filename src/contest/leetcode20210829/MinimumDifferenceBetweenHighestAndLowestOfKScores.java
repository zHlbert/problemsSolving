package contest.leetcode20210829;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        MinimumDifferenceBetweenHighestAndLowestOfKScores m = new MinimumDifferenceBetweenHighestAndLowestOfKScores();
        int[] nums = new int[] {9,4,1,7};
        System.out.println(m.minimumDifference(nums, 2));
    }
}

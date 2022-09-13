package leetcode._1619;

import java.util.Arrays;

public class TrimMean {
    public double trimMean(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int n = nums.length;
        for (int i = n / 20; i < 19 * n / 20; i++) {
            sum += nums[i];
        }
        int c = 9 * n / 10;
        return (double) sum / c;
    }

    public static void main(String[] args) {
        TrimMean tm = new TrimMean();
        System.out.println(tm.trimMean(new int[20]));
        int[] nums = new int[20];
        Arrays.fill(nums, 2);
        nums[0] = 3;
        nums[1] = 0;
        nums[2] = 0;
        System.out.println(Arrays.toString(nums));
        System.out.println(tm.trimMean(nums));
    }
}

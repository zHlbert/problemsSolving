package leetcode._2465;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NumberOfDistinctAverages {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        boolean[] sum = new boolean[210];
        int n = nums.length;
        int res = 0;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int s = nums[i] + nums[j];
            res += sum[s] ? 0 : 1;
            sum[s] = true;
        }
        return res;
    }
}

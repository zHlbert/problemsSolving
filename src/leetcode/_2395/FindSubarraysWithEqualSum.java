package leetcode._2395;

import java.util.HashSet;
import java.util.Set;

public class FindSubarraysWithEqualSum {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        if (n == 2) return false;
        Set<Integer> sums = new HashSet<>();
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            if (!sums.add(sum)) return true;
            sum -= nums[i - 1];
        }
        return false;
    }
}

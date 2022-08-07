package contest.leetcode20220807;

public class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (nums[j] < nums[i] + diff) {
                    continue;
                }
                if (nums[j] > nums[i] + diff) {
                    break;
                }
                for (int k = 2; k < n; k++) {
                    if (nums[k] < nums[j] + diff) {
                        continue;
                    }
                    if (nums[k] > nums[j] + diff) {
                        break;
                    }
                    res++;
                }
            }
        }
        return res;
    }
}

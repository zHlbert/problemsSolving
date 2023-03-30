package leetcode._2367;

public class NumberOfArithmeticTriplets {
    /**
     * 哈希
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] occur = new boolean[210];
        int res = 0;
        for (int num : nums) {
            if (num >= diff + diff && occur[num - diff - diff] && occur[num - diff]) {
                res++;
            }
            occur[num] = true;
        }
        return res;
    }

    /**
     * 三指针
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets1(int[] nums, int diff) {
        int n = nums.length;
        int res = 0;
        for (int i = 0, j = 1, k = 2; i < n - 2; i++) {
            j = Math.max(j, i + 1);
            while (j < n - 1 && nums[j] - nums[i] < diff) j++;
            if (j == n - 1 || nums[j] - nums[i] > diff) continue;
            k = Math.max(k, j + 1);
            while (k < n && nums[k] - nums[j] < diff) k++;
            if (k < n && nums[k] - nums[j] == diff) res++;
        }
        return res;
    }
}

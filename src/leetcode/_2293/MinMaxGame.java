package leetcode._2293;

public class MinMaxGame {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] tmp = new int[n >> 1];
        for (int i = 0; i < n; i += 2)
            tmp[i >> 1] = ((i >> 1) & 1) == 0
                    ? Math.min(nums[i], nums[i + 1]) : Math.max(nums[i], nums[i + 1]);
        return minMaxGame(tmp);
    }
}

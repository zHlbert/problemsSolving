package contest.leetcode20220806;

public class MinimumReplacementsToSortTheArray {
    /**
     * 贪心
     * @param nums
     * @return
     */
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = n - 2, last = nums[n - 1]; i >= 0; i--) {
            if (nums[i] <= last) {
                last = nums[i];
            } else {
                int k = (nums[i] + last - 1) / last;
                res += k - 1;
                last = nums[i] / k;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumReplacementsToSortTheArray mr = new MinimumReplacementsToSortTheArray();
        int[] nums = new int[] {3,9,3};
        System.out.println(mr.minimumReplacement(nums));
    }
}

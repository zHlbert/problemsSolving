package contest.leetcode20220709;

public class SubarrayWithElementsGreaterThanVaryingThreshold {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;

        for (int i = 0, j = 0; i < n; i++) {
            int min = nums[i];
//            int j = i;
//            j = Math.max(j, i);
            while (j < n && min * (j - i + 1) <= threshold) {
                min = Math.min(min, nums[j]);
                j++;
            }
            if (j < n) {
                return j - i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SubarrayWithElementsGreaterThanVaryingThreshold se = new SubarrayWithElementsGreaterThanVaryingThreshold();
//        int[] nums = new int[] {818,232,595,418,608,229,37,330,876,774,931,939,479,884,354,328};
//        int threshold = 3790;
//        int[] nums = new int[] {6,5,6,5,8};
//        int threshold = 7;
        int[] nums = new int[] {1,3,4,3,1};
        int threshold = 6;
        // [818,232,595,418,608,229,37,330,876,774,931,939,479,884,354,328]
        //3790
        System.out.println(se.validSubarraySize(nums, threshold));
    }
}

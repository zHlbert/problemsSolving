package leetcode._795;

public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length, last1 = -1, last2 = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                res += last1 - last2;
            }
        }
//        System.out.println(last1);
        return res;
    }

    public static void main(String[] args) {
        NumberOfSubarraysWithBoundedMaximum ns = new NumberOfSubarraysWithBoundedMaximum();
//        int[] nums = new int[] {2,1,4,3};
//        int left = 2, right = 3;
        int[] nums = new int[] {2,9,2,5,6};
        int left = 2, right = 8;
//        int[] nums = new int[] {73,55,36,5,55,14,9,7,72,52};
//        int left = 32, right = 69;
        System.out.println(ns.numSubarrayBoundedMax(nums, left, right));
    }
}

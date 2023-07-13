package leetcode._1911;

public class MaximumAlternatingSubsequenceSum {
    public long maxAlternatingSum(int[] nums) {
        long even = nums[0], odd = 0;
        for (int num : nums) {
            even = Math.max(even, odd + num);
            odd = Math.max(odd, even - num);
        }
        return even;
    }

    public static void main(String[] args) {
        MaximumAlternatingSubsequenceSum ma = new MaximumAlternatingSubsequenceSum();
        System.out.println(ma.maxAlternatingSum(new int[] {4,2,5,3}));
    }
}

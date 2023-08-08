package leetcode._1749;

public class MaximumAbsoluteSumOfAnySubArray {
    public int maxAbsoluteSum(int[] nums) {
        int res = 0, mn = 0, mx = 0;
        for (int num : nums) {
            mn = Math.min(num, mn + num);
            mx = Math.max(num, mx + num);
            res = Math.max(res, Math.max(Math.abs(mn), Math.abs(mx)));
        }
        return res;
    }

    /**
     * 前缀和
     * @param nums
     * @return
     */
    public int maxAbsoluteSum1(int[] nums) {
        int mx = 0, mn = 0, sum = 0;
        for (int x : nums) {
            sum += x;
            mn = Math.min(mn, sum);
            mx = Math.max(mx, sum);
        }
        return mx - mn;
    }

    public static void main(String[] args) {
        MaximumAbsoluteSumOfAnySubArray ma = new MaximumAbsoluteSumOfAnySubArray();
        System.out.println(ma.maxAbsoluteSum(new int[] {1,-3,2,3,-4}));
        System.out.println(ma.maxAbsoluteSum(new int[] {2,-5,1,-4,3,-2}));
    }
}

package leetcode._1658;

public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + nums[i];

        if (preSum[n] < x)
            return -1;

        if (preSum[n] == x)
            return n;

        int total = preSum[n];
        int i = 0, j = 1;
        int res = n;
        while (j <= n) {
            while (j <= n && preSum[j] - preSum[i] > total - x) i++;

            while (j <= n && preSum[j] - preSum[i] < total - x) j++;

            if (j <= n && preSum[j] - preSum[i] == total - x) {
                res = Math.min(res, n - j + i);
                i++;
                j++;
            }
        }
        return res == n ? -1 : res;
    }

    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero mo = new MinimumOperationsToReduceXToZero();
//        int[] nums = new int[] {1,1,4,2,3};
//        int x = 5;
//        int[] nums = new int[] {5,6,7,8,9};
//        int x = 4;
        int[] nums = new int[] {3,2,20,1,1,3};
        int x = 10;
        System.out.println(mo.minOperations(nums, x));
    }
}

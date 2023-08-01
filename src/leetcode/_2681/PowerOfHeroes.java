package leetcode._2681;

import java.util.Arrays;

public class PowerOfHeroes {
    static final int mod = (int) (1e9 + 7);
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int pre = i < n - 1 ? nums[i + 1] : 0;
            preSum[i] = ((preSum[i + 1] << 1) - (long) pre * pre + (long) nums[i] * nums[i]) % mod;
        }

        long res = 0L;
        for (int i = 0; i < n; i++) {
            res = (res + nums[i] * preSum[i]) % mod;
        }

        return (int) res;
    }

    public int sumOfPower1(int[] nums) {
        Arrays.sort(nums);
        long preSum = 0L, res = 0L;
        for (int num : nums) {
            // 以num结尾的子序列最小值之和
            long dp = (preSum + num) % mod;
            preSum = (preSum + dp) % mod;
            res = (res + (long) num * num % mod * dp) % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        PowerOfHeroes ph = new PowerOfHeroes();
        System.out.println(ph.sumOfPower1(new int[] {2,1,4}));
        System.out.println(ph.sumOfPower1(new int[] {2,1,4,3}));
        System.out.println(ph.sumOfPower1(new int[] {2,3}));
        System.out.println(ph.sumOfPower1(new int[] {1,1,1}));

    }
}

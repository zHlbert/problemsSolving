package contest.leetcode20221113;

import contest.leetcode20220625.NumberOfDistinctRollSequences;

public class NumberOfSubarraysWithLCMEqualToK {
    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int subarrayLCM(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int lcm = nums[i];
            for (int j = i; j < n; j++) {
                lcm = lcm(lcm, nums[j]);
                if (lcm == k) {
                    res++;
                }
                if (lcm > k) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSubarraysWithLCMEqualToK ns = new NumberOfSubarraysWithLCMEqualToK();
        int[] nums = new int[] {3,6,2,7,1};
        int k = 6;
        System.out.println(ns.subarrayLCM(nums, k));
    }
}

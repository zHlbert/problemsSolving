package contest.leetcode20220717;

import java.util.Arrays;

public class MinimumDeletionsToMakeArrayDivisible {
    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public int minOperations(int[] nums, int[] numsDivide) {

        int gcd = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            gcd = gcd(gcd, numsDivide[i]);
        }

        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (i > 0 && i < n && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i < n && gcd % nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeArrayDivisible md = new MinimumDeletionsToMakeArrayDivisible();
        int[] nums = new int[] {2,2};
        int[] numsDivide = new int[] {964351116};
        System.out.println(md.minOperations(nums, numsDivide));
    }
}

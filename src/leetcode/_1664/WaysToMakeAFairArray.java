package leetcode._1664;

import java.util.Arrays;

public class WaysToMakeAFairArray {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] prefixOdd = new int[n + 1];
        int[] prefixEven = new int[n + 1];

        for (int i = 0, oddSum = 0, evenSum = 0; i < n; i++) {
            if ((i & 1) == 1) {
                oddSum += nums[i];
                prefixOdd[i + 1] = oddSum;
                prefixEven[i + 1] = prefixEven[i];
            }
            if ((i & 1) == 0) {
                evenSum += nums[i];
                prefixEven[i + 1] = evenSum;
                prefixOdd[i + 1] = prefixOdd[i];
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int oddSum = prefixOdd[i] + prefixEven[n] - prefixEven[i + 1];
            int evenSum = prefixEven[i] + prefixOdd[n] - prefixOdd[i + 1];
//            System.out.println(i + ", " + oddSum + ", " + evenSum);
            res += oddSum == evenSum ? 1 : 0;
        }
        return res;
    }

    public int waysToMakeFair1(int[] nums) {
        int odd1, odd2, even1, even2;
        odd1 = odd2 = even1 = even2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) odd2 += nums[i];
            else even2 += nums[i];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) odd2 -= nums[i];
            else even2 -= nums[i];
            res += odd1 + even2 == odd2 + even1 ? 1 : 0;
            if ((i & 1) == 1) odd1 += nums[i];
            else even1 += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        WaysToMakeAFairArray wmf = new WaysToMakeAFairArray();
        System.out.println(wmf.waysToMakeFair(new int[] {2, 1, 6, 4}));
        System.out.println(wmf.waysToMakeFair(new int[] {1,1,1}));
        System.out.println(wmf.waysToMakeFair(new int[] {1,2,3}));
    }
}

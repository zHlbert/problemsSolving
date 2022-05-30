package leetcode._1218;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> numLenMap = new HashMap<>();
        int maxL = 0;
        for (int num : arr) {
            int curLen = numLenMap.getOrDefault(num - difference, 0) + 1;
            maxL = Math.max(maxL, curLen);
            numLenMap.put(num, curLen);
        }
        return maxL;
    }

    public int longestSubsequenceArr(int[] arr, int difference) {
        int[] dp = new int[40001];
        int maxL = 0;
        for (int num : arr) {
            int curLen = dp[num + 20000 - difference] + 1;
            maxL = Math.max(maxL, curLen);
            dp[num + 20000] = curLen;
        }
        return maxL;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequenceOfGivenDifference las = new LongestArithmeticSubsequenceOfGivenDifference();
//        int[] arr = new int[] {1,2,3,4};
//        int difference = 1;
//        int[] arr = new int[] {1,3,5,7};
//        int difference = 1;
        int[] arr = new int[] {1,5,7,8,5,3,4,2,1,6,-2};
        int difference = -3;
        System.out.println(las.longestSubsequenceArr(arr, difference));
    }
}

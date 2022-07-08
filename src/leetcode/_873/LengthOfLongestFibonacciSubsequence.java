package leetcode._873;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
 */
public class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> numIdxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numIdxMap.put(arr[i], i);
        }

        Map<Integer, Set<Integer>> numPreMap = new HashMap<>();
        int[] dp = new int[n];
        int maxL = 0;
        for (int i = 2; i < n; i++) {
            int n3 = arr[i];
            for (int j = 0; arr[j] + arr[j] < n3; j++) {
                int n1 = arr[j];
                if (numIdxMap.containsKey(n3 - n1)) {
                    boolean used = numPreMap.getOrDefault(n3 - n1, new HashSet<>()).contains(n1);
                    dp[i] = Math.max(dp[i], used ? dp[j] + 1 : dp[numIdxMap.get(n3 - n1)] + 1);
                    Set<Integer> preSet = numPreMap.getOrDefault(n3, new HashSet<>());
                    preSet.add(n1);
                    numPreMap.put(n3, preSet);
                }
            }
            maxL = Math.max(maxL, dp[i]);
        }
        ArrayUtils.printArray(dp);
        return maxL + 2;
    }

    public int lenLongestFibSubseq1(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(arr[i], i);
        }

        Map<Integer, Integer> longest = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + arr[j] < arr[i] && index.containsKey(arr[i] - arr[j])) {
                    int idx = index.get(arr[i] - arr[j]);
                    longest.put(j * n + i, longest.getOrDefault(idx * n + j, 0) + 1);
                    ans = Math.max(ans, longest.get(j * n + i) + 2);
                }
            }
        }

        return ans >= 3 ? ans : 0;
    }

    /**
     * 动态规划 + 哈希表
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq2(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && 2 * arr[j] > arr[i]; j--) {
                int k = index.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(3, dp[k][j] + 1);
                }
                res = Math.max(res, dp[j][i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestFibonacciSubsequence ll = new LengthOfLongestFibonacciSubsequence();
//        int[] arr = new int[] {1,2,3,4,5,6,7,8};
//        int[] arr = new int[] {1,3,7,11,12,14,18};
        int[] arr = new int[] {2,4,7,8,9,10,14,15,18,23,32,50};
        // [2,4,7,8,9,10,14,15,18,23,32,50]
        System.out.println(ll.lenLongestFibSubseq2(arr));
    }
}

package contest.leetcode20220327;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-286/problems/maximum-value-of-k-coins-from-piles/
 */
public class MaximumValueOfKCoinsFromPiles {
    int maxVal = 0;
    int k;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        List<Deque<Integer>> dequeList = new ArrayList<>();
        for (List<Integer> pile : piles) {
            dequeList.add(new ArrayDeque<>(pile));
        }
//        System.out.println(dequeList);
        this.k = k;
        backtrack(dequeList, 0, 0);
        return maxVal;
    }

    private void backtrack(List<Deque<Integer>> dequeList, int i, int sum) {
        if (i == k) {
            maxVal = Math.max(maxVal, sum);
            return;
        }
        for (Deque<Integer> deque : dequeList) {
            if (deque.isEmpty()) {
                continue;
            }
            int top = deque.pop();
            backtrack(dequeList, i + 1, sum + top);
            deque.push(top);
        }
    }

    public int maxValueOfCoinsDP(List<List<Integer>> piles, int k) {
        int l = piles.size();
        // dp[i][j]为考虑[0,i]组,背包容量为j时,能获取物品价值的最大值
        int[][] dp = new int[l][k + 1];
        for (int i = 1; i <= piles.get(0).size() && i <= k; i++) {
            dp[0][i] = dp[0][i - 1] + piles.get(0).get(i - 1);
        }
        // 遍历物品组
        for (int i = 1; i < l; i++) {
            int n = piles.get(i).size();
            int minNK = Math.min(n, k);

            int[] preSum = new int[minNK + 1];
            for (int c = 1; c <= minNK; c++) {
                preSum[c] = preSum[c - 1] + piles.get(i).get(c - 1);
            }

            // 遍历背包容量
            for (int j = 1; j <= k; j++) {
                int minV = Math.min(n, j);
                // 遍历第i组的物品
                for (int m = 0; m <= minV; m++) {
                    // 参考分组背包的技巧,每次抉择范围为选第i组的哪个物品?其中包含一种特殊情况(m=0代表不选->dp[i-1][j])
                    // dp[i][j]=max(dp[i][j],dp[i-1][j-v[i][m]]+w[i][m]),m∈[0,pile.size()]
                    // 这里的v[i][m]指第i组内的第k个物品的体积;w[i][m]指第i组内的第m个物品的价值
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - m] + preSum[m]);
                }
            }
        }
        return dp[l - 1][k];
    }

    public static void main(String[] args) {
        MaximumValueOfKCoinsFromPiles mv = new MaximumValueOfKCoinsFromPiles();

//        int[][] pile2DArr = new int[][] {{1,100,3},{7,8,9}};
        int[][] pile2DArr = new int[][] {{100},{100},{100},{100},{100},{100},{1,1,1,1,1,1,700}};
        List<List<Integer>> piles = new ArrayList<>();
        for (int[] pileArr : pile2DArr) {
            List<Integer> pile = new ArrayList<>();
            for (int p : pileArr) {
                pile.add(p);
            }
            piles.add(pile);
        }
        System.out.println(mv.maxValueOfCoinsDP(piles, 7));
    }
}

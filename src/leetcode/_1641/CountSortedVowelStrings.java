package leetcode._1641;

import java.util.Arrays;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int[] dp = new int[] {1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++)
            for (int j = 1; j < 5; j++)
                dp[j] += dp[j - 1];
//        System.out.println(Arrays.toString(dp));
        return dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
    }

    /**
     * 插板法
     * 等价于 n 个球放入 5 个盒子里，盒子可以为空
     *
     * @param n
     * @return
     */
    public int countVowelStrings1(int n) {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }

    public static void main(String[] args) {
        CountSortedVowelStrings cs = new CountSortedVowelStrings();
        System.out.println(cs.countVowelStrings(1));
        System.out.println(cs.countVowelStrings(2));
        System.out.println(cs.countVowelStrings(3));
        System.out.println(cs.countVowelStrings(4));
        System.out.println(cs.countVowelStrings(5));
    }
}

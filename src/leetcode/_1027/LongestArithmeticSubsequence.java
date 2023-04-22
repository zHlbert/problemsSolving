package leetcode._1027;

import java.util.Arrays;

public class LongestArithmeticSubsequence {
    /**
     * 动态规划 + 哈希
     * @param nums
     * @return
     */
    public int longestArithSeqLength(int[] nums) {
        int dv = 500, len = 1001;
        int n = nums.length;
        int[][] cnt = new int[n][len];
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int df = nums[i] - nums[j];
                int idx = df + dv;
                cnt[i][idx] = cnt[j][idx] + 1;
//                System.out.println(Arrays.toString(new int[] {i, j, df, cnt[i][idx]}));
                res = Math.max(res, cnt[i][idx]);
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequence las = new LongestArithmeticSubsequence();
//        System.out.println(las.longestArithSeqLength(new int[] {3,6,9,12}));
//        System.out.println(las.longestArithSeqLength(new int[] {9,4,7,2,10}));
//        System.out.println(las.longestArithSeqLength(new int[] {20,1,15,3,10,5,8}));
        System.out.println(las.longestArithSeqLength(new int[] {83,20,17,43,52,78,68,45}));
    }
}

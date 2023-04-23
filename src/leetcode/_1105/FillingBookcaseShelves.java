package leetcode._1105;

import java.util.Arrays;

public class FillingBookcaseShelves {
    /**
     * 动态规划
     * @param books
     * @param shelfWidth
     * @return
     */
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1000005);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int width = 0, height = 0, levelHeight = dp[i + 1];
            for (int j = i; j >= 0; j--) {
                width += books[j][0];
                if (width > shelfWidth) break;
                height = Math.max(height, books[j][1]);
                levelHeight = Math.min(levelHeight, dp[j] + height);
            }
//            System.out.println(i + ", " + levelHeight);
            dp[i + 1] = levelHeight;
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        FillingBookcaseShelves fb = new FillingBookcaseShelves();
        System.out.println(fb.minHeightShelves(new int[][]{{1,3},{2,4},{3,2}}, 6));
    }
}

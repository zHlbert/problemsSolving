package contest.leetcode20220514;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/contest/biweekly-contest-78/problems/maximum-white-tiles-covered-by-a-carpet/
 */
public class MaximumWhiteTilesCoveredByACarpet {
//    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
//        Arrays.sort(tiles, Comparator.comparingInt(t -> t[0]));
//        int n = tiles.length;
//        int maxIdx = tiles[n - 1][1];
//        int[] cnt = new int[maxIdx + 1];
//        int pre = 1;
//        for (int i = 0; i < n; i++) {
//            if (carpetLen <= tiles[i][1] - tiles[i][0] + 1) {
//                return carpetLen;
//            }
//            for (int j = pre; j <= tiles[i][1]; j++) {
//                if (j >= tiles[i][0]) {
//                    cnt[j] = cnt[j - 1] + 1;
//                } else {
//                    cnt[j] = cnt[j - 1];
//                }
//            }
//            pre = tiles[i][1] + 1;
//        }
//        int maxTiles = 0;
//        for (int i = 0; i < n; i++) {
//            int from = tiles[i][0];
//            int to = Math.min(tiles[i][0] + carpetLen - 1, cnt.length - 1);
//            maxTiles = Math.max(maxTiles, cnt[to] - cnt[from] + 1);
//        }
//        for (int i = n - 1; i >= 0; i--) {
//            int to = tiles[i][1];
//            int from = Math.max(tiles[i][1] - carpetLen + 1, 0);
//            maxTiles = Math.max(maxTiles, cnt[from] - cnt[to] + 1);
//        }
//        return maxTiles;
//    }

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(t -> t[0]));
        int n = tiles.length;
        // 第i个瓷砖组累积的瓷砖数
        int[] acc = new int[n + 1];
        for (int i = 0; i < n; i++) {
            acc[i + 1] = acc[i] + tiles[i][1] - tiles[i][0] + 1;
        }

        int maxTiles = 0;
        // 滑动窗口
        for (int i = 0, j = 0; i < n; i++) {
            int l = tiles[i][0];
            // 移动右指针，直到最后瓷砖组 或 毯子最远能够到的瓷砖组
            while (j < n && tiles[j][1] - l + 1 <= carpetLen) {
                j++;
            }
            // 毯子完全覆盖的瓷砖数
            int cur = acc[j] - acc[i];
            if (j < n) {
                // 毯子部分覆盖的瓷砖组
                int curLeft = tiles[j][0];
                int curRight = Math.min(tiles[j][1], carpetLen + l - 1);

                cur += Math.max(0, curRight - curLeft + 1);
            }
            maxTiles = Math.max(maxTiles, cur);
        }
        return maxTiles;
    }

    public static void main(String[] args) {
        MaximumWhiteTilesCoveredByACarpet mwt = new MaximumWhiteTilesCoveredByACarpet();
        int[][] tiles = new int[][] {{1,5},{10,11},{12,18},{20,25},{30,32}};
//        int[][] tiles = new int[][] {{10,11},{1,1}};
        int carpetLen = 10;
        System.out.println(mwt.maximumWhiteTiles(tiles, carpetLen));
    }
}

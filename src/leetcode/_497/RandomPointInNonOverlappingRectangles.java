package leetcode._497;

import utils.ArrayUtils;

import java.util.Random;

/**
 * https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/
 */
public class RandomPointInNonOverlappingRectangles {
    public static void main(String[] args) {
        int[][] rects = new int[][] {{-2,-2,1,1},{2,2,4,6}};
        Solution s = new Solution(rects);
//        ArrayUtils.printArray(s.preSum);
//        ArrayUtils.printArray(s.pick());
//        ArrayUtils.printArray(s.pick());
//        ArrayUtils.printArray(s.pick());
//        ArrayUtils.printArray(s.pick());
//        ArrayUtils.printArray(s.pick());
        for (int i = 0; i < 100000; i++) {
            s.pick();
        }
    }
}

class Solution {

    int[] preSum;
    Random random;
    int n;
    int[][] recs;

    public Solution(int[][] rects) {
        random = new Random();
        n = rects.length;
        preSum = new int[n];
        this.recs = new int[n][4];
        for (int i = 0; i < n; i++) {
            int[] rect = rects[i];
            int yDiff = rect[3] - rect[1] + 1;
            int xDiff = rect[2] - rect[0] + 1;
            int area = xDiff * yDiff;
            preSum[i] = area + (i > 0 ? preSum[i - 1] : 0);
            this.recs[i] = new int[] {rect[0], rect[1], rect[2], rect[3]};
        }
    }

    public int[] pick() {
        int ranCnt = random.nextInt(preSum[n - 1]);
        int i = 0;
        // TODO 二分查找
        for (; i < n; i++) {
            if (ranCnt < preSum[i]) {
                break;
            }
        }
        int cCnt = i > 0 ? ranCnt - preSum[i - 1] : ranCnt;

        int[] rec = recs[i];
        int col = rec[3] - rec[1] + 1;
        int dx = cCnt / col;
        int dy = cCnt - dx * col;
        return new int[] {rec[0] + dx, rec[1] + dy};
    }
}

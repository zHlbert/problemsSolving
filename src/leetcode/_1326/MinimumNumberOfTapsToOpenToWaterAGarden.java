package leetcode._1326;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumNumberOfTapsToOpenToWaterAGarden {
//    public int minTaps(int n, int[] ranges) {
//        List<int[]> intervals = new ArrayList<>();
//        for (int i = 0, rangesLength = ranges.length; i < rangesLength; i++) {
//            int range = ranges[i];
//            intervals.add(new int[] {i - range, i + range});
//        }
//
//        intervals.sort(Comparator.comparingInt(a -> a[0]));
//        int left = 0, right = 0, res = 0;
//        for (int[] itv : intervals) {
//            if (itv[0] <= left) {
//                while (itv[0] <= left) {
//                    right = Math.max(right, itv[1]);
//                }
//                res++;
//            }
//        }
//    }

    /**
     * 贪心
     * @param n
     * @param ranges
     * @return
     */
    public int minTaps(int n, int[] ranges) {
        int[] rightMost = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            rightMost[i] = i;
        }

        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            rightMost[start] = Math.max(rightMost[start], end);
        }
        // last 表示 左端点不大于 i 的所有子区间的最远右端点
        // pre 表示 上一个被使用的子区间的结束位置
        int last = 0, pre = 0, res = 0;
        for (int i = 0; i < n; i++) {
            last = Math.max(last, rightMost[i]);
            if (i == last) return -1;
            if (i == pre) {
                res++;
                pre = last;
            }
        }
        return res;
    }

}

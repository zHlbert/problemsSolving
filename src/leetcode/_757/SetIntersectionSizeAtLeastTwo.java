package leetcode._757;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/set-intersection-size-at-least-two/
 */
public class SetIntersectionSizeAtLeastTwo {
    // TODO: 2022/7/22 待改正
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int n = intervals.length;
        int start = Integer.MAX_VALUE, end = 0;
        for (int i = 0; i < n; i++) {
            start = Math.min(start, intervals[i][1] - 1);
            end = Math.max(end, intervals[i][0] + 1);
        }
        return end - start + 1;
    }

    /**
     * 贪心 https://leetcode.cn/problems/set-intersection-size-at-least-two/solution/she-zhi-jiao-ji-da-xiao-zhi-shao-wei-2-b-vuiv/
     * @param intervals
     * @return
     */
    public int intersectionSizeTwo1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int n = intervals.length;
        List<Integer>[] numList = new List[n];
        for (int i = 0; i < n; i++) {
            numList[i] = new ArrayList<>();
        }

        int res = 0, m = 2;
        for (int i = n - 1; i >= 0; i--) {
            for (int num = intervals[i][0], k = numList[i].size(); k < m; num++, k++) {
                res++;
                for (int j = i - 1; j >= 0; j--) {
                    if (intervals[j][1] < num) {
                        break;
                    }
                    numList[j].add(num);
                }
            }
        }
        return res;
    }

    /**
     * 贪心
     * @param intervals
     * @return
     */
    public int intersectionSizeTwo2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int res = 2;
        int end = intervals[0][1];
        int preEnd = end - 1;
        for (int[] interval : intervals) {
            if (interval[0] <= preEnd) { // left <= preEnd < end
                continue;
            }

            if (interval[0] <= end) { // preEnd < left <= end
                res++;
                preEnd = end;
            } else { // end < left < right
                res += 2;
                preEnd = interval[1] - 1;
            }
            end = interval[1];
        }
        return res;
    }
}

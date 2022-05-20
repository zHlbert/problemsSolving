package leetcode._436;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/find-right-interval/
 */
public class FindRightInterval {
    // 二分查找
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        // 对区间的起点排序，记录区间i的起点排序位次
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(o -> intervals[o][0]));

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            // 如果当前区间的终点已经大于最大起点，则res[i]=-1
            if (intervals[indices[n - 1]][0] < intervals[i][1]) {
                res[i]--;
            } else {
                int l = 0, r = n - 1;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (intervals[indices[mid]][0] < intervals[i][1]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                res[i] = indices[l];
            }
        }
        return res;
    }

    // 双指针
    public int[] findRightInterval2Pointers(int[][] intervals) {
        int n = intervals.length;
        Integer[] indices1 = new Integer[n];
        Integer[] indices2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices1[i] = i;
            indices2[i] = i;
        }
        Arrays.sort(indices1, Comparator.comparingInt(i -> intervals[i][0]));
        Arrays.sort(indices2, Comparator.comparingInt(i -> intervals[i][1]));

        int[] res = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            int right = indices2[i];
            while (j < n && intervals[right][1] > intervals[indices1[j]][0]) {
                j++;
            }
            res[right] = j == n ? -1 : indices1[j];
        }
        return res;
    }

    public static void main(String[] args) {
        FindRightInterval fr = new FindRightInterval();
//        int[][] intervals = new int[][] {{3,4},{2,3},{1,2}};
        int[][] intervals = new int[][] {{1,4},{2,3},{3,4}};
        ArrayUtils.printArray(fr.findRightInterval2Pointers(intervals));
    }
}

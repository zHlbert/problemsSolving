package leetcode._56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] ints : intervals) {
            int L = ints[0], R = ints[1];
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                merged.add(ints);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * [[1,4],[4,5]]
     * @param args
     */
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,3}, {2,6},{8,10},{15,18}};
//        int[][] intervals = new int[][] {{1,4}, {4,6}};
        MergeIntervals m = new MergeIntervals();
        int[][] merged = m.merge(intervals);
        for (int[] ints : merged) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

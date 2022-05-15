package leetcode._57;

import utils.ArrayUtils;

import java.util.*;

/**
 * https://leetcode.cn/problems/insert-interval/
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        TreeMap<Integer, int[]> map = new TreeMap<>(Comparator.comparingInt(o -> o));
        for (int[] interval : intervals) {
            map.put(interval[0], interval);
        }
        Map.Entry<Integer, int[]> floor = map.floorEntry(newInterval[1]);
        int lt = newInterval[0];
        int rt = newInterval[1];
        while (floor != null && floor.getValue()[1] >= lt) {
            lt = Math.min(lt, floor.getValue()[0]);
            rt = Math.max(rt, floor.getValue()[1]);
            map.remove(floor.getKey());
            floor = map.floorEntry(newInterval[1]);
        }
        map.put(lt, new int[] {lt, rt});

        int[][] res = new int[map.size()][2];
        int i = 0;
        for (int[] interval : map.values()) {
            res[i][0] = interval[0];
            res[i][1] = interval[1];
            i++;
        }
        return res;
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int newLeft = newInterval[0];
        int newRight = newInterval[1];
        boolean inserted = false;
        for (int[] interval : intervals) {
            if (interval[1] < newLeft) {
                ans.add(interval);
            } else if (interval[0] > newRight) {
                if (!inserted) {
                    ans.add(new int[] {newLeft, newRight});
                    inserted = true;
                }
                ans.add(interval);
            } else {
                newLeft = Math.min(newLeft, interval[0]);
                newRight = Math.max(newRight, interval[1]);
            }
        }
        if (!inserted) {
            ans.add(new int[] {newLeft, newRight});
        }
        return ans.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        int[][] intervals = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] interval = new int[] {4,8};
//        int[][] intervals = new int[][] {{1,3},{6,9}};
//        int[] interval = new int[] {2,5};
        ArrayUtils.print2DArray(ii.insert1(intervals, interval));
    }
}

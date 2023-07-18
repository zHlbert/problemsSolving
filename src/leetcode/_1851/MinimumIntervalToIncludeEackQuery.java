package leetcode._1851;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumIntervalToIncludeEackQuery {
    /**
     * 排序 优先队列 离线算法
     * @param intervals
     * @param queries
     * @return
     */
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        Integer[] qIndex = new Integer[n];
        for (int i = 0; i < n; i++) {
            qIndex[i] = i;
        }
        Arrays.sort(qIndex, Comparator.comparingInt(a -> queries[a]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] res = new int[n];
        Arrays.fill(res, -1);
        int i = 0;
        for (Integer qi : qIndex) {
            while (i < intervals.length && intervals[i][0] <= queries[qi]) {
                pq.offer(new int[] {intervals[i][1] - intervals[i][0] + 1, intervals[i][0], intervals[i][1]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[2] < queries[qi]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                res[qi] = pq.peek()[0];
            }
        }
        return res;
    }
}

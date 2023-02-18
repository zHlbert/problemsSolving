package leetcode._1792;

import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            long x = (long) b[1] * (a[1] - a[0]) * (b[1] + 1);
            long y = (long) a[1] * (a[1] + 1) * (b[1] - b[0]);
            return Long.compare(y, x);
        });


        for (int[] aClass : classes) {
            pq.offer(aClass);
        }

        while (extraStudents > 0) {
            int[] cur = pq.poll();
            pq.offer(new int[] {cur[0] + 1, cur[1] + 1});
            extraStudents--;
        }

        System.out.println(pq);

        double res = 0.0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            res += (poll[0] + 0.0) / poll[1];
        }

        return res / classes.length;
    }
}

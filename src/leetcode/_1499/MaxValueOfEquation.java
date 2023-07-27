package leetcode._1499;

import java.util.PriorityQueue;

public class MaxValueOfEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>();
        pq.offer(new int[] {points[0][1] - points[0][0], points[0][0]});
        int n = points.length;
//        for (int i = 1; i < n; i++) {
//            while (!pq.isEmpty() && )
//        }
        return n;
    }
}

package leetcode._871;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/minimum-number-of-refueling-stops/
 */
public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int fuel = startFuel, n = stations.length, res = 0, pre = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i <= n; i++) {
            int curr = i < n ? stations[i][0] : target;
            fuel -= curr - pre;
            while (fuel < 0 && !pq.isEmpty()) {
                fuel += pq.poll();
                res++;
            }
            if (fuel < 0) {
                return -1;
            }
            if (i < n) {
                pq.offer(stations[i][1]);
                pre = curr;
            }
        }
//        while (!pq.isEmpty()) {
//            int i = pq.poll();
//            if (fuel >= target) {
//                return res;
//            }
//            int maxAcc = 0, j = i + 1;
//            while (j < n && fuel - stations[j][0] >= 0) {
//                maxAcc = Math.max(maxAcc, stations[j][1]);
//                pq.offer(j++);
//            }
//            if (maxAcc == 0) {
//                return -1;
//            }
//            fuel += maxAcc;
//            res++;
//        }
        return res;
    }

    public static void main(String[] args) {
        MinimumNumberOfRefuelingStops mn = new MinimumNumberOfRefuelingStops();
//        int target = 1, startFuel = 1;
//        int[][] stations = new int[0][];
//        int target = 100, startFuel = 1;
//        int[][] stations = new int[][] {{10, 100}};
//        int target = 100, startFuel = 10;
//        int[][] stations = new int[][] {{10, 60},{20,30},{30,30},{60,40}};
//        int target = 999, startFuel = 1000;
//        int[][] stations = new int[][] {{5,100},{997,100},{998,100}};
        int target = 1000, startFuel = 299;
        int[][] stations = new int[][] {{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}};
        System.out.println(mn.minRefuelStops(target, startFuel, stations));
    }
}

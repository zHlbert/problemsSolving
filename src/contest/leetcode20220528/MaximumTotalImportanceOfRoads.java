package contest.leetcode20220528;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/contest/biweekly-contest-79/problems/maximum-total-importance-of-roads/
 */
public class MaximumTotalImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {
        int[] count = new int[n];
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
        }
        Integer[] countIdx = new Integer[n];
        for (int i = 0; i < n; i++) {
            countIdx[i] = i;
        }
        Arrays.sort(countIdx, Comparator.comparingInt(i -> count[i]));

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[countIdx[i]] = i + 1;
        }

        long sum = 0;
        for (int[] road : roads) {
            sum += scores[road[0]];
            sum += scores[road[1]];
        }
        return sum;
    }

    public long maximumImportance1(int n, int[][] roads) {
        int[] count = new int[n];
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
        }
        Arrays.sort(count);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) (i + 1) * count[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumTotalImportanceOfRoads mti = new MaximumTotalImportanceOfRoads();
        int n = 5;
//        int[][] roads = new int[][] {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        int[][] roads = new int[][] {{0,3},{2,4},{1,3}};
        System.out.println(mti.maximumImportance(n, roads));
    }
}

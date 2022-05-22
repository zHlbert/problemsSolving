package contest.leetcode20220522;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/contest/weekly-contest-294/problems/minimum-lines-to-represent-a-line-chart/
 */
public class MinimumLinesToRepresentALineChart {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if (n == 1) {
            return 0;
        }
        Arrays.sort(stockPrices, Comparator.comparingInt(s -> s[0]));
        ArrayUtils.print2DArray(stockPrices);
//        System.out.println(n);
        int[] k = computeK(stockPrices, 0, 1);

        int cnt = 1;
        for (int i = 2; i < n; i++) {
            int[] k1 = computeK(stockPrices, i - 1, i);
            if (k1[0] != k[0] || k1[1] != k[1]) {
                cnt++;
                k = k1;
            }
        }
        return cnt;
    }

    private int[] computeK(int[][] stockPrices, int d0, int d1) {
        int devX = stockPrices[d1][0] - stockPrices[d0][0];
        int devY = stockPrices[d1][1] - stockPrices[d0][1];
        int dx = devX, dy = Math.abs(devY);
        int m = Math.max(dx, dy), n = Math.min(dx, dy);
        while (n > 0) {
            int rem = m % n;
            m = n;
            n = rem;
        }
        return new int[] {dx / m, devY / m};
    }

    public static void main(String[] args) {
        MinimumLinesToRepresentALineChart ml = new MinimumLinesToRepresentALineChart();
        int[][] sp = new int[][] {{93,6},{87,11},{26,58},{28,1},{69,87},{45,59},{29,3},{5,58},{60,94},{46,54},{38,58},{88,10},{94,7},{72,96},{2,93},{63,54},{74,22},{77,84},{33,64},{13,71},{78,59},{76,93},{3,31},{7,95},{68,32},{27,61},{96,31},{4,67},{75,36},{67,21},{8,66},{83,66},{71,58},{6,36},{34,7},{86,78}};
        System.out.println(ml.minimumLines(sp));
    }
}

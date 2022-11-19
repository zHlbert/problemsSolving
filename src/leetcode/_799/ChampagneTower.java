package leetcode._799;

/**
 * 香槟塔
 * https://leetcode.cn/problems/champagne-tower/
 * 模拟
 */
public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = new double[] {poured};
        for (int i = 1; i <= query_row; i++) {
            double[] nextRow = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double volume = row[j];
                if (volume > 1) {
                    nextRow[j] += (volume - 1) / 2;
                    nextRow[j + 1] += (volume - 1) / 2;
                }
            }
            row = nextRow;
        }
        return Math.min(1, row[query_glass]);
    }
}

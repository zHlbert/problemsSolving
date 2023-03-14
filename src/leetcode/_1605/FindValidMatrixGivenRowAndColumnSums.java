package leetcode._1605;

public class FindValidMatrixGivenRowAndColumnSums {
    /**
     * 贪心
     * @param rowSum
     * @param colSum
     * @return
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] res = new int[m][n];
        int i = 0, j = 0;
        while (i < m && j < n) {
            int v = Math.min(rowSum[i], colSum[j]);
            res[i][j] = v;
            rowSum[i] -= v;
            colSum[j] -= v;
            if (rowSum[i] == 0) i++;
            if (colSum[j] == 0) j++;
        }
        return res;
    }
}

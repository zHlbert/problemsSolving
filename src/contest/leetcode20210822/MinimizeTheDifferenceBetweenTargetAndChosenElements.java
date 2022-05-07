package contest.leetcode20210822;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * You are given an m x n integer matrix mat and an integer target.
 *
 * Choose one integer from each row in the matrix such that the absolute difference between target and the sum of the chosen elements is minimized.
 *
 * Return the minimum absolute difference.
 *
 * The absolute difference between two numbers a and b is the absolute value of a - b.
 */
public class MinimizeTheDifferenceBetweenTargetAndChosenElements {
    int minDiff = Integer.MAX_VALUE;
    int target;
    int[][] mat;
    boolean[][] visited = new boolean[71][5000];
    public int minimizeTheDifference(int[][] mat, int target) {
        this.target = target;
        this.mat = mat;
        Arrays.stream(mat).forEach(Arrays::sort);
        dfs(0, 0);
        return minDiff;
    }

    private void dfs(int sum, int i) {
        if (i == mat.length) {
            minDiff = Math.min(minDiff, Math.abs(target - sum));
            return;
        }

        if (sum - target > minDiff || visited[i][sum]) {
            return;
        }
        visited[i][sum] = true;
        for (int j = 0; j < mat[i].length; j++) {
            dfs(sum + mat[i][j], i + 1);
        }
    }

    public static void main(String[] args) {
        MinimizeTheDifferenceBetweenTargetAndChosenElements m = new MinimizeTheDifferenceBetweenTargetAndChosenElements();
//        int[][] matrix = new int[][] {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };
//        int[][] matrix = new int[][] {{1},{2},{3}};
//        int[][] matrix = new int[][] {{1,2,9,8,7}};
        int[][] matrix = new int[][] {{3,5},{5,10}};
        System.out.println(m.minimizeTheDifference(matrix, 47));
    }
}

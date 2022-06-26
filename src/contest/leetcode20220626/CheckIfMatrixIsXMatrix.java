package contest.leetcode20220626;

public class CheckIfMatrixIsXMatrix {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
//                    System.out.println(i + ", " + j + ", " + grid[i][j] + " diag");
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
//                    System.out.println(i + ", " + j + ", " + grid[i][j] + " none diag");
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfMatrixIsXMatrix cm = new CheckIfMatrixIsXMatrix();
        int[][] grid = new int[][] {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
        System.out.println(cm.checkXMatrix(grid));
    }
}

package contest.leetcode20220508;

import java.util.*;

/**
 * https://leetcode-cn.com/contest/weekly-contest-292/problems/check-if-there-is-a-valid-parentheses-string-path/
 */
public class CheckIfThereIsAValidParenthesesStringPath {
    List<Character> path;
    int[] dx = new int[] {0, 1};
    int[] dy = new int[] {1, 0};
    boolean[][][] visited;
    int m;
    int n;
    char[][] grid;
//    public boolean hasValidPath(char[][] grid) {
//        if (grid[0][0] == ')') {
//            return false;
//        }
//        m = grid.length;
//        n = grid[0].length;
//        visited = new boolean[m][n];
//        visited[0][0] = true;
//        val = 1;
//        return backtrack(grid, 0, 0);
//    }

//    private boolean backtrack(char[][] grid, int row, int col) {
//        if (val < 0) {
//            return false;
//        }
//        if (row == m - 1 && col == n - 1) {
//            return val == 0;
//        }
//        for (int i = 0; i < 2; i++) {
//            int newRow = row + dx[i];
//            int newCol = col + dy[i];
//            if (newRow < m && newCol < n && !visited[newRow][newCol]) {
//                val += grid[newRow][newCol] == '(' ? 1 : -1;
//                visited[newRow][newCol] = true;
//                if (backtrack(grid, newRow, newCol)) {
//                    return true;
//                }
//                visited[newRow][newCol] = false;
//                val -= grid[newRow][newCol] == '(' ? 1 : -1;
//            }
//        }
//        return false;
//    }

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        this.grid = grid;
        visited = new boolean[m][n][m + n];
        return dfs(0, 0, 0);
    }

    /**
     *
     * @param x
     * @param y
     * @param c 左括号数量 - 右括号数量
     * @return
     */
    private boolean dfs(int x, int y, int c) {
        if (c > m - x + n - y - 1) { // 即使后面都是右括号，也无法变成0
            return false;
        }
        if (x == m - 1 && y == n - 1) {
            return c == 1;
        }
        if (visited[x][y][c]) {
            return false;
        }
        visited[x][y][c] = true;
        c += grid[x][y] == '(' ? 1 : -1;
        return c >= 0 && ((x < m - 1 && dfs(x + 1, y, c)) || (y < n - 1 && dfs(x, y + 1, c)));
    }

    private boolean isValidPath() {
        boolean isValid = true;
        Deque<Character> deque = new LinkedList<>();
        for (char ch : path){
            if (ch == '(') {
                deque.push(ch);
            } else {
                if (deque.isEmpty()) {
                    isValid = false;
                    break;
                }
                char top = deque.pop();
                if (top != '(' && ch == ')') {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid && deque.isEmpty();
    }

    public boolean hasValidPathDP(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        // k 为 左括号数量 - 右括号数量
        // dp[i][j][k] 含义为是否存在到坐标(i,j)时为k值的路径
        boolean[][][] dp = new boolean[m][n][m + n];
        dp[0][0][1] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = grid[i][j] == '(' ? 1 : -1;
                for (int k = 0; k < m + n; k++) {
                    int preC = k - c;
                    if (preC < 0 || preC >= m + n) {
                        continue;
                    }
                    if (i > 0) {
                        dp[i][j][k] |= dp[i - 1][j][preC];
                    }
                    if (j > 0) {
                        dp[i][j][k] |= dp[i][j - 1][preC];
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }

    public static void main(String[] args) {
        CheckIfThereIsAValidParenthesesStringPath cav = new CheckIfThereIsAValidParenthesesStringPath();
        char[][] grid = new char[][]
                {{'(','(',')','(','(',')','(',')','('},{')','(','(','(',')',')',')','(','('},{'(',')',')','(','(',')','(','(','('},{'(','(',')','(',')','(','(',')','('},{'(',')','(',')',')',')','(',')',')'}};
        System.out.println(cav.hasValidPathDP(grid));

    }
}

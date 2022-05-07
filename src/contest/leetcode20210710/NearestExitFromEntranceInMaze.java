package contest.leetcode20210710;

/**
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 *
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
 *
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 */
public class NearestExitFromEntranceInMaze {
    int[][] d = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;
    int res = 0;
    int minPath;
    int m, n;
    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;
        visited = new boolean[m][n];
        minPath = m * n;
        visited[entrance[0]][entrance[1]] = true;
        dfs(maze, entrance);
        return minPath == m * n ? -1 : minPath;
    }

    private void dfs(char[][] maze, int[] pos) {
        if (isBorder(pos) && maze[pos[0]][pos[1]] == '.' && res > 0) {
            minPath = Math.min(minPath, res);
            return;
        }
        for (int[] di : d) {
            int[] nextPos = new int[]{pos[0] + di[0], pos[1] + di[1]};
            if (inMaze(nextPos) && maze[nextPos[0]][nextPos[1]] == '.' && !visited[nextPos[0]][nextPos[1]]) {
                visited[nextPos[0]][nextPos[1]] = true;
                res++;
                dfs(maze, nextPos);
                res--;
                visited[nextPos[0]][nextPos[1]] = false;
            }
        }
    }

    private boolean isBorder(int[] pos) {
        return pos[0] == 0 || pos[0] == (m - 1) || pos[1] == 0 || pos[1] == (n - 1);
    }

    private boolean inMaze(int[] pos) {
        return pos[0] >= 0 && pos[0] <= (m - 1) && pos[1] >= 0 && pos[1] <= (n - 1);
    }

    public static void main(String[] args) {
        NearestExitFromEntranceInMaze near = new NearestExitFromEntranceInMaze();
        char[][] maze = {{'+','.','+','.','.','+','.','.','+','.','.','.','+','+','.','.','.','.','+','.'},
                        {'.','+','+','.','+','.','.','.','+','+','+','.','+','.','.','+','.','+','+','.'},
                        {'+','.','.','.','.','+','.','.','.','.','.','.','.','.','+','.','.','+','+','.'},
                        {'.','.','.','+','+','.','.','.','+','.','+','.','.','+','.','.','+','.','.','.'},
                        {'+','.','.','.','.','.','+','.','.','+','.','.','+','+','.','+','+','.','.','.'},
                        {'.','+','.','.','.','.','+','.','+','.','.','.','.','.','.','+','.','+','+','+'},
                        {'.','.','.','+','.','.','+','.','+','+','.','+','.','.','.','.','.','+','.','.'},
                        {'.','.','.','.','.','+','+','+','.','.','.','+','.','+','+','+','+','.','.','.'},
                        {'.','.','+','.','.','+','.','+','.','.','+','.','.','.','.','.','.','.','+','.'},
                        {'.','.','.','.','.','.','+','.','+','.','.','.','+','.','+','.','.','.','+','.'},
                        {'.','+','.','+','.','.','+','.','+','.','.','+','.','+','.','.','.','.','.','+'},
                        {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                        {'+','+','+','+','.','.','+','.','.','.','+','.','.','+','+','+','.','.','.','.'},
                        {'.','.','+','+','.','+','.','.','.','.','.','+','+','.','.','+','.','.','.','.'},
                        {'.','.','.','+','.','.','.','.','.','.','.','+','.','.','.','.','+','.','.','.'},
                        {'.','+','+','.','.','+','.','.','.','.','+','+','.','+','+','.','.','.','+','.'},
                        {'+','.','.','.','.','.','+','.','.','.','.','+','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','+','.','.','.','+','.','.','+','.','.','.','.','.','.','.','.'}};
        int[] entrance = new int[] {17, 15};
        System.out.println(near.nearestExit(maze, entrance));
    }
}

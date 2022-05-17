package leetcode._547;

/**
 * https://leetcode.cn/problems/number-of-provinces/
 */
public class NumberOfProvinces {
    boolean[] visited;
    int n;
    int[][] connected;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        visited = new boolean[n];
        connected = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(isConnected[i], 0, connected[i], 0, n);
        }
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int i) {
        for (int j = 0; j < n; j++) {
            if (!visited[j] && connected[i][j] == 1) {
                visited[j] = true;
                dfs(j);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces np = new NumberOfProvinces();
        int[][] isConnected = new int[][] {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(np.findCircleNum(isConnected));
    }
}

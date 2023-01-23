package acwing._844;

import utils.ArrayUtils;

import java.io.*;
import java.util.Arrays;

public class WalkTheMaze {
    static int N = 10010;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    /**
     * bfs
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] mn = reader.readLine().split(" ");
        int m = Integer.parseInt(mn[0]), n = Integer.parseInt(mn[1]);
        int[][] g = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] lines = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                g[i][j] = Integer.parseInt(lines[j]);
            }
        }

        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(d[i], -1);
        }

        int[][] q = new int[N][2];
        int head = 0, tail = -1;
        q[++tail] = new int[]{0, 0};
        d[0][0] = 0;
        while (head <= tail) {
            int[] cur = q[head++];
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i], ny = cur[1] + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && g[nx][ny] == 0 && d[nx][ny] == -1) {
                    q[++tail] = new int[] {nx, ny};
                    d[nx][ny] = d[cur[0]][cur[1]] + 1;
                }
            }
        }
//        ArrayUtils.print2DArray(d);
        writer.write(String.valueOf(d[m - 1][n - 1]));
        writer.flush();
        reader.close();
    }
}

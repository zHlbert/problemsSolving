package acwing._842;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 排列数字
 * https://www.acwing.com/problem/content/844/
 */
public class PermutationNumber {
    static int[] res;
    static boolean[] used;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        res = new int[n + 1];
        used = new boolean[n + 1];
        dfs(0);
        reader.close();
    }

    /**
     * 回溯
     * @param t
     */
    private static void dfs(int t) {
        if (t == n) {
            for (int i = 1; i <= n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                res[t + 1] = i;
                dfs(t + 1);
                used[i] = false;
            }
        }
    }
}

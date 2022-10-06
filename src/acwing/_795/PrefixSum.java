package acwing._795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nm = reader.readLine();
        int n = Integer.parseInt(nm.split(" ")[0]);
        int m = Integer.parseInt(nm.split(" ")[1]);
        int[] nums = new int[n + 1];
        String s = reader.readLine();
        String[] ns = s.split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(ns[i - 1]);
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1] + nums[i];
        }
        int[][] q = new int[m][2];
        for (int i = 0; i < m; i++) {
            String lr = reader.readLine();
            q[i][0] = Integer.parseInt(lr.split(" ")[0]);
            q[i][1] = Integer.parseInt(lr.split(" ")[1]);

        }
        for (int i = 0; i < m; i++) {
            System.out.println(sum[q[i][1]] - sum[q[i][0] - 1]);
        }
        reader.close();
    }
}

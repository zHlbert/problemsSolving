package acwing._801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OnesInBinary {
    /**
     * 求出 x 的最后一位 1
     * 比如 x = 10 = (1010) 2, 则 lowbit(x) = (10) 2 = 2
     *
     * @param x
     * @return
     */
    private static int lowbit(int x) {
        return x & (-x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] ns = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        for (int i = 0; i < n; i++) {
            int x = nums[i], res = 0;
            while (x != 0) {
                x -= lowbit(x);
                res++;
            }
            System.out.print(res + " ");
        }
        reader.close();
    }
}

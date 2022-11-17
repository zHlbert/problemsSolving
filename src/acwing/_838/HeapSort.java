package acwing._838;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HeapSort {
    static int[] h;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        cnt = n;
        h = new int[n + 1];
        String[] ns = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            h[i + 1] = Integer.parseInt(ns[i]);
        }
        System.out.println(Arrays.toString(h));
        for (int i = n / 2; i > 0; i--) {
            down(i);
        }
        System.out.println(Arrays.toString(h));

        for (int i = 0; i < m; i++) {
            System.out.print(h[1] + " ");
            h[1] = h[cnt--];
            down(1);
        }
        reader.close();
    }

    private static void down(int i) {
        int j = i;
        if (2 * i <= cnt && h[2 * i] < h[j]) {
            j = 2 * i;
        }
        if (2 * i + 1 <= cnt && h[2 * i + 1] < h[j]) {
            j = 2 * i + 1;
        }
        if (j != i) {
            swap(i, j);
            down(j);
        }
    }

    private static void swap(int i, int j) {
        int t = h[i];
        h[i] = h[j];
        h[j] = t;
    }
}

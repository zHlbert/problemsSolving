package acwing._154;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SlidingWindow {

    static int N = 100010;

    /**
     * 单调队列
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        int[] a = new int[n];
        String[] ns = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ns[i]);
        }

        int[] q = new int[n + 1];
        int head = 0, tail = -1;
        for (int i = 0; i < n; i++) {
            if (tail >= 0 && q[tail] - q[head] + 1 >= k) {
                head++;
            }
            while (head <= tail && a[q[tail]] >= a[i]) {
                tail--;
            }
            q[++tail] = i;
//            System.out.println(i + ": " + head + ", " + tail + ", " + Arrays.toString(q));
            if (i >= k - 1) {
                System.out.print(a[q[head]] + " ");
            }
        }
        System.out.println();
        head = 0;
        tail = -1;
        for (int i = 0; i < n; i++) {
            if (tail >= 0 && q[tail] - q[head] + 1 >= k) {
                head++;
            }
            while (head <= tail && a[q[tail]] <= a[i]) {
                tail--;
            }
            q[++tail] = i;
//            System.out.println(i + ": " + head + ", " + tail + ", " + Arrays.toString(q));
            if (i >= k - 1) {
                System.out.print(a[q[head]] + " ");
            }
        }
        reader.close();
    }
}

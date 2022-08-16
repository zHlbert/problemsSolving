package acwing._786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindKthSmallest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] arr = new int[n];
        String[] strs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(findK(arr, 0, n - 1, k));
    }

    private static int findK(int[] q, int l, int r, int k) {
        if (l >= r) {
            return q[l];
        }
        int x = q[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x);
            while (q[--j] > x);
            if (i < j) {
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }
        if (j - l + 1 >= k) {
            return findK(q, l, j, k);
        } else {
            return findK(q, j + 1, r, k - (j - l + 1));
        }
    }
}

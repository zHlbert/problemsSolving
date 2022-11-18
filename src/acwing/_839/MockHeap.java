package acwing._839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 模拟堆
 * https://www.acwing.com/problem/content/841/
 */
public class MockHeap {
    static int N = 100010;
    static int[] h = new int[N], hp = new int[N], ph = new int[N];
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()), m = 0;
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            if (op.equals("I")) {
                int x = Integer.parseInt(line[1]);
                h[++cnt] = x;
                m++;
                ph[m] = cnt;
                hp[cnt] = m;
                up(cnt);
            } else if (op.equals("PM")) {
                System.out.println(h[1]);
            } else if (op.equals("DM")) {
                heapSwap(1, cnt--);
                down(1);
            } else if (op.equals("D")) {
                int k = Integer.parseInt(line[1]);
                k = ph[k];
                heapSwap(k, cnt--);
                up(k);
                down(k);
            } else {
                int k = Integer.parseInt(line[1]);
                int x = Integer.parseInt(line[2]);
                k = ph[k];
                h[k] = x;
                up(k);
                down(k);
            }
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
            heapSwap(i, j);
            down(j);
        }
    }

    private static void up(int i) {
        while ((i >> 1) > 0 && h[i] < h[i >> 1]) {
            heapSwap(i, i >> 1);
            i = i >> 1;
        }
    }

    private static void heapSwap(int i, int j) {
        swap(ph, hp[i], hp[j]);
        swap(hp, i, j);
        swap(h, i, j);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

package acwing._827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 数组模拟双链表
 */
public class DualLinkedList {
    static int N = 100010;

    static int[] e = new int[N], l = new int[N], r = new int[N];

    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());

        init();
        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            String op = line[0];
            if (op.equals("L")) {
                int x = Integer.parseInt(line[1]);
                add2Right(0, x);
            } else if (op.equals("R")) {
                int x = Integer.parseInt(line[1]);
                add2Right(l[1], x);
            } else if (op.equals("D")) {
                int k = Integer.parseInt(line[1]);
                remove(k + 1);
            } else {
                int k = Integer.parseInt(line[1]);
                int x = Integer.parseInt(line[2]);
                if (op.equals("IL")) {
                    add2Right(l[k + 1], x);
                } else {
                    add2Right(k + 1, x);
                }
            }
        }

        for (int i = r[0]; i != 1; i = r[i]) {
            System.out.print(e[i] + " ");
        }
        reader.close();
    }

    private static void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

    private static void add2Right(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }

    private static void init() {
        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }
}

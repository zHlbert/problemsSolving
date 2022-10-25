package acwing._830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonoStack {
    /**
     * 单调栈
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] ns = reader.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++ ) {
            a[i] = Integer.parseInt(ns[i]);
        }
        int[] st = new int[n];
        int top = 0;
        for (int i = 0; i < n; i++ ) {
            while (top > 0 && a[st[top]] >= a[i]) {
                top--;
            }
            if (top <= 0) {
                System.out.print("-1 ");
            } else {
                System.out.print(a[st[top]] + " ");
            }
            st[++top] = i;
        }
        reader.close();
    }
}

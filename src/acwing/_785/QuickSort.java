package acwing._785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        String[] strs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        quickSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
        reader.close();
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l], i = l - 1, j = r + 1;
        while (i < j) {
            while (arr[++i] < x);
            while (arr[--j] > x);
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        quickSort(arr, l, j);
        quickSort(arr, j + 1, r);
    }
}

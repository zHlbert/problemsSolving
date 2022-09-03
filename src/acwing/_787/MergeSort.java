package acwing._787;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] ns = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        tmp = new int[n];
        mergeSort(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
        reader.close();
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return;

        int mid = l + r >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        int i = l, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j])
                tmp[k++] = nums[i++];
            else
                tmp[k++] = nums[j++];
        }
        while (i <= mid)
            tmp[k++] = nums[i++];
        while (j <= r)
            tmp[k++] = nums[j++];

        for (k = 0, i = l; i <= r; k++, i++) {
            nums[i] = tmp[k];
        }
    }
}

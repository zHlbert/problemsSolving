package acwing._788;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 逆序对数量
 *
 * 给定一个长度为 n 的整数数列，请你计算数列中的逆序对的数量。
 *
 * 逆序对的定义如下：对于数列的第 i 个和第 j 个元素，如果满足 i < j 且 a[i] > a[j]，则其为一个逆序对；否则不是。
 *
 * https://www.acwing.com/problem/content/790/
 */
public class ReverseOrderPairCount {
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        tmp = new int[n];
        String[] ns = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        long cnt = mergeSort(nums, 0, n - 1);
        System.out.println(cnt);
        reader.close();
    }

    private static long mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + r >> 1;
        long res = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);

        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }

        for (k = 0, i = l; i <= r; k++, i++) {
            nums[i] = tmp[k];
        }
        return res;
    }
}

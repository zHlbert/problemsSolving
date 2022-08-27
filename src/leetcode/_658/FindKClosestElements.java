package leetcode._658;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = k;
        for (int i = k; i < arr.length; i++, l++, r++) {
            if (Math.abs(arr[i] - x) >= Math.abs(arr[l] - x) && arr[l] != arr[i]) {
                break;
            }
        }
//        return Arrays.stream(Arrays.copyOfRange(arr, l, r)).boxed().collect(Collectors.toList());
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(arr[l + i]);
        }
        return res;
    }

    /**
     * 二分
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int n = arr.length;

        int l = 0, r = n - k;
        while (l < r) {
            int mid = l + r >> 1;
            if (x - arr[mid] <= arr[mid + k] - x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(arr[l + i]);
        }
        return res;
    }
}

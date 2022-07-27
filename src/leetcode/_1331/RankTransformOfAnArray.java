package leetcode._1331;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sorted = new int[n];
        System.arraycopy(arr, 0, sorted, 0, n);
        Arrays.sort(sorted);
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0, rk = 1; i < n; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                continue;
            }
            idx.put(sorted[i], rk++);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = idx.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        RankTransformOfAnArray rt = new RankTransformOfAnArray();
//        int[] arr = new int[] {40,10,20,30};
//        int[] arr = new int[] {100,100,100};
        int[] arr = new int[] {37,12,28,9,100,56,80,5,12};
        ArrayUtils.printArray(rt.arrayRankTransform(arr));
    }
}

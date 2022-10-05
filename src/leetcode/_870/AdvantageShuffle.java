package leetcode._870;

import java.util.Arrays;
import java.util.Comparator;

public class AdvantageShuffle {
    /**
     * 贪心
     * nums2 从小到大遍历 nums2[idx[i]], 找到nums1中大于 nums2[idx[i]] 的最小的数 填充到 位置idx[i]
     * 剩余数字随意填入
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int n = nums2.length;
        int[] res = new int[n];
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(a -> nums2[a]));
        boolean[] visited = new boolean[n];
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && nums1[j] <= nums2[idx[i]]) {
                j++;
            }
            if (j >= n) {
                break;
            }
            res[idx[i++]] = nums1[j];
            visited[j++] = true;
        }

        for (j = 0; i < n; i++) {
            while (visited[j]) {
                j++;
            }
            res[idx[i]] = nums1[j];
            visited[j] = true;
        }

        return res;
    }

    public static void main(String[] args) {
        AdvantageShuffle as = new AdvantageShuffle();
//        int[] res = as.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11});
        int[] res = as.advantageCount(new int[]{5621,1743,5532,3549,9581}, new int[]{913,9787,4121,5039,1481});
        System.out.println(Arrays.toString(res));
    }
}

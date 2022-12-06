package leetcode._1775;

import java.util.Arrays;

/**
 * 通过最少操作次数使数组的和相等
 * https://leetcode.cn/problems/equal-sum-arrays-with-minimum-number-of-operations/
 */
public class EqualSumArraysWithMinimumNumberOfOperations {
//    public int minOperations(int[] nums1, int[] nums2) {
//        int m = nums1.length, n = nums2.length;
//        int s1 = 0, s2 = 0;
//        for (int x : nums1) s1 += x;
//        for (int x : nums2) s2 += x;
//        if (s1 == s2) return 0;
//        boolean less = s1 < s2;
//        if (less && 6 * m < n || !less && 6 * n < m) return -1;
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int diff = s1 - s2;
//        int[] incr = less ? minOpsIncr(nums1, m, -diff) : minOpsIncr(nums2, n, diff);
//        int[] decr = less ? minOpsDecr(nums2, n, -diff) : minOpsDecr(nums1, m, diff);
//        if (incr[1] == 0 || decr[1] == 0) {
//            if (incr[1] == 0 && decr[1] == 0) {
//                return Math.min(incr[0], decr[0]);
//            }
//            return incr[1] == 0 ? incr[0] : decr[0];
//        } else {
//            int incDec = incr[0] + (less ? minOpsDecr(nums2, n, incr[1])[0] : minOpsDecr(nums1, m, incr[1])[0]);
//            int decInc = decr[0] + (less ? minOpsIncr(nums1, m, decr[1])[0] : minOpsIncr(nums2, n, decr[1])[0]);
//            return Math.min(incDec, decInc);
//        }
//    }
//
//    private int[] minOpsIncr(int[] nums, int n, int diff) {
//        int d = diff;
//        for (int i = 0; i < n; i++) {
//            if (d < 6 - nums[i]) {
//                return new int[] {i + 1, 0};
//            }
//            d += nums[i] - 6;
//        }
//        return new int[] {n, d};
//    }
//
//    private int[] minOpsDecr(int[] nums, int n, int diff) {
//        int d = diff;
//        for (int i = n - 1; i >= 0; i--) {
//            if (d < nums[i] - 1) {
//                return new int[] {n - i, 0};
//            }
//            d += 1 - nums[i];
//        }
//        return new int[] {n, d};
//    }

    /**
     * 排序 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int s1 = 0, s2 = 0;
        for (int x : nums1) s1 += x;
        for (int x : nums2) s2 += x;
        if (s1 == s2) return 0;
        boolean less = s1 < s2;
        if (less && 6 * m < n || !less && 6 * n < m) return -1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int diff = s1 - s2;
        return less ? minOps(nums1, nums2, m, n, -diff) : minOps(nums2, nums1, n, m, diff);
    }

    private int minOps(int[] ss, int[] ll, int m, int n, int diff) {
        int i = 0, j = n - 1, d = diff;
        while (d > 0) {
            int id = i < m ? 6 - ss[i] : 0;
            int dd = j >= 0 ? ll[j] - 1 : 0;
            if (id == 0 && dd == 0) {
                break;
            }
            if (id >= dd) {
                d += ss[i++] - 6;
            } else {
                d += 1 - ll[j--];
            }
        }
        return i + n - j - 1;
    }

    public static void main(String[] args) {
        EqualSumArraysWithMinimumNumberOfOperations es = new EqualSumArraysWithMinimumNumberOfOperations();
        int[] nums1 = new int[] {6,6};
        int[] nums2 = new int[] {1};
//        int[] nums1 = new int[] {1,1,1,1,1,1,1};
//        int[] nums2 = new int[] {6};
//        int[] nums1 = new int[] {1,2,3,4,5,6};
//        int[] nums2 = new int[] {1,1,2,2,2,2};
//        int[] nums1 = new int[] {5,6,4,3,1,2};
//        int[] nums2 = new int[] {6,3,3,1,4,5,3,4,1,3,4};
        System.out.println(es.minOperations(nums1, nums2));
    }
}

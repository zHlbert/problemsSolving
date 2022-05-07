package leetcode._88;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mn = nums1.length;
        int[] nums10 = new int[m];
        for (int i = 0; i < m; i++) {
            nums10[i] = nums1[i];
        }
        int i1 = 0, i2 = 0;
        for (int i = 0; i < mn; i++) {
            if (i1 < m && i2 < n) {
                if (nums10[i1] <= nums2[i2]) {
                    nums1[i] = nums10[i1++];
                } else {
                    nums1[i] = nums2[i2++];
                }
            } else if (i1 < m) {
                nums1[i] = nums10[i1++];
            } else if (i2 < n) {
                nums1[i] = nums2[i2++];
            }
        }
    }
}

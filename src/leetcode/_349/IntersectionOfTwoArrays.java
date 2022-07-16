package leetcode._349;

import java.util.*;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (Integer num : set1) {
            res[i++] = num;
        }
        return res;
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length, n2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < n1; i++) {
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                continue;
            }
            while (j < n2 && nums2[j] < nums1[i]) {
                j++;
            }
            if (j < n2 && nums2[j] == nums1[i]) {
                list.add(nums1[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        boolean[][] ins = new boolean[1001][2];
        for (int i : nums1) {
            ins[i][0] = true;
        }
        for (int i : nums2) {
            ins[i][1] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ins.length; i++) {
            if (ins[i][0] && ins[i][1]) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        boolean[] ins = new boolean[1001];
        for (int num : nums1) {
            ins[num] = true;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums2) {
            if (ins[num]) {
                set.add(num);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            res[i++] = num;
        }
        return res;
    }
}

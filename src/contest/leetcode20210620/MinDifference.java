package contest.leetcode20210620;

import java.util.*;

/**
 * The minimum absolute difference of an array a is defined as the minimum value of |a[i] - a[j]|, where 0 <= i < j < a.length and a[i] != a[j]. If all elements of a are the same, the minimum absolute difference is -1.
 *
 * For example, the minimum absolute difference of the array [5,2,3,7,2] is |2 - 3| = 1. Note that it is not 0 because a[i] and a[j] must be different.
 * You are given an integer array nums and the array queries where queries[i] = [li, ri]. For each query i, compute the minimum absolute difference of the subarray nums[li...ri] containing the elements of nums between the 0-based indices li and ri (inclusive).
 *
 * Return an array ans where ans[i] is the answer to the ith query.
 *
 * A subarray is a contiguous sequence of elements in an array.
 *
 * The value of |x| is defined as:
 *
 * x if x >= 0.
 * -x if x < 0.
 *
 */
public class MinDifference {
    public int[] minDifference(int[] nums, int[][] queries) {
        int length = queries.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = minDeference(nums, queries[i][0], queries[i][1]);
        }
        return result;
    }

    public Integer[] reduceDup(int[] nums, int start, int end) {
        Set<Integer> numSet = new TreeSet<>(Comparator.comparingInt(value -> value));
        for (int i = start; i <= end; i++) {
            numSet.add(nums[i]);
        }
        return numSet.toArray(new Integer[0]);
    }

    public int minDeference(int[] nums, int start, int end) {
        boolean updated = false;
        int minDiff = 200;
        Integer[] nums1 = reduceDup(nums, start, end);
        for (int i = 0; i < nums1.length - 1; i++) {
            int abs = nums1[i + 1] - nums1[i];
            if (abs < minDiff) {
                updated = true;
                minDiff = abs;
            }
        }
        return updated ? minDiff : -1;
    }

    public int[] minDifference1(int[] nums, int[][] queries) {
        int length = nums.length;
        int[][] cnt = new int[100005][101];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= 100; j++)
                cnt[i][j] = cnt[i - 1][j];
            cnt[i][nums[i - 1]]++;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int max = 10000;
            int minD = max, minNum = -max;
            int l = queries[i][0];
            int r = queries[i][1];
            for (int j = 1; j <= 100; j++) {
                if (cnt[l][j] != cnt[r + 1][j]) {
                    minD = Math.min(minD, j - minNum);
                    minNum = j;
                }
            }
            result[i] = minD != max ? minD : -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,2,2,7,10};
        int[][] queries = new int[][] {{2,3},{0,2},{0,5},{3,5}};
        MinDifference m = new MinDifference();
        int[] result = m.minDifference1(nums, queries);
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}

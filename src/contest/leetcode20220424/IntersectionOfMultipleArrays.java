package contest.leetcode20220424;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers,
 * return the list of integers that are present in each array of nums sorted in ascending order.
 */
public class IntersectionOfMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        int[] numCounts = new int[1001];
        for (int[] numArr : nums) {
            for (int num : numArr) {
                numCounts[num]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < numCounts.length; i++) {
            if (len == numCounts[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
